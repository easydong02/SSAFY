package algo0823;

import java.util.Arrays;

public class UFTest {
	
	static int[] p;
	static int[] r;
	static int N;
	public static void main(String[] args) {
		N=6;
		makeSet();
		union(0,1);
		System.out.println(Arrays.toString(p));
		System.out.println(Arrays.toString(r));
		union(2,3);
		System.out.println(Arrays.toString(p));
		System.out.println(Arrays.toString(r));
	}
	private static boolean union(int x, int y) {
		x= find(x);
		y= find(y);
		if(x==y)return false; //사이클이 있다.
		if(r[x]<r[y]) {
			r[y]+=r[x];
			p[x]=y;
		}else {
			r[x] +=r[y];
			p[y]=x;
		}
		
		return true;
		
	}
	private static int find(int x) {
		if(x==p[x])return p[x];
		else return p[x]= find(p[x]);
	}
	
	private static void makeSet() {
		p=new int[N];
		for (int i = 0; i < N; i++) {
			p[i]=i;
		}
		
		r=new int[N];
		for (int i = 0; i < N; i++) {
			r[i]=1;
		}
		
		
	}

}
