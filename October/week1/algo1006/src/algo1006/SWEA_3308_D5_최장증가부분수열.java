package algo1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3308_D5_최장증가부분수열 {
	
	static int T,N,nums[],C[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int testcase = 1; testcase <=T; testcase++) {
			N= Integer.parseInt(br.readLine());
			nums= new int[N];
			C= new int[N];
			StringTokenizer st =new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}//end of reading
			
			int result = 0;
			
			for (int i = 0; i < nums.length; i++) {
				int pos= Arrays.binarySearch(C, 0, result, nums[i]);
				if(pos>=0)continue;
				
				int insertPos= Math.abs(pos)-1;
				
				C[insertPos]= nums[i];
				
				if(insertPos==result)result++;
			}
			System.out.println("#"+testcase+" "+result);
			
		}
	}

}
