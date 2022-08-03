package com.ssafy;

import java.util.Arrays;

public class BookTest2 {

	public static void main(String[] args) {
		
		
		Book b1 = new Book("21424","Java Pro","신동희","jaen.kr",15000,"Java 문법");
		Book b2 = new Book("35355","신동희","신동희","jaen.kr",30000,"SW 모델링");
		Book b3 = new Book("35455","신동희2","신동희","jaen.kr",30000,"SW 모델링");
		Book b4 = new Book("35555","신동희3","신동희","jaen.kr",30000,"SW 모델링");
		Book b5 = new Book("35655","신동희4","신동희","jaen.kr",30000,"SW 모델링");
		Book b6 = new Book("35755","신동희5","신동희","jaen.kr",30000,"SW 모델링");
		
		
		BookManager bookManager1 = BookManager.getInstance();
		
		bookManager1.add(b1);
		bookManager1.add(b2);
		bookManager1.add(b3);
		bookManager1.add(b4);
		bookManager1.add(b5);
		bookManager1.add(b6);
		
		
		
		bookManager1.remove("35455");
		
		Book[] books = bookManager1.getList();
		for(Book book : books) {
			System.out.println(book);
		}
	}

}
