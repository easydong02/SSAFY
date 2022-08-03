package com.ssafy.singleton;

class SingletonClass {
	//stateless한 클래스 - 상태를 가지지 않고 기능만~
	private static SingletonClass sc = new SingletonClass(); //static에서 non-static 접근 불가하기 때문에 static 붙여줌
	
	private SingletonClass() {}
	
	static public SingletonClass getSingletonClass() {
		return sc;
	}
	public void sayHello() {
		System.out.println("Hello");
	}
	
}


public class SingletonTest{
	public static void main(String[] args) {
		
		SingletonClass sc = SingletonClass.getSingletonClass();
		
		sc.sayHello();
	}
}