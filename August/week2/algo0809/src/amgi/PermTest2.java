package amgi;

import java.util.Arrays;

public class PermTest2 {
	
	
	static int[] p = {1,2,3,4,5};
	static int N= p.length;
	static int R;

	static int count;
	
	public static void main(String[] args) {
		R=3;
		npr(0, 0,new int[R]);
		System.out.println(count);
		
	}

	private static void npr(int cnt,int flag ,int[] nums) {
		if(cnt==3) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if((flag&(1<<i))!=0)continue;
			nums[cnt]= p[i];
			npr(cnt+1,flag|(1<<i), nums);
			
			nums[cnt]=0;
		}
		
	}

}
