package com.ssafy.backend.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.backend.dao.BookDao;
import com.ssafy.backend.dao.BookDaoImpl;
import com.ssafy.backend.dto.Book;

public class BookService{
	
	private static BookService service = new BookService();
	
	private BookService() {
		bDao= new BookDaoImpl();
	}
	
	public static BookService getInstance() {
		return service;
	}
	
	BookDao bDao;

	public int insert(Book book) throws SQLException {
		return bDao.insert(book);
	}

	public List<Book> select() throws SQLException {
		return bDao.select();
	}

	public Book getBook(String isbn) throws SQLException {
		return bDao.getBook(isbn);
	}

	public int update(Book book) throws SQLException {
		return bDao.update(book);
	}

	public int delete(String isbn) throws SQLException {
		return bDao.delete(isbn);
	}
}
