package com.ssafy.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.dong.model.Dong;
import com.ssafy.dong.model.service.DongServiceImpl;
import com.ssafy.dong.model.service.IDongService;
import com.ssafy.interest.model.InterestDto;
import com.ssafy.interest.model.service.InterestService;
import com.ssafy.interest.model.service.InterestServiceImpl;
import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;
import com.ssafy.member.model.service.MemberServiceImpl;

@Controller
@RequestMapping("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	private MemberService memberService;
	private InterestService interestService;
	private IDongService dongService;
	
	@Autowired
	public MemberController(MemberService memerService, InterestService interestService,IDongService dongService ) {
		this.memberService = memerService;
		this.interestService = interestService;
		this.dongService = dongService;
	}
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session, HttpServletResponse response) {
		logger.debug("map : {}", map.get("userId"));
		try {
			MemberDto memberDto = memberService.login(map);
			logger.debug("memberDto : {}", memberDto);
			if(memberDto != null) {
				session.setAttribute("userinfo", memberDto);
				
				Cookie cookie = new Cookie("ssafy_id", map.get("userId"));
				cookie.setPath("/board");
				if("ok".equals(map.get("saveid"))) {
					cookie.setMaxAge(60*60*24*365*40);
				} else {
					cookie.setMaxAge(0);
				}
				response.addCookie(cookie);
				return "redirect:/";
			} else {
				model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요!");
				return "user/login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "로그인 중 문제 발생!!!");
			return "error/error";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
