package com.ssafy.ws.step3;

public class QuantityException extends Exception {

	public QuantityException() {
		this("올바른 수량이 아닙니다.");
	}

	public QuantityException(String message) {
		super(message);
	}

}
