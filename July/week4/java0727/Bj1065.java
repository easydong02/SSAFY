package java0727;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Bj1065 {
	static int num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		num = sc.nextInt();
		
		int result = cntHan(num);
		
		System.out.println(result);
		
	}
	private static int cntHan(int num) {
		int cnt=0;
		
		for (int i = 1; i <=num ; i++) {
			if(checkHan(i)) {
				cnt++;
			}
		}

		return cnt;
	}
	
	private static boolean checkHan(int a) {
        int[] digits = Stream.of(String.valueOf(a).split("")).mapToInt(Integer::parseInt).toArray();
        if(digits.length <=2) {
        	return true;
        }
		
		for (int i = 1; i < digits.length-1; i++) {
			if((digits[i+1]-digits[i])==digits[i]-digits[i-1]) {
				return true;
			}else {
				break;
			}
		}
		return false;
	}

}
