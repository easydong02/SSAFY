package com.ssafy.backend.dto;

public class User {
	private String id;
    private String name;
    private String pass;
    private String recId;
    
	public User() {
	}
	public User(String id, String name, String pass, String recId) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.recId = recId;
	}
	public User(String id, String name, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", pass=" + pass + ", recId=" + recId + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRecId() {
		return recId;
	}
	public void setRecId(String recId) {
		this.recId = recId;
	}
}
