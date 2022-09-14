package jdbc0914;


public class DBtest3 {

	public static void main(String[] args) {
		HRDao dao= new HRDao();
		EmpDto emps= dao.getEmp(100);
		System.out.println(emps);
	}
}
