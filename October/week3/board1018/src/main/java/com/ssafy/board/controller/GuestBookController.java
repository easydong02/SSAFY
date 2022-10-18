package com.ssafy.board.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.board.model.GuestBookDto;
import com.ssafy.board.model.service.GuestBookService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class GuestBookController {
	
	@Autowired
	GuestBookService gService;
	
	private static final Logger logger = LoggerFactory.getLogger(GuestBookController.class);
	
	@RequestMapping(value = "/guestlist", method = RequestMethod.GET)
	public String guestlist(Model model) throws Exception {
		
		model.addAttribute("guestlist",gService.listArticle());
		
		return "guestlist";
	}
	
	@RequestMapping(value = "/guestupdate", method = RequestMethod.POST)
	public String guestupdate(Model model, GuestBookDto book) throws Exception {
		logger.info("welcome guestwrite get.");
		gService.updateArticle(book);
		return "redirect:/guestdetail?articleNo="+book.getArticleNo();
	}
	@RequestMapping(value = "/guestwrite", method = RequestMethod.GET)
	public String guestwrite(Model model) throws Exception {
		logger.info("welcome guestwrite get.");
		return "guestwrite";
	}
	@RequestMapping(value = "/guestwrite", method = RequestMethod.POST)
	public String writeboard(GuestBookDto book, Model model) throws Exception {
		logger.info("welcome guestwrite post.");
		
		gService.writeArticle(book);
		
		return "redirect:/guestlist";
	}
	@RequestMapping(value = "/guestdetail", method = RequestMethod.GET)
	public String guestdetail(int articleNo, Model model) throws Exception {
		logger.info("welcome guestwrite post.");
		
		model.addAttribute("book", gService.selectArticle(articleNo)); 
		
		return "guestdetail";
	}
	
}
