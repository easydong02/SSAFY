package algo0802;
import java.util.Arrays;

public class SubsetTest {
	
	
	static int[] p = {1,2,3,4,5};
	static int N=p.length;
	static int count;
	static boolean[] visited;// 선택된적 있냐?
	
	public static void main(String[] args) {
		visited = new boolean[N];
		subset(0);
		System.out.println(count);
	}

	private static void subset(int cnt) {
		if(cnt ==N) {
			count++;
			// 선택된 것 출력
			for (int i = 0; i < N; i++) {
				if(visited[i])System.out.print(p[i]+ " ");
			}
			System.out.println();
			return;
		}
	
		visited[cnt]= true;
		subset(cnt+1);
		visited[cnt]= false;
		subset(cnt+1);
	}

}
