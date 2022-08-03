package java0727;

import java.util.ArrayList;

public class ArrayListTest2 {
	
	
	
	
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
		
		
		points.sort(new PointManhattan());
		
		
		for(Point point: points) {
			System.out.println(point);
		}
	}
	
	
	
	

}



