package algo0826;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_16236_아기상어_교수님ver {
	
	static int N;
	static int[][] map;
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	static int result;
	
	static Shark shark;			//이동상어
	static List<Fish> fishes;	//모든 물고기 정보
	
	static class Shark{
		int r;
		int c;
		int size=2;
		int eat=0;
		int time=0;
		
		public Shark(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		void eat() {
			if(++this.eat == this.size) {
				this.size ++;
				this.eat =0;
			}
		}
	}
	
	static class Fish implements Comparable<Fish>{
		int r;
		int c;
		int size;
		int distance;	// 거리를 구하고 pq에 넣는다.
		public Fish(int r, int c, int size, int distance) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.distance = distance;
		}
		public Fish(int r, int c, int size) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
		}
		public Fish(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public int compareTo(Fish o) {
			int dis= Integer.compare(this.distance, o.distance);
			if(dis!=0) {
				return dis;
			}else {
				int rs= Integer.compare(this.r, o.r);
				if(rs!=0) {
					return rs;
				}else {
					return Integer.compare(this.c, o.c);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N= sc.nextInt();
		map=new int[N][N];
		fishes = new ArrayList<Fish>();
		for (int i = 0; i < N;i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]= sc.nextInt();
				if(map[i][j]==9) {
					shark= new Shark(i, j);
				}else if(map[i][j]>=1 && map[i][j]<=6) {
					fishes.add(new Fish(i,j,map[i][j]));
				}
			}
		}//end of reading
		
		result=0;
		eating();
		System.out.println(result);
	}

	private static void eating() {
		//모든 물고기에서 현재 상어가 먹을 수 있는 물고기 찾기
		while(true) {
			List<Fish> edible= new ArrayList<Fish>();
			for(Fish f: fishes) {
				if(shark.size>f.size) {
					edible.add(f);
				}
			}
			
			if(edible.size()==0)return;//먹을 것이 없다.
			//먹을 수 있는 물고기에 대하여 거리를 구하고, 가장 가까운 물고기를 먹자.
			//먹을 수 있는 물고기에 도달 못하면 -1
			
			PriorityQueue<Fish> que= new PriorityQueue<>();
			//먹을 수 있는 물고기를 가져오고, 상어에서 각 물고기에 대한 거리를 구한다.
			for (int i = 0; i < edible.size(); i++) {
				Fish cur = edible.get(i);
				int dist= distance(shark.r,shark.c,cur.r,cur.c,shark.size);
				if(dist ==-1)continue;
				cur.distance= dist;
				que.offer(cur);
			}
			if(que.size()==0)return;
			
			Fish go= que.poll();
			map[shark.r][shark.c]=0;
			shark.r=go.r;
			shark.c=go.c;
			shark.eat();
			result += go.distance;
			fishes.remove(go);
		}
		
	}
	
	private static int distance(int sr, int sc, int fr, int fc, int size) {
		boolean[][] visited= new boolean[N][N];
		Queue<Fish> que= new LinkedList<Fish>();
		que.offer(new Fish(sr,sc,size,0));
		visited[sr][sc]=true;
		while(!que.isEmpty()) {
			Fish cur = que.poll();
			int rr= cur.r;
			int cc= cur.c;
			int fsize= cur.size;
			int dist= cur.distance;
			
			if(rr==fr && cc== fc) {
				return dist;
			}
			
			for (int i = 0; i < dc.length; i++) {
				int nr= rr+dr[i];
				int nc= cc+dc[i];
				
				if(nr>=0 && nr <N && nc>=0 && nc<N && !visited[nr][nc]) {
					if(map[nr][nc]<= size) {
						que.offer(new Fish(nr,nc,fsize,dist+1));
					}
					visited[nr][nc]=true;
				}
			}
			
		}
		return -1;
	}

}
