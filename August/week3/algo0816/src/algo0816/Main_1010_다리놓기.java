package algo0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1010_다리놓기 {
	static int T,N,M;
	static Integer[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T= Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			N= Integer.parseInt(st.nextToken());
			M= Integer.parseInt(st.nextToken());
			dp = new Integer[30][30];
			
			
			
			
			System.out.println(ncr(N,M));
			
		}
	}
	private static int ncr(int n, int m) {
		if(dp[n][m] != null) {
			return dp[n][m];
		}
		
		if(n==m || n==0) {
		
			return 1;
		}
		
		
		return dp[n][m] = ncr(n-1,m-1) + ncr(n,m-1);
		
	}

}
