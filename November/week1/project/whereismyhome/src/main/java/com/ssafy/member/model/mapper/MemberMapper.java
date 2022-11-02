package com.ssafy.member.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.member.model.MemberDto;


@Mapper
public interface MemberMapper {
	void regist(MemberDto member) throws Exception;
	MemberDto login(Map<String, String> map) throws Exception;
	MemberDto findPwd(Map<String, String> map) throws Exception;
	MemberDto getInfo(String id) throws Exception;
	void update(MemberDto member)throws Exception;
	List<MemberDto> getList() throws Exception;
	void delete(String id)throws Exception;
}
