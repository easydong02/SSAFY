package java0725;

import java.util.Arrays;
import java.util.Scanner;

public class Main_omok {

	static int N=19;
	static int [][] map;
	static int[] dr= { 0,-1, 1,-1,1,-1,1,0};
	static int[] dc= {-1,-1,-1, 0,0, 1,1,1};
	                 
	public static void main(String[] args) {
		Scanner scann =new Scanner(System.in);
		map=new int[N+2][N+2];
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				map[i][j]=scann.nextInt();
			}
		}// 읽기
		
		//로직
		for (int r = 1; r < N+1; r++) {
			for (int c = 1; c < N+1; c++) {
				// 바둑알을 찾아서 ....
				if(map[r][c]!=0) {
					for (int d = 0; d < 4; d++) { //4방 5목 체크 -> 알골1번
						int nr=r+dr[d];
						int nc=c+dc[d];
						// 오목인지 찾으려는 반대 방향
						// 바둑알이 없거나 다른 색 바둑알
						// 오목방향 오직 5개
						if((map[nr][nc]!=map[r][c]) // 색상이 다르다.
								&& (steps(map[r][c],r,c,7-d))) {// 같은색상이
							                           //연속적으로 몇개
							//출력
							System.out.println(map[r][c]);
							System.out.println(r+" "+c);
							return ; //main끝
						}
					}
				}
			}
		}
		System.out.println("0"); // 완성 오목이 없으면 0
	}
	// 5,6,7목이든 0으로 둘레를 채워넣음 -> 색상이 무조건 달라진다.
	private static boolean steps(int color, int r, int c, int d) {
		int cnt=1;
		// 진행방향으로 색상이 달라질때 까지 가본다.
		for (; color==map[r+dr[d]][c+dc[d]]; r+=dr[d],c+=dc[d] ) {
			cnt++;
		}
		return cnt==5?true:false;//5개이어야만 성공
	}

}
