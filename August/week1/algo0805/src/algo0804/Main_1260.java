package algo0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260 {
	static int N,M,V;
	static int[][] map;
	
	static int[] dfs;
	static int[] bfs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		V=Integer.parseInt(st.nextToken())-1;
		
		map = new int [N][N];
		dfs= new int[N];
		bfs= new int[N];
		
		for (int i = 0; i < M ; i++) {
			st= new StringTokenizer(br.readLine());
			int s= Integer.parseInt(st.nextToken())-1;
			int e= Integer.parseInt(st.nextToken())-1;
			map[s][e]=1;
			map[e][s]=1;
		} //읽기 끝
		
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		dfs(V);
		System.out.println();
		bfs();
		
	}

	private static void bfs() {
		Queue<Integer> que= new LinkedList<>(); 
		bfs[V]=1;
		que.offer(V); //이 지점에서 시작
		System.out.print((V+1)+" ");
		
		while(!que.isEmpty()) {
			int s= que.poll(); //일단 빼
			for (int e = 0; e < N; e++) { // s-> e
				if(map[s][e]==1 && bfs[e]==0) { // 간선이 있고 온 적이 없으면
					bfs[e]=1;
					que.offer(e);// 이 지점에서 시작
					System.out.print((e+1)+" ");
				}
			}
		}
	}

	private static void dfs(int s) {
		dfs[s]=1;
		System.out.print((s+1)+" ");
		
		for (int e = 0; e < N; e++) { // s-> e
			if(map[s][e]==1 && dfs[e]==0) { // 간선이 있고 온 적이 없으면
				dfs(e);
			}
		}
		
	}

}
