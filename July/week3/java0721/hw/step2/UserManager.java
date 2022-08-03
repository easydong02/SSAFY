package com.ssafy.hw.step2;

public class UserManager {
	private final static int MAX_SIZE =100;
	private int size;
	private User[] users;
	
	
	
	private static UserManager um = new UserManager();
	
	private UserManager() {
		users = new User[MAX_SIZE];
	}
	
	public static UserManager getInstance() {
		return um;
	}
	
	public User searchByName(String name) {
		for (int i = 0; i < size; i++) {
			if(users[i].getName().equals(name)) {
				return users[i];
			}
		}
		
		return null; 
	}
	
	public boolean add(User user) {
		if(searchByName(user.getName())==null) {
			users[size++] = user;
			return true;
		}
		
		return false;
	}
	
	public User[] getList() {
		User[] uu = new User[size];
		for (int i = 0; i < size; i++) {
			uu[i]= users[i];
		}
		return uu;
	}
	
	
}
