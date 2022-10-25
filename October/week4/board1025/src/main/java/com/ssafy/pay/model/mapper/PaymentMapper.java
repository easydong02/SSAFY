package com.ssafy.pay.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.pay.model.PaymentDto;

@Mapper
public interface PaymentMapper {
	int write(PaymentDto pdto) throws SQLException;
	List<PaymentDto> list(String userid) throws SQLException;
	List<PaymentDto> lists() throws SQLException;
	void fin(int pid)throws SQLException;
	
	// #21# 월별 벌금 목록 
	List<PaymentDto> calendar() throws SQLException;
}
