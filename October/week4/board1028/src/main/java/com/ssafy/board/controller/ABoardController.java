package com.ssafy.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;


@RestController
@RequestMapping("/aboard")
@CrossOrigin("*")
public class ABoardController {

	private static final Logger logger = LoggerFactory.getLogger(ABoardController.class);
	
	private BoardService boardService;
	
	@Autowired
	public ABoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping(value = "/list")
	public ResponseEntity<?> boardlist() {
		logger.debug("boardlist call");
		try {
			List<BoardDto> list = boardService.list();
			if(list != null && !list.isEmpty()) {
				return new ResponseEntity<List<BoardDto>>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/{articleno}")
	public ResponseEntity<?> boardView(@PathVariable("articleno") int articleNo) {
		System.out.println("여기 들어왔다~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		try {
			BoardDto boardDto = boardService.getBoard(articleNo);
			logger.debug("{boardDto = }", boardDto );
			if(boardDto != null) {
				return new ResponseEntity<BoardDto>(boardDto,HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}