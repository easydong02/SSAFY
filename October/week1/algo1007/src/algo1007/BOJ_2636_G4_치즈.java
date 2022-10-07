package algo1007;

import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_G4_치즈 {
	
	static int R,C,map[][], map2[][],times,result;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean [][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		R= Integer.parseInt(st.nextToken());
		C= Integer.parseInt(st.nextToken());
		map=new int[R][C];
		map2=new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int tmp= Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				map2[i][j]= tmp;
			}
		}// end of reading
		
		
		while(true) {
			times++;
			melt(); //녹이기
			
			//종료조건
			if(finish()) {
				break;
			}else {
				copy(); //복사
			} 
			
		}
		
		result = makeResult(); //마지막 너비 계산
		
		System.out.println(times);
		System.out.println(result);
		
	}
	
	private static int makeResult() {
		int sum =0;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]==1)sum ++;
			}
		}
		
		return sum;
	}
	
	
	private static void copy() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j]=map2[i][j];
			}
		}
	}
	
	//map2 녹이기
	private static void melt() {
		//구멍찾기, 벽은2, 구멍0, 치즈1
		findholes();
		boolean[][] meltChk =new boolean[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map2[i][j]==1) {
					for (int k = 0; k < dc.length; k++) {
						if(map2[i+dr[k]][j+dc[k]] == 2) {
							meltChk[i][j]= true;
						}
					}
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(meltChk[i][j]) {
					map2[i][j]=2;
				}
			}		
		}
		
	}
	
	
	private static void findholes() {
		visited = new boolean[R][C];
		bfs(0,0);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {r,c});
		visited[r][c]= true;
		map2[r][c]=2;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int rr = cur[0];
			int cc = cur[1];
			
			for (int i = 0; i < dr.length; i++) {
				int nr = rr+dr[i];
				int nc = cc+dc[i];
				
				if(nr>=0 && nr<R && nc>=0 && nc<C && !visited[nr][nc] && map2[nr][nc]!=1) {
					que.offer(new int[] {nr,nc});
					visited[nr][nc]=true;
					map2[nr][nc]=2;
				}
			}
		}
	}

	private static boolean finish() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map2[i][j] ==1) {
					return false;
				}
			}
		}
		return true;
	}

}
