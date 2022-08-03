package com.ssafy.ws.step4;

public class Test1 {

	public static void main(String[] args) {
		Restaurant rest1= new Restaurant(101,"¿ï¹Ğ´ë","¼­¿ï","³Ã¸é",4);
		Restaurant rest2= new Restaurant(401,"µµ¸¶29","´ë±¸","¿¬¾îÃÊ¹ä",3);
		
		Restaurant[] rest= new Restaurant[2];
		
		rest[0]=rest1;
		rest[1]=rest2;
		
		Review rev1 = new Review(1,101,"±è½ÎÇÇ","³Ê¹« ¸ÀÀÖ³×¿ä~");
		Review rev2 = new Review(2,401,"³ª½ÎÇÇ","¸ÀÀÖ¾î¿ä!");
		
		Review[] rev= new Review[2];
		rev[0] =rev1;
		rev[1]= rev2;
		
		System.out.println(rest1);
		System.out.println(rest2);
		System.out.println(rev1);
		System.out.println(rev2);
		
		System.out.println("----------------");
		for(Restaurant r: rest) {
			System.out.println(r);
		}
		System.out.println("----------------");
		for(Review r: rev) {
			System.out.println(r);
		}
	}

}
