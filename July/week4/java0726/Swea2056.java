package java0726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea2056 {
	static int T;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int testcase = 1; testcase <=T; testcase++) {
			String str =br.readLine();

			if(str.length() !=8) {
				System.out.println("#"+testcase+" "+ -1);
				continue;
			}
			
			char[] arr= new char[str.length()];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = str.charAt(i);
			}
			
			StringBuilder sb= new StringBuilder();
			StringBuilder sb2= new StringBuilder();
			StringBuilder sb3= new StringBuilder();
			
			sb.append(arr[0]).append(arr[1]).append(arr[2]).append(arr[3]);
			sb2.append(arr[4]).append(arr[5]);
			sb3.append(arr[6]).append(arr[7]);
			
			int year = Integer.parseInt(sb.toString());
			int month = Integer.parseInt(sb2.toString());
			int day = Integer.parseInt(sb3.toString());
			
			if(month>12 || day>31) {
				System.out.println("#"+testcase+" "+ -1);
				continue;
			}
			
			
			
			
			
		}
	}

}
