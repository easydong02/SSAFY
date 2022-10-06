package algo1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3307_D3_최장증가부분수열 {
	
	static int T,N,nums[],lis[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int testcase = 1; testcase <=T; testcase++) {
			N= Integer.parseInt(br.readLine());
			nums= new int[N];
			lis= new int[N];
			Arrays.fill(lis, 1);
			StringTokenizer st =new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}//end of reading
			
			int max =1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < i; j++) {
					if(nums[i]>nums[j] && lis[i]<lis[j]+1) {
						lis[i]=lis[j]+1;
					}
				}
				max= Math.max(max, lis[i]);
			}
			
			System.out.println("#"+testcase+" "+max);
		}
	}

}
