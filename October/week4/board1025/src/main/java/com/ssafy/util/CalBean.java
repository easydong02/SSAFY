package com.ssafy.util;

import java.util.Calendar;

public class CalBean {
	private int year = 0; 
	private int month = 0; 
	private int day = 0;
	
	public CalBean() {
		Calendar cal = Calendar.getInstance();
		this.year = cal.get(Calendar.YEAR);
		this.month = cal.get(Calendar.MONTH) + 1;	// 하나 모자르게 줘서 +1 필요
		this.day = cal.get(Calendar.DAY_OF_MONTH);
	}

	@Override
	public String toString() {
		return "CalBean [year=" + year + ", month=" + month + ", day=" + day + "]";
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
}
