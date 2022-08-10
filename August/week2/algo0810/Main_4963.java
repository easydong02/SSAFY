package algo0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4963 {
	static int C,R;
	static int[][] map;
	static boolean[][] visited;
	static int count;
	
	static int[] dr= {-1,-1,0,1,1,1,0,-1};
	static int[] dc= {0,1,1,1,0,-1,-1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			count=0;
			StringTokenizer st =new StringTokenizer(br.readLine());
			
			C= Integer.parseInt(st.nextToken());
			R= Integer.parseInt(st.nextToken());
			if(C==0 && R==0)break;
			map=new int[R][C];
			visited= new boolean[R][C];
			
			for (int i = 0; i < R; i++) {
				st= new StringTokenizer(br.readLine());
				for (int j = 0; j < C; j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
				}
			}// end of reading
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(!visited[i][j] && map[i][j] !=0) {
						dfs(i,j);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
	}

	private static void dfs(int r, int c) {
		
		for (int i = 0; i < dc.length; i++) {
			int nr= r +dr[i];
			int nc= c +dc[i];
			
			if(nr>=0 && nr <R && nc>=0 && nc <C && !visited[nr][nc] && map[nr][nc] ==1) {
				visited[nr][nc]=true;
				dfs(nr,nc);
			}
		}
	}

}
