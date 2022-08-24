package algo0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1717_집합의표현 {
	static int N,M;
	static int[]p;
	static int[]r;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
	
		makeSet();
		for (int i = 0; i < M; i++) {
			st= new StringTokenizer(br.readLine());
			int c= Integer.parseInt(st.nextToken());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			
			if(c==0) {
				union(a,b);
			}else if(c==1) {
				if(find(a)==find(b)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
	}
	private static boolean union(int a, int b) {
		a= find(a);
		b= find(b);
		if(a==b)return false;
		
		if(r[a]<r[b]) {
			r[b] +=r[a];
			p[a]=b;
		}else {
			r[a] +=r[b];
			p[b]=a;
		}
		
		return true;
	}
	private static int find(int a) {
		if(a==p[a])return p[a];
		return p[a] = find(p[a]);
	}
	private static void makeSet() {
		p=new int[N+1];
		r=new int[N+1];
		
		for (int i = 0; i < N+1; i++) {
			p[i]=i;
		}
		for (int i = 0; i < N+1; i++) {
			r[i]=1;
		}
	}

}
