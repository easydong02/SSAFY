package algo0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TopologySortTest {
	
	static class Node{
		int vertex;
		Node next;
		
		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}
		
		
	}
	static int V,E;
	static Node[] adjList;
	static int[] inDegree;
	public static void main(String[] args) throws IOException {
		BufferedReader  br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		V =Integer.parseInt(st.nextToken());
		E= Integer.parseInt(st.nextToken());
		
		adjList = new Node[V+1]; //각 정점별 인접리스트
		inDegree=new int[V+1];//정점별 진입차수
		for (int i = 0; i < E; i++) {
			st =  new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			//유향처리
			adjList[from]= new Node(to, adjList[from]);
			inDegree[to]++;
		}//end of reading
		
		ArrayList<Integer>list= topologySort();
		if(list.size()==V) { //위상정렬 완성
			for(int i : list) {
				System.out.print(i+" ");
			}
			System.out.println();
		}else {				//사이클 발생
			System.out.println("cycle");
		}
		
	}
	
	private static ArrayList<Integer> topologySort(){
		ArrayList<Integer>list= new ArrayList<>();
		Queue<Integer>que= new ArrayDeque<Integer>();
		
		//진입차수가 0인 정점 큐에 넣기
		for (int i = 1; i < V; i++) {
			if(inDegree[i]==0) que.offer(i);
		}
		
		//BFS
		while(!que.isEmpty()) {
			int cur= que.poll();
			list.add(cur);
			for (Node tmp = adjList[cur]; tmp !=null; tmp= tmp.next) {
				if(--inDegree[tmp.vertex]==0)que.offer(tmp.vertex);
			}
		}
		return list;
		
	}
	

}
