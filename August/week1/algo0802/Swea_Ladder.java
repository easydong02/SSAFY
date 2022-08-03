package algo0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_Ladder {
	static int T;
	static int N =100;
	static int[][] ladder;
	
	static int[] dr= {0,0};
	static int[] dc= {-1,1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T= 10;
		
		for (int tc = 1; tc <=T ; tc++) {
			tc= Integer.parseInt(br.readLine());
			ladder = new int[N][N];
			int r = 99;
			int c = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					ladder[i][j]= Integer.parseInt(st.nextToken());
				}
			} // end of reading
			
			for(int i=0;i<N;i++) { //도착지점 체크
				if(ladder[r][i]==2) {
					c =i;
				}
			}
			int result = ladder(r,c);
			System.out.println("#"+tc+" "+result);
			
		}
		
	}
	private static int ladder(int r, int c) {
		boolean lChk=false;
		boolean rChk=false;
		while(true) {
			//좌우 확인 확인
			int lc= c+dc[0];
			int rc= c+dc[1];
			boolean lcChk= lc>=0 && lc<N;
			boolean rcChk= rc>=0 && rc<N;
			
			if(  lcChk &&  (ladder[r][lc]==1 && !rChk)) {
				c= lc;
				lChk=true;
			}else if(rcChk && (ladder[r][rc]==1  && !lChk)) {
				c= rc;
				rChk=true;
			}else {
				r--;
				rChk=false;
				lChk=false;
			}
			
			if(r<0) {
				return c;
			}
			
		}
	}

}
