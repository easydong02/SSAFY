package algo0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1197_prim_pq {
	
	static int V,E;
	
	static class Edge implements Comparable<Edge>{
		int v;
		int weight;
		public Edge(int v, int weight) {
			super();
			this.v = v;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
		
	}
	static List<Edge>[] adj;
	static long min;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		V= Integer.parseInt(st.nextToken());
		E= Integer.parseInt(st.nextToken());
		
		adj=new ArrayList[V+1];
		for (int i = 0; i < V+1; i++) {
			adj[i]=new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st= new StringTokenizer(br.readLine());
			int s= Integer.parseInt(st.nextToken());
			int e= Integer.parseInt(st.nextToken());
			int w= Integer.parseInt(st.nextToken());
			
			//양방향
			adj[s].add(new Edge(e,w));
			adj[e].add(new Edge(s,w));
		}//end of reading
		
		System.out.println(prim());
		
	}
	private static long prim() {
		long min=0L;
		boolean[] visited=new boolean[V+1];
		PriorityQueue<Edge> points= new PriorityQueue<>();
		points.offer(new Edge(1,0));
		int cnt =0;
		
		while(!points.isEmpty()) {
			Edge cur= points.poll();
			if(visited[cur.v])continue;
			min += cur.weight;
			visited[cur.v]=true;
			if(++cnt == V)return min;
			for (int i = 0; i < adj[cur.v].size(); i++) {
				Edge next= adj[cur.v].get(i);
				if(visited[next.v])continue;
				points.offer(next);
			}
		}
		return min;
	}

}
