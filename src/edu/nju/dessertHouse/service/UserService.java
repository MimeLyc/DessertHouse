package edu.nju.dessertHouse.service;

import java.util.List;

import javax.ejb.Remote;

import edu.nju.dessertHouse.model.Branch;
import edu.nju.dessertHouse.model.Customer;
import edu.nju.dessertHouse.model.Dessert;
import edu.nju.dessertHouse.model.SalePlan;
import edu.nju.dessertHouse.model.SaleRec;
import edu.nju.dessertHouse.model.User;

public interface UserService {
	
	public boolean valideUser(String id,String password);
	
	public boolean valideCustomer(String id,String password);
	
	public Customer getCustomerInfo(String id);
	
	public User getUserInfo(String id);
	
	public void saveUser(User user);
	
	public void saveCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
	
	public List<Branch> getAllBranch();
	
	public void saveBranch(Branch branch);
	
	public void deleteBranch(String id);
	
	public List<User> getAllClerk();
	
	public void deleteClerk(String id);
	
	public List<Dessert> getAllDessert();
	
	public int getBiggistPlanId();
	
	public Dessert getDessertByName(String name);
	
	public void saveSalePlan(SalePlan salePlan);
	
	public int getIdOfPlan();
	
	public List<SalePlan> getAllSalePlan();
	
	public List<String> getDessertInfoByPlanId(String id);
	
	public Branch getBranchByName(String name);
	
	public List<SalePlan> getPlanByStatus(String status);
	
	public SalePlan getSalePlanByPlanId(String id);
	
	public List<SalePlan> getSalePlanListByPlanId(String id);
	
	public void updateSalePlan(SalePlan salePlan);

	public Dessert getDessert(String id);
	public List<SalePlan> getPlanByValidBranch(Branch branch,String status);
	
	public int getBiggistSaleRecId();
	
	public void saveSaleRec(SaleRec saleRec);
	
	public List<SaleRec> getSaleRecByCustomer(Customer customer);
	
	public int getCount(Class c,String column,String con);
	
	public List<Customer> getAllCustomer();
	
	public List<SaleRec> getAllSaleRec();
	
	public List<SaleRec> getReserveByBranch(Branch branch);
	
	public SaleRec loadSaleRec(int id);
	
	public void updateSaleRec(SaleRec saleRec);
	
	public Branch getBranch(String id);
	
	public void updateBranch(Branch branch);
}
