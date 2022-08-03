package java0726;

public class Antquiz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ant(20);
	}
	
	public static void ant(int stage) {
		String s="11";
		for (int i = 0; i < stage; i++) {
			System.out.println(s);
			s = ant(s);
		}
	}
	
	
	static public String ant(String s) {
		String t= "";
		char c = s.charAt(0);
		
		int cnt=1;
		for (int i = 1; i < s.length(); i++) {
			if(c==s.charAt(i)) {
				cnt ++;
			}else {
				t = t+c+cnt;
				c= s.charAt(i);
				cnt =1;
			}
		}
		
		t = t+c+cnt;
		return t;
	}

}
