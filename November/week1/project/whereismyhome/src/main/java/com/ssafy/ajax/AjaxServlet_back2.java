package com.ssafy.ajax;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.dong.model.Dong;
import com.ssafy.dong.model.service.IDongService;
import com.ssafy.housedeal.model.HouseDealInfo;
import com.ssafy.housedeal.model.service.IHouseDealService;
import com.ssafy.subway.model.Subway;
import com.ssafy.subway.model.service.ISubwayService;


@RestController
@RequestMapping("/ajax3")
public class AjaxServlet_back2{
	
	private static final long serialVersionUID = 1L;
	
	IDongService dservice;
	IHouseDealService hdservice;
	ISubwayService subservice;
	
	@Autowired
	public AjaxServlet_back2(IDongService dservice, IHouseDealService hdservice, ISubwayService subservice) {
		this.dservice = dservice;
		this.hdservice = hdservice;
		this.subservice = subservice;
	}	
	
	@RequestMapping("/searchSubway")
	private ResponseEntity<?> dosearchSubway(@RequestBody Map<String, String> map) throws IOException {
		String lat = map.get("lat");
		String lng = map.get("lng");
		String sido = map.get("sido");
		System.out.println(lat + " "+lng+" "+sido);
		
		try {
			List<Subway> lists = subservice.getSubway(sido);
			return new ResponseEntity<List<Subway>>(lists,HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/searchHouseDealInfo")
	private ResponseEntity<?> dosearchHouseDealInfo(@RequestBody Map<String, String> map) throws IOException {
		String fullCode = map.get("fullCode");
		String dealYear = map.get("dealYear");
		String dealMonth = map.get("dealMonth");
		System.out.println(fullCode + " "+dealYear+" "+dealMonth);
		try {
			List<HouseDealInfo> lists = hdservice.getHouseDeal(fullCode, dealYear, dealMonth);
			return new ResponseEntity<List<HouseDealInfo>>(lists,HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	@RequestMapping("/sidoNames")
	private ResponseEntity<?> doGetSidoNames() throws IOException {
		// TODO Auto-generated method stub

		try {
			List<String> lists = dservice.getSidoNames();
			return new ResponseEntity<List<String>>(lists,HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/gugunNames")
	private ResponseEntity<?> doGetGugunNames(@RequestBody Map<String, String> map) throws IOException {
		String sidoName = map.get("sidoName"); 
		System.out.println(sidoName);
		try {
			List<String> lists = dservice.getGugunNames(sidoName);
			return new ResponseEntity<List<String>>(lists,HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping("/dongNames")
	private ResponseEntity<?> doGetDongNames(@RequestBody Map<String, String> map) throws IOException {
		String sidoName = map.get("sidoName"); 
		String gugunName = map.get("gugunName"); 
		Dong dong = new Dong();
		dong.setSidoName(sidoName);
		dong.setGugunName(gugunName);
		try {
			List<Dong> list = dservice.getDongNames(dong);
			return new ResponseEntity<List<Dong>>(list,HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
//	public  void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html; charset=UTF-8");
//		
//		Gson gson = new Gson();
//		String employeeJsonString = "";
////		try {
//////			employeeJsonString = gson.toJson(bservice.select());
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		
//		PrintWriter out = response.getWriter();
//		response.setContentType("application/json");
//		response.setCharacterEncoding("utf-8");
//		out.print(employeeJsonString);
//		out.flush();
//	}
	
}