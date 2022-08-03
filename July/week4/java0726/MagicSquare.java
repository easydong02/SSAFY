package java0726;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSquare {
	static int n;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		map= new int[n][n];
		
		make();
		
		print();
		
	}
	
	
	public static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] +" ");
			}
			System.out.println();
		}
	}
	
	public static void make() {
		int r = 0;
		int c = n/2;
		for (int i = 1; i <= n*n; i++) {
			map[r][c]= i;
			int tr= r;
			int tc= c;
			if(r-1<0) {
				r = n-1;
			}else {
				r --;
			}
			if(c+1==n) {
				c = 0;
			}else {
				c ++;
			}
			if(map[r][c] !=0) {
				r= tr+1;
				c= tc;
			}
		}
	}

}
