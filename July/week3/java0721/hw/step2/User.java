package com.ssafy.hw.step2;

public class User {
	private int userId;
	private String password;
	private String name;
	private String addr;
	private String cellPhone;
	
	
	
	public User() {}
	
	public User(int userId, String password, String name, String addr, String cellPhone) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.addr = addr;
		this.cellPhone = cellPhone;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", addr=" + addr
				+ ", cellPhone=" + cellPhone + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	
	
	
}
