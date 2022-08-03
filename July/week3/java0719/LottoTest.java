package com.ssafy.edu.first;

public class LottoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lotto lot= new Lotto();
		lot.make();
		lot.print();
		
		System.out.println(lot.getClass());
		System.out.println(lot.hashCode());
		System.out.println(lot.toString());
		System.out.println(Integer.toHexString(lot.hashCode()));
	}

}
