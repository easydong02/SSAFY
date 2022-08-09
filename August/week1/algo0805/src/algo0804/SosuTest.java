package algo0804;

public class SosuTest {

	public static void main(String[] args) {
		
		for (int i = 2; i <= 1000; i++) {
			if(isP(i)) {
				System.out.println(i);
			}
		}
	}

	private static boolean isP(int n) {
		if(n==1)return false;
		for (int i = 2; i <= (int)Math.sqrt(n); i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}

}
