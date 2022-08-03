package com.ssafy;

import java.util.Scanner;

public class Bj2447 {
	static int[][] star;

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		
		star= new int[N][N];
		star(0,0,N);
		StringBuilder sb= new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(star[i][j]== 1? "*":" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

	private static void star(int r, int c, int n) {
		if(n==3) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if(i==1 && j==1)continue;
					star[r+i][c+j]=1;
				}
			}
		}else {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if(i==1 && j==1)continue;
					star(r+n/3*i, c+n/3*j,n/3);
				}
			}
			
		}
		
	}

}
