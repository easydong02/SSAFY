package algo0826;

import java.util.Scanner;

public class Main_10971_외판원순회2 {
	
	static int N;
	static int[][] dist;
	static int min;
	
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N= sc.nextInt();
		dist= new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dist[i][j]= sc.nextInt();
			}
		}
		min= Integer.MAX_VALUE;
		tsp(0,new boolean[N],new int[N]);
		System.out.println(min);
	}


	private static void tsp(int cnt, boolean[] visited, int[] nums) {
		if(cnt==N) {
			// A B C D + A
			int sum =0;
			for (int i = 0; i < N-1; i++) {
				if(dist[nums[i]][nums[i+1]]==0) {
					return;
				}
				if(dist[nums[N-1]][nums[0]]==0) {
					return;
				}
				sum += dist[nums[i]][nums[i+1]];
			}
			sum += dist[nums[N-1]][nums[0]];
			min= Math.min(min, sum);
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i])continue;
			visited[i]=true;
			nums[cnt]=i;
			tsp(cnt+1,visited,nums);
			nums[cnt]=0;
			visited[i]=false;
		}
	}

}
