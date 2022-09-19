package com.ssafy.edu.board;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDates {
	private String mydate;

	
	public String getMydate() {
		return mydate;
	}

	public String getMydate2() {
		Date date =new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	public void setMydate(String mydate) {
		this.mydate = mydate;
	}
	
	
}
