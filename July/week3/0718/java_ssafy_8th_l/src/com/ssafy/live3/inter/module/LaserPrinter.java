package com.ssafy.live3.inter.module;

public class LaserPrinter implements Printer {

	@Override
	public void print(String fileName) {
		System.out.println("lazer printer: "+ fileName);
	}

}
