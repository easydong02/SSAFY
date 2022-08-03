package com.ssafy.edu.first;

import java.util.Arrays;
import java.util.Scanner;

import sun.text.resources.cldr.or.FormatData_or;

public class Solution_1961_회전배열 {
	static int T;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int testcase = 1; testcase <= T; testcase++) {
			N = sc.nextInt();
			int [][] array = new int[N][N];
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					array[i][j] = sc.nextInt();
				}
			}
			
			int [][] array_90 = turn90(array);
			int [][] array_180 = turn90(array_90);
			int [][] array_270 = turn90(array_180);
			
			System.out.println("#"+testcase);
			for (int i = 0; i < N; i++) {
				print_(array_90[i]);System.out.print(" ");
				print_(array_180[i]);System.out.print(" ");
				print_(array_270[i]);
				System.out.println();
			}
		}
		
	}


	private static void print_(int[] is) {
		for (int i = 0; i < is.length; i++) {
			System.out.print(is[i]);
		}
	}


	private static int[][] turn90(int[][] array) {
		int [][] array_ = new int [N][N];
		
		for (int i = 0; i < array_.length; i++) {
			for (int j = 0; j < array_.length; j++) {
				array_[i][j] =array[N-j-1][i];
			}
		}
		
		return array_;
	}
	
	

}
