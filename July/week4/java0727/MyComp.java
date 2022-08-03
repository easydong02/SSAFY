package java0727;

import java.util.Comparator;
//두 개의 순서를 정할때는 Comparator 구현

public class MyComp implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}
	
}
