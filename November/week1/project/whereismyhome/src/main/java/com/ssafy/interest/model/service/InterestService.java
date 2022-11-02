package com.ssafy.interest.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.interest.model.InterestDto;

public interface InterestService {
	List<InterestDto> getList(String user_id) throws Exception;
	void insert(InterestDto interestDto) throws Exception;
	void delete(String user_id, String dongCode)throws Exception;
	int count(String user_id)throws Exception;
}
