package com.ssafy.edu.user;

import java.sql.SQLException;

public interface IMemberDao {
	boolean registry(Member member) throws SQLException;
	Member login(Member member) throws SQLException;
	Member getMember(String userId) throws SQLException;
	
}
