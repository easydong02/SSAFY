package com.ssafy.edu.first;

import java.util.Scanner;

public class Solution_1954_달팽이 {
	static int N;
	static int [][] snail;
	static int[] dr= {0,1,0,-1};
	static int[] dc= {1,0,-1,0}; //cw
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			N = sc.nextInt();
			snail = new int[N][N];
			int r=0;
			int c=0;
			int d=0;
			
			for (int j = 1; j <= N*N; j++) {
				snail[r][c] = j;
				int nr = r+dr[d];
				int nc= c+dc[d];
				if(!(check(nr,nc) && snail[nr][nc]==0)) {
					d= (d+1)%4;
				}
				r = r+dr[d]; //방향을 고려해서 이동
				c = c+dc[d];
			}
			System.out.println("#"+i);
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					System.out.print(snail[j][j2]+" ");
				}
				System.out.println();
			}
		}
	}

	private static boolean check(int r, int c) {
		
		return r>=0 && r<N && c>=0 && c<N;
	}

}
