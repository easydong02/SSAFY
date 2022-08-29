package algo0827;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_헌터2 {
	static class Hunter {
		int r;
		int c;
		int dist;

		public Hunter(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}

	static int T, N;
	static int result;
	static int[][] map;
	static List<int[]> p;
	static boolean[] permVisit;
	static Hunter ht;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			result = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			p = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp;
					if (temp != 0) {
						p.add(new int[] { i, j, map[i][j] });
					}
				}
			} // end of reading

			permVisit = new boolean[p.size()];
			int cnt = 1;

			perm(0, new ArrayList<int[]>());

			System.out.println("#" + tc + " " + result);

		}
	}

	// 일단 모든 경우의 수
	private static void perm(int cnt, ArrayList<int[]> nums) {
		if (cnt == p.size()) {
			// 몬스터 잡고 npc 가는 경우의 수만 추출
			if (check(nums)) {
				ht = new Hunter(0, 0, 0);
				start(nums);
				result = Math.min(ht.dist, result);
			}
			return;
		}

		for (int i = 0; i < p.size(); i++) {
			if (permVisit[i])
				continue;
			permVisit[i] = true;
			nums.add(p.get(i));
			perm(cnt + 1, nums);
			nums.remove(p.get(i));
			permVisit[i] = false;
		}

	}

	// 주어진 루트로 진행
	private static void start(ArrayList<int[]> nums) {
		for (int i = 0; i < nums.size(); i++) {
			int[] thing = nums.get(i);
			ht.dist += Math.abs(ht.r - thing[0]) + Math.abs(ht.c - thing[1]);
			ht.r = thing[0];
			ht.c = thing[1];

		}
	}

	// npc를 먼저 방문한건 prunning
	private static boolean check(ArrayList<int[]> nums) {
		for (int i = 1; i <= nums.size() / 2; i++) {
			boolean chk = false;
			for (int j = 0; j < nums.size(); j++) {
				if (!chk) {
					if (nums.get(j)[2] == -1 * i) {
						return false;
					}
				}
				if (nums.get(j)[2] == i) {
					chk = true;
				}
			}
		}
		return true;
	}

}
