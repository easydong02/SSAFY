package com.ssafy.corona.app;

import java.util.*;
import com.ssafy.corona.virus.*;

public class MainTest {
	public static void main(String[] args) {
	

		// 10.질병관리 문제 //
		//
		//	아래 11~13번 주석을 해제하여
		//	"정상 출력 예" 와 같이 출력될 수 있도록 
		//	코드들을 디버깅 하세요!
		//
		System.out.println("10.질병관리(코로나,메르스) =================================");
		VirusMgr vmgr=VirusMgrImpl.getInstance();// 싱글톤
		System.out.println();		
		
 //<- 주석 해제 후 작성 : start ////////////////////////////////
		System.out.println("11.코로나19 등록");
		// 정상 출력 예: 
		// 11.코로나19 등록
		// 코로나19: 등록된 바이러스입니다.
		try {
			vmgr.add(new Mers(  "메르스15", 2, 1.5));
			vmgr.add(new Corona("코로나19", 3, 2));
			vmgr.add(new Corona("코로나19", 2, 2));
			vmgr.add(new Mers(  "메르스16", 2, 1.5));
			vmgr.add(new Corona("코로나17", 3, 2));
			vmgr.add(new Corona("코로나18", 2, 2));
			vmgr.add(new Mers(  "메르스19", 2, 1.5));
			vmgr.add(new Corona("코로나19", 3, 2));
			vmgr.add(new Corona("코로나20", 3, 2));
			vmgr.add(new Corona("코로나21", 2, 2));
			// 이미 존재하면 
		} catch (DuplicatedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		
		
		System.out.println("12.바이러스 전체검색");
		// 정상 출력 예: 
		// 12.바이러스 전체검색
		// 메르스15	2	1.5
		// 코로나19	3	2
		Virus[] virus=vmgr.search();
		for(Virus v:virus) {
			System.out.println(v);// v.toString()
		}
		System.out.println();
		
		//-> 여기
		System.out.println("13.코로나15 조회");
		// 정상 출력 예: 
		// 13.코로나15 조회
		// 코로나15: 미등록 바이러스입니다.
		try {
			Virus v=vmgr.search("코로나15");
			System.out.println(v);
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
 //<- 주석 해제 후 작성 : end /////////////////////////////////
		
		

	}
}
