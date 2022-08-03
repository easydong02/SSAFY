package java0726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2443 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		
		//°ø¹é 0 1 2 3 4
		//º° 9 7 5 3 1
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2*N - 2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
