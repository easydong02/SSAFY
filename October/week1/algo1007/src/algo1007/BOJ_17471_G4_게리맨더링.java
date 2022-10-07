package algo1007;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BOJ_17471_G4_게리맨더링 {
	
	static int N,map[][],count;
	static int inf= 1000000;
	static int result = inf;
	static int[] people;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N= Integer.parseInt(br.readLine());
		map= new int [N][N];
		people = new int[N];
		visited= new boolean[N];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			people[i]= Integer.parseInt(st.nextToken());
		}
		
		
		for (int i = 0; i < N; i++) {
			map[i][i]=0;
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for (int j = 0; j < a; j++) {
				map[i][Integer.parseInt(st.nextToken())-1] =1;
			}
		}
		
//		System.out.println(Arrays.toString(people));
//		for(int[] m : map) {
//			
//			System.out.println(Arrays.toString(m));
//		}
		
		subset(0);
		if(result ==inf) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
	}
	private static void subset(int cnt) {
		if(cnt == N) {
			start();
			return;
		}
		
		visited[cnt]= true;
		subset(cnt+1);
		visited[cnt]=false;
		subset(cnt+1);
		
	}
	private static void start() {
		count++;
		int a = 0;
		for (int i = 0; i < N; i++) {
			if(visited[i])a++;
		}
		int b = N-a;
		int[] A = new int[a];
		int[] B = new int[b];
		int aIdx=0;
		int bIdx=0;
		for (int i = 0; i < N; i++) {
			if(visited[i])A[aIdx++]=i;
			else {B[bIdx++]=i;}
		}
//		System.out.println(count);
//		System.out.println(Arrays.toString(A));
//		System.out.println(Arrays.toString(B));
//		System.out.println("-------------------");
		if(!check(A,B))return;
		
		int sumA=0;
		int sumB=0;
		
		for (int i = 0; i < A.length; i++) {
			sumA += people[A[i]];
		}
		for (int i = 0; i < B.length; i++) {
			sumB += people[B[i]];
		}
		
		result = Math.min(result, Math.abs(sumA-sumB) );		
	}
	private static boolean check(int[] a, int[] b) {
		if(a.length==0 || b.length ==0)return false;
		
		if(a.length !=1) {
			boolean[] chk = bfs(a);
			for (int i = 0; i < chk.length; i++) {
				if(!chk[i])return false;
			}
		}
		
		if(b.length !=1) {
			boolean[] chk = bfs(b);
			for (int i = 0; i < chk.length; i++) {
				if(!chk[i])return false;
			}
		}
		return true;
	}
	private static boolean[] bfs(int[] nums) {
		boolean[] temp = new boolean[N];
		Arrays.fill(temp, true);
		for (int i = 0; i < nums.length; i++) {
			temp[nums[i]]=false;
		}
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(nums[0]);
		temp[nums[0]]=true;
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			
			for (int i = 0; i < N; i++) {
				int ncur = map[cur][i];
				
				if(ncur ==1 && !temp[i]) {
					que.offer(i);
					temp[i]=true;
				}
			}
		}
		
		return temp;
	}

}
