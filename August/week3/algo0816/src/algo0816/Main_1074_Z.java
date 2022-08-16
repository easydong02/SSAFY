package algo0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z {
	static int n,r,c,tmp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		n= Integer.parseInt(st.nextToken());
		r= Integer.parseInt(st.nextToken());
		c= Integer.parseInt(st.nextToken());
		int N = (int) Math.pow(2, n);
		
		dnq(r,c,N);
//		for(int []m: map) {
//			System.out.println(Arrays.toString(m));
//		}
		
		System.out.println(tmp);

	}
	private static void dnq(int r, int c, int cnt) {
		if(cnt==1 ) {
			return;
		}
		
		
		if( r < cnt/2 && c < cnt/2) {
			dnq(r,c,cnt/2);
		}else if(r< cnt/2 && c >= cnt/2) {
			tmp += cnt * cnt /4;
			dnq(r,c-cnt/2,cnt/2);
		}else if(r >= cnt/2 && c< cnt/2) {
			tmp += cnt*cnt/4 *2;
			dnq(r-cnt/2,c,cnt/2);
		}else if(r >= cnt/2 && c >= cnt/2) {
			tmp += cnt* cnt/4*3;
			dnq(r-cnt/2,c-cnt/2,cnt/2);
		}
		
		
	}

}
