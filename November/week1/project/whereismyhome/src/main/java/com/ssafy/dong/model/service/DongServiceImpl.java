package com.ssafy.dong.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dong.model.Dong;
import com.ssafy.dong.model.mapper.DongMapper;

@Service
public class DongServiceImpl implements IDongService {
	
	DongMapper dmapper;
	
	@Autowired
	private DongServiceImpl(DongMapper dongmapper){
		super();
		dmapper = dongmapper;
	}
	
	@Override
	public List<String> getSidoNames() throws SQLException {
		// TODO Auto-generated method stub
		return dmapper.getSidoNames();
	}

	@Override
	public List<String> getGugunNames(String sidoName) throws SQLException {
		// TODO Auto-generated method stub
		return dmapper.getGugunNames(sidoName);
	}

	@Override
	public List<Dong> getDongNames(Dong dong) throws SQLException {
		// TODO Auto-generated method stub
		return dmapper.getDongNames(dong);
	}
	@Override
	public Dong selectdong(String dongCode) throws SQLException {
		return dmapper.selectdong(dongCode);
	}

}
