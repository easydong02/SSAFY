package com.ssafy;

public class BookTest {

	public static void main(String[] args) {
		Book[] books = new Book[2];
		
		books[0] = new Book("21424","Java Pro","���ϳ�","jaen.kr",15000,"Java ����");
		books[1] = new Book("35355","����","�ҳ���","jaen.kr",30000,"SW �𵨸�");
		
		for(Book book: books) {
			System.out.println(book);
		}
	}

}
