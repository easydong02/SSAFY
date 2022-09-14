package jdbc0914;

import java.util.List;

public class DBtest2 {

	public static void main(String[] args) {
		HRDao dao= new HRDao();
		List<EmpDto> emps= dao.getEmpList();
		for (EmpDto dto : emps) {
			System.out.println(dto);
		}
	}
}
