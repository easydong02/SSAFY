package java0801;
//npr 5p3 = 5*4*3

import java.util.Arrays;

public class Combitest {
	
	static int[] p = {1,2,3,4,5};
	static int N;
	static int R;
	static int[] nums;			//5p3이면 3개 저장
	static boolean[] visited;	//사용한 적 있냐?
	static int count;				//npr 개수
	
	public static void main(String[] args) {
		N= p.length;
		R=3;
		nums = new int[R];
		visited= new boolean[N];
		npr(0,0);
		System.out.println(count);
	}
	
	private static void npr(int start, int cnt) {
		if(cnt==R) {
			count ++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = start; i < N; i++) {
			if(visited[i])continue;
			visited[i]=true;
			nums[cnt] = p[i];
			npr(i+1,cnt+1);
			//nums[cnt]=0;
			visited[i]=false;
			
		}
		
	}

}
