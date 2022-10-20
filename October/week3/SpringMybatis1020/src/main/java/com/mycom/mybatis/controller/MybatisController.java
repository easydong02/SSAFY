package com.mycom.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.mybatis.dto.EmpDto;
import com.mycom.mybatis.service.MybatisService;

@Controller
public class MybatisController {
	
	@Autowired
	MybatisService service;
	
	//상세 1건
	@GetMapping(value="/empDetail/{employeeId}")
	@ResponseBody // 메소드가 리턴하는 객체를 spring이 json으로 변환해서 frontend에 전달한다.
	public EmpDto empDetail(@PathVariable int employeeId) {
		System.out.println(employeeId);
		return service.empDetail(employeeId);
	}
	
	@GetMapping(value="/empList")
	@ResponseBody // 메소드가 리턴하는 객체를 spring이 json으로 변환해서 frontend에 전달한다.
	public List<EmpDto> empList() {
		return service.empList();
	}
	
	
	//등록
	@PostMapping(value="/empInsert")
	@ResponseBody
	public int empInsert(EmpDto empDto) {
		System.out.println(empDto);
		int ret = service.empInsert(empDto);
		return ret;
	}
	
	
	//수정
	@PostMapping(value="/empUpdate")
	@ResponseBody
	public int empUpdate(EmpDto empDto) {
		System.out.println(empDto);
		int ret = service.empUpdate(empDto);
		return ret;
	}
	
	
	
	//수정
	@PostMapping(value="/empDelete")
	@ResponseBody
	public int empDelete(int employeeId) {
		System.out.println(employeeId);
		int ret = service.empDelete(employeeId);
		return ret;
	}
	
	
	
}
