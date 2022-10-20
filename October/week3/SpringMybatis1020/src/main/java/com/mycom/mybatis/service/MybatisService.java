package com.mycom.mybatis.service;

import java.util.List;

import com.mycom.mybatis.dto.EmpDto;

public interface MybatisService {
	EmpDto empDetail(int employeeId); //1건 상세
	List<EmpDto> empList();// 전체 항목
	int empInsert(EmpDto dto);//삽입
	int empUpdate(EmpDto dto);//수정
	int empDelete(int employeeId); //삭제
}
