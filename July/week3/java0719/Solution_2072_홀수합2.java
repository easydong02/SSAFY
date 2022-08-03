package com.ssafy.edu.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_2072_홀수합2 {
	static int N = 10;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			int[] nums = new int[N]; // 32bit 320bit
			StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄을 먼저 읽고
			for (int j = 0; j < nums.length; j++) {
				nums[j] = Integer.parseInt(st.nextToken()); // 그 한 줄을 공백을 기준으로 순서대로 입력
			}

			int sum = sums(nums);

			System.out.println("#" + i + " " + sum);
		}
	}

	private static int sums(int[] nums) {
		int sum =0;
		for(int num : nums) {
			if(num%2 !=0) {
				sum += num;
			}
		}
		return sum;
	}

}
