package edu.nju.dessertHouse.model;

import java.util.ArrayList;
import java.util.List;

public class DessertList {
	List<Dessert> list = new ArrayList<Dessert>();
	
	public void setList(ArrayList<Dessert> list){
		this.list = list;
	}
	
	public List<Dessert> getList(){
		return this.list;
	}
	
	public void add(Dessert dessert){
		
		list.add(dessert);
	}
	
	public void remove(Dessert dessert){
		list.remove(dessert);
	}
	
	public Dessert getDessert(int i){
		return this.list.get(i);
	}
	
	public int getBiggistId(){
		int result = 0;
		for(int i=0;i<list.size();i++){
			if(Integer.parseInt(list.get(i).getId())>=result){
				result = Integer.parseInt(list.get(i).getId());
			}
			
		}
		return result;
		
	}
}
