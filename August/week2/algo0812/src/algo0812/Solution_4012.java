package algo0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4012 {
	static int T,N,result;
	static int[][] snj;
	static int[] p,nums;
	static boolean[] chk;
	
	static int[] numsA,numsB;
	
	static int[] aSide;
	static int[] bSide;
	
	static int a;
	static int b;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T= Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			result= Integer.MAX_VALUE;
			N= Integer.parseInt(br.readLine());
			snj= new int[N][N];
			p= new int[N];
			nums= new int[N/2];
			for (int i = 0; i < N; i++) {
				p[i]= i;
			}
			
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st= new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					snj[i][j]= Integer.parseInt(st.nextToken());
				}
			}// end of reading
		
			ncr(0,0);
			
			System.out.println("#"+tc+" "+result);
		}
	}

	private static void ncr(int start, int cnt) {
		if(cnt == N/2) {
			solve(nums);
			return;
		}
		
		for (int i = start; i < N; i++) {
			nums[cnt]=p[i];
			ncr(i+1,cnt+1);
			nums[cnt]=0;
		}
	}

	private static void ncrA(int start, int cnt) {
		if(cnt == 2) {
			a+= snj[numsA[0]][numsA[1]];
			a+= snj[numsA[1]][numsA[0]];
			return;
		}
		
		for (int i = start; i < aSide.length; i++) {
			numsA[cnt]=aSide[i];
			ncrA(i+1,cnt+1);
			numsA[cnt]=0;
		}
		
	}
	
	
	private static void ncrB(int start, int cnt) {
		if(cnt == 2) {
			b+= snj[numsB[0]][numsB[1]];
			b+= snj[numsB[1]][numsB[0]];
			return;
		}
		
		for (int i = start; i < bSide.length; i++) {
			numsB[cnt]=bSide[i];
			ncrB(i+1,cnt+1);
			numsB[cnt]=0;
		}
		
	}
	
	
	private static void solve(int[] ASIDE) {
		chk= new boolean[N];
		aSide= ASIDE;
		bSide= new int[N/2];
		numsA= new int[2];
		numsB= new int[2];
		a=0;
		b=0;
		int tmp=0;
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < N; j++) {
				if(aSide[i]==p[j]) {
					chk[j]=true;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			if(!chk[i]) {
				bSide[tmp++]=p[i];
			}
		}
		
		
		ncrA(0,0);
		ncrB(0,0);
		int temp= Math.abs(a-b);
		if(temp<=result) {
			result=temp;
		}
		
//		System.out.println("aSide"+Arrays.toString(aSide));
//		System.out.println("bSide"+Arrays.toString(bSide));
		
	}



}
