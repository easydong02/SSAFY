package algo0826;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕2 {
	
	static Point[] machines;
	static int R,C,T,result;
	static int[][] map;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		R= Integer.parseInt(st.nextToken());
		C= Integer.parseInt(st.nextToken());
		T= Integer.parseInt(st.nextToken());
		machines= new Point[2];
		map=new int[R][C];
		int gonggi=0;
		for (int i = 0; i < R; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int tmp=Integer.parseInt(st.nextToken());
				map[i][j]= tmp;
				if(tmp==-1) {
					machines[gonggi++]=new Point(i,j+1);
				}
			}
		}//end of reading
		
		
		for (int i = 0; i < T; i++) {
			spread();
//			for(int[] m : map) {
//				System.out.println(Arrays.toString(m));
//			}
//			System.out.println("---------------------");
			operate();
//			for(int[] m : map) {
//				System.out.println(Arrays.toString(m));
//			}
//			System.out.println("---------------------");
		}
		
		
		
		//결과 출력
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != -1 && map[i][j] != 0 ) {
					result += map[i][j];
				}
			}
		}
		System.out.println(result);
	}
	private static void operate() {
		Point up = machines[0];
		Point down= machines[1];
		
		upClean(up);
		downClean(down);

	}
	private static void downClean(Point down) {
		int dx= down.x;
		int dy= down.y;
		int [] dr = {0,1,0,-1};
		int [] dc = {1,0,-1,0};
		int temp=map[dx][dy];
		map[dx][dy]=0;
		for (int i = 0; i < dc.length; i++) {
			while(true) {
				int nr= dx+ dr[i];
				int nc= dy+ dc[i];
				
				if(nr>=0 && nr <R && nc >=0 && nc <C ) {
					if(map[nr][nc] ==-1)return;
					int tmp= map[nr][nc];
					map[nr][nc]= temp;
					temp= tmp;
					dx=nr;
					dy=nc;
				}else {
					break;
				}
			}
		}
	}
	private static void upClean(Point up) {
		int ux=up.x;
		int uy=up.y;
		int [] dr = {0,-1,0,1};
		int [] dc = {1,0,-1,0};
		int temp=map[ux][uy];
		map[ux][uy]=0;
		for (int i = 0; i < dc.length; i++) {
			while(true) {
				int nr= ux+ dr[i];
				int nc= uy+ dc[i];
				
				if(nr>=0 && nr <R && nc >=0 && nc <C ) {
					if(map[nr][nc] ==-1)return;
					int tmp= map[nr][nc];
					map[nr][nc]= temp;
					temp= tmp;
					ux=nr;
					uy=nc;
				}else {
					break;
				}
			}
		}
	}
	private static void spread() {
		int[] dr= {-1,0,1,0};
		int[] dc= {0,1,0,-1};
		int[][] temp = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != -1 && map[i][j] != 0 && map[i][j]>=5) {
					int cnt =0;
					for (int k = 0; k < dr.length; k++) {
						int nr = i+dr[k];
						int nc = j+dc[k];
						if(nr>=0 && nr< R && nc>=0 && nc<C && map[nr][nc] !=-1) {
							temp[nr][nc]+= map[i][j]/5;
							cnt ++;
						}
					}
					map[i][j] -= (map[i][j]/5)*cnt;
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] +=temp[i][j];
			}
		}
		


		
		
	}

}
