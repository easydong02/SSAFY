package java0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bj10972 {
	static int[] p ;
	static int N ;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N= Integer.parseInt(br.readLine());
		
		p = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			p[i]= Integer.parseInt(st.nextToken());
		}
		
		
		if(np(N-1)) {
			
			for (int i = 0; i < p.length; i++) {
				System.out.print(p[i]);
				
				if(i != p.length-1) {
					System.out.print(" ");
				}
			}
		}else {
			System.out.print(-1);
		}
		

	}


	private static boolean np(int size) {
		int i =size;
		while(i>0 && p[i-1]>p[i]) {
			i--;
		}
		if(i==0) {
			return false;
		}
		int j=size;
		while(p[i-1]>p[j]) {
			j--;
		}
		int temp=p[i-1];
		p[i-1]=p[j];
		p[j] =temp;
		
		int k =size;
		while(i< k) {
			temp=p[i];
			p[i]=p[k];
			p[k]=temp;
			i++;
			k--;
		}
		
		
		return true;
	}

}
