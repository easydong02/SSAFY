package algo0817;

import java.util.ArrayList;
import java.util.Arrays;

public class PermTest2 {
	static int[] p = {1,2,3,4,5,6};
	static int N= p.length;
	static int R;
	static boolean[] visited;
	static int count;
	
	public static void main(String[] args) {
		R=3;
		visited = new boolean[N];
		npr(0, new ArrayList<String>());
		System.out.println(count);
	}

	private static void npr(int cnt, ArrayList<String> nums) {
		if(cnt==R) {
			count++;
			System.out.println(Arrays.toString(nums.toArray()));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i])continue;
			visited[i]=true;
			nums.add(p[i]+"");
			npr(cnt+1,nums);
			nums.remove(p[i]+"");
			visited[i]=false;
			
		}
		
		
	}

}
