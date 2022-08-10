package algo0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11286_pq3 {

	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		PriorityQueue<Long> pq=new PriorityQueue<>(( o1,  o2) ->{
				int r=Long.compare(Math.abs(o1), Math.abs(o2));
				if(r==0) {
					return Long.compare(o1, o2);
				}
				else return r;
			}
		);
		for (int i = 0; i < N; i++) {
			long x=Long.parseLong(br.readLine());
			if(x==0) {
				if(pq.size()==0) {
					System.out.println(0);
				}else {
					long tt=pq.poll();
					System.out.println(tt);
				}
			}else {
				pq.offer(x);
			}
		}
	}

}
