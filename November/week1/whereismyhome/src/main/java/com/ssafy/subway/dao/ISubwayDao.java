package com.ssafy.subway.dao;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.subway.model.Subway;

public interface ISubwayDao {
	List<Subway> getSubway(String sido)  throws SQLException ;
}
