package com.ssafy.ws.step3;

public class Magazine extends Book {
	private int year;
	private int month;
	
	
	public Magazine() {
		this("","","","",0,"",0,0);
	}
	
	public Magazine(int year, int month) {
		super();
		this.year = year;
		this.month = month;
	}

	public Magazine(String isbn, String title, String author, String publisher, int price, String desc,int year, int month) {
		super(isbn, title, author, publisher, price, desc);
		this.month= month;
		this.year = year;
	}

	public String toString() {
		return "Magazine ["+super.toString()+"year=" + year + ", month=" + month + "]";
	}
	
	
	
	
	
	
	
}
