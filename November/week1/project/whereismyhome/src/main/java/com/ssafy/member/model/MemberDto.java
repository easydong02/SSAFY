package com.ssafy.member.model;

public class MemberDto {

	private String userId;
	private String userName;
	private String userPwd;
	private String emailId;
	private String emailDomain;
	private String joinDate;
	private int age;
	private String role;
	private int delflag;
	public MemberDto() {
		super();
	}
	public MemberDto(String userId, String userName, String userPwd, String emailId, String emailDomain, String joinDate,
			int age, String role, int delflag) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.emailId = emailId;
		this.emailDomain = emailDomain;
		this.joinDate = joinDate;
		this.age = age;
		this.role = role;
		this.delflag = delflag;
	}
	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", emailId=" + emailId
				+ ", emailDomain=" + emailDomain + ", joinDate=" + joinDate + ", age=" + age + ", role=" + role
				+ ", delflag=" + delflag + "]";
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEmailDomain() {
		return emailDomain;
	}
	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getDelflag() {
		return delflag;
	}
	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}
	
	
	
	
}
