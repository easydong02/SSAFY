package com.ssafy.edu.first;

import java.util.Scanner;

public class Solution_1954_달팽이2 {
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
			
			godfs(0,0,0,1);
			System.out.println("#"+i);
			
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					System.out.print(snail[j][j2]+" ");
				}
				System.out.println();
			}
		}
	}

	private static void godfs(int r, int c, int d, int n) {
		snail[r][c] = n;
		if(n==N*N) return;
		int nr = r+dr[d];
		int nc= c+dc[d];
		if(!(check(nr,nc) && snail[nr][nc]==0)) {
			d= (d+1)%4;
		}
		r = r+dr[d]; //방향을 고려해서 이동
		c = c+dc[d];
		godfs(r, c, d, n+1);
	}

	private static boolean check(int r, int c) {
		
		return r>=0 && r<N && c>=0 && c<N;
	}

}
