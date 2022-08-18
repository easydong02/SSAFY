package algo0818;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1247_최적경로 {
	static int T,N,result;
	static Point home,com;
	static List<Point> nums;
	static Point[] p;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T= Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <=T; tc++) {
			result= Integer.MAX_VALUE;
			nums= new ArrayList<Point>();
			N= Integer.parseInt(br.readLine());
			visited=new boolean[N];
			p= new Point[N];
			StringTokenizer st= new StringTokenizer(br.readLine());
			com = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			home= new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			for (int i = 0 ; i <N; i++) {
				int x =Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				p[i]= new Point(x,y);
			}//end of reading
//			
//			for (int i = 0; i < p.size(); i++) {
//				System.out.println(p.get(i).x+" "+ p.get(i).y);
//			}
			
			
			perm(0,new ArrayList<Point>() );
			
			System.out.println("#"+tc+" "+result);
		}
	}
	private static void perm(int cnt,  ArrayList<Point> nums) {
		if(cnt==N) {
			int sum = Math.abs(com.x-nums.get(0).x)+Math.abs(com.y-nums.get(0).y);
			for (int i = 1; i < nums.size(); i++) {
				sum+= Math.abs(nums.get(i-1).x-nums.get(i).x)+Math.abs(nums.get(i-1).y-nums.get(i).y);
				if(sum>result)return;
			}
			sum += Math.abs(home.x-nums.get(nums.size()-1).x)+Math.abs(home.y-nums.get(nums.size()-1).y);
			if(sum<result) {
				result=sum;
			}
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i])continue;
			visited[i]=true;
			nums.add(p[i]);
			perm(cnt+1,nums);
			nums.remove(p[i]);
			visited[i]=false;
		}
		
	}

}
