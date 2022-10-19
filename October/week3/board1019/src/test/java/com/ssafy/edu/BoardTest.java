package com.ssafy.edu;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.edu.board.model.GuestBook;
import com.ssafy.edu.board.model.service.GuestService;


public class BoardTest extends UnitTestConfig {

	private final Logger logger = LoggerFactory.getLogger(BoardTest.class);
	
	@Autowired
	private GuestService boardService;
	
	@Test
	public void listTest() throws Exception {
		List<GuestBook> list = boardService.listArticle();
		assertEquals(2, list.size());
		logger.debug("list : {}", list);
		logger.debug("list size : {}", list.size());
	}
	
	@Test
	//@Ignore
	public void modifyTest() throws Exception {
		GuestBook book = new GuestBook();
		book.setArticleNo(1);
		book.setSubject("Hello Hello");
		book.setContent("인재야 놀자!");
		boardService.updateArticle(book);	
	}

	
}