package com.ssafy.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.mapper.BoardMapper;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.BoardServiceImpl;
import com.ssafy.member.model.MemberDto;
import com.ssafy.util.PageNavigation;
import com.ssafy.util.ParameterCheck;

@Controller
@RequestMapping("/board")
public class BoardController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private Logger logger= LoggerFactory.getLogger(BoardController.class);
    
    @Autowired
    private ServletContext servletContext;
    
    private BoardService bservice;
    private Map<String, String> map;
    
    @Autowired
    public BoardController(BoardService boardService) {
    	bservice = boardService;
	}
    
    
    @GetMapping("/list")
	public ModelAndView list(@RequestParam Map<String, String> map) throws Exception {
		logger.debug("list parameter : {}", map);
		ModelAndView mav = new ModelAndView();
//		try {
		List<BoardDto> list = bservice.listArticle(map);
		PageNavigation pageNavigation = bservice.makePageNavigation(map);
		mav.addObject("articles", list);
		mav.addObject("navigation", pageNavigation);
		mav.addObject("pgno", map.get("pgno"));
		mav.addObject("key", map.get("key"));
		mav.addObject("word", map.get("word"));
		mav.setViewName("board/list");
		return mav;
//		} catch (Exception e) {
//			e.printStackTrace();
//			mav.addObject("msg", "글작성 처리중 문제발생!!!");
//			mav.setViewName("error/error");
//			return mav;
//		}
	}
    
	@GetMapping("/view")
	public String view(@RequestParam("articleno") int articleNo, @RequestParam Map<String, String> map, Model model)
			throws Exception {
		logger.debug("view articleNo : {}", articleNo);
		BoardDto boardDto = bservice.getArticle(articleNo);
		bservice.updateHit(articleNo);
		model.addAttribute("article", boardDto);
		model.addAttribute("pgno", map.get("pgno"));
		model.addAttribute("key", map.get("key"));
		model.addAttribute("word", map.get("word"));
		return "board/view";
	}
	
	@GetMapping("/write")
	public String write(@RequestParam Map<String, String> map, Model model) {
		logger.debug("write call parameter {}", map);
		model.addAttribute("pgno", map.get("pgno"));
		model.addAttribute("key", map.get("key"));
		model.addAttribute("word", map.get("word"));
		return "board/write";
	}
	
	
	@PostMapping("/write")
	public String write(@Value("${file.path.upload-files}") String filePath, BoardDto boardDto, HttpSession session,
			RedirectAttributes redirectAttributes) throws Exception {
		logger.debug("write boardDto : {}", boardDto);
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
//		boardDto.setUserId(memberDto.getUserId());
		boardDto.setUserId("adminn");

		bservice.writeArticle(boardDto);
		redirectAttributes.addAttribute("pgno", "1");
		redirectAttributes.addAttribute("key", "");
		redirectAttributes.addAttribute("word", "");
		return "redirect:/board/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("articleno") int articleNo, @RequestParam Map<String, String> map,
			RedirectAttributes redirectAttributes) throws Exception {
		logger.debug("delete articleNo : {}", articleNo);
		bservice.deleteArticle(articleNo);
		redirectAttributes.addAttribute("pgno", map.get("pgno"));
		redirectAttributes.addAttribute("key", map.get("key"));
		redirectAttributes.addAttribute("word", map.get("word"));
		return "redirect:/board/list";
	}
    
	
	@GetMapping("/modify")
	public String modify(@RequestParam("articleno") int articleNo, @RequestParam Map<String, String> map, Model model)
			throws Exception {
		logger.debug("modify articleNo : {}", articleNo);
		BoardDto boardDto = bservice.getArticle(articleNo);
		logger.debug("mv - modify articleNo : {}", boardDto);
		
		model.addAttribute("article", boardDto);
		model.addAttribute("pgno", map.get("pgno"));
		model.addAttribute("key", map.get("key"));
		model.addAttribute("word", map.get("word"));
		return "board/modify";
	}

	@PostMapping("/modify")
	public String modify(BoardDto boardDto, @RequestParam Map<String, String> map,
			RedirectAttributes redirectAttributes) throws Exception {
		logger.debug("modify boardDto : {}", boardDto);
		bservice.modifyArticle(boardDto);
		redirectAttributes.addAttribute("pgno", map.get("pgno"));
		redirectAttributes.addAttribute("key", map.get("key"));
		redirectAttributes.addAttribute("word", map.get("word"));
		return "redirect:/board/list";
	}
}
