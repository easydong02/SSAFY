package algo0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_G3_말이되고픈원숭이 {
	
	static class Monk{
		int r;
		int c;
		int count;
		int k;
		
		public Monk(int r, int c, int count, int k) {
			super();
			this.r = r;
			this.c = c;
			this.count = count;
			this.k = k;
		}
	}
	
	static int K,W,H, map[][],result;
	static boolean[][][] visited;
	static Queue<Monk> que;
	static int [] dr = {-1,0,1,0};
	static int [] dc = {0,1,0,-1};
	
	static int [] hr;
	static int [] hc;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		init();
		K= Integer.parseInt(br.readLine());
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map= new int[H][W];
		visited=new boolean[H][W][K+1];
		que =new LinkedList<>();
		for (int i = 0; i < H; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}//end of reading
		
		Monk monk = new Monk(0,0,0,K);
		
		bfs(monk);
		System.out.println(result);
		
	}
	private static void bfs(Monk monk) {
		que.offer(monk);
		visited[monk.r][monk.c][monk.k]=true;
		
		
		while(!que.isEmpty()) {
			Monk cur = que.poll();
			int r = cur.r;
			int c = cur.c;
			int count = cur.count;
			int k = cur.k;
			
			if(r == H-1 && c == W -1) {
				result = count;
				return;
			}
			
			for (int i = 0; i < dc.length; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr>=0 && nr <H && nc>=0 && nc <W && !visited[nr][nc][k] && (map[nr][nc] != 1)) {
					visited[nr][nc][k]=true;
					Monk temp = new Monk(nr,nc,count+1,k);
					que.offer(temp);
				}
			}
			
			if(k>0) {
				for (int i = 0; i < hr.length; i++) {
					int nr = r + hr[i];
					int nc = c + hc[i];
					
					if(nr>=0 && nr <H && nc>=0 && nc <W && !visited[nr][nc][k-1] && (map[nr][nc] != 1)) {
						visited[nr][nc][k-1]=true;
						Monk temp = new Monk(nr,nc,count+1,k-1);
						que.offer(temp);
					}
				}
			}
			
		}
		
		result = -1;
	}
	private static void init() {
		hr = new int[8];
		hc = new int[8];
		
		int [] point1= {-1,1};
		int [] point2= {1,1};
		int [] point3= {1,-1};
		int [] point4= {-1,-1};
		
		hr[0]= point1[0]-1;
		hc[0]= point1[1];
		
		hr[1]= point1[0];
		hc[1]= point1[1]+1;
		
		hr[2]= point2[0];
		hc[2]= point2[1]+1;
		
		hr[3]= point2[0]+1;
		hc[3]= point2[1];
		
		hr[4]= point3[0]+1;
		hc[4]= point3[1];
		
		hr[5]= point3[0];
		hc[5]= point3[1]-1;
		
		hr[6]= point4[0];
		hc[6]= point4[1]-1;
		
		hr[7]= point4[0]-1;
		hc[7]= point4[1];
	}

}
