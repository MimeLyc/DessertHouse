package edu.nju.dessertHouse.dao;

import java.util.List;

import javax.ejb.Remote;

import edu.nju.dessertHouse.model.Customer;

public interface CustomerDao {
	
	public boolean login(String id,String password);
	
	public Customer find(String id);
	
	public boolean register(Customer customer);
	
	public void save(Customer customer);
	
	public void update(Customer customer);
	
	public int getCount(String column,String con);
	
	public List<Customer> getAllCustomer();
}
