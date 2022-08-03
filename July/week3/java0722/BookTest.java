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
		
		
		Book b1 = new Book("21424","Java Pro", "���ϳ�", "jaen.kr", 15000, "Java �⺻ ����");
		Book b2 = new Book("21425","Java Pro2", "���ϳ�", "jaen.kr", 25000, "Java ����");
		Book b3 = new Book("35355","�м�����", "�ҳ���", "jaen.kr", 30000, "SW �𵨸�");
		Book m = new Magazine("45678", "���� �˰���", "ȫ�浿", "jaen.kr", 10000, "1�� �˰���", 2021, 1);
		
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
		System.out.println("�Ʒ� ���⿡�� ���ϴ� ��ȣ�� �Է��Ͻÿ�.");
		System.out.println("1.å�Է�");
		System.out.println("2.�����Է�");
		System.out.println("3.��� å ��Ϻ���");
		System.out.println("4.å�� ����");
		System.out.println("5.������ ����");
		System.out.println("9.������");
		return sc.nextInt();
		
	}
	
	
	private static void endBookManager() {
		System.out.println("�ȳ��� ���ʽÿ�..");
		System.exit(0);
	}
	
	private static void addBook() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Object[] temp = new Object[6];
		System.out.println("�߰��� å ������ �Է��Ͻʽÿ�.(å��ȣ å�̸� ���� ���ǻ� ���� ����)");
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
		System.out.println("�߰��� ���� ������ �Է��Ͻʽÿ�.(å��ȣ å�̸� ���� ���ǻ� ���� ���� �� ��)");
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
