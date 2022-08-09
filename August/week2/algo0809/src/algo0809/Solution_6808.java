package algo0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6808 {
	static int T;
	static int[] in;
	static int[] gyu;
	static boolean[] chk;
	
	static int win;
	static int lose;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T= Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			chk =new boolean[18];
			gyu= new int[9];
			in= new int[9];
			win=0;
			lose=0;
			StringTokenizer st= new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 9; i++) {
				int a= Integer.parseInt(st.nextToken());
				gyu[i]= a;
				chk[a-1]= true;
			} 
			int cnt=0;
			for(int i=0; i<18; i++) {
				if(!chk[i]) {
					in[cnt++]= i+1;
					
				}
			}//end of reading
			
			do {
				play();
			}while(np(8));
			
			System.out.println("#"+tc+" "+win+" "+lose);
		}
	}
	
	
	
	private static void play() {
		int num1 =0;
		int num2= 0;
		for (int i = 0; i < gyu.length; i++) {
			if(gyu[i]>in[i]) {
				num1 += (gyu[i]+in[i]);
			}else {
				num2 += (gyu[i]+in[i]);	
			}
		}
		
		if(num1>num2) {
			win++;
		}else if(num1<num2) {
			lose++;
		}
	}



	private static boolean np(int size) {
		int i = size;
		while(i>0 && in[i-1]>in[i])i--;
		if(i==0)return false;
		int j=size;
		while(in[i-1]>in[j])j--;
		
		int temp= in[i-1];
		in[i-1] = in[j];
		in[j]= temp;
		
		int k = size;
		while(i<k) {
			temp= in[i];
			in[i] = in[k];
			in[k]= temp;
			
			i++;
			k--;
		}
		
		return true;
	}

}
