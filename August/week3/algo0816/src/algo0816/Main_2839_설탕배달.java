package algo0816;

import java.util.Scanner;

public class Main_2839_설탕배달 {
	static int N;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N= sc.nextInt();
		int cnt= N/3;
		
//		
//		if(N%5==0) {
//			System.out.println(N/5);
//			System.exit(0);
//		}
		
		for (int i = 0; i <=cnt; i++) {
			for (int j = 0; j <= cnt; j++) {
				if((3*i + 5*j) ==N) {
					System.out.println(i+j);
					System.exit(0);
				}
			}
		}
		
		System.out.println(-1);
		
	}

}
