package algo0817;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {
	static int T,M,A,sum;
	static int[][] map;
	static int[][] map2;
	static int group;
	static boolean[][] visited;
	static boolean[][] visited2;
	
	static int[] a,b;
	static Point Pa,Pb;
	
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T= Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			Pa= new Point(0,0);
			Pb= new Point(9,9);
			map= new int[10][10];
			map2= new int[10][10];
			visited= new boolean[10][10];
			visited2= new boolean[10][10];
			sum=0;
			group=0;
			StringTokenizer st =new StringTokenizer(br.readLine());
			M= Integer.parseInt(st.nextToken());
			A= Integer.parseInt(st.nextToken());
			a= new int[M];
			b= new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i <M; i++) {
				a[i]= Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i <M; i++) {
				b[i]= Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < A; i++) {
				group++;
				st = new StringTokenizer(br.readLine());
				int x= Integer.parseInt(st.nextToken())-1;
				int y= Integer.parseInt(st.nextToken())-1;
				int c= Integer.parseInt(st.nextToken());
				int p= Integer.parseInt(st.nextToken());
				makeAp(y,x,c,p);
			} //end of reading
			
			
			for(boolean[] m : visited2) {
				System.out.println(Arrays.toString(m));
			}
			
			System.out.println("--------------------------");
			for(int[] m : map) {
				System.out.println(Arrays.toString(m));
			}
			System.out.println("--------------------------");
			
			for(int[] m : map2) {
				System.out.println(Arrays.toString(m));
			}
			
			
			
			sum += (map[0][0]+map[9][9]);
			for (int i = 0; i < M; i++) {
				move(a[i],b[i]);
			}
			
			System.out.println("#"+tc+" "+sum);
		}
	}

	private static void move(int i, int j) {
		int a = i-1;
		int b = j-1;
		
		int ar= Pa.x;
		int ac= Pa.y;
		
		int br= Pb.x;
		int bc= Pb.y;
		
		if(a != -1) {
			ar += dr[a];
			ac += dc[a];
		}
		if(b != -1) {
			br += dr[b];
			bc += dc[b];
		}
		
		
		if(map2[ar][ac]==map2[br][bc]) { //같은 지역
			if(visited2[ar][ac] && visited2[br][bc]) { //같은데 둘다 접경지역
				sum +=map[ar][ac];
			}else{ //둘다 접경지역 아님
				sum += map[ar][ac]/2;
				sum += map[br][bc]/2;
			}
			
		}else if(one(ar,ac,br,bc)) { // 다른 지역 but 하나만 접경지대.
			sum += map[ar][ac]>map[br][bc]? map[ar][ac]:map[br][bc]; //더 큰거 하나만 넣으면 된다.
		}else if(both(ar,ac,br,bc)){ //서로 다르고 근데 각각 다른 접경지대
			
		}else { //서로 다르고 둘다 접경지대가 아닐 때
			sum += map[ar][ac];
			sum += map[br][bc];
		}
		
		Pa.x= ar;
		Pa.y= ac;
		Pb.x= br;
		Pb.y= bc;
	}

	
	private static boolean both(int ar, int ac, int br, int bc) {
		if(visited2[ar][ac] && visited2[br][bc] ) {
			if(map2[ar][ac] != map2[br][bc]) {
				return true;
			}
		}
		return false;
	}

	private static boolean one(int ar, int ac, int br, int bc) { //접경지대 찾기
		if(visited2[ar][ac] && !visited2[br][bc]) { // a가 접경지대 있다면
			int tmp = map2[ar][ac]-map2[br][bc];
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if(map2[i][j]==tmp) {
						if(map[i][j]+map[br][bc]==map[ar][ac]) {
							return true;
						}
					}
				}
			}
		}else if (visited2[br][bc] && !visited2[ar][ac]){ // b가 접경지대 있다면
			int tmp = map2[br][bc]-map2[ar][ac];
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if(map2[i][j]==tmp) {
						if(map[i][j]+map[ar][ac]==map[br][bc]) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	//AP map에 찍기
	private static void makeAp(int r, int c, int d, int p) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {r,c,0});
		map2[r][c] +=group;
		if((map[r][c] != 0)&&( map[r][c] != p)) {
			if(!visited2[r][c]) {
				map[r][c] +=p;
				visited2[r][c]=true;
			}
		}else {
			map[r][c] =p;
		}
		visited[r][c]=true;
		while(!que.isEmpty()) {
			int[] temp = que.poll();
			int rr = temp[0];
			int cc = temp[1];
			int dep= temp[2];
			if(dep<d) {
				for (int i = 0; i < dr.length; i++) {
					int nr = rr+dr[i]; 
					int nc = cc+dc[i];
					if(nr>=0 && nr < 10 && nc >=0 && nc<10) {
						if(!visited[nr][nc]) {
							que.offer(new int[] {nr,nc,dep+1});
							visited[nr][nc]=true;
							map[nr][nc] =p;
							map2[nr][nc] =group;
						}else if((map[nr][nc] != 0)&&( map[nr][nc] != p)) {
							if(!visited2[nr][nc]) {
								map[nr][nc] +=p;
								visited2[nr][nc]=true;
								map2[nr][nc] +=group;
							}
						}
					}
				}
			}
		}
		
	}

}
