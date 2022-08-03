package java0727;

import java.util.HashMap;
import java.util.Iterator;

public class MapTest {

	public static void main(String[] args) {
		HashMap<String, Point> hs = new HashMap<>();
		hs.put("a", new Point(1,2));
		hs.put("b", new Point(2,3));
		hs.put("b", new Point(3,5)); //최후에 한 것으로 업데이트
		hs.put("d", new Point(-1,5));
		
		
		System.out.println(hs.size());
		System.out.println(hs.get("b"));
		
		Iterator<String> iter= hs.keySet().iterator();
		
		while(iter.hasNext()) {
			String key= iter.next();
			Point p= hs.get(key);
			System.out.println(p);
		}
	}

}
