package algo0823;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_13023_ABCDE {
	static int N,M;
	static List<ArrayList<Integer>> list;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		list= new ArrayList<>();
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}//end of reading
		
		for (int i = 0; i < N; i++) {
			visited= new boolean[N];
			dfs(i,1);
		}
		System.out.println(0);
		
	}
	private static void dfs(int start, int cnt) {
		if(cnt ==5){
			System.out.println(1);
			System.exit(0);
		}
		
		visited[start]=true;
		
		for( int tmp :list.get(start)) {
			if(!visited[tmp]) {
				dfs(tmp,cnt+1);
			}
		}
		
		visited[start]=false;
		
	}

}
