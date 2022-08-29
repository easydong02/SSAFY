package algo0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_최단경로 {
	
	static int V,E,K;
	
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
		K= Integer.parseInt(br.readLine());
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
		}//end of reading
		
		dijkstra();
		
	}
	private static void dijkstra() {
		long min=0L;
		boolean[] visited=new boolean[V+1];
		int[] distance= new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE/100);
		distance[K]=0;
		for (int i = 1; i < V+1; i++) { // 모든 정점에 대하여 w->V
			//a[w]->a[V]
			int w= -1;
			int minv=Integer.MAX_VALUE/100;
			for (int j = 1; j < V+1; j++) {
				if(!visited[j] && minv>distance[j]) {
					minv= distance[j];
					w=j;
				}
			}
			if(w==-1)break; //prim에는 없다. 연결 안 되면,
			visited[w]=true;
			for (int j = 0; j < adj[w].size(); j++) {
				Edge cur= adj[w].get(j);
				if(!visited[cur.v] && distance[w] +cur.weight < distance[cur.v]) {
					distance[cur.v]=distance[w]+cur.weight;
				}
			}
		}
		for (int i = 1; i < V+1; i++) {
			if(distance[i]==Integer.MAX_VALUE/100) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}
	}

}
