package algo0802;

import java.util.Arrays;

public class PhivoTest3 {
	
	static int[] phivo;
	
	public static void main(String[] args) {
		phivo = new int[47];
		phivo[0]=0;
		phivo[1]=1;
		
		
		
		for (int i = 2; i < 47;i++) {
			phivo[i]= phivo[i-1] + phivo[i-2];
		}
		for (int i =0; i < 47;i++) {
			System.out.printf("f(%d)=%d\n",i,phivo[i]);
		}

	}


}
