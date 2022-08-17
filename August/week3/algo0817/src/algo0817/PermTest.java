package algo0817;

import java.util.Arrays;

public class PermTest {
	static int[] p = {1,2,3,4,5,6};
	static int N= p.length;
	static int R;
	static int[] nums;
	static boolean[] visited;
	static int count;
	
	public static void main(String[] args) {
		R=3;
		nums= new int[R];
		visited = new boolean[N];
		npr(0);
		System.out.println(count);
	}

	private static void npr(int cnt) {
		if(cnt==R) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i])continue;
			nums[cnt]= p[i];
			visited[i]=true;
			npr(cnt+1);
			nums[cnt]=0;
			visited[i]=false;
			
		}
		
		
	}

}
