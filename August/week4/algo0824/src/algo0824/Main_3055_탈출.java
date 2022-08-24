package algo0824;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055_탈출 {
	static class Gosmdochi{
		int r;
		int c;
		public Gosmdochi(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int R,C;
	static char[][] map;
	static boolean[][] visited;
	static Gosmdochi gs;
	static Point D;
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	static List<int[]>water;
	static int level = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		R= Integer.parseInt(st.nextToken());
		C= Integer.parseInt(st.nextToken());
		water= new ArrayList<int[]>();
		map=new char[R][C];
		
		for (int i = 0; i < R; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j]=tmp[j];
				if(tmp[j]=='S') {
					gs= new Gosmdochi(i, j);
				}else if(tmp[j]=='D') {
					D= new Point(i,j);
				}else if(tmp[j]=='*') {
					water.add(new int[] {i,j});
				}
			}
		}//end of reading
		
		
		start(gs.r,gs.c);
		
//		for(char[] c : map) {
//			System.out.println(Arrays.toString(c));
//		}
		
	}
	private static void start(int r, int c) {
		visited= new boolean[R][C];
		Queue<int[]> que= new LinkedList<int[]>();
		que.offer(new int[] {r,c,0});
		visited[r][c]=true;
		while(!que.isEmpty()) {
			boolean chk=false;
			int [] cur = que.poll();
			int rr= cur[0];
			int cc= cur[1];
			int dist= cur[2];
			if(rr==D.x && cc==D.y) {
				System.out.println(dist);
				return;
			}else if(map[rr][cc]=='*') {
				continue;
			}
			for (int i = 0; i < dr.length; i++) {
				int nr= rr+dr[i];
				int nc= cc+dc[i];
				if(nr>=0 && nr <R && nc >=0 && nc <C && !visited[nr][nc]) {
					if(check(nr,nc) && map[nr][nc] != 'X') {
						que.offer(new int[] {nr,nc,dist+1});
						if(dist+1>level && !chk) {
							level=dist+1;
							chk=true;
						}
					}
					visited[nr][nc]= true;
				}
			}
			if(dist+1==level && chk) {
				for (int i = 0,size=water.size(); i < size; i++) {
					flood(water.get(i));
				}
			}
		}
		System.out.println("KAKTUS");
	}
	private static boolean check(int r, int c) {
		if(map[r][c]=='*')return false;
		if(map[r][c]=='D')return true;
		for (int i = 0; i < dc.length; i++) {
			int nr= r+dr[i];
			int nc= c+dc[i];
			if(!(nr>=0 && nr <R && nc>=0 && nc<C))continue;
			if(map[nr][nc]=='*') {
				return false;
			}
		}
		return true;
	}
	private static void flood(int[] tmp) {
		int r= tmp[0];
		int c= tmp[1];
		
		for (int i = 0; i < dr.length; i++) {
			int nr= r+dr[i];
			int nc= c+dc[i];
			if(nr>=0 && nr <R && nc >=0 && nc <C && map[nr][nc] !='*' && map[nr][nc]!='X' && map[nr][nc] !='D') {
				map[nr][nc]='*';
				water.add(new int[] {nr,nc});
			}
		}
	}

}
