package com.ssafy.edu.member.model.service;

import com.ssafy.edu.member.model.Member;

public interface MemberService {
	void registerMember(Member member) throws Exception;
	Member login(Member member)  throws Exception;
	int idCheck(String userId)  throws Exception;
}
