package algo0817;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_8382_방향전환 {
	static int T;
	static int r1,r2,c1,c2;
	
	static int[] dr = {-1,0,1,0}; //  even odd
	static int[] dc = {0,1,0,-1};
	static int val;
	static int[][][] visited; //핵심 -> 딜레마: 갈 수 있는  + 무한루프해소
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T= Integer.parseInt(br.readLine());
		
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			c1=Integer.parseInt(st.nextToken())+100;
			r1=Integer.parseInt(st.nextToken())+100;
			c2=Integer.parseInt(st.nextToken())+100;
			r2=Integer.parseInt(st.nextToken())+100;
			
			visited= new int[201][201][2]; //2 ->  양옆, 상하
			val =-1;
			bfs();
			System.out.println("#"+t+" "+val);
		}
		
	}

	private static void bfs() {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {r1,c1,0,0});//좌표, 거리, 방향
		que.offer(new int[] {r1,c1,0,1});//좌표, 거리, 방향
		
		visited[r1][c1][0] =1; //위아래
		visited[r1][c1][1] =1; //양옆
		
		while(!que.isEmpty()){
			int[] cur =  que.poll();
			int r= cur[0];
			int c= cur[1];
			int cnt= cur[2];
			int dir= cur[3];
			if(r==r2 && c==c2) {
				val= cnt;
				return;
			}
			for (int i = 1; i < 4; i+=2) {
				int s= (dir+i)%4; // 4방중 2방 만들기
				int u= (dir+i)%2; // 홀짝
				int nr= r+dr[s]; // 방향이 바뀐다.
				int nc= c+dc[s];
				if(!check(nr,nc))continue;
				if(visited[nr][nc][u]==0) {
					que.offer(new int[] {nr,nc,cnt+1,s});//좌표거리 방향
					visited[nr][nc][u]=1;// 위 아래
				}
			}
			
		}
		
	}

	private static boolean check(int nr, int nc) {
		
		return (nr>=0 && nr<201 && nc>=0 && nc<201);
	}

}
