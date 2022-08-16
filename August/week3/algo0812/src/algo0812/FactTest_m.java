package algo0812;

public class FactTest_m {
	static int[] nums= new int [13];
	public static void main(String[] args) {
		
		for(int i =0; i<13; i++) {
			System.out.println(fact(i));
		}
		
	}
	
	
	// f(5)= 5*f(4) => callstack(stack) dfs
	private static int fact(int n) {
		if(n==1 || n==0) {
			nums[n]=1;
			return nums[n];
		}
		nums[n]= n*nums[n-1];
		
		return nums[n];
	}

}
