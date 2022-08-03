package com.ssafy.hw.step2;

import java.util.Arrays;

public class UserTest {

	public static void main(String[] args) {
		UserManager um = UserManager.getInstance();
		
		User u1= new User(1,"1234","donghee","서울","010-6645-2753");
		User u2= new User(2,"12345","mayeon","인천","010-5959-5959");
		
		um.add(u1);
		um.add(u2);
		
		System.out.println(Arrays.toString(um.getList()));
		
		System.out.println(um.searchByName("신동희"));
		
		System.out.println("유저수: "+ um.getList().length);
	}

}
