package java0727;

import java.util.Scanner;

public class Bj2523 {
	static int N;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int M= 2*N-1;
		for (int i = 0; i < 2*N-1; i++) {
			int j =0;
			for ( j = 0; j < -1* Math.abs(i-M/2)+1+M/2; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
	}

}
