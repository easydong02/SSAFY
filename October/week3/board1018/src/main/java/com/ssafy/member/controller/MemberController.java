package com.ssafy.member.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.board.model.GuestBookDto;
import com.ssafy.board.model.service.GuestBookService;
import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.mapper.MemberMapper;
import com.ssafy.member.model.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {
	
	@Autowired
	MemberService mService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session,MemberDto member,Model model) throws Exception {
		MemberDto login = mService.login(member);
		if(login !=null) {
			session.setAttribute("login", login);
		}else {
			session.invalidate();
		}
		
		return "redirect:/guestlist";
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String registerMember(HttpSession session,MemberDto member,Model model) throws Exception {
		
		return "memberregist";
	}
	
	@RequestMapping(value = "/registMember", method = RequestMethod.POST)
	public String registerMember2(HttpSession session,MemberDto member,Model model) throws Exception {
		
		
		
		return "memberregist";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session,MemberDto member,Model model) throws Exception {
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	
	
	
}
