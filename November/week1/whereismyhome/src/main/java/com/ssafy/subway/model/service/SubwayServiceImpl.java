package com.ssafy.subway.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.housedeal.model.HouseDealInfo;
import com.ssafy.subway.dao.ISubwayDao;
import com.ssafy.subway.dao.SubwayDaoImpl;
import com.ssafy.subway.model.Subway;

public class SubwayServiceImpl implements ISubwayService {
	
	private static ISubwayService service = new SubwayServiceImpl();
	private ISubwayDao dao;
	public SubwayServiceImpl() {
		dao = SubwayDaoImpl.getInstance();
	}
	
	public static ISubwayService getInstance() {
		return service;
	}
	
	@Override
	public List<Subway> getSubway(String sido) throws SQLException {
		return dao.getSubway(sido);
	}

}
