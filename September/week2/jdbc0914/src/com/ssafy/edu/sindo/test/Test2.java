package com.ssafy.edu.sindo.test;

import java.util.List;

import com.ssafy.edu.sindo.SindoBoardDto;
import com.ssafy.edu.sindo.SindoDao;

public class Test2 {

	public static void main(String[] args) {
		SindoDao dao =new SindoDao();
		List<SindoBoardDto> boards= dao.getBoardList();
		for(SindoBoardDto board : boards) {
			System.out.println(board);
		}
	}
}
