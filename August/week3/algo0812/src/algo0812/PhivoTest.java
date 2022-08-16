package algo0812;

public class PhivoTest {

	public static void main(String[] args) {
		for (int i = 0; i < 30; i++) {
			System.out.println(phivo(i));
		}

	}

	private static int phivo(int n) {
		if(n==0) return 0;
		else if(n==0)return 1;
		else return phivo(n-1)+phivo(n-2);
	}

}
