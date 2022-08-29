package algo0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_헌터 {
	static class Hunter{
		int r;
		int c;
		boolean[] gotM;
		public Hunter(int r, int c,int n) {
			super();
			this.r = r;
			this.c = c;
			gotM= new boolean[n];
		}
		
		
	}
	static int T,N;
	static int[][] map;
	static int[] p;
	static boolean[] permVisit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T= Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N= Integer.parseInt(br.readLine());
			map=new int[N][N];
			int Count=0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int temp= Integer.parseInt(st.nextToken());
					map[i][j]= temp;
					if(temp >0) {
						Count++;
					}
					
				}
			}// end of reading
			Hunter ht= new Hunter(0,0,Count);
			p= new int[Count*2];
			permVisit= new boolean[Count*2];
			int cnt=1;
			for (int i = 0; i < Count*2; i+=2) {
				p[i]= cnt;
				p[i+1]= -1*cnt++;
			}
			
			perm(0, new int[Count*2]);
			
			
		}
	}
	
	//일단 모든 경우의 수
	private static void perm(int cnt, int[] nums) {
		if(cnt==nums.length) {
			//몬스터 잡고 npc 가는 경우의 수만 추출
			if(check(nums)) {
//				System.out.println(Arrays.toString(nums));
				start(nums);
			}
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if(permVisit[i])continue;
			permVisit[i]=true;
			nums[cnt]= p[i];
			perm(cnt+1,nums);
			nums[cnt]=0;
			permVisit[i]=false;
		}
		
	}
	
	
	//주어진 루트로 진행
	private static void start(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			
		}
	}

	//npc를 먼저 방문한건 prunning
	private static boolean check(int[] nums) {
		for (int i = 1; i <= nums.length/2; i++) {
			boolean chk=false;
			for (int j = 0; j < nums.length; j++) {
				if(!chk) {
					if(nums[j]== -1*i) {
						return false;
					}
				}
				if(nums[j]==i) {
					chk=true;
				}
			}
		}
		return true;
	}

}
