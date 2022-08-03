package java0727;

import java.util.ArrayList;
import java.util.Comparator;

public class ArrayListTest5 {
	
	
	
	
	public static void main(String[] args) {
		ArrayList<Point> points = new ArrayList<>();
		points.add(new Point(2,3));
		points.add(new Point(0,0));
		points.add(new Point(4,2));
		points.add(new Point(3,1));
		points.add(new Point(5,0));
		points.add(new Point(3,4));
		
		System.out.println(points.size());
		
		for(Point point: points) {
			System.out.println(point);
		}
		System.out.println("------------------------");
		
		
		points.sort((Point p1, Point p2) ->{  //람다 인터페이스에 구현할 메서드 하나만 있다면 굳이 또 익명클래스만들필요까지 없다.
				int manh1= Math.abs(p1.getX() - 0)+ Math.abs(p1.getY()-0);
				int manh2= Math.abs(p2.getX() - 0)+ Math.abs(p2.getY()-0);
				return Integer.compare(manh1, manh2);
			});
		
		
		for(Point point: points) {
			System.out.println(point);
		}
	}
	
	
	
	

}



