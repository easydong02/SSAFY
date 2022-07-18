package com.ssafy.ws01.step3;

import java.util.Scanner;

public class DigitTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = 5;
		int cnt= 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2*Math.abs(i-N/2)+1; j++) {
				System.out.printf("%d ",cnt++);
			}
			System.out.println();
		}
	}

}
