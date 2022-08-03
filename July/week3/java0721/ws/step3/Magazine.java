package com.ssafy.ws.step3;

public class Magazine extends Book {
	private int year;
	private int month;
	public Magazine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Magazine(String isbn, String title, String author, String pulisher, int price, String desc,
			int year, int month) {
		super(isbn, title, author, pulisher, price, desc);
		this.year= year;
		this.month = month;
	}
	@Override
	public String toString() {
		return "Magazine ["+super.toString()+"year=" + year + ", month=" + month + "]";
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
	
	
}
