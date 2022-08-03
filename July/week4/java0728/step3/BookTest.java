package com.ssafy.ws.step3;

import java.util.Date;
import java.util.Scanner;

public class BookTest {
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
		System.out.println("SSAFY BookManager�Դϴ�. "
				+ "Magazine�� �߰��մϴ�. ");
		Scanner scann = new Scanner(System.in);
		System.out.println("삭제할 책의 isbn을 입력하세요.");
		String isbn = scann.nextLine();
		bm.remove(isbn);
	}

	private static void addMagazine() {
		System.out.println("SSAFY BookManager입니다. Magazine을 추가합니다. ");
		Scanner scann = new Scanner(System.in);
		System.out.println("isbn를 입력하세요");
		String isbn = scann.nextLine();
		System.out.println("title을 입력하세요");
		String title = scann.nextLine();
		System.out.println("author을 입력하세요");
		String author = scann.nextLine();
		System.out.println("publisher을 입력하세요");
		String publisher = scann.nextLine();
		System.out.println("price을 입력하세요");
		String price = scann.nextLine();
		System.out.println("desc을 입력하세요");
		String desc = scann.nextLine();
		System.out.println("quantity를 입력하세요");
		String quantity = scann.nextLine();
		System.out.println("year을 입력하세요");
		String year = scann.nextLine();
		System.out.println("month을 입력하세요");
		String month = scann.nextLine();
		bm.add(new Magazine(isbn, title, author, publisher, Integer.parseInt(price.trim()),desc,Integer.parseInt(quantity),Integer.parseInt(year),Integer.parseInt(month)));
		System.out.println("SSAFY BookManager입니다. Magazine 추가하였습니다. ");
		
	}

	private static void bookList() {
		System.out.println("SSAFY BookManager입니다. 모든 책 목록입니다. ");
		System.out.println("<<-----------------------");
		for (Book b : bm.getList()) {
			System.out.println(b);
		}
		System.out.println( new Date()+"-------------->>");
	}
	
	private static void getBooks() {
		System.out.println("SSAFY BookManager입니다. 모든 책 목록입니다. ");
		System.out.println("<<-----------------------");
		for(Book b: bm.getBooks()) {
			System.out.println(b);
		}
		System.out.println( new Date()+"-------------->>");
	}
	private static void getMagazines() {
		System.out.println("SSAFY BookManager입니다. 모든 책 목록입니다. ");
		System.out.println("<<-----------------------");
		for(Magazine b: bm.getMagazines()) {
			System.out.println(b);
		}
		System.out.println( new Date()+"-------------->>");
	}

	private static void add() {
		System.out.println("SSAFY BookManager입니다. Magazine을 추가합니다. ");
		Scanner scann = new Scanner(System.in);
		System.out.println("isbn를 입력하세요");
		String isbn = scann.nextLine();
		System.out.println("title을 입력하세요");
		String title = scann.nextLine();
		System.out.println("author을 입력하세요");
		String author = scann.nextLine();
		System.out.println("publisher을 입력하세요");
		String publisher = scann.nextLine();
		System.out.println("price을 입력하세요");
		String price = scann.nextLine();
		System.out.println("desc을 입력하세요");
		String desc = scann.nextLine();
		System.out.println("quantity를 입력하세요");
		String quantity = scann.nextLine();
		bm.add(new Book(isbn, title, author, publisher, Integer.parseInt(price.trim()),desc,Integer.parseInt(quantity)));
		System.out.println("SSAFY BookManager입니다. Magazine 추가하였습니다. ");
		
	}

	private static void endBookManager() {
		System.out.println("SSAFY BookManager입니다. 안녕히 가십시오. ");
		System.exit(0);
	}

	private static int init() {
		System.out.println("안녕하세요. SSAFY BookManager입니다. ");
		System.out.println("아래 보기에서 원하는 번호를 입력하세요. ");
		System.out.println("1. 책입력 ");
		System.out.println("2. 잡지입력 ");
		System.out.println("3. 모든 책 목록보기");
		System.out.println("4. 책만 보기");
		System.out.println("5. 잡지만 보기");
		System.out.println("6.삭제");
		System.out.println("9. 끝");
		Scanner scann = new Scanner(System.in);
		System.out.println("<====번호를 입력하세요====>");
		return scann.nextInt();
	}
}

