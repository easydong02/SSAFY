package algo1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1263_D6_사람네트워크2 {
	static int T,N,d[][],map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int testcase = 1; testcase <=T; testcase++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map= new int[N][N];
			d= new int[N][N];
			int inf= 1000000000;
			
			for(int[] temp : d) {
				Arrays.fill(temp, inf );
			}
			
			for (int i = 0; i < N; i++) {
				d[i][i]=0;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int temp =Integer.parseInt(st.nextToken());
					map[i][j]= temp;
					if(temp==1) {
						d[i][j]=1;
					}
				}
			}//end of reading
			
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						d[i][j]= Math.min(d[i][j], d[i][k]+d[k][j]);
					}
				}
			}
			
			int result =Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum =0;
				for (int j = 0; j < N; j++) {
					sum += d[i][j];
				}
				result = Math.min(result, sum);
			}
			
			System.out.println("#"+testcase+" "+result);
		}
	}

}
