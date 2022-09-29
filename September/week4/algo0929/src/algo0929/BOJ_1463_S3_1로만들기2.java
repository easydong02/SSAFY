package algo0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1463_S3_1로만들기2 {
	static int N,dp[];
	static int min = 100001;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N= Integer.parseInt(br.readLine());
		System.out.println(recur(N,0));
		
	}
	private static int recur(int n, int count) {
		
		if(n <2) {
			return count;
		}
		
		
		return Math.min(recur(n/2,count +1+ (n%2)), recur(n/3,count +1+ (n%3)) );
	}
	
	

}
