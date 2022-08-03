package algo0802;

import java.util.Scanner;

public class Solution_d3_2805 {

	static int T;
	static int N;
	static int[][] map;
	static int sum;
	// 최악 50*50*5=12500 sum <2000000000 int
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N=scann.nextInt();// 홀수 1~49
			map=new int[N][N];
			for (int i = 0; i < N; i++) {
				String s=scann.next();
				char[] sc=s.toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j]=sc[j]-'0'; // 숫자형 char -'0' =숫자
				}
			}// end of reading
			sum=0;
			for (int i = 0; i <N; i++) {
				int st=Math.abs(i-N/2);
				// 부터~까지 : 까지-부터(j)=개수 N-2j
				for (int j = st; j <N-st ; j++) {
					sum+=map[i][j];
				}
			}
			// i=0 N= 5 st=2  <5-2
			
			System.out.println("#"+t+" "+sum);
			
		}//testcase

	}

}
