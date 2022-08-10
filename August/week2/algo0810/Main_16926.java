package algo0810;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_16926 {

	static int N, M, R, point, idx;
	static int[][] array;
	static boolean[][] visited;

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		array = new int[N][M];

		int first = array[0][0];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of reading

		for (int i = 0; i < R; i++) {
			visited = new boolean[N][M];
			point = 0;
			for (int j = 0; j < Math.min(N, M) / 2; j++) {
				int tmp = array[point][point];
				dfs(point, point, tmp);
				idx = 0;
				point++;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void dfs(int r, int c, int tmp) {
		int pre = tmp;

		while (idx < 4) {
			int nr = r + dr[idx];
			int nc = c + dc[idx];

			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
				tmp = array[nr][nc];
				array[nr][nc] = pre;
				visited[nr][nc] = true;
				dfs(nr, nc, tmp);
			} else {
				idx++;
			}

		}

	}

}
