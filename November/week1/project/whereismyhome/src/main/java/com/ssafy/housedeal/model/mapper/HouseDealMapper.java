package com.ssafy.housedeal.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.housedeal.model.HouseDealInfo;


@Mapper
public interface HouseDealMapper {
	List<HouseDealInfo> getHouseDeal(String fullCode, String dealYear, String dealMonth) throws SQLException;
	List<HouseDealInfo> getHouseDealFull(String dongCode) throws SQLException;
}
