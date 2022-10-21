package com.ssafy.member.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {
	
	private MemberDao memberDao;
	
	@Autowired
	private MemberServiceImpl(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	@Transactional
	public int idCheck(String userId) throws Exception {
		return memberDao.idCheck(userId);
	}

	@Override
	@Transactional
	public void joinMember(MemberDto memberDto) throws Exception {
		memberDao.joinMember(memberDto);
	}

	@Override
	@Transactional
	public MemberDto loginMember(Map<String, String> map) throws Exception {
		System.out.println("서비스 들어옴");
		return memberDao.loginMember(map);
	}

}
