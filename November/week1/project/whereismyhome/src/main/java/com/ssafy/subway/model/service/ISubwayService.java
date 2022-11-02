package com.ssafy.subway.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.subway.model.Subway;

public interface ISubwayService {
	List<Subway> getSubway(String sido)  throws SQLException ;
}
