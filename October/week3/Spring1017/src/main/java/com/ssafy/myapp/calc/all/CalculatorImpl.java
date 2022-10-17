package com.ssafy.myapp.calc.all;

import org.springframework.stereotype.Component;

@Component("aaa")
public class CalculatorImpl implements Calculator {

	@Override
	public int add(int n1, int n2) {
		System.out.println("impl1");
		return n1+ n2;
	}

}
