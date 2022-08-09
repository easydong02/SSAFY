package amgi;

import java.util.Arrays;

public class PermTest {
	
	
	static int[] p = {1,2,3,4,5};
	static int N= p.length;
	static int R;

	static boolean[] visited;
	static int count;
	
	public static void main(String[] args) {
		R=3;
		visited = new boolean[N];
		
		npr(0, new int[R]);
		System.out.println(count);
		
	}

	private static void npr(int cnt, int[] nums) {
		if(cnt==3) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i])continue;
			visited[i]= true;
			nums[cnt]= p[i];
			npr(cnt+1,nums);
			
			nums[cnt]=0;
			visited[i]=false;
		}
		
	}

}
