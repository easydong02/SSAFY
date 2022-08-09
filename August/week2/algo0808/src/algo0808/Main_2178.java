package algo0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {
	static int N,M;
	static int[][] map;
	static int[][] visited;
	static int count;
	
	static int[] dr = {-1,0,1,0};// delta vector 4방
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		map= new int[N][M];
		visited= new int[N][M];
		
		for (int i = 0; i < N; i++) {
			char[] sc= br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j]= sc[j]-'0';
			}
		}// end of reading
		
		bfs();
		System.out.println(visited[N-1][M-1]);
		
		
	}

	private static void bfs() {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {0,0});
		visited[0][0] =1;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if(cur[0]==N-1 && cur[1]==M-1) {
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nr= cur[0]+dr[i];
				int nc= cur[1]+dc[i];
				if(!check(nr,nc))continue;
				if(map[nr][nc]==1 && visited[nr][nc]==0) {
					visited[nr][nc]=visited[cur[0]][cur[1]]+1;
					que.offer(new int[] {nr,nc});
				}
			}
		}
	}

	private static boolean check(int nr, int nc) {
		
		return false;
	}

}
