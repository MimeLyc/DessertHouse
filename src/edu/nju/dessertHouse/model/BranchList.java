package edu.nju.dessertHouse.model;

import java.util.ArrayList;
import java.util.List;

public class BranchList {
	List<Branch> list = new ArrayList<Branch>();
	
	public void setList(ArrayList<Branch> list){
		this.list = list;
	}
	
	public List<Branch> getList(){
		return this.list;
	}
	
	public void add(Branch branch){
		
		list.add(branch);
	}
	
	public void remove(Branch branch){
		list.remove(branch);
	}
	
	public Branch getBranch(int i){
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
