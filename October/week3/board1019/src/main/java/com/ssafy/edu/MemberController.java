package com.ssafy.edu;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.edu.member.model.Member;
import com.ssafy.edu.member.model.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	//Single Responsibility Pricipal - 하나의 객체는 하나의 책임 -로직 -> 응집
	//LSP -> OCP -> IoC(DI를 개발자가 안 함.)
	@Autowired
	private MemberService mService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String guestlist(HttpSession session, Member member,Model model) throws Exception {
		logger.debug("Welcome home! this is <login>");
		Member login = mService.login(member);
		String url = null;
		if(login !=null) {
			session.setAttribute("login", login);
			url = "redirect:/home";
		}else {
			session.invalidate();
			url="redirect:/login";
		}
		return url;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String bfguestwrite(HttpSession session, Model model) throws Exception {
		logger.debug("Welcome home! this is <logout>");
		session.invalidate();
		
		return "login";
	}
	
	
}
