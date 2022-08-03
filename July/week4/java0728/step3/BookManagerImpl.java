package com.ssafy.ws.step3;

import java.util.ArrayList;
import java.util.List;

public class BookManagerImpl implements IBookManager {
	private List<Book> books;
	
	private static IBookManager bm = new BookManagerImpl();
	private BookManagerImpl() {
		books= new ArrayList<>();
	}
	
	
	public static IBookManager getInstance() {
		return bm;
	}
	
	@Override
	public void add(Book book) {
		Book b = this.searchByIsbn(book.getIsbn());
		if(b==null) {
			books.add(b);
		}
	}

	@Override
	public void remove(String isbn) {
		for (int i = books.size()-1; i >=0; i--) {
			if(books.get(i).getIsbn().equals(isbn)) {
				books.remove(i);  // i번째 지우기
				return;
			}
			
		}

	}

	@Override
	public Book[] getList() {
		return books.toArray(new Book[books.size()]);
	}

	@Override
	public Book searchByIsbn(String isbn) {
		for(Book b: books) {
			if(b.getIsbn().equals(isbn)) {
				return b;
			}
		}
		return null;
	}

	@Override
	public Book[] searchByTitle(String title) {
		ArrayList<Book> temp = new ArrayList<>();
		for(Book b : books) {
			if(b.getTitle().contains(title)) {
				temp.add(b);
			}
		}
		return temp.toArray(new Book[temp.size()]);
	}

	@Override
	public Magazine[] getMagazines() {
		ArrayList<Magazine> temp = new ArrayList<>();
		for(Book b : books) {
			if(b instanceof Magazine) {
				temp.add((Magazine)b);
			}
		}
		return temp.toArray(new Magazine[temp.size()]);
	}

	@Override
	public Book[] getBooks() {
		ArrayList<Book> temp = new ArrayList<>();
		for(Book b : books) {
			if(!(b instanceof Magazine)) {
				temp.add(b);
			}
		}
		return temp.toArray(new Book[temp.size()]);
	}

	@Override
	public int getTotalPrice() {
		int sum=0;
		for(Book b : books) {
			sum += b.getPrice();
		}
		return sum;
	}

	@Override
	public double getPriceAvg() {
		int sum = getTotalPrice();
		if(books.size()!=0) {
			return (double)sum/books.size();
		}
		return 0.0;
	}

	@Override
	public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException {
		Book b= this.searchByIsbn(isbn);
		
		if(b==null) {
			throw new ISBNNotFoundException(isbn+"은 존재하지 않는 ISBN입니다."); //throw는 return과 같은 효과, 메서드 끝냄
		}
		int curquantity = b.getQuantity();
		if(curquantity <quantity) {
			throw new QuantityException("수량이 부족하여 판매를 할 수 없습니다.");
		}else if (curquantity == quantity) { //다 팔아버림 그냥 없앰.
			this.remove(isbn);
		}else {
			b.setQuantity(curquantity-quantity); //수량 조절
		}

	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		Book b = this.searchByIsbn(isbn);
		if(b==null) {
			throw new ISBNNotFoundException(isbn+"은 존재하지 않는 ISBN입니다.");
		}
		int curquantity = b.getQuantity();
		b.setQuantity(curquantity+quantity);
	}

}
