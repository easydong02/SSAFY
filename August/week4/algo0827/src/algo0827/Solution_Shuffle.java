package algo0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_Shuffle {
	static int T,N,result;
	static int[] cards,temp;
	static boolean chk;
	static boolean[] permVisit;
	static int[] p ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T= Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			chk=false;
			result=Integer.MAX_VALUE;
			N= Integer.parseInt(br.readLine());
			StringTokenizer st= new StringTokenizer(br.readLine());
			cards= new int[N];
			p=new int[N];
			for (int i = 0; i < N; i++) {
				cards[i]= Integer.parseInt(st.nextToken());
			}// end of reading
			
			
			
			if(check(cards)) {
				System.out.println("#"+tc+" "+0);
				continue;
			}
			if(chk) {
				System.out.println("#"+tc+" "+(-1));
				continue;
				
			}
			
			
			repitPerm(0,new int[5]);
			System.out.println(result);
		}
	}
	

	
	//모든 경우의 수 작동
	private static void repitPerm(int cnt, int[] nums) {
		if(cnt==nums.length) {
			// 0번 포함되어있으면 없앰 -> 바뀌지 않아서 최소값에 도움 안 됨.
			for (int i = 0; i < nums.length; i++) {
				if(nums[i]==0)return;
			}
			System.out.println(Arrays.toString(nums));
			//start(nums);
			return;
		}
		
		for (int i = 0; i < p.length; i++) {
			nums[cnt]=i;
			repitPerm(cnt+1, nums);
		}

	}
	
	//정해진 셔플 순서로 셔플 돌리기
	private static void start(int[] nums) {
		temp= cards.clone();
		int cnt=0;
		for (int i = 0; i < nums.length; i++) {
			shuffle(0,nums[i],new boolean[temp.length],temp.length/2-1);
			cnt++;
			if(cnt>result) {
				return;
			}
			if(check(temp)) {
				result= Math.min(result, cnt);
				chk=false;
				return;
			}
		}
		
		//이 셔플 순서로 정렬 안 됐음.
		if(result == Integer.MAX_VALUE) {
			chk=true;
		}
	}
	
	//각 번호대로 셔플
	private static void shuffle(int cnt, int n, boolean[] chks, int idx) {
		if(cnt==n) {
			return;
		}
		
		chks[idx]=true;
		for (int i = 0; i < temp.length; i++) {
			if(chks[i]) {
				int tmp= temp[i];
				temp[i]=temp[i+1];
				temp[i+1]=tmp;
			}
		}
		chks[idx]=false;
		if(idx-1>=0) {
			shuffle(cnt+1, n, chks, idx-1);
		}
		if(idx+1<temp.length-1) {
			shuffle(cnt+1, n, chks, idx+1);
		}
		
	}
	



	//오름 차순 또는 내림차순인지
	private static boolean check(int[] cards) {
		int[] temp= cards.clone();
		Arrays.sort(temp);
		if(Arrays.equals(cards, temp)) {
			return true;
		}
		int[] temp2= temp.clone();
		for (int i = 0; i < temp.length; i++) {
			temp2[i]=temp[cards.length-i-1];
		}
		if(Arrays.equals(cards, temp2)) {
			return true;
		}
		return false;
	}

}
