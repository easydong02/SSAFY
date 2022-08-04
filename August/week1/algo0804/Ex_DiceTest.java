package algo0804;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_DiceTest {

	static int N;
	static int[] nums;
	static int totalCnt;
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 던지는 주사위의 수
		int mode = sc.nextInt(); // 던지기 모드

		totalCnt = 0;
		nums = new int[N];

		switch (mode) {
		case 1:
			dice1(0);
			break;
		case 2:
			isSelected = new boolean[7]; // 1~6 주사위눈 선택여부
			dice2(0);

			break;
		case 3:
			dice3(0,1);

			break;
		case 4:
			dice4(0,1);

			break;
		}

		System.out.println("총 경우의 수는:" + totalCnt);
	}

	// 주사위던지기1 :중복 순열
	private static void dice1(int cnt) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(nums));
			return;
		}

		// 가능한 모든 수 시도
		for (int i = 1; i <= 6; i++) {
			// 나온 수가 또 나올 수 있으므로 중복선택이 가능하므로
			// 해당 수 선택
			nums[cnt] = i;
			// 다음 주사위던지러 가기
			dice1(cnt + 1);
		}
	}

	// 주사위 던지기2: 순열
	private static void dice2(int cnt) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(nums));
			return;
		}

		// 가능한 모든 수 시도
		for (int i = 1; i <= 6; i++) {
			// 중복체크 필요!
			if (isSelected[i])
				continue;
			// 해당 수 선택
			nums[cnt] = i;
			isSelected[i] = true;
			// 다음 주사위던지러 가기
			dice2(cnt + 1);

			// 다시 조건 초기화
			nums[cnt] = 0;
			isSelected[i] = false;
		}
	}

	// 주사위 던지기3: 중복조합
	private static void dice3(int cnt,int start) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(nums));
			return;
		}

		// 가능한 모든 수 시도
		for (int i = start; i <= 6; i++) {
			// 중복체크 필요!
			// 해당 수 선택
			nums[cnt] = i;
			// 다음 주사위던지러 가기
			dice3(cnt + 1, i );
		}
	}

	// 주사위 던지기4: 조합
	private static void dice4(int cnt, int start) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(nums));
			return;
		}

		// 가능한 모든 수 시도
		for (int i = start; i <= 6; i++) {
			// 중복체크 필요!
			// 해당 수 선택
			nums[cnt] = i;
			// 다음 주사위던지러 가기
			dice4(cnt + 1, i + 1);
		}
	}

}
