package algo0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1463_S3_1로만들기 {
	static int N,dp[];
	static int min = 100001;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N= Integer.parseInt(br.readLine());
		dp = new int[N+1];
		Arrays.fill(dp, -1);
		dp[0]=dp[1] =0;
		System.out.println(recur(N));
		
	}
	private static int recur(int n) {
		
		// ex) 8이면 7과 4의 최적해에서 한번만 더 하면 된다( +1, *2), 즉 이 둘의 최적해에서 최소값을 찾고 거기에 한번더 해주면 8의 최적해
		if(dp[n]==-1) {
			if(n%6==0) {
				dp[n] = Math.min(recur(n-1), Math.min(recur(n/2), recur(n/3)))+1;
			}else if(n%3==0) {
				dp[n]=Math.min(recur(n-1), recur(n/3))+1;
			}else if(n%2==0) {
				dp[n]=Math.min(recur(n-1), recur(n/2))+1;
			}else {
				dp[n]=recur(n-1)+1;
			}
		}
		
		
		return dp[n];
	}
	
	

}
