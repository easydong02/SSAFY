package algo0817;

import java.util.Arrays;

public class PermTest3 {
	static int[] p = {1,2,3,4,5,6};
	static int N= p.length;
	static int R;
	static int[] nums;
	static int count;
	
	public static void main(String[] args) {
		R=3;
		nums= new int[R];
		npr(0,0);
		System.out.println(count);
	}
	
	// flag 000000~111111
	private static void npr(int cnt, int flag) {
		if(cnt==R) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if( (1<<i & flag)  !=0)continue;
			nums[cnt]= p[i];
			npr(cnt+1, (1<<i | flag));
			nums[cnt]=0;
			
		}
		
		
	}

}