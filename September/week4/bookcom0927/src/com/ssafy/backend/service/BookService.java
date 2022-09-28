package com.ssafy.backend.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.backend.dao.BookDao;
import com.ssafy.backend.dao.BookDaoImpl;
import com.ssafy.backend.dto.Book;

public class BookService {

	private static BookService service=new BookService();
	private BookService() {
		bdao=new BookDaoImpl();
	}
	public static BookService getInstance() {
		return service;
	}
	BookDao bdao;
	
	public int insert(Book book) throws SQLException {
		return bdao.insert(book);
	}
	
	public List<Book> select() throws SQLException {
		return bdao.select();
	}
	
	public Book getBook(String isbn) throws SQLException {
		return bdao.getBook(isbn);
	}
	
	public int update(Book book) throws SQLException {
		return bdao.update(book);
	}
	
	public int delete(String isbn) throws SQLException {
		return bdao.delete(isbn);
	}
}
