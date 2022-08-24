package algo0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class CCTV {
	int r;
	int c;
	int index;

	public CCTV(int r, int c, int index) {
		super();
		this.r = r;
		this.c = c;
		this.index = index;
	}
}

public class Main_15683_감시 {
	static int N, M, cNums;
	static int result = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] temp;
	static int[] dr = { 0, 1, 2, 3 }; // 상우하좌
	static int[] cctvD;// cctv 순서대로 각 방향 정보
	static CCTV[] cctvs; // cctv 좌표방향

	static int[] D = { -1, 0, 1, 0 };
	static int[] C = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of reading

		// 카메라 개수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && map[i][j] != 6) {
					cNums++;
				}
			}
		}
		cctvs = new CCTV[cNums];
		cctvD = new int[cNums];
		int tmp = 0;
		// 카메라 배열에 담기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctvs[tmp++] = new CCTV(i, j, map[i][j]);
				}
			}
		}

		cctv(0);
		System.out.println(result);

	}

	private static void cctv(int cnt) {
		if (cnt == cNums) { // 각각 cctv의 방향 경우의 수
			int sum = 0;
			// 복사본 만들기
			temp = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[i][j] = map[i][j];
				}
			}

			// 각 cctv 작동 시키기
			for (int i = 0; i < cNums; i++) {
				look(cctvs[i], cctvD[i], cctvs[i].index);// 각 cctv와 그 방향 넘겨서 메서드

			}

			// 사각지대 구하기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (temp[i][j] == 0) {
						sum++;
					}
				}
			}

			// 최소값 넣기
			result = Math.min(result, sum);

			return;
		}

		for (int i = 0; i < 4; i++) { // 중복순열만들기
			cctvD[cnt] = dr[i];
			cctv(cnt + 1);
		}
	}

	private static void look(CCTV cctv, int d, int idx) {
		int nr = cctv.r + D[d];
		int nc = cctv.c + C[d];

		switch (idx) {
		case 2:
			look(cctv, (d + 2) % 4, 1);
			break;
		case 3:
			look(cctv, (d + 1) % 4, 1);
			break;
		case 4:
			look(cctv, (d + 1) % 4, 1);
			look(cctv, (d + 3) % 4, 1);
			break;
		case 5:
			look(cctv, (d + 1) % 4, 1);
			look(cctv, (d + 2) % 4, 1);
			look(cctv, (d + 3) % 4, 1);
			break;

		default:
			break;
		}

		while (nr >= 0 && nr < N && nc >= 0 && nc < M) {
			if (temp[nr][nc] == 6) {
				return;
			}

			if (temp[nr][nc] == 0) {
				temp[nr][nc] = 7;
			}

			nr += D[d];
			nc += C[d];
		}
	}
}
