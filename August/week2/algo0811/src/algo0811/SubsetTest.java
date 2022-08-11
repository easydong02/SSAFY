package algo0811;

import java.util.Arrays;

public class SubsetTest {
	static int [] p = {1,2,3,4,5};
	static int N=p.length;
	static int R;
	static int count;
	static boolean[] visited;
	
	public static void main(String[] args) {
		
		R=3;
		visited= new boolean[N];
		npr(0,0);
		System.out.println(count);
		
	}

	private static void npr(int cnt,int tot) {
		if(cnt==N) {
			count++;
			for (int i = 0; i < N; i++) {
				if(visited[i])System.out.print(p[i]+" ");
			}
			System.out.print("\ttot"+tot);
			System.out.println();
			return;
		}
			
		visited[cnt]= true;
		npr(cnt+1, tot+p[cnt]);
		visited[cnt]=false;
		npr(cnt+1, tot);
		
	}

}
