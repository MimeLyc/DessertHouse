package edu.nju.dessertHouse.dao;

import java.util.List;

import javax.ejb.Remote;

import edu.nju.dessertHouse.model.Branch;
import edu.nju.dessertHouse.model.Dessert;
import edu.nju.dessertHouse.model.SalePlan;

public interface SalePlanDao {
	public int getBiggistId();
	
	public void save(SalePlan salePlan);

	int getBiggistPlanId();
	
	public List<SalePlan> getAllSalePlan();
	
	public List<SalePlan> getSalePlan(String id);
	
	public List<String> getSalePlanId();
	
	public List<SalePlan> getSalePlanByStatus(String status);
	
	public void update(SalePlan salePlan);
	
	public List<SalePlan> getPlanByValidBranch(Branch branch,String status);
}
