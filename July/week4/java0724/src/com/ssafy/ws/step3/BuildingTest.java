package com.ssafy.ws.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BuildingTest {
	static int T;
	static String[][] map;
	static int[][] map_;
	
	static int[] dr= {-1,-1,-1,0,1,1,1,0};
	static int[] dc= {-1,0,1,1,1,0,-1,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int testcase = 1; testcase <= T; testcase++) {
			int result = Integer.MIN_VALUE;
			//map만들기
			int n  = Integer.parseInt(br.readLine());
			map = new String[n][n];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = st.nextToken();
				}
			}
			
			//map_만들기
			map_ = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(checkGrn(map,i,j) && map[i][j].equals("B")) {
						map_[i][j] = 2;
					}else if(map[i][j].equals("G")) {
						map_[i][j]=0;
					}else {
						map_[i][j]= checkFloor(map,i,j);
					}
				}
			}
			
			
			for(int[] m : map_) {
				System.out.println(Arrays.toString(m));
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(map_[i][j]>result) {
						result = map_[i][j];
					}
				}
			}
			
			
			System.out.println("#"+testcase+" "+result);
		}
		
	}

	private static int checkFloor(String[][] array, int r, int c) {
		int cnt = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i][c].equals("B")) {
				cnt ++;
			}
		}
		for (int i = 0; i < array[r].length; i++) {
			if(array[r][i].equals("B")) {
				cnt ++;
			}
		}
		
		
		return cnt-1;
	}

	private static boolean checkGrn(String[][] array, int r, int c) {
		for (int i = 0; i < dr.length; i++) {
			int nr= r+dr[i];
			int nc= c+dc[i];
			
			if(nr>=0 && nr< array.length && nc>=0 && nc< array.length) {
				if(array[nr][nc].equals("G")) {
					return true;
				}
			}
			
		}
		
		return false;
	}

}
