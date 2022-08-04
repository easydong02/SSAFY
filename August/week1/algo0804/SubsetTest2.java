package algo0804;

import java.util.Scanner;

// n개의 수를 입력받고 가능한 모든 부분집합 생성
public class SubsetTest2 {
	
	static int N, totalCnt;
	static int[] input;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N= sc.nextInt();
		input = new int[N];
		isSelected= new boolean[N];
		totalCnt=0;
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}// end of reading
		
		subset(0);
		
	}
	
	private static void subset(int index) { //cnt: 직전까지 고려한 원소 수
		
		if(index==N) {
			totalCnt++;
			for (int i = 0; i < N; i++) {
				System.out.print(isSelected[i]? input[i]: "X");
				System.out.print("\t");
			}
			System.out.println();
			return;
		}
		
		//원소 선택
		isSelected[index]= true;
		subset(index+1);
		
		//원소 미선택
		isSelected[index]=false;
		subset(index+1);
	}

}
