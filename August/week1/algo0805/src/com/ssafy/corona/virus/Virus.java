package com.ssafy.corona.virus;

import java.io.Serializable;

//DTO 직렬화 -> Serializable
//markup interface
public class Virus implements Serializable, Comparable<Virus>{
	
	private String name;
	private int level;

	public Virus() {}
	public Virus(String name, int level) {
		setName(name);
		setLevel(level);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}	
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(getName()).append("\t")
		  .append(getLevel());
		return sb.toString();
	}
	
	@Override
	public int hashCode() {
		int result=1;
		final int prime =31;
		result = prime*result +((name==null)? 0: name.hashCode());
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.name.equals(((Virus)obj).getName());
	}
	
	
	@Override
	public int compareTo(Virus v) {
		String n1= this.getName();
		String n2= v.getName();
		
		int result = n1.compareTo(n2); //Lexico
		
		if(result==0) {
			int lv1= this.getLevel();
			int lv2= v.getLevel();
			return Integer.compare(lv1,lv2); //level 순 ASC
		}else return result; //이름으로 ASC
	}
}
