package com.ssafy.ws.step4;

import java.util.Arrays;

import com.ssafy.Book;

public class RestaurantManager {
	
	private static final int MAX_RESTAURANT_SIZE = 100 ;
	private static final int MAX_REVIEW_SIZE = 1000 ;
	
	
	private Restaurant[] restaurants;
	private Review[] reviews;
	
	private int restaurantSize;
	private int reviewSize;
	
	private static RestaurantManager manager = new RestaurantManager();
	
	
	
	private RestaurantManager() {
		restaurants = new Restaurant[MAX_RESTAURANT_SIZE];
		reviews = new Review[MAX_REVIEW_SIZE];
	}
	
	public static RestaurantManager getInstance() {
		return manager;
	}
	
	public boolean addRestaurant(Restaurant newRest) {
		if(searchByresid(newRest.getResid())==null) {
			restaurants[restaurantSize++] =newRest;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean updateRestaurant(Restaurant rest) {
		Restaurant myrest=searchByresid(rest.getResid());
		if(myrest !=null) {
			myrest.setResid(rest.getResid());
			myrest.setName(rest.getName());
			myrest.setAddress(rest.getAddress());
			myrest.setRate(rest.getRate());
			myrest.setSignatureMenu(rest.getSignatureMenu());
			return true;
		}else {
			return false;
		}
	}
	
	public boolean addReview(Review rev) {
		if(reviewSize < MAX_REVIEW_SIZE) {
			reviews[reviewSize++] =rev;
			return true;
		}
		return false;
	}
	
	
	public Restaurant[] getRestaurantList() {
		return Arrays.copyOf(restaurants, restaurantSize);
	}
	
	public Restaurant getRestaurant(int resid) {
		return searchByresid(resid);
	}
	
	public Review[] getRestaurantReview(int resid) {
		int index=0;
		for(int i=0; i<reviewSize;i++) {
			if(reviews[i].getResid() ==resid) {
				Review tmp = reviews[index];
				reviews[index] = reviews[i];
				reviews[i] = tmp;
				index++;
			}
		}
		return Arrays.copyOf(reviews, index);
	}
	


	
	public boolean removeRestaurant(int resid) {
		if(restaurantSize==0) {
			return false;
		}else {
			int loc =0;
			for (int i = 0; i < restaurantSize; i++) {
				if(restaurants[i].getResid() == resid) {
					loc=i;
					break;
				}
			}
			restaurants[loc] = restaurants[reviewSize-1];
			restaurants[restaurantSize-1] =null;
			restaurantSize--;
			return true;
		}
	}
	
	public boolean removeReview(int reviewid) {
		if(reviewSize==0) {
			return false;
		}else {
			int loc =0;
			for (int i = 0; i < reviewSize; i++) {
				if(reviews[i].getReviewid() == reviewid) {
					loc=i;
					break;
				}
			}
			reviews[loc] = reviews[reviewSize-1];
			reviews[reviewSize-1] =null;
			reviewSize--;
			return true;
		}
	}
	
	
	public Restaurant searchByresid(int resid) {
		for (int i = 0; i < restaurantSize; i++) {
			if(restaurants[i].getResid()==resid) {
				return restaurants[i];
			}
		}
		return null;
	}
	
	
}
