package com.ssafy.ws.step3;

import java.util.Arrays;
import java.util.Scanner;

public class BuildingTest {
	static int N;
	static String[][] building;
	static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int testcase = 1; testcase <= T; testcase++) {

			N = sc.nextInt();
			building = new String[N][N];

			int d = 0;
			int c = 0;
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					building[i][j] = sc.next();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int temp = 0;
					if (building[i][j].equals("B")) {
						if (!checkGreen(building, i, j)) {
							temp = cntB(building, i, j);
							if (temp >= max) {
								max = temp;
							}
						}
					}
				}
			}
			System.out.print("#" + testcase + " " + max);
		}

	}

	private static int cntB(String[][] array, int i, int j) {
		int cnt = 0;
		for (int k = 0; k < N; k++) {
			if (array[i][k].equals("B")) {
				cnt += 1;
			}
		}
		for (int k = 0; k < N; k++) {
			if (array[k][j].equals("B")) {
				cnt += 1;
			}
		}

		return cnt - 1;
	}

	private static boolean check(int r, int c) {

		return r >= 0 && r < N && c >= 0 && c < N;
	}

	private static boolean checkGreen(String[][] array, int r, int c) {
		boolean result = false;
		for (int i = 0; i < dr.length; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if (array[nr][nc].equals("G")) {
					result = true;
				}
			}
		}

		return result;
	}

}
