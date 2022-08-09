package algo0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {
	
	static int N,M;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] visited;
	
	static class P{
		int r;
		int c;
		public P(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		map=new int[N][M];
		visited= new int[N][M]; //온 적 있다 + 거리
		
		for (int i = 0; i < N; i++) {
			String str= br.readLine();
			char[] temp = str.toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j]= temp[j] -'0';
			}
		} //end of reading
		
		bfs();
		//바문위치가 정해져 있다. -> 거리출력
		System.out.println(visited[N-1][M-1]);
		
		for(int[] v : visited) {
			System.out.println(Arrays.toString(v));
		}
		
	}

	private static void bfs() {
		Queue<P> que= new LinkedList<>();
		visited[0][0] = 1; //자신 포함
		que.offer(new P(0,0));
		while(!que.isEmpty()) {
			P cur= que.poll();
			int r = cur.r;
			int c= cur.c;
			if(r==N-1 && c== M-1)return;//마지막 지점
			
			for (int d = 0; d < dc.length; d++) {
				int nr =r +dr[d];
				int nc =c +dc[d];
				if(!check(nr,nc))continue; //범위 밖
				if(map[nr][nc]==1 && visited[nr][nc]==0) {
					que.offer(new P(nr,nc));
					visited[nr][nc]=visited[r][c]+1; //전 거리 + 1 = 현재거리
				}
			}
			
			
		}
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
