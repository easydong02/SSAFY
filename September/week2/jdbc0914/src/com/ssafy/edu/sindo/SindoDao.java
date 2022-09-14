package com.ssafy.edu.sindo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc0914.DataBaseSindo;
import jdbc0914.EmpDto;

public class SindoDao extends DataBaseSindo {
	
	public boolean insertBoard(SindoBoardDto dto) {
		int count=0;
		String sql= " insert into sinboard(writer,title,content,wdate) values "
				+" (?,?,?, now())";
		
		Connection conn =null;
		PreparedStatement stmt= null;
		try {
			conn= this.getConnection();
			System.out.println(this.getClass() +" insertBoard 2/6 S");
			stmt= conn.prepareStatement(sql);
			int j=1;
			stmt.setString(j, dto.getWriter());
			stmt.setString(++j, dto.getTitle());
			stmt.setString(++j, dto.getContent());
			
			System.out.println(this.getClass() +" insertBoard 3/6 S");
			count = stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(this.getClass() +" insertBoard F"+ e);
		}finally {
			this.close(conn, stmt, null);
		}
		
		
		return count >0? true:false;
	}
	
	public List<SindoBoardDto> getBoardList(){
		List<SindoBoardDto> emps = new ArrayList<>();
		String sql="SELECT IDS, WRITER, TITLE, CONTENT, WDATE FROM SINBOARD ORDER BY WDATE ASC";
		
		Connection conn= null;
		PreparedStatement stmt=null;
		ResultSet rs= null;
		
		try {
			conn= this.getConnection();
			System.out.println(this.getClass()+" 2/6 S");
			stmt=conn.prepareStatement(sql);
			System.out.println(this.getClass()+" 3/6 S");
			rs= stmt.executeQuery();
			System.out.println(this.getClass()+" 4/6 S");
			
			while(rs.next()) {
				int i =1;
				SindoBoardDto dto =new SindoBoardDto(rs.getInt(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++));
				emps.add(dto);
			}
			
			System.out.println(this.getClass()+" 5/6 S");
		} catch (SQLException e) {
			System.out.println(this.getClass()+" F "+e);
		} finally {
			this.close(conn, stmt, rs);
			System.out.println(this.getClass()+" 6/6 S");
		}
		
		return emps;
	}
}
