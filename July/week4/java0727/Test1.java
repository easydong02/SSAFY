package java0727;

public class Test1 {

	public static void main(String[] args) {
		int a =20;
		long start= System.currentTimeMillis();
		for (int i = 0; i < 1000000000; i++) {
			if(i%10==0) {
				a++;
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end-start);

	}

}
