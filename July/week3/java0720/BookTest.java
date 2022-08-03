package com.ssafy;

public class BookTest {

	public static void main(String[] args) {
		Book[] books = new Book[2];
		
		books[0] = new Book("21424","Java Pro","김하나","jaen.kr",15000,"Java 문법");
		books[1] = new Book("35355","설계","소나무","jaen.kr",30000,"SW 모델링");
		
		for(Book book: books) {
			System.out.println(book);
		}
	}

}
