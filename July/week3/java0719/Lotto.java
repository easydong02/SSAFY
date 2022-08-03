package com.ssafy.edu.first;

import java.util.Arrays;

public class Lotto {
	private int[] lots;
	private int n;
	
	public Lotto(int n) {
		super();
		this.n =n;
		lots= new int[n];
	}

	public Lotto() {
		this(6); //위에 만든 생성자 오버로딩  F3누르면 확인 가능.
	}
	
	public void print() {
//		for (int i = 0; i < n; i++) {
//			System.out.print(lots[i]+" ");
//		}
//		System.out.println();
		
		System.out.println(Arrays.toString(lots));
	}

	public void make() {
		int cnt =0;
		while(cnt<this.n) {
			int t = (int)(Math.random()*45)+1;
			if(!contains(t)) {
				lots[cnt++] = t;
			}
		}
		Arrays.sort(lots);
	}

	private boolean contains(int t) {
		for(int lot : lots) {
			if(lot ==t) {
				return true;
			}
		}
		return false;
	}

	@Override // 오버라이딩했음
	public String toString() {
		return "Lotto [lots=" + Arrays.toString(lots) + ", n=" + n + "]";
	}
	
	
	
	
}
