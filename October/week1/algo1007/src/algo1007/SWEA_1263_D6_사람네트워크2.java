package algo1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1263_D6_사람네트워크2 {
	
	static int T,N,d[][],map[][];
	static int inf = 1000000000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int testcase = 1; testcase <=T; testcase++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			N= Integer.parseInt(st.nextToken());
			map =new int[N][N];
			d= new int[N][N];
			int result =  Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					d[i][j]=inf;
					if(i==j)d[i][j]=0;
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int temp =Integer.parseInt(st.nextToken());
					if(temp==1) {
						d[i][j]= temp;
					}
				}
			}// end of reading
			
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(d[i][j]> d[i][k]+d[k][j]) {
							d[i][j]=d[i][k]+d[k][j];
						}
					}
				}
			}
			
			
			for (int i = 0; i < N; i++) {
				int sum =0;
				for (int j = 0; j < N; j++) {
					sum += d[i][j];
				}
				result = Math.min(sum, result);
			}
			System.out.println("#"+testcase+" "+result);
			
		}
	}

}
