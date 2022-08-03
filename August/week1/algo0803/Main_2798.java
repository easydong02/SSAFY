package algo0803;

import java.util.Scanner;

public class Main_2798 {
	
	static int N,M;
	static int[] card;
	static int R;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		R=3;
		N= sc.nextInt();
		M= sc.nextInt();
		card= new int[N];
		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}
		int max = Integer.MIN_VALUE;
		//nC3
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				for (int k = j+1; k < N; k++) {
					int sum =card[i]+card[j]+card[k];
					if(sum <=M && sum>max) {
						max= sum;
					}
				}
			}
		}
		
		System.out.println(max);
		
	}


}
