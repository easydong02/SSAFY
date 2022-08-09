package algo0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_12891 {
	static int N,M;
	static char[] dna;
	static int[] condition;
	static Set<String>set;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		String str= br.readLine();
		dna= str.toCharArray();
		condition= new int[4];
		visited = new boolean[N];
		set= new HashSet<>();
		
		st= new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 4; i++) {
			condition[i] = Integer.parseInt(st.nextToken());
		}//end of reading
		
		chk(str); //조건 안 맞는 것
		subset(0);
		
		System.out.println(set.size());
		System.out.println(Arrays.toString(set.toArray()));
		
	}
	
	private static void subset(int cnt) {
		if(cnt ==N) {
			// 선택된 것 출력
			String temp="";
			for (int i = 0; i < N; i++) {
				if(visited[i])temp +=dna[i];
			}
			if(temp.length()==M) {
				System.out.println(temp);
					set.add(temp);
			}
			return;
		}
		
		visited[cnt]= true;
		subset(cnt+1);
		visited[cnt]= false;
		subset(cnt+1);
	}

	private static boolean chk(String temp) {
		char[] arr= temp.toCharArray();
		int[] cnt= {0,0,0,0};
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='A') {
				cnt[0]++;
			}else if(arr[i]=='C') {
				cnt[1]++;
			}else if(arr[i]=='G') {
				cnt[2]++;
			}else if(arr[i]=='T') {
				cnt[3]++;
			}
		}
		
		for (int i = 0; i < condition.length; i++) {
			if(cnt[i]<condition[i]) {
				System.out.println(0);
				System.exit(0);
				return false;
			}
		}
		
		return true;
	}

}
