package algo0802;

public class PhivoTest {
	
	public static void main(String[] args) {
		for (int i = 0; i < 47;i++) {
			System.out.printf("f(%d)= %d\n",i,phivo(i));
		}

	}

	private static int phivo(int n) {
		if(n==0)return 0;
		else if(n==1) {
			return 1;
		}else {
			return phivo(n-1)+phivo(n-2);
		}
		
	}

}
