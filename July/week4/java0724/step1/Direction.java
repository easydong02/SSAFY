package com.ssafy.ws.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Direction {
	static int r= 0;
	static int c= 0;
	
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	
	static int[][] map = new int[3][3];
	
	public static void main(String[] args) throws Exception {
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < dr.length; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0 && nr<3 &&nc>=0 && nc<3 ) {
				System.out.print(map[nr][nc]+" ");
			}
			
		}
		
	}
	
	
}
