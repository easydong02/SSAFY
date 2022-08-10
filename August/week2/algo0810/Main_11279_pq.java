package algo0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11279_pq {

	static class NNN implements Comparable<NNN>{
		int x;

		public NNN(int x) {
			this.x = x;
		}

		@Override
		public int compareTo(NNN nn) {
			int r=Integer.compare(x, nn.x);
			return -r;
		}
		
	}
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq=new PriorityQueue<>((o1,  o2)-> -(o1-o2));
		for (int i = 0; i < N; i++) {
			int x=Integer.parseInt(br.readLine());
			if(x==0) {
				if(pq.size()==0) {
					System.out.println(0);
				}else {
					int tt=pq.poll();
					System.out.println(tt);
				}
			}else {
				pq.offer(x);
			}
		}
	}

}
