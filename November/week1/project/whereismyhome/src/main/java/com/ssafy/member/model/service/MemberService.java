package com.ssafy.member.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.member.model.MemberDto;

public interface MemberService {

//	int idCheck(String userId) throws Exception; //아이디 중복검사
//	void joinMember(Member memberDto) throws Exception; //회원가입
//	Member loginMember(String userId, String userPwd) throws Exception;//로그인
	void regist(MemberDto member) throws Exception;
	MemberDto login(Map<String, String> map) throws Exception;
	MemberDto findPwd(Map<String, String> map) throws Exception;
	MemberDto getInfo(String id) throws Exception;
	void update(MemberDto member) throws Exception;
	List<MemberDto> getList() throws Exception;
	void delete(String id) throws Exception;
}
