package algo0802;

import java.util.Arrays;

public class FactTest2 {
	
	static int[] fact;
	
	public static void main(String[] args) {
		fact = new int[13];
		Arrays.fill(fact, -1);
		fact[0]= 1;
		fact[1]= 1;
		fact(12);
		for (int i = 0; i < 13;i++) {
			System.out.println(i+ "!="+fact[i]);
		}

	}

	
	private static int fact(int n) {
		if(fact[n] != -1) {
			return fact[n];
		}else {
			fact[n] = n*fact(n-1);
			return fact[n];
		}
	}


}
