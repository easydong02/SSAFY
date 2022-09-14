package jdbc0914;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HRDao extends DataBase {
	public List<EmpDto> getEmpList(){
		List<EmpDto> emps = new ArrayList<>();
		String sql="SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, DEPARTMENT_ID FROM EMPLOYEES ORDER BY EMPLOYEE_ID ASC";
		
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
				EmpDto dto =new EmpDto(rs.getInt(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getInt(i++));
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
	
	public EmpDto getEmp(int employee_id){
		EmpDto emp = null;
		String sql="SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, DEPARTMENT_ID FROM EMPLOYEES WHERE EMPLOYEE_ID=? ";
		
		Connection conn= null;
		PreparedStatement stmt=null;
		ResultSet rs= null;
		
		try {
			conn= this.getConnection();
			System.out.println(this.getClass()+" 2/6 S");
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, employee_id);
			System.out.println(this.getClass()+" 3/6 S");
			rs= stmt.executeQuery();
			System.out.println(this.getClass()+" 4/6 S");
			
			while(rs.next()) {
				int i =1;
				emp =new EmpDto(rs.getInt(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getInt(i++));
			}
			
			System.out.println(this.getClass()+" 5/6 S");
		} catch (SQLException e) {
			System.out.println(this.getClass()+" F "+e);
		} finally {
			this.close(conn, stmt, rs);
			System.out.println(this.getClass()+" 6/6 S");
		}
		
		return emp;
	}
	
	//부하직원 전체
	public List<EmpDto> getSubordinateList(int employee_id){
		List<EmpDto> emps = new ArrayList<>();
		String sql="SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, DEPARTMENT_ID \r\n" + 
				"FROM EMPLOYEES\r\n" + 
				"WHERE MANAGER_ID =? ";
		
		Connection conn= null;
		PreparedStatement stmt=null;
		ResultSet rs= null;
		
		try {
			conn= this.getConnection();
			System.out.println(this.getClass()+" 2/6 S");
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, employee_id);
			System.out.println(this.getClass()+" 3/6 S");
			rs= stmt.executeQuery();
			System.out.println(this.getClass()+" 4/6 S");
			
			while(rs.next()) {
				int i =1;
				EmpDto temp =new EmpDto(rs.getInt(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getInt(i++));
				emps.add(temp);
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
	
	//이름으로 그 이름의 부하직원 전체
	public List<EmpDto> getSubordinateListByName(String first_name){
		List<EmpDto> emps = new ArrayList<>();
		String sql="SELECT E.EMPLOYEE_ID, E.FIRST_NAME, E.LAST_NAME, E.EMAIL, E.PHONE_NUMBER, E.HIRE_DATE, E.JOB_ID, E.DEPARTMENT_ID \r\n" + 
				"FROM EMPLOYEES E JOIN EMPLOYEES M\r\n" + 
				"ON E.MANAGER_ID = M.EMPLOYEE_ID\r\n" + 
				"WHERE M.FIRST_NAME = ? ";
		
		Connection conn= null;
		PreparedStatement stmt=null;
		ResultSet rs= null;
		
		try {
			conn= this.getConnection();
			System.out.println(this.getClass()+" 2/6 S");
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, first_name);
			System.out.println(this.getClass()+" 3/6 S");
			rs= stmt.executeQuery();
			System.out.println(this.getClass()+" 4/6 S");
			
			while(rs.next()) {
				int i =1;
				EmpDto temp =new EmpDto(rs.getInt(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getInt(i++));
				emps.add(temp);
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
