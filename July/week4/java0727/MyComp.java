package java0727;

import java.util.Comparator;
//�� ���� ������ ���Ҷ��� Comparator ����

public class MyComp implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}
	
}
