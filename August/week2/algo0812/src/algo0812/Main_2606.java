package algo0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;




public class Main_2606 {
	static int coms;
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int count;
	static List<int[]> ar;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		coms= Integer.parseInt(br.readLine());
		map= new int[coms][coms];
		visited= new boolean[coms];
		N= Integer.parseInt(br.readLine());
		ar= new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int r= Integer.parseInt(st.nextToken());
			int c= Integer.parseInt(st.nextToken());
			
			map[r-1][c-1]=1;
		}
			dfs(0);
			System.out.println(ar.size());
		
	}

	private static void dfs(int r) {
			for (int j = 0; j < coms; j++) {
				if (map[r][j]==1 && !visited[j] ) {
					visited[j]=true;
					ar.add(new int[] {r,j});
					dfs(j);
				}
			}
		
		
		
		
	}

}
