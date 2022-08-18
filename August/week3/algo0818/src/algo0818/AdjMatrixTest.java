package algo0818;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class AdjMatrixTest {
	
	static int[][] adjMatrix;
	static boolean[] visited;
	static int N;
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		N= sc.nextInt();
		int E = sc.nextInt();
		adjMatrix= new int[N][N]; //0으로 자동 초기화
		visited= new boolean[N]; //0으로 자동 초기화
		
		for (int i = 0; i < E; i++) { // 간선정보에 해당하는 부분만 덮어씀.
			int from= sc.nextInt();
			int to= sc.nextInt();
			adjMatrix[from][to]=1;
			adjMatrix[to][from]=1;
		}
		
		//bfs();
		System.out.println("-------------------");
		dfs(0);
	}

	private static void dfs(int cur) {
		visited[cur]=true;
		
		System.out.print((char)(cur+'A'));
		
		//현 정점의 인접정점들을 큐에 넣어서 차후 탐색하도록 하기
		for (int i = 0; i < N; i++) {
			if(!visited[i] && adjMatrix[cur][i] !=0 ) { //방문하지 않았고 인접한 경우
				dfs(i);
			}
		}
	}

	private static void bfs() {
		Queue<Integer> que= new ArrayDeque<>();
		boolean[] visited= new boolean[N]; //방문관리 배열
		
		visited[0]= true;
		que.offer(0);
		
		while(!que.isEmpty()) {
			int cur= que.poll();
			System.out.print((char)(cur+'A'));
			
			//현 정점의 인접정점들을 큐에 넣어서 차후 탐색하도록 하기
			for (int i = 0; i < N; i++) {
				if(!visited[i] && adjMatrix[cur][i] !=0 ) { //방문하지 않았고 인접도 아님
					visited[i]=true;
					que.offer(i);
				}
			}
		}
		System.out.println();
		
		
	}

}
