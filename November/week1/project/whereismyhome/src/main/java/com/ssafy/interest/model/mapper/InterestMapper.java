package com.ssafy.interest.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.interest.model.InterestDto;

@Mapper
public interface InterestMapper {
	List<InterestDto> getList(String user_id) throws SQLException;
	void insert(InterestDto interestDto) throws SQLException;
	void delete(String user_id, String dongCode)throws SQLException;
	int count(String user_id)throws SQLException;
}
