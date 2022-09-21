package com.ssafy.backend.dao;

import java.sql.SQLException;

import com.ssafy.backend.dto.User;

public interface UserDao {
	User select(String id) throws SQLException;
	User login(User user) throws SQLException;
	int registry(User user) throws SQLException;
}	
