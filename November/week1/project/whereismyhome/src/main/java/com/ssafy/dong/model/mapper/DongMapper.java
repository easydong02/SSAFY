package com.ssafy.dong.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.ssafy.dong.model.Dong;

@Mapper
public interface DongMapper {
	List<String> getSidoNames() throws SQLException;
	List<String> getGugunNames(String sidoName) throws SQLException;
	List<Dong> getDongNames(Dong dong) throws SQLException;
	Dong selectdong(String dongCode) throws SQLException;
}
