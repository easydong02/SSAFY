package algo0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11279 {
	
	static int N;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
		N= Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp !=0) {
				que.offer(temp);
			}else {
				if(que.size()==0)System.out.println(0);
				else System.out.println(que.poll());
			}
			
			
		}
	}
}
