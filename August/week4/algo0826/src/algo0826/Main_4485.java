package algo0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485 {
	
	static class Rupee{
		int r;
		int c;
		int cost;
		public Rupee(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
	}
	
	
	static int testcase,N;
	static int[][] map,cost;
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	static int r;
	static int c;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			r=0;
			c=0;
			N= Integer.parseInt(br.readLine());
			if(N==0) {
				break;
			}
			
			map=new int[N][N];
			
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st= new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}//end of reading
			
			bfs(r,c);
			
			
			System.out.println("Problem "+ ++testcase+": "+cost[N-1][N-1]);
		}
	}
	private static void bfs(int r, int c) {
		PriorityQueue<Rupee> que = new PriorityQueue<>();
		que.offer(new Rupee(r,c,map[r][c]));
		cost= new int[N][N];
		Arrays.fill(cost, Integer.MAX_VALUE/100);
		cost[r][c]=map[r][c];
		
		while(!que.isEmpty()) {
			Rupee rup= que.poll();
			
			
			
			
		}
	}

}
