package java0801;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("우리는 몇기?");
		int no = sc.nextInt();
		System.out.println("우리는 SSAFY "+ no+"기!!");
		
		
		System.out.println("우리를 대표하는 한마디?");
//		String msg = sc.next(); nextInt를 포함한 그냥 next는 앞에있는 enter를 없애고 하기 때문에 그냥 써도 된다.
		sc.nextLine(); //이걸 써주지 않는다면 위에서 입력한 enter가 남아있어서 그것을 반환한다.
		String msg = sc.nextLine();// nextLine은 엔터까지 가져오기 때문
		System.out.println("우리를 대표하는 한마디는 "+ msg);
		
		
	}

}
