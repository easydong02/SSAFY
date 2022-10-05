package algo1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194_G1_달이차오른다 {
	static class Man{
		int r;
		int c;
		int dist =0;
		int key = 0 ;
		
		@Override
		public String toString() {
			return "Man [r=" + r + ", c=" + c + "]";
		}


		public Man(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}


		public Man(int r, int c, int dist, int key) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.key = key;
		}
	}
	
	
	static int N,M,result;
	static char[][]map;
	static boolean[][][] visited;
	static Man man;
	static Queue<Man> que;
	static int[] dr = {-1,0,1,0};  //상우하좌
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		map= new char [N][M];
		visited= new boolean[N][M][1<<7];
		
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j]= temp[j];
				if(temp[j]=='0') {
					man = new Man(i, j);
					map[i][j]='.';
				}
			}
		} // end of reading
		
		
		bfs(man);
		System.out.println(result);
	}
	private static void bfs(Man man) {
		que = new LinkedList<>();
		que.offer(man);
		visited[man.r][man.c][0] =true;
		
		while(!que.isEmpty()) {
			Man cur = que.poll();
			int r = cur.r;
			int c =cur.c;
			int dist = cur.dist;
			int key = cur.key;
			
			if(map[r][c] =='1') {
				result = dist;
				return;
			}
			
			for (int i = 0; i < dc.length; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr>=0 && nr < N && nc>=0 && nc <M && !visited[nr][nc][key] && map[nr][nc] !='#') {
					if(map[nr][nc]=='.') {
						que.offer(new Man(nr,nc,dist+1,key));
						visited[nr][nc][key]= true;
						
					}else if(map[nr][nc]-96>=1 && map[nr][nc]-96 <=6) { //열쇠면
						que.offer(new Man(nr,nc,dist+1,key|(map[nr][nc]-96)));
						System.out.println("key: "+(key|(map[nr][nc]-96)));
						visited[nr][nc][key|(map[nr][nc]-96)] = true;
						
					}else if(map[nr][nc]-64>=1 && map[nr][nc]-64 <=6   ) { //문이면
						if((key & 1<<(map[nr][nc]-64)) == 1<<(map[nr][nc]-64)) {
							que.offer(new Man(nr,nc,dist+1,key));
							visited[nr][nc][key]=true;
						}
					}
				}
			}
			
		}
		result = -1;
		
		
	}

}
