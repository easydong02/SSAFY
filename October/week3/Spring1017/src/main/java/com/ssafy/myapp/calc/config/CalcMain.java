package com.ssafy.myapp.calc.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {
	public static void main(String[] args) {
		//Spring DI 사용 X
//		Calculator calculator= new Calculator(); //직접 코드에서 객체를 생성
//		int temp = calculator.add(5,6);
//		System.out.println(temp);
		
		//Spring DI 사용 O
		//Spring 실행환경 구성
		//Spring framework에서 제공하는 클래스를 이용
		//configuration 클래스 기반에는 xml 문서 사용 x <= xml문서를 Java Class로 대체
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("calc-xml.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CalcConfiguration.class);
		
		//Spring 객체 생성 요구 -> spring이 객체를 생성해서 남겨준다.
		Calculator calculator = (Calculator)context.getBean("calculator"); //Spring에게 객체 생성을 요구(만들어줘)
		System.out.println(calculator.add(4, 5));
	}
}
