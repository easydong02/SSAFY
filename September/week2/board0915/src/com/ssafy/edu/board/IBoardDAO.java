package com.ssafy.edu.board;

import java.util.List;

public interface IBoardDAO {
	boolean addBoard(Board board);
	List<Board> getBoardList();
	
}
