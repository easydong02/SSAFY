package algo0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_8382_D4_방향전환 {
	
	
	static int T,map[][],start[],end[];
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	static boolean[][] visited;
	static Queue<int[]> que;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		map = new int[201][201];
		visited=new boolean[201][201];
		start= new int [4];
		end= new int [4];
		que = new LinkedList<>();
		T = Integer.parseInt(br.readLine());
		
		for (int testcase = 1; testcase <=T; testcase++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken())+100;
			start[1] = Integer.parseInt(st.nextToken())+100;
			start[2]=0;
			start[3]=0;
			end[0] = Integer.parseInt(st.nextToken())+100;
			end[1] = Integer.parseInt(st.nextToken())+100;
			end[3]=0;
			
			bfs(start);
			System.out.println(end[2]);
		}
		
	}
	private static void bfs(int[] start) {
		que.offer(start);
		visited[start[0]][start[1]]= true;
		
		
		while(!que.isEmpty()) {
			int[] cur =que.poll();
			int r = cur[0];
			int c = cur [1];
			int dist = cur[2];
			int chk = cur[3];
			if(r==end[0] && c == end[1]) {
				end[2]=dist;
				return;
			}
			
			for (int i = 0; i < dr.length; i++) {
				int nr= -1;
				int nc= -1;
				if(chk ==0 && (i==1 || i==3)) {
					nc = c + dc[i];
					nr = r + dr[i];
				}else if(chk==1 && (i==0 || i ==2)) {
					nc = c + dc[i];
					nr = r + dr[i];
				}
				if(nr >=0 && nr <201 && nc >=0 && nc <201 && !visited[nr][nc]) {
					visited[nr][nc]=true;
					int chk2= chk==0? 1:0;
					int[] temp = {nr,nc,dist+1,chk2};
					que.offer(temp);
				}
			}
		}
	}

}
