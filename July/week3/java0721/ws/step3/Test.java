package com.ssafy.ws.step3;

public class Test {

	public static void main(String[] args) {
		// 설계도엔 Object로 나오지만 heap에는 원래 타입으로 저장되어 있다.
		Object obj = new Object();
		Object str =new String();
		
		Book b = new Book();
		Book m = new Magazine();
		
		System.out.println(b instanceof Book);
		System.out.println(b instanceof Magazine); //false
		System.out.println(m instanceof Book);
		System.out.println(m instanceof Magazine);
	}

}
