package algo0812;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15686 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static List<Point> rests;
	static Point[] rest;
	static Queue<Point> que;
	static int min = Integer.MAX_VALUE;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		rest = new Point[M];
		rests = new ArrayList<Point>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if (temp == 2) {
					rests.add(new Point(i, j)); // 치킨집이면 좌표 추가
				}
			}
		} // end of reading

		ncr(0, 0);

		System.out.println(min);
	}

	private static void ncr(int start, int cnt) {
		if (cnt == M) {
			findD(rest); // 살아남은 치킨집 경우의 수로 치킨거리 구하기

			return;
		}

		for (int i = start; i < rests.size(); i++) {
			rest[cnt] = rests.get(i);
			ncr(i + 1, cnt + 1);
		}

	}

	private static void findD(Point[] rest) {
		que = new LinkedList<Point>();
		int sum = 0;
		for (Point p : rest) {
			map[p.x][p.y] = 3; // 살아남은 치킨집 3
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					int tmp = Integer.MAX_VALUE;
//					Point p = bfs(i,j); //각각의 집에서 가까운 치킨집 좌표 구하기
//					sum += ( Math.abs(i-p.x) + Math.abs(j-p.y));

					for (int k = 0; k < rest.length; k++) {
						Point pp = rest[k];
						int dist = Math.abs(pp.x - i) + Math.abs(pp.y - j);
						if (dist < tmp) {
							tmp = dist;
						}
					}
					sum += tmp;

				}
			}
		}

		if (sum <= min) {
			min = sum;
		}

	}

//	private static Point bfs(int r, int c) {
//		visited= new boolean[N][N];
//		que.offer(new Point(r,c));
//		
//		while(!que.isEmpty()) {
//			Point tmp = que.poll();
//			if(map[tmp.x][tmp.y]== 3) {
//				return tmp;
//			}
//			for (int i = 0; i < dc.length; i++) {
//				int nr = tmp.x +dr[i];
//				int nc = tmp.y +dc[i];
//				
//				if(nr>=0 && nr <N && nc>=0 && nc< N && !visited[nr][nc]) {
//					visited[nr][nc]=true;
//					que.offer(new Point(nr,nc));
//				}
//			}
//			
//		}
//		
//		return null;
//		
//	}

}
