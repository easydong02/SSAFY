package algo0811;

import java.util.Arrays;

public class CombiTest {
	static int [] p = {1,2,3,4,5};
	static int N=p.length;
	static int R;
	static int count;
	static int[] nums;
	static boolean[] visited;
	
	public static void main(String[] args) {
		
		
		R=3;
		nums= new int[R];
		visited= new boolean[N];
		ncr(0,0);
		System.out.println(count);
		
	}

	private static void ncr(int start, int cnt) {
		if(cnt==R) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for (int i = start; i < N; i++) {
			visited[i]= true;
			nums[cnt]=p[i];
			ncr(i+1, cnt+1);
			nums[cnt]=0;
			visited[i]=false;
		}
		
	}

}
