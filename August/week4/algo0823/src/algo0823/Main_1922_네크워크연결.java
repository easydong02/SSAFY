package algo0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_1922_네크워크연결 {
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
		
		
	}
	
	static int V,E,result;
	static boolean[] visited;
	static int[] p,r;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		
		V= Integer.parseInt(br.readLine());
		E= Integer.parseInt(br.readLine());
		visited=new boolean[V+1];
		PriorityQueue<Edge> que= new PriorityQueue<Edge>();
		
		for (int i = 0; i < E; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			que.offer(new Edge(A,B,C));
			que.offer(new Edge(B,A,C));
		}//end of reading
		
		makeSet();
		
		while(!que.isEmpty()) {
			Edge tmp = que.poll();
			if(find(tmp.from) != find(tmp.to)) {
				union(tmp.from,tmp.to);
				result +=tmp.weight;
			}
		}
		
		System.out.println(result);
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
		p=new int[V+1];
		r=new int[V+1];
		
		for (int i = 0; i < V+1; i++) {
			p[i]=i;
		}
		for (int i = 0; i < V+1; i++) {
			r[i]=1;
		}
	}

}
