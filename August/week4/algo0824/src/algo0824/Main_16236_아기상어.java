package algo0824;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_아기상어 {
	static class Shark {
		int r;
		int c;
		int level;
		int exp;

		public Shark(int r, int c) {
			super();
			this.r = r;
			this.c = c;
			this.level = 2;
			this.exp = 0;
		}
	}

	static class Fish implements Comparable<Fish> {
		int r;
		int c;
		int level;

		public Fish(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Fish o) {
			return this.r != o.r ? this.r - o.r : this.c - o.c;
		}

	}

	static int N, M, result, MaxDist;
	static int[][] map;
	static Shark bs;
	static List<Fish> fishes;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		fishes = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp != 0) {
					if (tmp == 9) {
						bs = new Shark(i, j);
					} else {
						map[i][j] = tmp;
					}
				}
			}
		} // end of reading

//		for (int[] m : map) {
//			System.out.println(Arrays.toString(m));
//		}

		while (check()) {
			fishes = new ArrayList<>();
			if (scan(bs.r, bs.c)) {
				if(fishes.size()==0)break;
				Collections.sort(fishes);
				Fish target = fishes.get(0);
				bs.r=target.r;
				bs.c=target.c;
				map[target.r][target.c]=0;
				if (++bs.exp >= bs.level) {
					bs.level++;
					bs.exp = 0;
				}
			}else {
				System.out.println(result);
				System.exit(0);
			}
		}

		System.out.println(result);
	}

	private static boolean scan(int r, int c) {
		boolean chk = false;
		MaxDist = 0;
//		Fish f= find(r,c);
		Queue<int[]> que = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		que.offer(new int[] { r, c, 0 });
		visited[r][c] = true;

		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int rr = cur[0];
			int cc = cur[1];
			int dist = cur[2];
//			if(checkFish(visited)) {
//				return true;
//			}
			if (map[rr][cc] < bs.level && map[rr][cc] > 0) {
				if (!chk) {
					if (dist > MaxDist) {
						MaxDist = dist;
						result += dist;
					}
					chk = true;
				}
				if(dist==MaxDist) {
					fishes.add(new Fish(rr, cc));
				}else{
					return true;
				}
			}
			for (int i = 0; i < dc.length; i++) {
				int nr = rr + dr[i];
				int nc = cc + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
					if (map[nr][nc] <= bs.level) {
						que.offer(new int[] { nr, nc, dist + 1 });
					}
					visited[nr][nc] = true;
				}
			}

		}
		return true;

	}

	private static boolean checkFish(boolean[][] visited) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					if(map[i][j]<bs.level) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)
					continue;
				if (map[i][j] < bs.level) {
					return true;
				}
			}
		}
		return false;
	}

}
