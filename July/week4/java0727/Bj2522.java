package java0727;

import java.util.Scanner;

public class Bj2522 {
	static int N;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		for (int i = 0; i < 2*N-1; i++) {
			int j =0;
			for ( j = 0; j < Math.abs(i-(2*N-1)/2); j++) {
				System.out.print(" ");
			}
			for (int j2 = 0; j2 < N-j; j2++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
	}

}
