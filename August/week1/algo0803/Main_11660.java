package algo0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11660 {

	static int[][] sums;
	static int N,M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		sums=new int[N+1][N+1];
		for (int i = 1; i < N+1; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				sums[i][j]=sums[i][j-1]+Integer.parseInt(st.nextToken());
				// 읽으면서 구해 놓는다. tabulation
			}
		}//읽기
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < M; i++) {
			int sum=0;
			// 100000개*1000(최대) <int max
			st=new StringTokenizer(br.readLine());
			int Ix=Integer.parseInt(st.nextToken());
			int Iy=Integer.parseInt(st.nextToken());
			int Jx=Integer.parseInt(st.nextToken());
			int Jy=Integer.parseInt(st.nextToken());
			//11659와 동일 행을 반복한다. 
			// 행이 여러개 일뿐이다. 
			for (int j = Ix; j < Jx+1; j++) {
				sum+=(sums[j][Jy]-sums[j][Iy-1]);
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
	
	}

}
