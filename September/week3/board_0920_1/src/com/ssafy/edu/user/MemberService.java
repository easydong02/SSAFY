package com.ssafy.edu.user;

import java.sql.SQLException;

public class MemberService {
	private static MemberService service= new MemberService();
	private MemberService() {
		mdao=new MemberDaoImpl();
	}
	
	public static MemberService getInstance() {
		return service;
	}
	
	private IMemberDao mdao;
	
	public boolean registry(Member member)throws SQLException{
		return mdao.registry(member);
	}
	
	public Member login(Member member) throws SQLException {
		return mdao.login(member);
	}
	
	public Member getMember(String userId) throws SQLException{
		return mdao.getMember(userId);
	}
	
}
