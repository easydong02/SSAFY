package java0727;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class SetTest2 {

	public static void main(String[] args) {
		
		HashSet<Point> points = new HashSet<>(); 
		
		points.add(new Point(2,3));
		points.add(new Point(0,0));
		points.add(new Point(4,2));
		points.add(new Point(2,4));
		points.add(new Point(3,1));
		points.add(new Point(5,0));
		points.add(new Point(3,4));
		points.add(new Point(3,4));
		points.add(new Point(3,-4));
		
		
		// list.clear(); �� �����
		System.out.println(points.size());
		
		Iterator<Point> iter = points.iterator();  // Iterator�� �ڵ����� asc�������ְ� ������ ������ش�.
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
