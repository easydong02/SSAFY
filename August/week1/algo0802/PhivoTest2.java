package algo0802;

import java.util.Arrays;

public class PhivoTest2 {
	
	static int[] phivo;
	
	public static void main(String[] args) {
		phivo = new int[47];
		Arrays.fill(phivo, -1);
		phivo[0]=0;
		phivo[1]=1;
		phivo[2]=1;
		
		
		
		for (int i = 0; i < 47;i++) {
			System.out.printf("f(%d)= %d\n",i,phivo(i));
		}

	}

	private static int phivo(int n) {
		if(phivo[n] != -1) {
			return phivo[n];
		}else {
			phivo[n] = phivo(n-1) + phivo(n-2);
			return phivo[n];
		}
	}

}
