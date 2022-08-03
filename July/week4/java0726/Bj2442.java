package java0726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2442 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		
		//°ø¹é 4 3 2 1 0
		//º° 1 3 5 7 9
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-i-1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2*i +1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
