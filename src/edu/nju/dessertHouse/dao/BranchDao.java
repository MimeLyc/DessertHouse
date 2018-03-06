package edu.nju.dessertHouse.dao;

import java.util.List;

import edu.nju.dessertHouse.model.Branch;

public interface BranchDao {
	
	public List<Branch> getAllBranch();
	
	public void save(Branch branch);

	public void delete(String id);
	
	public Branch getBranchByName(String name);
	
	public Branch getbranch(String id);
	
	public void updateBranch(Branch branch);
	
}
