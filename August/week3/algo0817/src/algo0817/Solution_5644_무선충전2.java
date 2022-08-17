package algo0817;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5644_무선충전2 {
	static int T,M,A,sum;
	static int[][][] map;
	static int group;
	static boolean[][][] visited;
	
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
			sum=0;
			group=0;
			StringTokenizer st =new StringTokenizer(br.readLine());
			M= Integer.parseInt(st.nextToken());
			A= Integer.parseInt(st.nextToken());
			visited= new boolean[10][10][A+1];
			map= new int[10][10][A+1];
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
			
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					System.out.print(map[i][j][1]+" ");
				}
				System.out.println();
			}
			System.out.println("-------------------");
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					System.out.print(map[i][j][2]+" ");
				}
				System.out.println();
			}
			System.out.println("-------------------");
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					System.out.print(map[i][j][3]+" ");
				}
				System.out.println();
			}
			
			for (int i = 0; i < M; i++) {
				move(a[i],b[i]);
			}
			
			
		}
	}


	


	private static void move(int i, int j) {
		
	}





	//AP map에 찍기
	private static void makeAp(int r, int c, int d, int p) {
		Queue<int[]>  que = new LinkedList<>();
		que.offer(new int[] {r,c,0});
		visited[r][c][group]=true;
		map[r][c][group]=p;
		while(!que.isEmpty()) {
			int[] cur= que.poll();
			int rr= cur[0];
			int cc= cur[1];
			int dep= cur[2];
			if(dep<d) {
				for (int i = 0; i < dr.length; i++) {
					int nr= rr+dr[i];
					int nc= cc+dc[i];
					if(nr>=0 && nr <10 && nc>=0 && nc<10 && !visited[nr][nc][group]) {
						que.offer(new int[] {nr,nc,dep+1});
						visited[nr][nc][group]=true;
						map[nr][nc][group]=p;
					}
				}
			}
		}
		
	}

}
