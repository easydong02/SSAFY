package algo0808;

public class PowerSetTest {
	static int[] p = {1,2,3,4,5};
	static int N = p.length;
	
	public static void main(String[] args) {
		//10001
		//1   5
		//1<<0 1
		//1<<1 10
		//1<<2 100
		//1<<3 1000
		for (int i = 0; i < (1<<N); i++) {
			for (int j = 0; j < N; j++) {
				if((i & (1<<j))!=0) {
					System.out.print(p[j]+" ");
				}
			}
			System.out.println();
		}
		
	}
	
}
