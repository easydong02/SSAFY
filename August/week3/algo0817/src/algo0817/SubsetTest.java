package algo0817;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetTest {
	static int[] p = {1,2,3,4,5,6};
	static int N= p.length;
	static int R;
	static boolean[] visited;
	static int count;
	
	public static void main(String[] args) {
		R=3;
		visited = new boolean[N];
		npr(0,0, new ArrayList<String>());
		System.out.println(count);
	}

	private static void npr(int cnt, int tot, ArrayList<String> nums) {
		if(cnt==N) {
			count++;
			System.out.println(Arrays.toString(nums.toArray()));
			System.out.println("---->"+tot);
			return;
		}
		
		
		visited[cnt]=true;
		nums.add(p[cnt]+"");
		npr(cnt+1,tot+p[cnt],nums);
		visited[cnt]=false;
		nums.remove(p[cnt]+"");
		npr(cnt+1,tot,nums);
		
	}

}
