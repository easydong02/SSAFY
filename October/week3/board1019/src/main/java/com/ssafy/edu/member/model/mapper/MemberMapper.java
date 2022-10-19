package com.ssafy.edu.member.model.mapper;

import com.ssafy.edu.member.model.Member;

public interface MemberMapper {
	void registerMember(Member member) throws Exception;
	Member login(Member member)  throws Exception;
	int idCheck(String userId)  throws Exception;
}
