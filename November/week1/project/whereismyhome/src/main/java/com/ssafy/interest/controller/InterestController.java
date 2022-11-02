package com.ssafy.interest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.dong.model.Dong;
import com.ssafy.dong.model.service.IDongService;
import com.ssafy.housedeal.model.HouseDealInfo;
import com.ssafy.housedeal.model.service.IHouseDealService;
import com.ssafy.interest.model.InterestDto;
import com.ssafy.interest.model.service.InterestService;
import com.ssafy.member.model.MemberDto;

import java.util.Arrays;


@Controller
@RequestMapping("/interest")
public class InterestController extends HttpServlet {
    public static final long serialVersionUID = 1L;

    public Map<String, String> map;
    public InterestService interestService;
    public IDongService dongService;
	IHouseDealService hdservice;
    
	@Autowired
	public InterestController(InterestService interestService, IDongService dongService, IHouseDealService hdservice) {
		this.interestService = interestService;
		this.dongService = dongService;
		this.hdservice = hdservice;
	}
	
	
	@RequestMapping(value="/detail/{dongCode}")
	public String detail(@PathVariable("dongCode") String dongCode, Model model) {
		System.out.println(dongCode);
		try {
			List<HouseDealInfo> list = hdservice.getHouseDealFull(dongCode);
			model.addAttribute("infos", list);
			return "interest/detail";
		} catch (Exception e) {
			e.printStackTrace();
	        return "error/error";
		}
	}
	
	
	@RequestMapping(value="/mvwrite")
	public String mvwrite() {
		
		return "interest/write";
	}
	
	
	@RequestMapping(value="/list")
	public String list(HttpSession session) {
		System.out.println("ssafy");
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
	    if(memberDto !=null) {
	    	try {
	    		List<InterestDto> interests = interestService.getList(memberDto.getUserId());
	    		List<Dong> dongs = new ArrayList<Dong>();
	    		System.out.println(Arrays.toString(interests.toArray()));
	    		if(interests !=null) {
	    			for(InterestDto i : interests) {
	    				System.out.println(i.getDongCode());
	    				Dong d = dongService.selectdong(i.getDongCode());
	    				System.out.println(d);
	    				dongs.add(d);
	    			}
	    		}
	    		
	    		session.setAttribute("dongs", dongs);
	    		return "interest/list";
	    		
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    		return "error/error";
	    	}
	    }
	else {
	    	return "member/login";
	    }
	}
	
	@RequestMapping(value = "/write/{dong}")
	public String write(HttpSession session, @PathVariable("dong") String dongCode) {
	    MemberDto memberDto = (MemberDto) session.getAttribute("member");
		
	    InterestDto interestDto = new InterestDto();
	    interestDto.setUser_id(memberDto.getUserId());
	    interestDto.setDongCode(dongCode);
	    
	    try {
			interestService.insert(interestDto);
			return "redirect:/interest/list";
		} catch (Exception e) {
			e.printStackTrace();
	        return "error/error";
		}
	}
	
	@RequestMapping(value="/delete/{user_id}/{dongCode}")
	public String delete( @PathVariable("user_id") String user_id, @PathVariable("dongCode") String dongCode ) {
		
		try {
			interestService.delete(user_id, dongCode);
			return "redirect:/interest/list";
		} catch (Exception e) {
			e.printStackTrace();
			return "error/error";
		}
	}
	}
