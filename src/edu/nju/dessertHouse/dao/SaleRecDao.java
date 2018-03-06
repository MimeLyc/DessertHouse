package edu.nju.dessertHouse.dao;

import java.util.List;

import javax.ejb.Remote;

import edu.nju.dessertHouse.model.Branch;
import edu.nju.dessertHouse.model.Customer;
import edu.nju.dessertHouse.model.SaleRec;

public interface SaleRecDao {
	public int getBiggistId();
	public void save(SaleRec saleRec);
	public List<SaleRec> getSaleRecByCus(Customer customer);
	
	public List<SaleRec> getAllSaleRec();
	
	public List<SaleRec> getReserveByBranch(Branch branch);
	
	public SaleRec load(int id);
	
	public void update(SaleRec saleRec);
}
