package algo0803;

import java.util.Scanner;

public class Main_2798_2 {
	
	static int N,M;
	static int[] card;
	static int R;
	static int max;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		R=3;
		N= sc.nextInt();
		M= sc.nextInt();
		card= new int[N];
		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}
		//nC3
		max = Integer.MIN_VALUE;
		nCr(0,0,0);
		
		System.out.println(max);
		
	}

	private static void nCr(int start, int cnt, int tot) {
		if(cnt==R) {
			if(tot<=M) {
				max= Math.max(tot,max);
			}
			return;
		}
		for (int i = start; i < N; i++) {
			nCr(i+1,cnt+1,tot+card[i]);
		}
		
	}


}
