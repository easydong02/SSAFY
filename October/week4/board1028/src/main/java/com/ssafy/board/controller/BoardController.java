package com.ssafy.board.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value ="/board")
public class BoardController {
	
	private BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception{
		
		logger.debug("BoardController! ! list");
		
		model.addAttribute("lists", boardService.list());
		
		return "board/list";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String bfwrite(Model model) throws Exception{
		
		logger.debug("BoardController! ! bfwrite");
		
		return "board/write";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(BoardDto boardDto, Model model) throws Exception{
		
		logger.debug("BoardController! ! write {}",boardDto);
		
		boardService.write(boardDto);
		
		return "redirect:/board/list";
	}
	
	
	
	@RequestMapping(value = "/detail/{articleno}", method = RequestMethod.GET)
	public String detail(@PathVariable int articleno,Model model) throws Exception{
		
		logger.debug("BoardController! ! detail");
		model.addAttribute("board", boardService.getBoard(articleno));
		
		return "board/detail";
	}
	
	@RequestMapping(value = "/alist", method = RequestMethod.GET)
    public String alist(Model model) throws Exception {
        logger.debug("BoardController ! alist  ");
        return "board/alist";
    }
	
}
