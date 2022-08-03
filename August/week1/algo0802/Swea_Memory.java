package algo0802;

import java.util.Scanner;

public class Swea_Memory {
	static char[] start;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			boolean chk = false;
			boolean oneChk = true;
			boolean zeroChk = true;
			int cnt = 0;
			char[] end = sc.next().toCharArray();
			start = new char[end.length];
			for (int i = 0; i < end.length; i++) {
				start[i] = '0';
			}

			int temp = 0;
			for (int i = temp; i < end.length; i++) {
				if (end[i] == '1' && oneChk) {
					cnt++;
					temp = i;
					chk = true;
					oneChk = false;
					zeroChk = true;
					for (int j = temp; j < start.length; j++) {
						start[j] = '1';
					}
				} else if (end[i] == '0' && chk && zeroChk) {
					cnt++;
					zeroChk = false;
					oneChk = true;
					for (int j = i; j < start.length; j++) {
						start[j] = '0';
					}
				}

				if (chk(start, end)) {
					break;
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}

	private static boolean chk(char[] start, char[] end) {
		for (int i = 0; i < end.length; i++) {
			if (start[i] != end[i]) {
				return false;
			}
		}
		return true;
	}
}
