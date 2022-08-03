package com.ssafy.ws.step3;

import java.util.Date;
import java.util.Scanner;


public class BookTest2 {
	static IBookManager bm = BookManagerImpl.getInstance();

	public static void main(String[] args) {

		while (true) {
			int c = init();
			switch (c) {
			case 1:
				add();
				break;
			case 2:
				addMagazine();
			case 3:
				bookList();
				break;
			case 4:
				getBooks();
				break;
			case 5:
				getMagazines();
				break;
			case 6:
				remove();
				break;
			case 9:
				endBookManager();
				break;
			default:
				break;
			}

		}


	}

	private static void remove() {
		System.out.println("SSAFY BookManager�Դϴ�. Magazine�� �߰��մϴ�. ");
		Scanner scann = new Scanner(System.in);
		System.out.println("삭제할 책의 isbn을 입력하세요.");
		String isbn = scann.nextLine();
		bm.remove(isbn);
	}

	private static void addMagazine() {
		System.out.println("SSAFY BookManager�Դϴ�. Magazine�� �߰��մϴ�. ");
		Scanner scann = new Scanner(System.in);
		System.out.println("isbn�� �Է��ϼ���");
		String isbn = scann.nextLine();
		System.out.println("title�� �Է��ϼ���");
		String title = scann.nextLine();
		System.out.println("author�� �Է��ϼ���");
		String author = scann.nextLine();
		System.out.println("publisher�� �Է��ϼ���");
		String publisher = scann.nextLine();
		System.out.println("price�� �Է��ϼ���");
		String price = scann.nextLine();
		System.out.println("desc�� �Է��ϼ���");
		String desc = scann.nextLine();
		System.out.println("quantity를 입력하세요");
		String quantity = scann.nextLine();
		System.out.println("year�� �Է��ϼ���");
		String year = scann.nextLine();
		System.out.println("month�� �Է��ϼ���");
		String month = scann.nextLine();
		bm.add(new Magazine(isbn, title, author, publisher, Integer.parseInt(price.trim()),desc,Integer.parseInt(quantity),Integer.parseInt(year),Integer.parseInt(month)));
		System.out.println("SSAFY BookManager�Դϴ�. Magazine �߰��Ͽ����ϴ�. ");
		
	}

	private static void bookList() {
		System.out.println("SSAFY BookManager�Դϴ�. ��� å ����Դϴ�. ");
		System.out.println("<<-----------------------");
		for (Book b : bm.getList()) {
			System.out.println(b);
		}
		System.out.println( new Date()+"-------------->>");
	}
	
	private static void getBooks() {
		System.out.println("SSAFY BookManager�Դϴ�. ��� å ����Դϴ�. ");
		System.out.println("<<-----------------------");
		for(Book b: bm.getBooks()) {
			System.out.println(b);
		}
		System.out.println( new Date()+"-------------->>");
	}
	private static void getMagazines() {
		System.out.println("SSAFY BookManager�Դϴ�. ��� å ����Դϴ�. ");
		System.out.println("<<-----------------------");
		for(Magazine b: bm.getMagazines()) {
			System.out.println(b);
		}
		System.out.println( new Date()+"-------------->>");
	}

	private static void add() {
		System.out.println("SSAFY BookManager�Դϴ�. Magazine�� �߰��մϴ�. ");
		Scanner scann = new Scanner(System.in);
		System.out.println("isbn�� �Է��ϼ���");
		String isbn = scann.nextLine();
		System.out.println("title�� �Է��ϼ���");
		String title = scann.nextLine();
		System.out.println("author�� �Է��ϼ���");
		String author = scann.nextLine();
		System.out.println("publisher�� �Է��ϼ���");
		String publisher = scann.nextLine();
		System.out.println("price�� �Է��ϼ���");
		String price = scann.nextLine();
		System.out.println("desc�� �Է��ϼ���");
		String desc = scann.nextLine();
		System.out.println("quantity를 입력하세요");
		String quantity = scann.nextLine();
		bm.add(new Book(isbn, title, author, publisher, Integer.parseInt(price.trim()),desc,Integer.parseInt(quantity)));
		System.out.println("SSAFY BookManager�Դϴ�. Magazine �߰��Ͽ����ϴ�. ");
		
	}

	private static void endBookManager() {
		System.out.println("SSAFY BookManager�Դϴ�. �ȳ��� ���ʽÿ�. ");
		System.exit(0);
	}

	private static int init() {
		System.out.println("�ȳ��ϼ���. SSAFY BookManager�Դϴ�. ");
		System.out.println("�Ʒ� ���⿡�� ���ϴ� ��ȣ�� �Է��ϼ���. ");
		System.out.println("1. å�Է� ");
		System.out.println("2. �����Է� ");
		System.out.println("3. ��� å ��Ϻ���");
		System.out.println("4. å�� ����");
		System.out.println("5. ������ ����");
		System.out.println("6.삭제");
		System.out.println("9. ��");
		Scanner scann = new Scanner(System.in);
		System.out.println("<====��ȣ�� �Է��ϼ���====>");
		return scann.nextInt();
	}
}