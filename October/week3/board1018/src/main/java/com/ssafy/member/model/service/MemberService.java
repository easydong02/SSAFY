package com.ssafy.member.model.service;

import java.util.List;

import com.ssafy.board.model.GuestBookDto;
import com.ssafy.member.model.MemberDto;

public interface MemberService {
	void registerMember(MemberDto member) throws Exception;
	MemberDto login(MemberDto member) throws Exception;
	int idCheck(String userId) throws Exception;
}
