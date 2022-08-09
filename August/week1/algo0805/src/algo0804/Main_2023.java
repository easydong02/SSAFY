package algo0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2023 {
	
	static int N;
	static boolean chk;
	public static void main(String[] args) throws NumberFormatException, IOException {
		long start= System.currentTimeMillis();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		
		
		for (int i = (int) Math.pow(10, N-1)+1; i < Math.pow(10, N); i +=2) {
			if(!isP(i/( (int)Math.pow(10, N-1))))continue;
			if(isP(i)) {
				chk=true;
				int point= 0;
				int a = i/( (int)Math.pow(10, N-1-point));
				while(a<i) {
					if(!isP(a)) {
						chk=false;
						break;
					}
					point++;
					a = i/ (int)(Math.pow(10, N-1-point));
				}
				if(chk) {
					System.out.println(i);
				}
			}
		}
		
		long end= System.currentTimeMillis();
		System.out.println("시간"+ (end-start)/1000.0+"초");
//		for (int i = 2; i <= 1000; i++) {
//			if(isP(i)) {
//				System.out.println(i);
//			}
//		}
		
		
		
		
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
