package com.ssafy.edu.board;

public class BoardService {
	private static BoardService service= new BoardService();
	
	public static BoardService getInstance() {
		return service;
	}
	
	
	private BoardService() {
		dao= new BoardDAOImpl();
	}
	
	private IBoardDAO dao;
	
	//----------------------------
	
	public boolean addBoard(Board board) {
		return dao.addBoard(board);
	}
	
	
}
