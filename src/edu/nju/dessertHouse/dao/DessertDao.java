package edu.nju.dessertHouse.dao;

import java.util.List;

import javax.ejb.Remote;

import edu.nju.dessertHouse.model.Dessert;

public interface DessertDao {
	
	public Dessert find(int id);
	
	public Dessert find(String name);
	
	public List<Dessert> getAllDessert();
	
	public Dessert getDessertByName(String name);
	
	public Dessert getDessertById(String id);

}
