package algo1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17143_G1_낚시왕 {
	static class Shark implements Comparable<Shark>{
		int r;
		int c;
		int speed;
		int direct;
		int size;
		int isDel;

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", speed=" + speed + ", direct=" + direct + ", size=" + size
					+ ", isDel=" + isDel + "]";
		}

		public Shark(int r, int c, int speed, int direct, int size, int isDel) {
			super();
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.direct = direct;
			this.size = size;
			this.isDel = isDel;
		}

		@Override
		public int compareTo(Shark o) {
			return this.size - o.size;
		}

		
	}
	
	static int R,C,M, map[][],result;
	static List<Shark> sharks;
	static int[] dr = {-1,1,0,0};  //상 하 우 좌
	static int[] dc = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [R][C];
		sharks = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st= new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			sharks.add(new Shark(r, c,
					Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()),0));
			map[r][c]= 1;
		}// end of reading
		
//		for(Shark s : sharks) {
//			System.out.println(s);
//		}
		
		for (int i = 0; i < C; i++) {
			//1. 상어 잡기
			hunt(i);
			
			//2. 상어이동
			moveShark();
			
			//3. 상어잡아먹기
			checkShark();
		}
		
		System.out.println(result);
		
	}
	private static void hunt(int c) {
		for (int r = 0; r < R; r++) {
			if(map[r][c] ==1) {
				delShark(r,c);
				return;
			}
		}
	
		
	}
	private static void moveShark() {
		for (int i = 0; i < sharks.size(); i++) {
			Shark shark = sharks.get(i);
			if(shark.isDel ==1 || shark.speed==0)continue;
			int r = shark.r;
			int c = shark.c;
			int nr =0;
			int nc=-0;
			for (int j = 0; j < shark.speed; j++) {
				nr = shark.r + dr[shark.direct];
				nc = shark.c + dc[shark.direct];
				
				if(nr >=0 && nr < R && nc>=0 && nc < C) {
					shark.r= nr;
					shark.c= nc;
				}else{
					shark.direct = shark.direct==0? 1: shark.direct ==1? 0 : shark.direct ==2? 3: shark.direct ==3? 2: -1;
					j-=1;
					continue;
				}
			}
			map[r][c] -=1;
			map[nr][nc] +=1;
		}
		
		
	}
	private static void checkShark() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]>1) {
					eatShark(i,j);
				}
			}
		}
	}
	private static void eatShark(int r, int c) {
		int max = Integer.MIN_VALUE;
		int maxidx= 0;
		List<Integer> idx = new ArrayList<>();
		for (int i = 0; i < sharks.size(); i++) {
			Shark s = sharks.get(i);
			if(s.isDel==1)continue;
			if(s.r==r && s.c==c) {
				idx.add(i);
				if(s.size >max) {
					max= s.size;
					maxidx=i;
				}
			}
		}
		for (int i = 0; i < idx.size(); i++) {
			int index = idx.get(i);
			if(index != maxidx) {
				sharks.get(index).isDel =1;
				
			}
		}
		
		map[r][c] =1;
	}
	private static void delShark(int r, int c) {
		for (int i = 0; i < sharks.size(); i++) {
			Shark shark = sharks.get(i);
			if(shark.r==r && shark.c==c ) {
				if(shark.isDel==1)continue;
				shark.isDel=1;
				result += shark.size;
				map[r][c] = 0;
				return;
			}
		}
	}

}
