package jdbc0914;

import java.util.List;

public class DBtest4 {

	public static void main(String[] args) {
		HRDao dao= new HRDao();
		List<EmpDto> emps= dao.getSubordinateList(102);
		for (EmpDto dto : emps) {
			System.out.println(dto);
		}
	}
}
