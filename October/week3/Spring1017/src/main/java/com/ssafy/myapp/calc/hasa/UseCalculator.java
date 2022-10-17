package com.ssafy.myapp.calc.hasa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //annotation ��� spring�� �ڽ� ��ü�� ���
public class UseCalculator {
	
	// #1 field ����
//	@Autowired //�Ʒ� type�� �´� ��ü�� ���� DI ���ּ���
//	Calculator calculator;
	
	// #2 stter ����
	
//	Calculator calculator;
//	
//	@Autowired
//	public void setCalculator(Calculator calculator) {
//		this.calculator = calculator;
//	}
	
	// #3. constructor ����
	Calculator calculator;
	
	@Autowired
	public UseCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	public int add(int n1, int n2) {
		return calculator.add(n1, n2);
	}
}
