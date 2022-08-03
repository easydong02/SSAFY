package com.ssafy.ws.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BookTest {
	private static BookManager bm = BookManager.getInstance();

	public static void main(String[] args) throws Exception {
		
		
		Book b1 = new Book("21424","Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
		Book b2 = new Book("21425","Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용");
		Book b3 = new Book("35355","분석설계", "소나무", "jaen.kr", 30000, "SW 모델링");
		Book m = new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2021, 1);
		
		bm.add(b1);
		bm.add(b2);
		bm.add(b3);
		bm.add(m);
		
		while(true) {
			int c= init();
			switch(c) {
				case 1:
					addBook();
					break;
				case 2:
					addMagazine();
					break;
				case 3:
					for(Book book: bm.getList()) {
						System.out.println(book);
					}
					break;
				case 4:
					for(Book book: bm.getBooks()) {
						System.out.println(book);
					}
					break;
				case 5:
					for(Book book: bm.getMagazine()) {
						System.out.println(book);
					}
					break;
				case 9:
					endBookManager();
					break;
			}
		}
	}
	private static int init() {
		Scanner sc =new Scanner(System.in);
		System.out.println("아래 보기에서 원하는 번호를 입력하시오.");
		System.out.println("1.책입력");
		System.out.println("2.잡지입력");
		System.out.println("3.모든 책 목록보기");
		System.out.println("4.책만 보기");
		System.out.println("5.잡지만 보기");
		System.out.println("9.나가기");
		return sc.nextInt();
		
	}
	
	
	private static void endBookManager() {
		System.out.println("안녕히 가십시오..");
		System.exit(0);
	}
	
	private static void addBook() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Object[] temp = new Object[6];
		System.out.println("추가할 책 정보를 입력하십시오.(책번호 책이름 저자 출판사 가격 설명)");
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i<6 ; i++) {
			if(i!=4) {
				temp[i] = st.nextToken();
			}else {
				temp[i] = Integer.parseInt(st.nextToken());
			}
		}
		
		bm.add(new Book((String)temp[0],(String)temp[1],(String)temp[2],(String)temp[3],(int)temp[4],(String)temp[5]));
	}
	
	private static void addMagazine() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Object[] temp = new Object[6];
		System.out.println("추가할 잡지 정보를 입력하십시오.(책번호 책이름 저자 출판사 가격 설명 연 월)");
		for(int i =0; i<8 ; i++) {
			if(i!=4) {
				temp[i] = st.nextToken();
			}else {
				temp[i] = Integer.parseInt(st.nextToken());
			}
		}
		
		bm.add(new Book((String)temp[0],(String)temp[1],(String)temp[2],(String)temp[3],(int)temp[4],(String)temp[5]));
	}

}
