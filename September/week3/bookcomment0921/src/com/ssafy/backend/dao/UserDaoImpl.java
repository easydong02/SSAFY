package com.ssafy.backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.backend.dto.Book;
import com.ssafy.backend.dto.User;
import com.ssafy.backend.util.DBUtil;

public class UserDaoImpl implements UserDao {
	
	DBUtil db= DBUtil.getInstance();

	@Override
	public User select(String id) throws SQLException {
		StringBuilder sql =new StringBuilder();
		sql.append(" select id,name,pass, rec_id \n ");
		sql.append(" from user where id=? ");
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		User login = null;
		try {
			conn =db.getConnection();
			psmt=conn.prepareStatement(sql.toString());
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			while(rs.next()) {
				int i=1;
				login = new User(rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.close(rs,psmt,conn);
		}
		return login;
	}

	@Override
	public User login(User user) throws SQLException {
		StringBuilder sql =new StringBuilder();
		sql.append(" select id,name,rec_id \n ");
		sql.append(" from user where id=? and pass=? ");
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		User login = null;
		try {
			conn =db.getConnection();
			psmt=conn.prepareStatement(sql.toString());
			psmt.setString(1, user.getId());
			psmt.setString(2, user.getPass());
			rs=psmt.executeQuery();
			while(rs.next()) {
				int i=1;
				login = new User(rs.getString(i++),rs.getString(i++),rs.getString(i++));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.close(rs,psmt,conn);
		}
		return login;
	}

	@Override
	public int registry(User user) throws SQLException {
		int count= 0;
		StringBuilder sql =new StringBuilder();
		sql.append(" insert into user(id,name,pass,rec_id) \n ");
		sql.append(" values(?,?,?,?) ");
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn =db.getConnection();
			psmt=conn.prepareStatement(sql.toString());
			int i=1;
			psmt.setString(i++,user.getId());
			psmt.setString(i++, user.getName());
			psmt.setString(i++, user.getPass());
			psmt.setString(i++, user.getRecId());
			count = psmt.executeUpdate();
		}finally {
			db.close(psmt,conn);
		}
		return count;
	}

}
