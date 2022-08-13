package algo0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697 {
	static int s,d;
	static Queue<int[]> que;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		que = new LinkedList<int[]>();
		visited= new boolean[100001];
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		s= Integer.parseInt(st.nextToken());
		d= Integer.parseInt(st.nextToken());
		int[] su = {s,0};
		visited[s]=true;
		bfs(su);
	}

	private static void  bfs(int [] s) {
		que.offer(s);
		
		while(!que.isEmpty()) {
			s= que.poll();
			
			if(s[0]==d) {
				System.out.println(s[1]);
				System.exit(0);
			}
			
			for (int i = 0; i < 3; i++) {
				switch (i) {
				case 0:
					s[0] -=1;
					if(s[0]>=0 && !visited[s[0]]) {
						visited[s[0]]=true;
						que.offer(new int[] {s[0],s[1]+1});
					}
					s[0] +=1;
					break;
				case 1:
					s[0] +=1;
					if(s[0]<=100000 && !visited[s[0]]) {
						visited[s[0]]=true;
						que.offer(new int[] {s[0],s[1]+1});
					}
					s[0] -=1;
					break;
				case 2:
					s[0] *=2;
					if(s[0]<=100000&& !visited[s[0]]) {
						visited[s[0]]=true;
						que.offer(new int[] {s[0],s[1]+1});
					}
					break;

				}
			}
		}
		
	}
	
	

}
