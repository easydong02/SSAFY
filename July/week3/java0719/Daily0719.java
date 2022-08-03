package com.ssafy.edu.first;

import java.util.Scanner;

public class Daily0719 {
	static int N;
	static int[][] land;
	static int max;
	
	static int []dr = {0,-1,0,0,1};
	static int []dc = {-1,0,0,1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		land = new int [N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				land[i][j] = sc.nextInt();
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (sum(land,i,j)>max) {
					max =sum(land,i,j);
				}
			}
		}
		System.out.println(max);
		
	}
	

	private static int sum(int[][] array, int r, int c) {
		int sum =0;

		for (int i = 0; i < dr.length; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if (check(nr, nc)) {
				sum += array[r+dr[i]][c+dc[i]];
			}
		}
		
		
		
		return sum;
	}


	private static boolean check(int r, int c) {
		
		return r>=0 && r<N && c>=0 && c<N;
	}
	
	

}
