package algo0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1043_교수님 {

	static int [] p;
	static int [] r;
	static int N,M;
	public static void main(String[] args) throws IOException {
		//100줄 이상이라 
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		p=new int[N+1];
		r=new int[N+1];
		makeSet();
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int opp=Integer.parseInt(st.nextToken());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			switch (opp) {
				case 0:
					union(a,b);
					break;
				case 1:
					print(a,b);
					break;
			}
		}
	}

	private static void print(int x, int y) {
		x=find(x);
		y=find(y);
		if(x==y) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}

	private static boolean union(int x, int y) {
		x=find(x);
		y=find(y);
		if(x==y) return false;// 싸이클 있다. 
		if (r[x]<r[y]) {
			r[y]+=r[x];
			p[x]=y;
		} else {
			r[x]+=r[y];
			p[y]=x;
		}
		return true;
	}

	private static int find(int x) {
		if (x==p[x])return p[x];
		else return p[x]=find(p[x]); // 최종 BOSS
	}

	private static void makeSet() {
		for (int i = 0; i < N; i++) {
			p[i]=i;
		}
		for (int i = 0; i < N; i++) {
			r[i]=1;
		}
	}

}
