package com.ssafy.ws.step3;

public class BookManager {
	
	private final static int MAX_SIZE= 100;
	private int size;
	private Book[] books;
	
	private static BookManager bm= new BookManager();
	private BookManager() {
		books= new Book[MAX_SIZE];
	}
	
	public static BookManager getInstance() {
		return bm;
	}
	
	
	public Book searchByIsbn (String isbn) {
		for (int i = 0; i < size; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				return books[i];
			}
		}
		return null;
	}
	
	public void add(Book book) {
		Book b= searchByIsbn(book.getIsbn());
		if(b ==null) {
			books[size++]=book;
		}
	}
	
	public Book[] getBooks() {
		int cnt= 0;
		for (int i = 0; i < size; i++) {
			if(!(books[i] instanceof Magazine)) {
				cnt++;
			}
		}
		Book[] bb= new Book[cnt];
		int tt=0;
		for (int i =0; i<size; i++) {
			if(!(books[i] instanceof Magazine)) {
				bb[tt++]= books[i];
			}
		}
		return bb;
	}
	public Magazine[] getMegazines() {
		int cnt= 0;
		for (int i = 0; i < size; i++) {
			if((books[i] instanceof Magazine)) {
				cnt++;
			}
		}
		Magazine[] mm= new Magazine[cnt];
		int tt=0;
		for (int i =0; i<size; i++) {
			if((books[i] instanceof Magazine)) {
				mm[tt++]= (Magazine)books[i];
			}
		}
		return mm;
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
