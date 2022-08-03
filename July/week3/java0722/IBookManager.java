package com.ssafy.ws.step3;

import java.util.Arrays;

public interface IBookManager {
	public Book searchByIsbn (String isbn);
	
	public void add(Book book);
	
	public void remove(String isbn);
	
	public Book[] getList() ;
	
	public Book[] searchByTitle(String title);
	
	public Magazine[] getMagazine() ;
	
	public Book[] getBooks() ;
	
	
	public int getTotalPrice();
	
	public double getPriceAvg() ;

	
}
