package algo0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11659 {
	static int N,M;
	static int[] sums;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		sums =new int[N+1];
		sums[0]=0;
		int temp=0;
		st= new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			temp += Integer.parseInt(st.nextToken());
			sums[i] = temp;
			
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
//			System.out.println(sums[start-1]);
//			System.out.println(sums[end]);
//			System.out.println(Arrays.toString(sums));
			System.out.println(sums[end]-sums[start-1]);
		}
		
	}

}
