package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.BoardDto;

public interface BoardService {
	void write(BoardDto board) throws Exception;
	void update(BoardDto board) throws Exception;
	void delete(int articleNo) throws Exception;
	
	List<BoardDto> list() throws Exception;
	BoardDto getBoard(int articleNo) throws Exception;
}
