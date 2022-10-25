package com.ssafy.pay.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pay.model.PaymentDto;
import com.ssafy.pay.model.mapper.PaymentMapper;
@Service
public class PaymentServiceImpl implements PaymentService {

	private PaymentMapper paymentMapper;
	
	@Autowired
	public PaymentServiceImpl(PaymentMapper paymentMapper) {
		this.paymentMapper = paymentMapper;
	}

	@Override
	public int write(PaymentDto pdto) throws SQLException {
		return paymentMapper.write(pdto);
	}

	@Override
	public List<PaymentDto> list(String userid) throws SQLException {
		return paymentMapper.list(userid);
	}

	@Override
	public List<PaymentDto> lists() throws SQLException {
		return paymentMapper.lists();
	}

	@Override
	public void fin(int pid) throws SQLException {
		paymentMapper.fin(pid);
	}

	// #21# 월별 벌금 목록 
	@Override
	public List<PaymentDto> calendar() throws SQLException {
		return paymentMapper.calendar();
	}

}
