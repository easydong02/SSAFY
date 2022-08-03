package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1859 {
	
	static int[] nums;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int testcase = 1; testcase <= T; testcase++) {
			int N = Integer.parseInt(br.readLine());
			nums =new int[N];
			
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i]= Integer.parseInt(st.nextToken());
			}
			
			long sum = 0L;
			int max =nums[N-1];
			for ( int i =N-2;i>=0;i--) {
				if(nums[i]>max) {
					max=nums[i];
					
				}
				else {
					sum +=(max-nums[i]);
				}
			}
			
			System.out.println("#"+testcase+" "+sum);
			
			
		}

	}

}
