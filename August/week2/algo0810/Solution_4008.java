package algo0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_4008 {
	static int T,N;
	static int[] signs;
	static int[] nums;
	
	static Set<Integer> result;
	static Stack<Integer> select;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T= Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <=T; tc++) {
			result= new HashSet<>();
			select= new Stack<>();
			N=Integer.parseInt(br.readLine());
			nums= new int[N];
			signs= new int[4]; // 0:+, 1:-, 2:*, 3:/
			StringTokenizer st= new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				signs[i]= Integer.parseInt(st.nextToken());
			}
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i]= Integer.parseInt(st.nextToken());
			}//end of reading
			
			
			dfs(0);
			
			int min = Collections.min(result);
			int max = Collections.max(result);
			
			System.out.println("#"+tc+" "+(max-min));
		}
	}

	private static void dfs(int k) {
		if(k==N-1) {
			result.add(makeNum());
		}
		
		for (int i = 0; i < signs.length; i++) {
			if(signs[i] !=0) {
				select.add(i);
				signs[i] -=1;
				dfs(k+1);
				signs[i] +=1;
				select.pop();
			}
		}
		
	}

	private static Integer makeNum() {
		int result = nums[0];
		
		for (int i = 0; i < select.size(); i++) {
			int temp = select.get(i);
			switch (temp) {
			case 0:
				result += nums[i+1];
				break;
			case 1:
				result -= nums[i+1];
				break;
			case 2:
				result *= nums[i+1];
				break;
			case 3:
				result /= nums[i+1];
				break;
			}
		}
		
		System.out.println(result);
		return result;
	}

}
