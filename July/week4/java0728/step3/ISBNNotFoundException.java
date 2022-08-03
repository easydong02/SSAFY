package com.ssafy.ws.step3;

// 사용자가 정의한 예외 -> 컴파일타이밍 -> 
public class ISBNNotFoundException extends Exception {

	public ISBNNotFoundException() {
		this("ISBN이 존재하지 않습니다.");
	}

	public ISBNNotFoundException(String message) {
		super(message);
		
	}
	
}
