package com.ssafy.backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.backend.dto.Book;
import com.ssafy.backend.util.DBUtil;

public class BookDaoImpl implements BookDao {
	
	DBUtil db= DBUtil.getInstance();
	
	@Override
	public int insert(Book book) throws SQLException {
		int count= 0;
		StringBuilder sql =new StringBuilder();
		sql.append(" insert into book(isbn,title,author,price,`desc`) \n ");
		sql.append(" values(?,?,?,?,?) ");
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn =db.getConnection();
			psmt=conn.prepareStatement(sql.toString());
			int i=1;
			psmt.setString(i++, book.getIsbn());
			psmt.setString(i++, book.getTitle());
			psmt.setString(i++, book.getAuthor());
			psmt.setInt(i++, book.getPrice());
			psmt.setString(i++, book.getDesc());
			count = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.close(psmt,conn);
		}
		return count;
	}

	@Override
	public List<Book> select() throws SQLException {
		List<Book> books= new ArrayList<>();
		StringBuilder sql =new StringBuilder();
		sql.append(" select isbn,title,author,price,`desc`,img  \n ");
		sql.append(" from book order by isbn ");
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn =db.getConnection();
			psmt=conn.prepareStatement(sql.toString());
			rs=psmt.executeQuery();
			while(rs.next()) {
				int i=1;
				Book book = new Book(rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getInt(i++),rs.getString(i++),rs.getString(i++));
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.close(rs,psmt,conn);
		}
		return books;
	}

	@Override
	public Book getBook(String isbn) throws SQLException {
		Book book= null;
		StringBuilder sql =new StringBuilder();
		sql.append(" select isbn,title,author,price,`desc`,img  \n ");
		sql.append(" from book \n ");
		sql.append(" where isbn=? ");
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn =db.getConnection();
			psmt=conn.prepareStatement(sql.toString());
			psmt.setString(1, isbn);
			rs=psmt.executeQuery();
			while(rs.next()) {
				int i=1;
				book = new Book(rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getInt(i++),rs.getString(i++),rs.getString(i++));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.close(rs,psmt,conn);
		}
		return book;
	}

	@Override
	public int update(Book book) throws SQLException {
		int count =0;
		StringBuilder sql =new StringBuilder();
		sql.append(" update book set title= ?,author=?,price=?,`desc`=?  \n ");
		sql.append(" where isbn=? ");
		
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn =db.getConnection();
			psmt=conn.prepareStatement(sql.toString());
			psmt.setString(1, book.getTitle());
			psmt.setString(2, book.getAuthor());
			psmt.setInt(3, book.getPrice());
			psmt.setString(4, book.getDesc());
			psmt.setString(5, book.getIsbn());
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.close(psmt,conn);
		}
		return count;
	}

	@Override
	public int delete(String isbn) throws SQLException {
		int count =0;
		StringBuilder sql =new StringBuilder();
		sql.append(" delete from book \n ");
		sql.append(" where isbn=? ");
		
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn =db.getConnection();
			psmt=conn.prepareStatement(sql.toString());
			psmt.setString(1, isbn);
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.close(psmt,conn);
		}
		return count;
	}

}
