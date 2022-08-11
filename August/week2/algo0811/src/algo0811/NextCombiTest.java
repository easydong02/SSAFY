package algo0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NextCombiTest {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		
		int N=Integer.parseInt(st.nextToken());
		int R=Integer.parseInt(st.nextToken());
		int[] input= new int[N];
		int[] chk = new int[N];
		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i]= Integer.parseInt(st.nextToken());
		}
		for (int i = 0 ; i<R; i++) {
			chk[i]=1;
		}
		
		//전처리
		Arrays.sort(chk);
		
		do {
			for (int i = 0; i < N; i++) {
				if(chk[i]==1) {
					System.out.print(input[i]);
				}
			}
			System.out.println();
		}while(np(chk));
		
		
	}

	private static boolean np(int[] numbers) {
		
		int N= numbers.length;
		//1. 꼭대기 찾기
		int i= N-1;
		while( i>0 &&numbers[i-1]>=numbers[i])i--;
		
		if(i==0)return false; //순열이 이미 완성되어있는 경우
		
		//2. 꼭대기의 바로 앞자리(i-1)의 값을 크게 만들 교환 값 뒤쪽에서 찾기
		int j=N-1;
		while(numbers[i-1]>=numbers[j])j--;
		
		//3. i-1위치값과 j위치값을 교환
		swap(numbers,i-1,j);
		
		//4. i위치부터 맨뒤까지의 수열을 가장 작은 형태의 오름차순으로 변경
		int k = N-1;
		while(i<k) {
			swap(numbers,i,k);
			i++;
			k--;
		}
		return true;
	}
	
	public static void swap(int[]numbers,int i, int j) {
		int tmp= numbers[i];
		numbers[i]=numbers[j];
		numbers[j]=tmp;
	}

}
