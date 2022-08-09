package algo0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_1861_2 {
	static int N,T;
	static int[][] map;
	
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	static int count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <=T; tc++) {
			N= Integer.parseInt(br.readLine());
			map= new int[N][N];
			int num=Integer.MAX_VALUE;
			int max= Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
				}
			}//end of reading
			
			
			
			for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int tmp = findMap(i, j) + 1;
                    if(tmp >= max){
                        if(tmp == max & num < map[i][j])
                            continue;
                        max = tmp;
                        num = map[i][j];
                    }
                }
            }
			
			System.out.println("#"+tc+" "+num+" "+max);
			
		}
		

	}
	private static int findMap(int r, int c) {
		int cnt=0;
		for (int i = 0; i < dr.length; i++) {
			int nr= r+dr[i];
			int nc= c+dc[i];
			
			if(nr >=0 && nr< N && nc >=0 && nc< N && (map[nr][nc]==map[r][c]+1) ) {
				cnt ++;
				cnt += findMap(nr,nc);
			}
		}
		
		
		return cnt;
	}

}
