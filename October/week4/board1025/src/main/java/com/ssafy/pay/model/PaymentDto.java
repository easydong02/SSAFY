package com.ssafy.pay.model;

public class PaymentDto {
	private int pid;
	private String userId;
	private String pday;
	private int pamount;
	private String pwhy;
	private int fin;
	public PaymentDto() {
	}
	public PaymentDto(int pid, String userId, String pday, int pamount, String pwhy, int fin) {
		super();
		this.pid = pid;
		this.userId = userId;
		this.pday = pday;
		this.pamount = pamount;
		this.pwhy = pwhy;
		this.fin = fin;
	}
	@Override
	public String toString() {
		return "PaymentDto [pid=" + pid + ", userId=" + userId + ", pday=" + pday + ", pamount=" + pamount + ", pwhy="
				+ pwhy + ", fin=" + fin + "]";
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPday() {
		return pday;
	}
	public void setPday(String pday) {
		this.pday = pday;
	}
	public int getPamount() {
		return pamount;
	}
	public void setPamount(int pamount) {
		this.pamount = pamount;
	}
	public String getPwhy() {
		return pwhy;
	}
	public void setPwhy(String pwhy) {
		this.pwhy = pwhy;
	}
	public int getFin() {
		return fin;
	}
	public void setFin(int fin) {
		this.fin = fin;
	}
	
}
