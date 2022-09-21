package com.ssafy.backend.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.backend.dto.Book;

public interface BookDao {
	int insert(Book book) throws SQLException;
	List<Book> select() throws SQLException;
	Book getBook(String isbn) throws SQLException;
	int update(Book book) throws SQLException;
	int delete(String isbn) throws SQLException;
}
