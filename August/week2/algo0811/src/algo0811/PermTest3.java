package algo0811;

import java.util.Arrays;

public class PermTest3 {
	static int [] p = {1,2,3,4,5};
	static int N=p.length;
	static int R;
	static int count;
	static int[] nums;
	
	public static void main(String[] args) {
		
		
		R=3;
		nums= new int[R];
		npr(0,0);
		System.out.println(count);
		
	}
	// 이렇게 해도 메모리 터지면 dfs+비트 -> dp
	private static void npr(int cnt, int flag) {
		if(cnt==R) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if((flag & (1<<i)) !=0)continue; //prunning
			
			nums[cnt]=p[i];
			npr(cnt+1, (flag | 1<<i));
			nums[cnt]=0;
		}
		
	}

}
