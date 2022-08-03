package java0726;

import java.util.Scanner;

public class FourMagicSquareTest {

	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		int n=scann.nextInt();
		FourMagicSquare odd=new FourMagicSquare(n);
		odd.make();
		odd.print();

	}

}
