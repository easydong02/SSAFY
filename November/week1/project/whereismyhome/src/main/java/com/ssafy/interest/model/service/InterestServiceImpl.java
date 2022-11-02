package com.ssafy.interest.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.mapper.BoardMapper;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.BoardServiceImpl;
import com.ssafy.interest.model.InterestDto;
import com.ssafy.interest.model.mapper.InterestMapper;

@Service
public class InterestServiceImpl implements InterestService {
	private InterestMapper imapper;
	
	@Autowired
	public InterestServiceImpl(InterestMapper interestMapper) {
		imapper= interestMapper;
	}

	@Override
	public List<InterestDto> getList(String user_id) throws Exception{
		return imapper.getList(user_id);
	}

	@Override
	public void insert(InterestDto interestDto) throws Exception {
		 imapper.insert(interestDto);
	}

	@Override
	public void delete(String user_id, String dongCode) throws Exception {
		 imapper.delete(user_id, dongCode);
	}


	@Override
	public int count(String user_id) throws Exception {
		return imapper.count(user_id);
	}

}
