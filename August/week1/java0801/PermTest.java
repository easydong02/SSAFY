package java0801;

import java.util.Arrays;

//npr  5p3= 5*4*3
public class PermTest {
	static int [] p= {1,2,3,4,5};
	static int N;
	static int R;
	static int [] nums;  // 5p3이면 3개 저장
	static boolean [] visited;// 사용한적 있냐
	static int count;// 몇개 npr개수
	public static void main(String[] args) {
		
		N=p.length;
		R=3;
		nums=new int[R];
		visited=new boolean[N];
		npr(0);
		System.out.println(count);
	}
	private static void npr(int cnt) {
		if(cnt==R) {
			count++;
			System.out.println(Arrays.toString(nums));
			return ;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i]=true;
			nums[cnt]=p[i];
			npr(cnt+1);
			//nums[cnt]=0;
			visited[i]=false;
		}
	}

}
