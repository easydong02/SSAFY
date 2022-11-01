package com.ssafy.subway.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.housedeal.model.HouseDealInfo;
import com.ssafy.subway.model.Subway;
import com.ssafy.util.DBUtil;

public class SubwayDaoImpl implements ISubwayDao {
	DBUtil db;
	private static ISubwayDao dao = new SubwayDaoImpl();
	
	public SubwayDaoImpl() {
		db= DBUtil.getInstance();
	}
	
	public static ISubwayDao getInstance() {
		return dao;
	}
	
	@Override
	public List<Subway> getSubway(String sido) throws SQLException {
		String sidoTwo = sido.substring(0,2);
		String sql = " select kakaoBunji from subway \n";
		sql += " where substr(kakaoBunji,1,2) = ? ";
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		List<Subway> list = new ArrayList<>();
		try {
			conn = db.getConnection();
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setString(1, sidoTwo);
			System.out.println(pstmt);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				Subway subway = new Subway();
				subway.setKakaoBunji(rs.getString(1));
				list.add(subway);
			}
		}finally {
			db.close(rs,pstmt,conn);
		}
		return list;
	}

}
