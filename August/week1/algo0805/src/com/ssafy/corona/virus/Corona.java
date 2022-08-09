package com.ssafy.corona.virus;

public class Corona extends Virus{
	public int spreadSpeed;
	
	
	//생성자는 리턴없는 메서드, 클래스 이름과 같아야 하고
	//자생 부생 -> 부초자초
	public  Corona(String name, int level, int spreadSpeed) {
		super(name, level);
//		setName(name);
//		setLevel(level);
		setSpreadSpeed(spreadSpeed);
	}
	
	public int getSpreadSpeed() {
		return spreadSpeed;
	}
	public void setSpreadSpeed(int spreadSpeed) {
		this.spreadSpeed = spreadSpeed;
	}	
	// overriding 확인
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(super.toString()).append("\t")
		  .append(getSpreadSpeed());
		return sb.toString();
	}
}