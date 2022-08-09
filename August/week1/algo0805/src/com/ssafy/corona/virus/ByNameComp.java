package com.ssafy.corona.virus;

import java.util.Comparator;

public class ByNameComp implements Comparator<Virus> {

//	@Override
//	public int compare(Virus v1, Virus v2) {
//		String n1= v1.getName();
//		String n2= v2.getName();
//		
//		int result = n1.compareTo(n2); //Lexico
//		
//		if(result==0) {
//			int lv1= v1.getLevel();
//			int lv2= v2.getLevel();
//			return Integer.compare(lv1,lv2); //level 순 ASC
//		}else return result; //이름으로 ASC
//	}
	
	@Override
	public int compare(Virus v1, Virus v2) {
		return v1.compareTo(v2);
	}

}
