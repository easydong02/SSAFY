package com.ssafy.live3.abs;

public class HorseCart extends Vehicle {
	
	@Override
	public void addFuel() {
		System.out.printf("차종: %s: 연료 주입: %s%n", this.getClass().getSimpleName(), "먹이주기");
	}
}
