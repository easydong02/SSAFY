package algo0802;
import java.util.Arrays;

public class CombiTest {
	
	
	static int[] p = {1,2,3,4,5};
	static int N=p.length;
	static int R;
	static int count;
	static boolean[] visited;// 선택된적 있냐?
	static int[] nums; // 선택된 R 개 나열
	
	public static void main(String[] args) {
		R=3;
		nums = new int[R];
		visited = new boolean[N];
		npc(0,0);
		System.out.println(count);
	}

	private static void npc(int start,int cnt) {
		if(cnt ==R) {
			count++;
			System.out.print(count+" ");
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for (int i = start; i < N; i++) {
			//if(visited[i])continue;
			//visited[i]= true;
			nums[cnt] = p[i];
			npc(i+1,cnt+1);
			//visited[i]= false;
		}
	}

}
