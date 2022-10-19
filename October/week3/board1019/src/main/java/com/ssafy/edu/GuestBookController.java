package com.ssafy.edu;

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

import com.ssafy.edu.board.model.GuestBook;
import com.ssafy.edu.board.model.service.GuestService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class GuestBookController {
	
	private static final Logger logger = LoggerFactory.getLogger(GuestBookController.class);
	
	//Single Responsibility Pricipal - 하나의 객체는 하나의 책임 -로직 -> 응집
	//LSP -> OCP -> IoC(DI를 개발자가 안 함.)
	@Autowired
	private GuestService gService;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/guestlist", method = RequestMethod.GET)
	public String guestlist( Model model) throws Exception {
		logger.debug("Welcome home! this is <guestlist>");
		
		model.addAttribute("books", gService.listArticle());
		
		
		return "board/guestlist";
	}
	
	@RequestMapping(value = "/bfguestwrite", method = RequestMethod.GET)
	public String bfguestwrite( Model model) throws Exception {
		logger.debug("Welcome home! this is <bfguestwrite>");
		
		return "board/guestwrite";
	}
	
	@RequestMapping(value = "/guestwrite", method = RequestMethod.POST)
	public String guestwrite(GuestBook book, Model model) throws Exception {
		logger.debug("Welcome home! this is <guestwrite> {}" , book);
		gService.writeArticle(book);
		
		
		return "redirect:/guestlist";
	}
	
	@RequestMapping(value = "/guestdetail", method = RequestMethod.GET)
	public String guestdetail(int articleNo, Model model) throws Exception {
		logger.debug("Welcome home! this is <guestwrite> {}" , articleNo);
		
		model.addAttribute("book", gService.selectArticle(articleNo));
		
		return "board/guestdetail";
	}
	
	@RequestMapping(value = "/guestupdate", method = RequestMethod.POST)
	public String guestupdate(GuestBook book, Model model) throws Exception {
		logger.debug("Welcome home! this is <guestwrite> {}" , book);
		
		gService.updateArticle(book);
		return "redirect:/guestdetail?articleNo="+book.getArticleNo();
	}
	@RequestMapping(value = "/guestdelete", method = RequestMethod.GET)
	public String guestdelete(int articleNo, Model model) throws Exception {
		logger.debug("Welcome home! this is <guestwrite> {}" , articleNo);
		
		gService.deleteArticle(articleNo);
		return "redirect:/guestlist";
	}
	
}
