package algo0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석 {
	static int[][] map;
	static int T,K,result;
	static int[] directs = {};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T= Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			K= Integer.parseInt(br.readLine());
			map= new int[4][8];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st= new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < K; i++) {
				StringTokenizer st= new StringTokenizer(br.readLine());
				start(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()));
			}
			
			System.out.println("#"+tc+" "+(map[0][0]+map[1][0]*2+map[2][0]*4+map[3][0]*8));
		}
	}
	
	//맞닿아 있는 부분의 index는 2 <-> 6 2 <-> 6 2 <-> 6
	//시계 1 		반시계 -1
	private static void start(int no, int direct) {
		boolean[] chk= new boolean[4];
		check(no,chk);
		
//		System.out.println(Arrays.toString(chk));
		
		for (int i = 0; i < 4; i++) {
			if(chk[i]) {
				spin(i,no,direct);
			}
		}
		
		
	}

	private static void spin(int no, int no2, int direct) {
		if(Math.abs(no-no2) %2==0) {
			go(no,no2,direct);
			
		}else {
			if(direct==1) {
				go(no,no2,-1);
			}else {
				go(no,no2,1);
			}
		}
	}

	private static void go(int no, int no2, int direct) {
		int tmp=0;
		switch (direct) {
		case -1:
			//반시계
			tmp=map[no][0];
			for (int i = 0; i < 7; i++) {
				map[no][i]=map[no][i+1];
			}
			map[no][7]=tmp;
			
			break;
		case 1:
			//시계
			tmp = map[no][7];
			for (int i = 7; i >=1; i--) {
				map[no][i]=map[no][i-1];
			}
			map[no][0]=tmp;
			break;
		}
		
	}

	private static void check(int no, boolean[] chk) {		
		chk[no]=true;
		int[] dr= {-1,1};
		for (int i = 0; i < 2; i++) {
			int nno=no;
			while(true) {
				nno += dr[i];
				if(nno >=0 && nno< 4) {
					if(dr[i]==-1) {
						chk[nno]= map[nno][2] != map[nno+1][6];
					}
					if(dr[i]==1){
						chk[nno]= map[nno-1][2] != map[nno][6];
					}
					
					if(!chk[nno])break;
				}else {
					break;
				}
			}
		}
		
	}
}
