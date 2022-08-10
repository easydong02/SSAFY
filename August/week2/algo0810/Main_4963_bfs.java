package algo0810;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_4963_bfs {

	static int W, H;
	static int [][] map;
	static int[] dr= {-1,-1,0,1,1, 1, 0,-1};
	static int[] dc= { 0, 1,1,1,0,-1,-1,-1};
		
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		W=scann.nextInt();
		H=scann.nextInt();
		while(!(W==0 && H==0)) {
			map=new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j]=scann.nextInt();
				}
			}//
			//로직
			int group=0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(map[i][j]==1) {//땅이면 
						group++;
						bfs(i,j,group+1);
					}
				}
			}//
			System.out.println(group);
			for(int[] m: map) {
				System.out.println(Arrays.toString(m));
			}
			//---------------
			W=scann.nextInt();
			H=scann.nextInt();
		}
		//System.out.println("end!");
	}

	private static void bfs(int rr, int cc, int g) {
		Queue<int[]> que=new LinkedList<>();
		que.offer(new int[] {rr,cc});
		map[rr][cc]=g;
		while(!que.isEmpty()) {
			int[] cur=que.poll();
			int r=cur[0];
			int c=cur[1];
			for (int d = 0; d < 8; d++) {
				int nr=r+dr[d];
				int nc=c+dc[d];
				if(!check(nr,nc)) continue;
				if(map[nr][nc]==1) {
					que.offer(new int[] {nr,nc});
					map[nr][nc]=g;
				}
			}
		}
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<H && c>=0 && c<W;
	}

}
