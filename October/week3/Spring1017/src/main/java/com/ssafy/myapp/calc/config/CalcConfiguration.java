package com.ssafy.myapp.calc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //Spring�� �ν��ϴ� Ư���� Java Ŭ����
public class CalcConfiguration {

	
	@Bean
	public Calculator calculator() {
		return new Calculator();
	}
}
