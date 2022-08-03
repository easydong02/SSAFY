package algo0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_14501 {
	static int N;
	static int[] times;
	static int[] pays;
	static int max = Integer.MIN_VALUE;
	static int total;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		times= new int[N];
		pays= new int[N];
		
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			times[i]= Integer.parseInt(st.nextToken());
			pays[i]= Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			total=0;
			int sum = earn(i);
			if(sum>=max) {
				max=sum;
			}
		}
		
		System.out.println(max);
		
	}
	
	private static int earn(int i) {
		int cnt =0;
		for (int j = i; j < N; j++) {
			
			if(cnt<=0 ) {
				if(times[j]<=N-j) {
					total +=pays[j];
					cnt = times[j];
				}
			}
			
			cnt--;
		}
		return total;
	} 

}
