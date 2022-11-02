package com.ssafy.subway.model;

public class Subway {
	private int id;
	private String subwayName;
	private String company;
	private String line;
	private String kakaoBunji;
	private String bunji;
	private String roadName;
	
	
	@Override
	public String toString() {
		return "Subway [id=" + id + ", subwayName=" + subwayName + ", company=" + company + ", line=" + line
				+ ", kakaoBunji=" + kakaoBunji + ", bunji=" + bunji + ", roadName=" + roadName + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubwayName() {
		return subwayName;
	}
	public void setSubwayName(String subwayName) {
		this.subwayName = subwayName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getKakaoBunji() {
		return kakaoBunji;
	}
	public void setKakaoBunji(String kakaoBunji) {
		this.kakaoBunji = kakaoBunji;
	}
	public String getBunji() {
		return bunji;
	}
	public void setBunji(String bunji) {
		this.bunji = bunji;
	}
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	public Subway() {
	}
	
	public Subway(int id, String subwayName, String company, String line, String kakaoBunji, String bunji,
			String roadName) {
		super();
		this.id = id;
		this.subwayName = subwayName;
		this.company = company;
		this.line = line;
		this.kakaoBunji = kakaoBunji;
		this.bunji = bunji;
		this.roadName = roadName;
	}
	
	
}
