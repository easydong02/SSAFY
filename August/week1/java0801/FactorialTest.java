package java0801;

import java.util.Scanner;

public class FactorialTest {

	
	static int factorial(int n) {
		//5*4*3*2*1
		int res=1;
		
		for (int i = n; i >=1; i--) {
			res *=i;
		}
		
		return res;
	}
	
	static int factorial2(int i) {
		if(i==0)return 1;
		else {
			return i*factorial2(i-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N =sc.nextInt();
		
		System.out.println(factorial2(N));

	}

}
