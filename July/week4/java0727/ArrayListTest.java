package java0727;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		
		list.add("hello");
		list.add("hello2");
		list.add("hello3");
		list.add("hello4");
		list.add("hello5");
		
		list.set(4, "bello~");
		System.out.println(list.size());
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		list.remove(1);
		
		list.sort(new MyComp()); //정렬은 가능하지만 순서가 구현 안 됐음. 그래서 Comparator 직접 구현
		System.out.println("------------------------");
		
		for(String s: list) {
			System.out.println(s);
		}
		
		
		
		// -1 ASC
		// 1 DESC
		// 0 same
		list.sort(new YourComp());
		System.out.println("------------------------");
		
		for(String s: list) {
			System.out.println(s);
		}
		
		
		
		Collections.sort(list,new YourComp()); 
		System.out.println("------------------------");
		
		for(String s: list) {
			System.out.println(s);
		}
		
	}

}
