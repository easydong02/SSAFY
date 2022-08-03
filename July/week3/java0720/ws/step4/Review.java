package com.ssafy.ws.step4;

public class Review {
	private int reviewid;
	private int resid;
	private String writer;
	private String content;
	public Review() {
		super();
	}
	public Review(int reviewid, int resid, String writer, String content) {
		super();
		this.reviewid = reviewid;
		this.resid = resid;
		this.writer = writer;
		this.content = content;
	}
	@Override
	public String toString() {
		return "Review [reviewid=" + reviewid + ", resid=" + resid + ", writer=" + writer + ", content=" + content
				+ "]";
	}
	public int getReviewid() {
		return reviewid;
	}
	public void setReviewid(int reviewid) {
		this.reviewid = reviewid;
	}
	public int getResid() {
		return resid;
	}
	public void setResid(int resid) {
		this.resid = resid;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
