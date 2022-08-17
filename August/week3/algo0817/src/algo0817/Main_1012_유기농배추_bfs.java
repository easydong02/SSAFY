package algo0817;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012_유기농배추_bfs {
	static int[][] map;
	static boolean[][] visited;
	static int T,M,N,K;
	static int count;
	static Queue<Point> que;
	
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T= Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			count=0;
			StringTokenizer st= new StringTokenizer(br.readLine());
			M= Integer.parseInt(st.nextToken());
			N= Integer.parseInt(st.nextToken());
			K= Integer.parseInt(st.nextToken());
			que = new LinkedList<Point>();
			
			
			map= new int[N][M];
			visited= new boolean[N][M];
			
			
			for (int j = 0; j < K; j++) {
				st= new StringTokenizer(br.readLine());
				int x= Integer.parseInt(st.nextToken());
				int y= Integer.parseInt(st.nextToken());
				map[y][x]=1;
			}//end of reading
			
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(map[j][k]==1 && !visited[j][k]) {
						count++;
						bfs(j,k);
					}
				}
			}
			System.out.println(count);
			
		}
	}
	private static void bfs(int r, int c) {
		visited[r][c]=true;
		que.offer(new Point(r,c));
		
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			for (int i = 0; i < dc.length; i++) {
				int nr= p.x +dr[i];
				int nc= p.y + dc[i];
				if(nr>=0 && nr < N && nc >= 0 && nc<M && !visited[nr][nc] && (map[nr][nc] == 1)) {
					visited[nr][nc]= true;
					que.offer(new Point(nr,nc));
				}
			}
		}
		
		
		
	}

}
