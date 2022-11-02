package com.ssafy.subway.model.mapper;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.subway.model.Subway;


@Mapper
public interface SubwayMapper {
	List<Subway> getSubway(String sido)  throws SQLException ;
}
