package com.ssafy.backend.service;

import java.sql.SQLException;

import com.ssafy.backend.dao.UserDao;
import com.ssafy.backend.dao.UserDaoImpl;
import com.ssafy.backend.dto.User;

public class UserService {
	
	private static UserService service = new UserService();
	
	private UserService() {
		uDao=new UserDaoImpl();
	}
	
	public static UserService getInstance() {
		return service;
	}
	
	UserDao uDao;

	public User select(String id) throws SQLException {
		return uDao.select(id);
	}

	public User login(User user) throws SQLException {
		return uDao.login(user);
	}

	public int registry(User user) throws SQLException {
		return uDao.registry(user);
	} 
}
