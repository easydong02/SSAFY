package jdbc0914;

import java.util.List;

public class DBtest5 {

	public static void main(String[] args) {
		HRDao dao= new HRDao();
		List<EmpDto> emps= dao.getSubordinateListByName("STEVEN");
		
		for (EmpDto dto : emps) {
			System.out.println(dto);
		}
	}
}
