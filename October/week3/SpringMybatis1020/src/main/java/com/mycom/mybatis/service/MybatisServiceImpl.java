package com.mycom.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.mybatis.dao.MybatisDao;
import com.mycom.mybatis.dto.EmpDto;

@Service
public class MybatisServiceImpl implements MybatisService {
	
	@Autowired
	MybatisDao dao;
	
	@Override
	public EmpDto empDetail(int employeeId) {
		
		return dao.empDetail(employeeId);
	}

	@Override
	public List<EmpDto> empList() {
		// TODO Auto-generated method stub
		return dao.empList();
	}

	@Override
	public int empInsert(EmpDto dto) {
		// TODO Auto-generated method stub
		return dao.empInsert(dto);
	}

	@Override
	public int empUpdate(EmpDto dto) {
		// TODO Auto-generated method stub
		return dao.empUpdate(dto);
	}

	@Override
	public int empDelete(int employeeId) {
		// TODO Auto-generated method stub
		return dao.empDelete(employeeId);
	}

}
