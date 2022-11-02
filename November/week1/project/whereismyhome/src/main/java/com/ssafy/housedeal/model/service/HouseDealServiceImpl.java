package com.ssafy.housedeal.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dong.model.mapper.DongMapper;
import com.ssafy.dong.model.service.DongServiceImpl;
import com.ssafy.dong.model.service.IDongService;
import com.ssafy.housedeal.model.HouseDealInfo;
import com.ssafy.housedeal.model.mapper.HouseDealMapper;


@Service
public class HouseDealServiceImpl implements IHouseDealService {

	HouseDealMapper dao;
	
	@Autowired
	public HouseDealServiceImpl(HouseDealMapper dao){
		super();
		this.dao = dao;
	}

	@Override
	public List<HouseDealInfo> getHouseDeal(String fullCode, String dealYear, String dealMonth) throws SQLException {
		// TODO Auto-generated method stub
		return dao.getHouseDeal(fullCode, dealYear, dealMonth);
	}
	@Override
	public List<HouseDealInfo> getHouseDealFull(String dongCode) throws SQLException {
		// TODO Auto-generated method stub
		return dao.getHouseDealFull(dongCode);
	}

}
