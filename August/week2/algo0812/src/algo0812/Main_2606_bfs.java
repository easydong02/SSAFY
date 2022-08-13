package algo0812;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2606_bfs {

	static int N,M;
	static int[][] map;
	static int count;
	static int[] visited;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		map=new int[N+1][N+1];
		visited=new int[N+1];
		for (int i = 0; i < M; i++) {
			int s=scann.nextInt();
			int e=scann.nextInt();
			map[s][e]=1;
			map[e][s]=1;
		}
		count=0;
		bfs();
		result();
	}
	private static void result() {
		int count=0;
		for (int i = 1; i < N+1; i++) {
			if(visited[i]==2) count++;
		}
		System.out.println(count-1);
	}
	private static void bfs() {
		Queue<Integer> que=new LinkedList<Integer>();
		que.add(1);
		visited[1]=2;
		while(!que.isEmpty()) {
			int s=que.poll();
			for (int i = 1; i < N+1; i++) {
				if(visited[i]!=0) continue;
				if(map[s][i]==1) {
					que.add(i);
					visited[i]=2;
				}
			}
		}
	}
}