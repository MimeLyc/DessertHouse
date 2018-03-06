package edu.nju.dessertHouse.model;

import java.util.ArrayList;
import java.util.List;

public class ClerkList {
	List<User> list = new ArrayList<User>();
	
	public void setList(ArrayList<User> list){
		this.list = list;
	}
	
	public List<User> getList(){
		return this.list;
	}
	
	public void add(User user){
		
		list.add(user);
	}
	
	public void remove(User user){
		list.remove(user);
	}
	
	public User getClerk(int i){
		return this.list.get(i);
	}
	
	
}
