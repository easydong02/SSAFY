package com.ssafy.member.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	
	private MemberMapper mmapper;
	
	@Autowired
	public MemberServiceImpl(MemberMapper memberMapper) {
		this.mmapper = memberMapper;
	}
	
	@Override
	public void regist(MemberDto member) throws Exception {
		mmapper.regist(member);
	}
	@Override
	public MemberDto login(Map<String, String> map) throws Exception {
		return mmapper.login(map);
	}
	@Override
	public MemberDto findPwd(Map<String, String> map) throws Exception {
		return  mmapper.findPwd(map);
	}
	@Override
	public MemberDto getInfo(String id) throws Exception {
		return mmapper.getInfo(id);
	}
	@Override
	public void update(MemberDto member) throws Exception {
		mmapper.update(member);
	}
	@Override
	public List<MemberDto> getList() throws Exception {
		return mmapper.getList();
		
	}
	@Override
	public void delete(String id) throws Exception{
		mmapper.delete(id);
	}
	
//	@Override
//	public int idCheck(String userId) throws Exception {
//		return memberDao.idCheck(userId);
//	}
//
//	@Override
//	public void joinMember(MemberDto memberDto) throws Exception {
//		memberDao.joinMember(memberDto);
//	}
//
//	@Override
//	public MemberDto loginMember(String userId, String userPwd) throws Exception {
//		return memberDao.loginMember(userId, userPwd);
//	}

}
