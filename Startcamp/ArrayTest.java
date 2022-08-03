package com.ssafy.ws.step2;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {
		// 1. 정수 배열 한줄로 출력
		int[] numArray= {1,2,3,4,5,6,7,8,9,0};
		String sum ="";
		for(int i : numArray) {
			sum += String.valueOf(i);
		}
		System.out.println(sum);
		
		// 2. 음식 배열
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String[] foodArray = new String[T];
		
		for (int i = 0; i < T; i++) {
			foodArray[i] = sc.next();
		}
		
		for(String food: foodArray) {
			System.out.println(food);
		}
		
		
	}

}
