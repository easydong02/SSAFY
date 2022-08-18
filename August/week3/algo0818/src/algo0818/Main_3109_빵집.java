package algo0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_빵집 {
	static int R,C,result;
	static char[][] map;
	static boolean[][] visited;
	
	static int[] dr= {-1,0,1};
	static int[] dc= {1,1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		R= Integer.parseInt(st.nextToken());
		C= Integer.parseInt(st.nextToken());
		map= new char[R][C];
		visited= new boolean[R][C];
		for (int i = 0; i < R; i++) {
			char[] tmp= br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j]=tmp[j];
			}
		}//end of reading
		
		for (int i = 0; i < R; i++) {
			if(!visited[i][0]) {
				dfs(i,0);
			}
		}
		System.out.println(result);
		
	}
	private static void dfs(int r,int c) {
		visited[r][c]=true;
		if(c==C-1) {
			result ++;
			return;
		}
		
		for (int i = 0; i < dc.length; i++) {
			int nr= r+dr[i];
			int nc= c+dc[i];
			if(nr>=0 && nr <R && nc >=0 && nc <C && map[nr][nc] !='x' && !visited[nr][nc]) {
				dfs(nr,nc);
				return;
			}
			
		}
		
	}

}
