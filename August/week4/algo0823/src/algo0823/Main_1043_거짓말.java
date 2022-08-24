package algo0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1043_거짓말 {
	static int N,M,result;
	static int[] p;
	static int[] r;
	static List<Integer> trues= new ArrayList<>();
	static List<int[]> parties= new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		makeSet();
		
		st= new StringTokenizer(br.readLine());
		int num=Integer.parseInt(st.nextToken());
//		if(num==0) {
//			System.out.println(M);
//			System.exit(0);
//		}
//		
		//진실 모임
		for (int i = 0; i < num; i++) {
			trues.add(Integer.parseInt(st.nextToken()));
		}
		
		//진실 모임 전부 union
		for (int i = 0; i < trues.size()-1; i++) {
			union(trues.get(i),trues.get(i+1));
		}
		
		//파티
		for (int i = 0; i <M; i++) {
			st=new StringTokenizer(br.readLine());
			//인원수
			int tmp= Integer.parseInt(st.nextToken());
			int[] nums =new int[tmp];
			boolean chk=false;
			
			//각 타피 인원 만들고 넣기
			for (int j = 0; j < tmp; j++) {
				nums[j]= Integer.parseInt(st.nextToken());
			}
			parties.add(nums);
			
			//각 파티에 진실을 알고 있는 사람 있으면 union
			for (int j = 0; j < nums.length; j++) {
				if(find(nums[j])==find(trues.get(0))) {
					chk=true;
				}
			}
			if(chk) {
				for (int j = 0; j < nums.length; j++) {
					union(find(trues.get(0)),nums[j]);
				}
			}
		}

		
		for (int i = 0; i < parties.size(); i++) {
			if(check(parties.get(i))) {
				result++;
			}
		}
		System.out.println(result);
		
	}

	private static boolean check(int[] people) {
		for (int i = 0; i < people.length; i++) {
			if(find(people[i])==find(trues.get(0))) {
				return false;
			}
		}
		return true;
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

}
