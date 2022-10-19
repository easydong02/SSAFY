package com.ssafy.edu.board.model;

public class GuestBook {
	private int articleNo;
	private String userId;
	private String subject;
	private String content;
	private String regtime;
	
	//조인
	private String userName;

	public GuestBook() {
	}

	public GuestBook(int articleNo, String userId, String subject, String content, String regtime, String userName) {
		super();
		this.articleNo = articleNo;
		this.userId = userId;
		this.subject = subject;
		this.content = content;
		this.regtime = regtime;
		this.userName = userName;
	}

	public GuestBook( String userId, String subject, String content) {
		super();
		this.userId = userId;
		this.subject = subject;
		this.content = content;
	}

	@Override
	public String toString() {
		return "GuestBook [articleNo=" + articleNo + ", userId=" + userId + ", subject=" + subject + ", content="
				+ content + ", regtime=" + regtime + ", userName=" + userName + "]";
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
