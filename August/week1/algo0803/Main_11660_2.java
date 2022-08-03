package algo0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11660_2 {
	static int N,M;
	static int[][] sums;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		sums =new int[N][N];
		
		//sums 만들기
		int temp=0;
		int cnt =0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				sums[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		for (int i = 0; i < M; i++) {
			int result =0;
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken())-1;
			int y1 = Integer.parseInt(st.nextToken())-1;
			int x2 = Integer.parseInt(st.nextToken())-1;
			int y2 = Integer.parseInt(st.nextToken())-1;
			
			for (int j = x1; j <= x2; j++) {
				for (int k = y1; k <= y2; k++) {
					result += sums[j][k];
				}
			}
			
			System.out.println(result);
			
		}
		
		//2 2 -> (1,1) ->  sums[5]
		//3 4 -> (2,3) ->  sums[11]
		
	}

}
