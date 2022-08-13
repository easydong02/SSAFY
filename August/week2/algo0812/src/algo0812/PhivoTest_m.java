package algo0812;

import java.util.Arrays;

public class PhivoTest_m {
	
	static int[] phivo = new int[47];
	
	public static void main(String[] args) {
		
		
		Arrays.fill(phivo, -1);
		phivo[0]=0;
		phivo[1]=1;
		
		for (int i = 0; i < 30; i++) {
			System.out.println(phivo(i));
		}
	}

	private static int phivo(int n) {
		if(phivo[n]!=-1) return phivo[n];
		else return phivo[n]=phivo(n-1)+phivo(n-2);
	}

}
