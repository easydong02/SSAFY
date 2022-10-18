package com.ssafy.member.model.mapper;

import java.util.List;
import java.util.Map;

import com.ssafy.board.model.GuestBookDto;
import com.ssafy.member.model.MemberDto;

public interface MemberMapper {
	void registerMember(MemberDto member);
	MemberDto login(MemberDto member);
	int idCheck(String userId);
}
