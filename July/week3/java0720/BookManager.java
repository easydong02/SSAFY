package com.ssafy;

import java.util.Arrays;

public class BookManager {
	private static final int MAX_SIZE = 100;
	private Book[] books;
	private int size;

	private static BookManager manager = new BookManager();

	private BookManager() {
		books = new Book[MAX_SIZE];
	}

	public static BookManager getInstance() {
		return manager;
	}

	// ��� �޼���
	public void add(Book book) {
		if (searchByIsbn(book.getIsbn()) == null) {
			books[size++] = book; // å����
		}
	}

	public Book searchByIsbn(String isbn) {
		Book b = null;

		for (int i = 0; i < size; i++) {
			if (books[i].getIsbn().equals(isbn)) {
				return books[i];

			}
		}
		return null;

	}

	public Book[] getList() {
		return Arrays.copyOf(books, size);
	}

	public void remove(String isbn) {
		Book b = searchByIsbn(isbn);
		int i = 0;
		if (b != null) {
			for (i = 0; i < books.length; i++) {
				if (b == books[i]) {
					books[i] = null;
					break;
				}
			}
			for (int j = i; j < size - 1; j++) {
				books[j] = books[j + 1];

				if (j == size - 2) {
					books[j + 1] = null;
					size -= 1;
				}
			}
			
		} else {
			System.out.println("삭제할 책이 없습니다.");
		}
	}

}
