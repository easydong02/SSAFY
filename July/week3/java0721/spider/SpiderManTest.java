package com.ssafy.spider;

import com.sun.corba.se.spi.oa.OADefault;

public class SpiderManTest {

	public static void main(String[] args) {
		
		SpiderMan sm = new SpiderMan("피터파커",false);
		sm.fireWeb();
		sm.eat();
		sm.jump();
		sm.isSpider= true;
		sm.fireWeb();
		sm.jump();
		
		System.out.println(sm.toString()); //person에서 오버라이딩 한 toString을 다시 SpiderMan에서 오버라이딩
		
		Person person = sm;
		
		person.jump(); // SpiderMan객체에서만 있는 메서드는 쓸 수 없지만, 원래 있던 메서드가 SpiderMan에서 오버라이딩 된 경우는 사용가능
		
		//오브젝트 배열에 들어갔기 때문에 여기에 이 배열로 접근하면 각 객체는 Object기능만 쓸 수 있다.
		Object[] objs = new Object[4];
		objs[0]= sm;
		objs[1]= "Hello";
		objs[2]= objs;
		objs[3]= 1;  // 1은 기본형인데 어케 드감? -> autoboxing으로 Integer타입, 하나의 참조타입으로 감싸줌
		
		//objs[0].fireWeb(); 안 됨
		SpiderMan reSpiderMan2 = (SpiderMan)objs[0];
		reSpiderMan2.fireWeb();
		
		
		for(Object o: objs) {
			System.out.println(o.getClass().getName());
		}
		
		System.out.println(sm);
		
		
		//다형성
		Person person2= sm;
		
		//명시적 형 변환
		SpiderMan reSpider = (SpiderMan)person2;
		reSpider.fireWeb();
		
//		String s1 = new String("abc");
		String s2 = "abd";
		
		System.out.println(s2=="abd");
		//System.out.println(s1.equals(s2));
	}

}
