package algo0804;

import java.util.Arrays;

public class PrevPerm {
	
	static int[] p = {1,2,3,4,5};
	static int N = p.length;
	static int count;
	
	public static void main(String[] args) {
		do {
			count++;
			System.out.println(Arrays.toString(p));
		}while(np(-1));
		System.out.println(count);
	}

	private static boolean np(int size) {
		
		int i = size;
		while(i>0 && p[i-1]> p[i]) i--;
		if(i ==0)return false;
		int j =size;
		while (p[i-1]>p[j]) j--;
		int  temp = p[i-1];
		p[i-1]=p[1];
		int k =size;
		return false;
	}

}
