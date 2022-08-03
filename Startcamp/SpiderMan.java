package com.ssafy.spider;

public class SpiderMan extends Person{
	boolean isSpider;
	Spider spider = new Spider();
	
	public SpiderMan(String name, boolean isSpider) {
		super(name);
		this.isSpider = isSpider;
	}
	
	public void fireWeb() {
		
		if(isSpider) {
			spider.fireWeb();
			
		}else {
			System.out.println("사람일 땐 참자..");
		}
	}
	@Override
	public void jump() {
		if(isSpider) {
			spider.jump();
			
		}else {
			//System.out.println("잠푸"); 똑같이 쓸 필요없이 super로 부모거 가져오기
			super.jump();
		}
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+", isSpider: "+ isSpider;
	}
	
}
