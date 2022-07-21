package com.ssafy.spider;

public class Person {
	String name;
	
	public Person(String name) {
		this.name=name;
	}
	
	public void jump() {
		System.out.println("잠푸");
		
	}
	public void eat() {
		System.out.println("냠냠");
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name: "+name;
	}
	
}
