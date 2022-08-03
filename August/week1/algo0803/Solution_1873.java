package algo0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1873 {
	static int T;
	static int H;
	static int W;
	static char[][] map;
	static char status;

	static int num;
	static char[] commands;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static int r = 0;
	static int c = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];

			for (int i = 0; i < H; i++) {
				char[] temp = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					map[i][j] = temp[j];
				}
			}
			num = Integer.parseInt(br.readLine());
			commands = br.readLine().toCharArray();
			// end of reading

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '<' || map[i][j] == 'v' || map[i][j] == '^' || map[i][j] == '>') {
						r = i;
						c = j;
						status = map[i][j];
					}
				}
			} // find start point

			for (int i = 0; i < num; i++) {
				char command = commands[i];

				if (command == 'S') {
					shoot(r, c);
				} else {
					move(r, c, command);
				}
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}

	private static void move(int x, int y, char command) {
		int d = command == 'U' ? 0 : command == 'R' ? 1 : command == 'D' ? 2 : command == 'L' ? 3 : -1;
		status = d == 0 ? '^' : d == 1 ? '>' : d == 2 ? 'v' : d == 3 ? '<' : 'n';

		int nr = x + dr[d];
		int nc = y + dc[d];

		if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
			if (map[nr][nc] == '.') {
				r = nr;
				c = nc;
				map[x][y] = '.';
				map[nr][nc] = status;

			} else {
				map[x][y] = status;
			}
		} else {
			map[x][y] = status;
		}
	}

	private static void shoot(int r, int c) {
		int d = status == '^' ? 0 : status == '>' ? 1 : status == 'v' ? 2 : status == '<' ? 3 : -1;

		int nr = r + dr[d];
		int nc = c + dc[d];
		while (true) {
			if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
				if (map[nr][nc] == '#') {
					return;
				} else if (map[nr][nc] == '*') {
					map[nr][nc] = '.';
					return;
				}
				nr += dr[d];
				nc += dc[d];
			} else {
				break;
			}

		}

	}

}
