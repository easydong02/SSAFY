package algo0827;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] temp = new int[4];
		int[] cards = {1,2,3,4};
		for (int i = 0; i < temp.length; i++) {
			temp[i]=cards[cards.length-i-1];
		}
		
		System.out.println(Arrays.toString(temp));
	}

}
