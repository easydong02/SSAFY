package com.ssafy.member.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.GuestBookDto;
import com.ssafy.board.model.mapper.GuestBookMapper;
import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	@Transactional
	public void registerMember(MemberDto member) throws Exception {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.registerMember(member);
	}

	@Override
	@Transactional(readOnly = true)
	public MemberDto login(MemberDto member) throws Exception {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		return memberMapper.login(member);
	}

	@Override
	@Transactional(readOnly = true)
	public int idCheck(String userId) throws Exception {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		return memberMapper.idCheck(userId);
	}
	

}
