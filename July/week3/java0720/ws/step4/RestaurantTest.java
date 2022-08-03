package com.ssafy.ws.step4;

import java.util.Arrays;

public class RestaurantTest {
	static RestaurantManager rmanager ;

	public static void main(String[] args) {
		
		rmanager = RestaurantManager.getInstance();
		rmanager.addRestaurant(new Restaurant(101,"연돈","서울","돈까스",4));
		rmanager.addRestaurant(new Restaurant(401,"땀땀","서울","곱창국수",3));
		
		getRestaurantList();
		rmanager.updateRestaurant(new Restaurant(401,"땀땀2","서울2","잔치국수",3) );
		getRestaurantList();
		
		rmanager.addReview(new Review(1,401,"신동희","맛있어요!"));
		rmanager.addReview(new Review(2,401,"신동희","맛있어요!!정말로요"));
		System.out.println(Arrays.toString(rmanager.getRestaurantReview(401)));
		System.out.println(Arrays.toString(rmanager.getRestaurantList()));
		System.out.println((rmanager.getRestaurant(401))); 
		rmanager.removeRestaurant(401);
		System.out.println(Arrays.toString(rmanager.getRestaurantList()));
		rmanager.removeReview(1);
		System.out.println(Arrays.toString(rmanager.getRestaurantReview(401)));
	}	
	
	private static void getRestaurantList() {
		for(Restaurant rest: rmanager.getRestaurantList() ) {
			System.out.println(rest);
		}
	}

}
