package algo0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_2819 {
	static int T;
	static int N=4;
	static int[][] map;
	static Set<String> set;
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	static StringBuilder sb= new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		map= new int [N][N];
		for (int tc = 1; tc <= T; tc++) {
			set = new HashSet<>();
			
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st= new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
				}
			}//end of reading
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i,j,"");
				}
			}
			
//			for(int[] m : map) {
//				System.out.println(Arrays.toString(m));
//			}
			
			
			System.out.println("#"+tc+" "+set.size());
		}
		
	}


	private static void dfs(int r, int c,String str) {
		if(str.length()==7) {
			set.add(str);
			return;
		}
		str+=map[r][c];
		for (int i = 0; i < dr.length; i++) {
			
			int nr= r+dr[i];
			int nc= c+dc[i];
			
			if(nr >=0 && nr<N && nc >=0 && nc<N) {
				dfs(nr,nc,str);
			}
		}
		
	}

}
