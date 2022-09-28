package com.ssafy.backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.backend.dto.User;
import com.ssafy.backend.util.DBUtil;

public class UserDaoImpl implements UserDao {
	DBUtil db=DBUtil.getInstance();
	@Override
	public User select(String id) throws SQLException {
		StringBuilder sql=new StringBuilder();
		sql.append(" select id,name,pass, rec_id ");
		sql.append(" from user where id=?   ");
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		User login=null;
		try {
			conn=db.getConnection();
			psmt=conn.prepareStatement(sql.toString());
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			while(rs.next()) {
				int i=1;
				login=new User(
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++));
			}
		} finally {
			db.close(rs,psmt, conn);
		}
		return login;
	}

	@Override
	public User login(User user) throws SQLException {
		System.out.println(user);
		StringBuilder sql=new StringBuilder();
		sql.append(" select id,name,rec_id ");
		sql.append(" from user where id=? and pass=?  ");
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		User login=null;
		try {
			conn=db.getConnection();
			psmt=conn.prepareStatement(sql.toString());
			psmt.setString(1, user.getId());
			psmt.setString(2, user.getPass());
			rs=psmt.executeQuery();
			while(rs.next()) {
				int i=1;
				login=new User(
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++));
			}
		} finally {
			db.close(rs,psmt, conn);
		}
		return login;
	}

	@Override
	public int registry(User user) throws SQLException {
		StringBuilder sql=new StringBuilder();
		if(user.getRecId()==null || user.getRecId().equals("")) {
			sql.append(" insert into user(id,name,pass) ");
			sql.append(" values(?,?,?) ");
		}else {
			sql.append(" insert into user(id,name,pass,rec_id) ");
			sql.append(" values(?,?,?,?) ");
		}
		System.out.println(user);
		// rec_id 포린키 : 비동기로 있는 아이디 찾는 로직을 나중에 추가하세요
		Connection conn=null;
		PreparedStatement psmt=null;
		int count=0;
		try {
			conn=db.getConnection();
			psmt=conn.prepareStatement(sql.toString());
			System.out.println(sql.toString());
			int i=1;
			if(user.getRecId()==null || user.getRecId().equals("")) {
				psmt.setString(i++, user.getId());
				psmt.setString(i++, user.getName());
				psmt.setString(i++, user.getPass());
			}else {
				psmt.setString(i++, user.getId());
				psmt.setString(i++, user.getName());
				psmt.setString(i++, user.getPass());
				psmt.setString(i++, user.getRecId());
			}
			count=psmt.executeUpdate();
			
		} finally {
			db.close(psmt, conn);
		}
		return count;
	}

	@Override
	public List<User> selectAll() throws SQLException {
		List<User> list = new ArrayList<User>();
		StringBuilder sql=new StringBuilder();
		sql.append(" select id ");
		sql.append(" from user ");
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		User login=null;
		try {
			conn=db.getConnection();
			psmt=conn.prepareStatement(sql.toString());
			rs=psmt.executeQuery();
			while(rs.next()) {
				login=new User();
				login.setId(rs.getString(1));
				list.add(login);
			}
		} finally {
			db.close(rs,psmt, conn);
		}
		return list;
	}

}
