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

	DBUtil db=DBUtil.getInstance();
	
	@Override
	public int insert(Book book)  throws SQLException{
		
		StringBuilder sql=new StringBuilder();
		sql.append(" insert into book(isbn,title,author,price,`desc`) ");
		sql.append(" values(?,?,?,?,?) ");
		Connection conn=null;
		PreparedStatement psmt=null;
		int count=0;
		try {
			conn=db.getConnection();
			psmt=conn.prepareStatement(sql.toString());
			System.out.println(sql.toString());
			int i=1;
			psmt.setString(i++, book.getIsbn());
			psmt.setString(i++, book.getTitle());
			psmt.setString(i++, book.getAuthor());
			psmt.setInt(i++, book.getPrice());
			psmt.setString(i++, book.getDesc());
			count=psmt.executeUpdate();
			
		} finally {
			db.close(psmt, conn);
		}
		return count;
	}

	@Override
	public List<Book> select() throws SQLException {
		StringBuilder sql=new StringBuilder();
		sql.append(" select isbn,title,author,price,`desc`,img ");
		sql.append(" from book order by isbn ");
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		List<Book> books=new ArrayList<>();
		try {
			conn=db.getConnection();
			psmt=conn.prepareStatement(sql.toString());
			System.out.println(sql.toString());
			rs=psmt.executeQuery();
			while(rs.next()) {
				int i=1;
				Book book=new Book(
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++), 
						rs.getInt(i++), 
						rs.getString(i++), 
						rs.getString(i++));
				books.add(book);
			}
		} finally {
			db.close(rs,psmt, conn);
		}
		return books;
	}

	@Override
	public Book getBook(String isbn) throws SQLException {
		StringBuilder sql=new StringBuilder();
		sql.append(" select isbn,title,author,price,`desc`,img ");
		sql.append(" from book where isbn=? ");
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Book book=null;
		try {
			conn=db.getConnection();
			psmt=conn.prepareStatement(sql.toString());
			psmt.setString(1, isbn);
			System.out.println(sql.toString());
			rs=psmt.executeQuery();
			while(rs.next()) {
				int i=1;
				book=new Book(
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++), 
						rs.getInt(i++), 
						rs.getString(i++), 
						rs.getString(i++));
			}
		} finally {
			db.close(rs,psmt, conn);
		}
		return book;
	}

	@Override
	public int update(Book book) throws SQLException {
		StringBuilder sql=new StringBuilder();
		sql.append(" update  book set title=?,author=?,price=?,`desc`=? ");
		sql.append(" where isbn=? ");
		Connection conn=null;
		PreparedStatement psmt=null;
		int count=0;
		try {
			conn=db.getConnection();
			psmt=conn.prepareStatement(sql.toString());
			System.out.println(sql.toString());
			int i=1;
			psmt.setString(i++, book.getTitle());
			psmt.setString(i++, book.getAuthor());
			psmt.setInt(i++, book.getPrice());
			psmt.setString(i++, book.getDesc());
			psmt.setString(i++, book.getIsbn());
			count=psmt.executeUpdate();
			
		} finally {
			db.close(psmt, conn);
		}
		return count;
	}

	@Override
	public int delete(String isbn) throws SQLException {
		StringBuilder sql=new StringBuilder();
		sql.append(" delete from   book  ");
		sql.append(" where isbn=? ");
		Connection conn=null;
		PreparedStatement psmt=null;
		int count=0;
		try {
			conn=db.getConnection();
			psmt=conn.prepareStatement(sql.toString());
			System.out.println(sql.toString());
			psmt.setString(1, isbn);
			count=psmt.executeUpdate();
			
		} finally {
			db.close(psmt, conn);
		}
		return count;
	}

}
