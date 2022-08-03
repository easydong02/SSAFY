package algo0802;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_d3_2805_2 {

	static int T;
	static int N;
	static int[][] map;
	static boolean [][] visited;
	static int sum;
	// 최악 50*50*5=12500 sum <2000000000 int
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N=scann.nextInt();// 홀수 1~49
			map=new int[N][N];
			visited=new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String s=scann.next();
				char[] sc=s.toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j]=sc[j]-'0'; // 숫자형 char -'0' =숫자
				}
			}// end of reading
			sum=0;
			bfs();
			System.out.println("#"+t+" "+sum);
			
		}//testcase
	}
	static int[] dr= {-1,0,1, 0};
	static int[] dc= { 0,1,0,-1};//CW
	// 4방 => 다이아몬드로 결정이 성장한다. => 다이아몬드로 검색한다. 
	private static void bfs() {
		Queue<int[]> que=new LinkedList<>(); //FIFO
		que.offer(new int[]{N/2,N/2,0});//(시작위치,depth)넣어
		sum+=map[N/2][N/2];// 중앙
		visited[N/2][N/2]=true; //중앙 온적 있다. 
		while(!que.isEmpty()) {       // 없을 때까지 한다. 
			int[] cur=que.poll();// 빼서
			int r=cur[0];  //현재 r
			int c=cur[1];  //현재 c
			int dep=cur[2]; // 현재 깊이 
			if(dep<N/2) {    // N/2겹보다 작아야 한다. 실행이 안되면 que에 넣을 것이 없어서
				// 큐가 굶어 죽는다. que.isEmpty()
				for (int d = 0; d < 4; d++) { //현재 위치에서  4방
					int nr=r+dr[d];  
					int nc=c+dc[d];
					if(visited[nr][nc]) continue;  // 방문한적 있으면 제외
					que.offer(new int[]{nr,nc, dep+1});//넣어
					sum+=map[nr][nc];     //계산 
					visited[nr][nc]=true; //이동한 위치 -> 다음의 현재위치 
				}
			}
		}
	}

}
