package algo0802;

import java.util.Arrays;

public class PrevPermutation {
	// 5 NextPermutation npn = n!
	
	static int [] p = {3,2,1,5,4};
	static int N;
	static int count;
	
	public static void main(String[] args) {
		N = p.length;
		do {
			count++;
			System.out.println(Arrays.toString(p));
		}while(np(N-1));
		System.out.println(count);
		
	}

	private static boolean np(int size) {
		int i = size;
		while(i>0 && p[i-1]<p[i])i--;
		if(i==0)return false;
		
		int j =size;
		while(p[i-1]<p[j])j--;
		int temp = p[i-1];
		p[i-1] = p[j];
		p[j] = temp;
		
		int k = size;
		while(i<k) {
			temp = p[i];
			p[i] = p[k];
			p[k] = temp;
			i++;
			k--;
		}
		
		return true;
	}

}
