package com.ssafy.edu.sindo.test;

import com.ssafy.edu.sindo.SindoBoardDto;
import com.ssafy.edu.sindo.SindoDao;

public class Test1 {

	public static void main(String[] args) {
		SindoDao dao =new SindoDao();
		boolean isS= dao.insertBoard(new SindoBoardDto("sindo","오늘은 기분이 매우 좋은 날","돈을 많이 벌었다."));
		System.out.println(isS);
	}

}
