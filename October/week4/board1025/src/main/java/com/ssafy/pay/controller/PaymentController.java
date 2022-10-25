package com.ssafy.pay.controller;

import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.FileInfoDto;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;
import com.ssafy.pay.model.PaymentDto;
import com.ssafy.pay.model.service.PaymentService;
import com.ssafy.util.CalBean;
import com.ssafy.util.PageNavigation;

@Controller
@RequestMapping("/pay")
public class PaymentController {

	private final Logger logger = LoggerFactory.getLogger(PaymentController.class);

	private final PaymentService paymentService;
	private final MemberService memberService;
	
	@Autowired
	public PaymentController(PaymentService paymentService, 
			MemberService memberService) {
		this.paymentService = paymentService;
		this.memberService=memberService;
	}

	// #21# 벌금 작성 
	// i) 페이지 이동 
	@GetMapping("/write")
	public String write( Model model) throws SQLException {
		logger.debug("write  ");
		model.addAttribute("members", memberService.members());
		return "pay/write";
	}
	// ii) 벌금 작성 
	@PostMapping("/write")
	public String write2(PaymentDto payment, Model model) throws SQLException {
		logger.debug("write  {}", payment);
		paymentService.write(payment);
		return "redirect:/pay/list";
	}
	
	// #21# 전체 벌금 목록 
	@GetMapping("/list")
	public String list( Model model) throws SQLException {
		logger.debug("list  ");
		model.addAttribute("lists", paymentService.lists());
		return "pay/list";
	}
	
	// #21# 월별 벌금 캘린더 
	@GetMapping("/calendar")
	public String calendar(HttpServletRequest request, CalBean cbean, Model model) throws SQLException {
		logger.debug("list  {}",cbean);
		StringBuilder sb=new StringBuilder();
		List<PaymentDto> cals=paymentService.calendar();
		//sb.append(cbean.toString());
		//<tr class="text-center">
		//<td class="text-start">
		String path=request.getContextPath();
		Calendar cal=Calendar.getInstance();
		cal.set(cbean.getYear(), cbean.getMonth()-1, 1); //1일이 시작
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH)+1;
		//int day=cal.get(Calendar.DAY_OF_MONTH);
		String left1=path+"/pay/calendar?year="+year+"&month="+(month-1);
		String left=String.format("<a href='%s'><img src='%s/img/left.png'/></a>", left1, path );
		
		String right1=path+"/pay/calendar?year="+year+"&month="+(month+1);
		String right=String.format("<a href='%s'><img src='%s/img/right.png'/></a>", right1, path );
		
		String caldays=String.format("%s %d년 %d월  %s", left, year, month, right);
		model.addAttribute("caldays", caldays);
		//1일의 요일 
		int dayOfWeek=cal.get(Calendar.DAY_OF_WEEK) -1;// 요일 1~7 -> 0~6
		sb.append("<tr class=\"text-left\" style='height:100px'>");
		for (int i = 0; i <dayOfWeek; i++) {
			sb.append("<td class=\"text-start\">&nbsp;</td>");
		}
		
		int lastDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		for (int i = 1; i <=lastDay; i++) {
			cal.set(Calendar.DAY_OF_MONTH, i);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			String dd=sdf.format(cal.getTime());
			SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
			String ddd=sdf2.format(cal.getTime());
			StringBuilder str=new StringBuilder();
			str.append("<ul style=\"width:10%\">");
			for (PaymentDto dto: cals) {
				if(dto.getPday().equals(ddd)) {
					str.append("<li>"+dto.getPid()+":"+dto.getPamount()+"</li>");
				}
			}
			str.append("</ul>");
			sb.append("<td class=\"text-start\" id='s"+dd+"'>"+i+str.toString()+"</td>");
			if((dayOfWeek+i)%7==0) {
				sb.append("</tr>");
				sb.append("<tr class=\"text-left\" style='height:100px'>");
			}
		}
		
		sb.append("</tr>");
		model.addAttribute("calendars", sb.toString());
		return "pay/calendar";
	}
}