package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper boardMapper;
	
	public BoardServiceImpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}

	@Override
	public void write(BoardDto board) throws Exception {
		boardMapper.write(board);
	}

	@Override
	public void update(BoardDto board) throws Exception {
		boardMapper.update(board);
	}

	@Override
	@Transactional
	public void delete(int articleNo) throws Exception {
		boardMapper.delete(articleNo);
	}

	@Override
	public List<BoardDto> list() throws Exception {
		return boardMapper.list();
	}

	@Override
	public BoardDto getBoard(int articleNo) throws Exception {
		return boardMapper.getBoard(articleNo);
	}

}
