package algo0808;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main_7568 {
	
	static int N;
	public static class PP implements Comparable<PP>{
		int x;
		int y;
		public PP(int x, int y) {
			super();
			this.x=x;
			this.y=y;
		}
		@Override
		public String toString() {
			return "[" +x+","+ y+"]";
		}
		

		@Override
		public int compareTo(PP p) {
			int rx= Integer.compare(this.x, p.x);
			int ry= Integer.compare(this.y, p.y);
			if(rx>0 && ry>0) {
				return -1;
			}else if(rx<0 && ry<0) {
				return 1;
			}else return 0;
		};
		
	}
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		N=sc.nextInt();
		List<PP> origin= new ArrayList<>(); 
		for (int i = 0; i < N; i++) {
			int x= sc.nextInt();
			int y= sc.nextInt();
			origin.add(new PP(x,y));
		}
		
		for (int i = 0; i < origin.size(); i++) {
			System.out.print(origin.get(i)+" ");
		}
		
		System.out.println();
		Collections.sort(origin);
		
		for (int i = 0; i < origin.size(); i++) {
			System.out.print(origin.get(i)+" ");
		}
		
	}
	
	
	
}
