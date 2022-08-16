package algo0812;

import java.util.Arrays;

public class PhivoTest_t {
	
	static int[] phivo = new int[47];
	
	public static void main(String[] args) {
		
		
		Arrays.fill(phivo, -1);
		phivo[0]=0;
		phivo[1]=1;
		
		for (int i = 2; i < 47; i++) {
			phivo[i]=phivo[i-1]+phivo[i-2];
		}
		
		for (int i = 0; i < phivo.length; i++) {
			System.out.println(phivo[i]);
		}
	}


}
