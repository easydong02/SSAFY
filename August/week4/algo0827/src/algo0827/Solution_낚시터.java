package algo0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_낚시터 {
	static int T,N,result;
	static boolean[] permVisit;
	static int[][] gates;
	static int[] spots;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T= Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <=T; tc++) {
			N= Integer.parseInt(br.readLine());
			result=Integer.MAX_VALUE;
			gates= new int[4][2];// 게이트3개
			permVisit= new boolean[4];//게이트 순열용
			for (int i = 1; i <= 3; i++) {
				StringTokenizer st= new StringTokenizer(br.readLine());
				//게이트 번호와 사람 수 입력
				gates[i][0]= Integer.parseInt(st.nextToken());
				gates[i][1]= Integer.parseInt(st.nextToken());
			}//end of reading
			
			
			perm(0, new int[3]);
			
			System.out.println("#"+tc+" "+result);
			
		}
	}
	
	//게이트 순서 순열 정하기
	private static void perm(int cnt, int[] nums) {
		if(cnt==3) {
			start(0,nums,new int [3] );
			return;
		}
		
		for (int i =1; i <= 3; i++) {
			if(permVisit[i])continue;
			permVisit[i]=true;
			nums[cnt]=i;
			perm(cnt+1,nums);
			permVisit[i]=false;
			nums[cnt]=0;
		}
	}
	
	//각 게이트 순서마다 채우는 방향 순서만들기
	private static void start(int cnt, int[] nums, int[] p) {
		if(cnt==3) {
			
			spots= new int[N+1]; // 각 낚시터 자리
			int sum = takeSeat(nums,p);
			result =Math.min(result, sum);
			return;
		}
		
		for (int i = 0; i < 2; i++) {
			p[cnt]=i;
			start(cnt+1,nums,p);
		}
		
	}
	
	//각 할당된 게이트 순서와 채워 넣을 순서까지 정한 메인 로직 메서드
	// nums = 게이트 순서 ex) 312     p = 0 왼쪽 , 1 오른쪽
	private static int takeSeat(int[] nums, int[] p) {
		int sum=0;
		for (int i = 0; i < nums.length; i++) {
			int gateNo= gates[nums[i]][0];
			int gateP=gates[nums[i]][1];
			
			sum += go(gateNo,gateP,p[i]);
			if(sum>result)return Integer.MAX_VALUE;
		}
		return sum;
	}
	
	
	// 하나의 게이트가 사람 넣는 로직
	private static int go(int gateNo, int gateP, int p) {
		int sum =0;
		int tmp=1;
		int left= gateNo-1;
		int right= gateNo+1;
		if(p==1) {
			int temp=left;
			left=right;
			right=temp;
			tmp=-1;
		}
		
		
		while (gateP>0) {
			boolean leftChk= left>0;
			boolean rightChk= right<= N;
			if(p==1) {
				leftChk= left<=N;
				rightChk= right>0;
			}
			
			if(spots[gateNo]==0) {
				spots[gateNo]=1;
				sum +=1;
			}else if(leftChk && spots[left]==0) {
				spots[left]=1;
				sum += Math.abs(left-gateNo)+1;
			}else if(rightChk && spots[right]==0 ) {
				spots[right]=1;
				sum += Math.abs(right-gateNo)+1;
			}else {
				left -=tmp;
				right +=tmp;
				gateP++;
			}
			
			gateP--;
		}
		
		return sum;
	
	}

}
