package com.ssafy.ws.step3;

import java.util.Arrays;

public class BookManager implements IBookManager{
	private int size;
	private Book[] books; // is has dependency
	private static final int MAX_SIZE;
	static {//한번 가능
		MAX_SIZE= 100;
	}
	
	
	private static BookManager bm = new BookManager();
	
	private BookManager() {
		super();
		books = new Book[MAX_SIZE];
	}
	
	public static BookManager getInstance() {
		return bm;
	}
	
	
	public Book searchByIsbn (String isbn) {
		for (int i = 0; i < size; i++) {
			if(books[i].getIsbn().equals(isbn.trim()) ) {
				return books[i];
			}
		}
		return null;
	}
	
	public void add(Book book) {
		if(searchByIsbn(book.getIsbn())==null) {
			books[size++] = book;
		}
	}
	
	public void remove(String isbn) {
		for (int i = 0; i < size; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				books[i] = books[--size];
				return;
			}
		}
	}
	
	public Book[] getList() {
		return  Arrays.copyOf(books, size);
	}
	
	public Book[] searchByTitle(String title) {
		int cnt=0;
		for (int i = 0; i < size; i++) {
			if(books[i].getTitle().contains(title)) {
				Book temp = books[i];
				books[i] = books[cnt];
				books[cnt] =temp;
				cnt ++;
			}
		}
		return Arrays.copyOf(books, cnt);
	}
	
	public Magazine[] getMagazine() {
		int cnt=0;
		for (int i = 0; i < size; i++) {
			if(books[i] instanceof Magazine) {
				cnt ++;
			}
		}
		
		Magazine[] magas= new Magazine[cnt];
		
		int t=0;
		for (int i = 0; i < size; i++) {
			if(books[i] instanceof Magazine) {
				magas[t++]=(Magazine)books[i];
			}
		}
		return magas;
	}
	
	public Book[] getBooks() {
		int cnt=0;
		for (int i = 0; i < size; i++) {
			if(!(books[i] instanceof Magazine)) {
				Book temp = books[i];
				books[i]= books[cnt];
				books[cnt]=temp;
				cnt ++;
			}
		}
		return    Arrays.copyOf(books, size);
	}
	
	
	public int getTotalPrice() {
		int total =0;
		for (int i = 0; i < size; i++) {
			total +=this.books[i].getPrice();
		}
		
		return total;
	}
	
	public double getPriceAvg() {
		return (double)getTotalPrice()/size;
	}

	
}
