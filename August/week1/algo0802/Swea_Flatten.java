package algo0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_Flatten {
	static int T =10;
	static int N= 100;
	static int dump;
	static int[] boxes;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		boxes = new int[N];
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= T; tc++) {
			dump = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
					boxes[i]= Integer.parseInt(st.nextToken());
			}// end of reading
			
			int diff= Integer.MAX_VALUE;
			while(dump>0) {
				int minIdx=0;
				int maxIdx=0;
				int min =Integer.MAX_VALUE;
				int max =Integer.MIN_VALUE;
				
				for (int i = 0; i < N; i++) {
					if(boxes[i]>=max) {
						max=boxes[i];
						maxIdx=i;
					}
					if(boxes[i]<=min) {
						min=boxes[i];
						minIdx=i;
					}
				}
				diff = boxes[maxIdx]-boxes[minIdx];
				
				if(diff<=1) {
					break;
				}
				boxes[maxIdx] = boxes[maxIdx] -1;
				boxes[minIdx] = boxes[minIdx] +1;
				
				for (int i = 0; i < N; i++) {
					if(boxes[i]>=max) {
						max=boxes[i];
						maxIdx=i;
					}
					if(boxes[i]<=min) {
						min=boxes[i];
						minIdx=i;
					}
				}
				diff = boxes[maxIdx]-boxes[minIdx];
				
				dump --;
				
			}
			
			
			System.out.println("#"+tc+" "+diff);
			
		}

	}

}
