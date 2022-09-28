package com.ssafy.backend.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.backend.dao.UserDao;
import com.ssafy.backend.dao.UserDaoImpl;
import com.ssafy.backend.dto.User;

public class UserService {

	private static UserService service=new UserService();
	private UserService() {
		udao=new UserDaoImpl();
	}
	public static UserService getInstance() {
		return service;
	}
	UserDao udao;
	
	public User select(String id) throws SQLException {
		return udao.select(id);
	}
	
	public User login(User user) throws SQLException {
		return udao.login(user);
	}
	
	public int registry(User user) throws SQLException {
		return udao.registry(user);
	}
	
	public List<User> selectAll() throws SQLException {
		return udao.selectAll();
	}
	
	
}
