package algo0819;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {
	static int N,M,D;
	static int[][] map;
	static int[][] temp;
	static int[] bows;
	static int max= Integer.MIN_VALUE;
	static boolean[] visited;
	static boolean[][] isTarget;
	static int[] dr= {0,-1,0}; //왼,위,좌
	static int[] dc= {-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		D= Integer.parseInt(st.nextToken());
		
		map= new int [N][M];
		bows= new int[3];
		visited=new boolean[M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}//end of reading
		
//		for(int[] m  : map) {
//			System.out.println(Arrays.toString(m));
//		}
		
		setArcher(0,0);
		System.out.println(max);
		
	}
	private static void setArcher(int start, int cnt) {
		if(cnt==3) {
			int sum =start(N,0); // 현재 진행된 궁수들로 게임 진행. N은 총 게임시간
			max = Math.max(max, sum);
			return;
		}
		
		
		for (int i = start; i < M; i++) {
			if(visited[i])continue;
			visited[i]=true;
			bows[cnt]=i;
			setArcher(i+1, cnt+1);
			bows[cnt]=0;
			visited[i]=false;
		}
	}
	private static int start(int count, int kill) {
		temp= new int[N][M]; //복제만들기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j]= map[i][j];
			}
		}
		
		while(count>0) {
			//System.out.println(count);
			kill += shoot(0); //배치된 궁수들로 한번 쏘기
			move(); //적들 이동
			count--; //시간하나 빼기
		}
		
		return kill;
	}
	private static void move() {
		for (int i = N-1; i >=0; i--) {
			for (int j = 0; j < M; j++) {
				if(temp[i][j]==1) {
					if(i+1>=N) {
						temp[i][j]=0;
					}else {
						temp[i+1][j]=1;
						temp[i][j]=0;
					}
				}
			}
		}
	}
	
	private static int shoot(int kill) {
		isTarget= new boolean[N][M];
		for (int i = 0; i < 3; i++) {
			kill(new Point(N,bows[i]));
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(isTarget[i][j]) {
					kill++;
					temp[i][j]=0;
				}
			}
		}
		
		return kill;
	}
	private static void kill(Point archer) {
		boolean[][] visited2= new boolean[N][M];
		Queue<Point> que= new LinkedList<Point>();
		
		que.offer(archer);
		
		while(!que.isEmpty()) {
			Point cur= que.poll();
			for (int i = 0; i < 3; i++) {
				int nr= cur.x + dr[i];
				int nc= cur.y + dc[i];
				if(nr>=0 && nr <N && nc>=0 && nc <M) {
					if((Math.abs(nr-archer.x)+Math.abs(nc-archer.y))<=D){
						if(temp[nr][nc]==1) {
							isTarget[nr][nc]=true;
							return;
						}
						if(!visited2[nr][nc]) {
							que.offer(new Point(nr,nc));
							visited2[nr][nc]=true;
						}
					}
				}
			}
		}
	}

}
