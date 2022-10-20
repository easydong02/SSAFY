package com.mycom.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.mybatis.dto.EmpDto;

@Mapper
public interface MybatisDao {
	EmpDto empDetail(int employeeId); //1건 상세
	List<EmpDto> empList();// 전체 항목
	int empInsert(EmpDto dto);//삽입
	int empUpdate(EmpDto dto);//수정
	int empDelete(int employeeId); //삭제

	
}

// public class MybatisDaoImpl implements MybatisDao{
// method 생성 및 각각 필요한 sql 담긴 클래스 -> 안 만들어도 된다.

