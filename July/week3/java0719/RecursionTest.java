package com.ssafy.edu.first;

public class RecursionTest {

	public static void main(String[] args) {
		int N=12;
		int fr=fact(N);
		System.out.println(fr);
	}

	private static int fact(int n) {
		if(n==1 || n==0)return 1;
		else return n*fact(n-1);
	}

}
