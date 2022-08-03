package com.ssafy.inter;

public class IronMan implements Heroble {
	int weaponDamage = 100;
	@Override
	public int fire() {
		System.out.println("적의 에너지 감소: "+weaponDamage);
		return weaponDamage;
	}

	@Override
	public void changeShape(boolean isHeroMode) {
		if(isHeroMode) {
			System.out.println("장갑 장착");
		}else {
			System.out.println("일반 토니 스타크");
		}
	}

	@Override
	public void upgrade() {
		// TODO Auto-generated method stub

	}

}
