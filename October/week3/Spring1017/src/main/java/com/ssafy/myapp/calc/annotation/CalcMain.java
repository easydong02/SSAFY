package com.ssafy.myapp.calc.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {
	public static void main(String[] args) {
		//Spring DI ��� X
//		Calculator calculator= new Calculator(); //���� �ڵ忡�� ��ü�� ����
//		int temp = calculator.add(5,6);
//		System.out.println(temp);
		
		//Spring DI ��� O
		//Spring ����ȯ�� ����
		//Spring framework���� �����ϴ� Ŭ������ �̿�
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("calc-annotation.xml");
		
		
		//Spring ��ü ���� �䱸 -> spring�� ��ü�� �����ؼ� �����ش�.
		Calculator calculator = (Calculator)context.getBean("calculator"); //Spring���� ��ü ������ �䱸(�������)
		System.out.println(calculator.add(4, 5));
	}
}
