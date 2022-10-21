package com.ssafy.member.model.dao;

import java.sql.SQLException;
import java.util.Map;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.member.model.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	private final String NAMESPACE = "com.ssafy.member.model.dao.MemberDao.";

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int idCheck(String userId) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + "idCheck", userId);
	}

	@Override
	public void joinMember(MemberDto memberDto) throws SQLException {
		sqlSession.insert(NAMESPACE + "joinMember", memberDto);
	}

	@Override
	public MemberDto loginMember(Map<String, String> map) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + "loginMember", map);
	}

}