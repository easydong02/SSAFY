package java0727;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		TreeSet<String> list = new TreeSet<>();
		
		list.add("hello");
		list.add("hello2");
		list.add("hello3");
		list.add("hello4");
		list.add("hello5");
		list.add("hello5");
		list.add("hello5");
		list.add("hello5");
		list.add("hello5");  // Set�� �ߺ� �����ش�.
		
		
		// list.clear(); �� �����
		System.out.println(list.size());
		
		Iterator<String> iter = list.iterator();  // Iterator�� �ڵ����� asc�������ְ� ������ ������ش�.
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
