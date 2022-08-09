package com.ssafy.corona.virus;
//사용자 정의 예외 -> 체크드 -> 예외처리
//예외처리 -> 	1. try
//			2. throws throw 


public class DuplicatedException extends Exception{
	public DuplicatedException(String msg) {
		super(msg);
	}
	public DuplicatedException() {
		this("Duplicated예외");
	}
}
