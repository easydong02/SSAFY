package java0727;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Bj1065_2 {
	static int num;
	static int[] nums;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		num = sc.nextInt();
		nums = new int[1001];
		
		for (int i = 1; i < 100; i++) {
			nums[i]=i;
		}
		
		for (int i = 100; i < num+1; i++) {
			if(isHan(i)) {
				nums[i]=nums[i-1]+1;
			}else {
				nums[i]=nums[i-1];
			}
		}
		System.out.println(nums[num]);
		
	}

	private static boolean isHan(int n) {
		String s = String.valueOf(n);
		char[] sc= s.toCharArray();
		int[] num = new int[sc.length];
		for (int i = 0; i < num.length; i++) {
			num[i]= sc[i]-'0';
		}
		for (int i = 1; i < num.length-1; i++) {
			if(num[i+1]-num[i]!=num[i]-num[i-1]) {
				return false;
			}
		}
		
		
		return true;
	}
	

}
