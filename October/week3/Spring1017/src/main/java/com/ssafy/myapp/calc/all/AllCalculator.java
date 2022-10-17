package com.ssafy.myapp.calc.all;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AllCalculator {
	
	@Autowired
	@Qualifier("aaa") // aaa라는 이름을 가진 Bean DI해줘
	Calculator calculator;
	
	public int add(int n1,int n2) {
		return calculator.add(n1, n2);
	}
}
