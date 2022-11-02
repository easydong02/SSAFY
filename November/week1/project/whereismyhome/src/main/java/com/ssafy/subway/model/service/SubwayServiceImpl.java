package com.ssafy.subway.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.subway.model.Subway;
import com.ssafy.subway.model.mapper.SubwayMapper;


@Service
public class SubwayServiceImpl implements ISubwayService {
	
	SubwayMapper dao;
	
	@Autowired
	public SubwayServiceImpl(SubwayMapper dao) {
		super();
		this.dao = dao;
	}
	
	
	@Override
	public List<Subway> getSubway(String sido) throws SQLException {
		return dao.getSubway(sido);
	}

}
