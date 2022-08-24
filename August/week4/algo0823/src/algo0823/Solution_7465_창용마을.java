package algo0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;


public class Solution_7465_창용마을 {
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		
		public Edge(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}

		@Override
		public int compareTo(Edge o) {
			return this.from-o.from;
		}
		
		
		
		
	}
	
	static int T,V,E;
	static Set<Integer> set;
	static boolean[] visited;
	static Integer[] p,r;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <=T ; tc++) {
			
			StringTokenizer st= new StringTokenizer(br.readLine());
			
			V= Integer.parseInt(st.nextToken());
			E= Integer.parseInt(st.nextToken());
			visited=new boolean[V+1];
			PriorityQueue<Edge> que= new PriorityQueue<Edge>();
			
			for (int i = 0; i < E; i++) {
				st= new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				que.offer(new Edge(A,B));
				que.offer(new Edge(B,A));
			}//end of reading
			
			makeSet();
			
			while(!que.isEmpty()) {
				Edge tmp = que.poll();
				union(tmp.from,tmp.to);
			}
			
			set= new HashSet<>();
			for (int i = 1; i <= V ; i++) {
				set.add(find(p[i]));
			}
			System.out.println("#"+tc+" "+(set.size()));
			
		}
	}
	
	private static boolean union(int a, int b) {
		a= find(a);
		b= find(b);
		if(a==b)return false;
		
		if(r[a]<r[b]) {
			r[b] +=r[a];
			p[a]=b;
		}else {
			r[a] +=r[b];
			p[b]=a;
		}
		
		return true;
	}
	
	private static int find(int a) {
		if(a==p[a])return p[a];
		return p[a] = find(p[a]);
	}
	
	private static void makeSet() {
		p=new Integer[V+1];
		r=new Integer[V+1];
		
		for (int i = 0; i < V+1; i++) {
			p[i]=i;
		}
		for (int i = 0; i < V+1; i++) {
			r[i]=1;
		}
	}

}
