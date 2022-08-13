package algo0812;

public class FactTest_t {
	static int[] nums= new int [13];
	public static void main(String[] args) {
		
		nums[0]=1;
		for(int i =1; i<13; i++) {
			nums[i]= i*nums[i-1];
		}
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
		
	}
	
	
	// f(5)= 5*f(4) => callstack(stack) dfs

}
