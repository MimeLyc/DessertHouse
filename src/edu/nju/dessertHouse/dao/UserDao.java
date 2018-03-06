package edu.nju.dessertHouse.dao;

import java.util.List;

import javax.ejb.Remote;

import edu.nju.dessertHouse.model.User;

public interface UserDao {

	public boolean login(String id,String password);
	
	public User find(String id);
	
	public void save(User user);
	
	public List<User> getAllClerk();
	
	public void delete(String id);
}
