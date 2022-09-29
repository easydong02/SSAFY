package algo0929;

import java.util.Arrays;
import java.util.Scanner;

public class DP1_Fibo_MomoTest {
	
	static long[] calls1, calls2,memo;
	static long callCnt1,callCnt2;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		N= sc.nextInt();
		
		calls1 = new long[N+1]; //각 항을 계산하기 위한 수행횟수
		calls2 = new long[N+1];
		memo = new long[N+1];
		
		callCnt1 = callCnt2=0; //총 수행횟수
		
		calls2 =new long[N+1];
		Arrays.fill(memo, -1); //초기값 -1
		memo[0]=0;
		memo[1]=1;
		
		System.out.println(fibo1(N));
		System.out.println(callCnt1);
		for (int i = 0; i <= N ; i++) {
			System.out.println("fibo("+i+") : "+ calls1[i]);
		}
		System.out.println("-----------------------------------");
		System.out.println(fibo2(N));
		System.out.println(callCnt2);
		for (int i = 0; i <= N ; i++) {
			System.out.println("fibo2("+i+") : "+ calls2[i]);
		}
	}
	
	//메모하지 않는 버전
	static long fibo1(int n) {
		callCnt1 ++;
		calls1[n]++;
		if(n<=1)return n;
		
		return fibo1(n-1)+fibo1(n-2);
	}
	
	//메모하는 버전
	static long fibo2(int n) {
		callCnt2++;
		calls2[n]++;
		if(memo[n]==-1) {
			memo[n] = fibo2(n-1) +fibo2(n-2);
		}
		return memo[n];
	}

}
