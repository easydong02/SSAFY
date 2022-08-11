package algo0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
	
	
public class PermTest {
	static int totalCnt,N,R;
	static int[] numbers;
	static int[] input = {1,2,3,4,5};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		
		N=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		
		numbers= new int[R];
		perm(0,0);
		
		System.out.println(totalCnt);
	}
	
	
	private static void perm(int cnt, int flag) {
		if(cnt==R) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=0; i<N; i++) {
			if((flag & 1<<i) !=0)continue;
			
			numbers[cnt]= input[i];
			perm(cnt+1,flag | 1<<i);
		}
	}
}
