package edu.nju.dessertHouse.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nju.dessertHouse.dao.BranchDao;
import edu.nju.dessertHouse.dao.CustomerDao;
import edu.nju.dessertHouse.dao.DessertDao;
import edu.nju.dessertHouse.dao.SalePlanDao;
import edu.nju.dessertHouse.dao.SaleRecDao;
import edu.nju.dessertHouse.dao.UserDao;
import edu.nju.dessertHouse.factory.DaoFactory;
import edu.nju.dessertHouse.model.Branch;
import edu.nju.dessertHouse.model.Customer;
import edu.nju.dessertHouse.model.Dessert;
import edu.nju.dessertHouse.model.SalePlan;
import edu.nju.dessertHouse.model.SaleRec;
import edu.nju.dessertHouse.model.User;
import edu.nju.dessertHouse.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	SalePlanDao salePlanDao;
	@Autowired
	CustomerDao customerDao;
	@Autowired
	UserDao userDao;
	@Autowired
	DessertDao dessertDao;
	@Autowired
	BranchDao branchDao;
	@Autowired
	SaleRecDao saleRecDao;
	static UserServiceImpl userService = new UserServiceImpl();
	@Override
	public boolean valideUser(String id, String password) {
		boolean result ;
		result = userDao.login(id, password);
		return result;
	}

	@Override
	public boolean valideCustomer(String id, String password) {
		boolean result ;
		System.out.println(id+"??"+password);
		result = customerDao.login(id, password);
		System.out.println(result+"(UserService)");
		return result;
	}

	@Override
	public Customer getCustomerInfo(String id) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer = customerDao.find(id);
		return customer;
	}

	@Override
	public User getUserInfo(String id) {
		// TODO Auto-generated method stub
		User user = new User();
		user = userDao.find(id);
		return user;
	}

	public static UserService getInstance()
	{
		return userService;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.save(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.update(customer);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Branch> getAllBranch() {
		// TODO Auto-generated method stub
		List<Branch> list = new ArrayList<Branch>();
		list = branchDao.getAllBranch();
		return list;
	}

	@Override
	public void saveBranch(Branch branch) {
		// TODO Auto-generated method stub
		branchDao.save(branch);
	}

	@Override
	public void deleteBranch(String id) {
		// TODO Auto-generated method stub
		branchDao.delete(id);
		System.out.println(id+"UsreService");
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	public List<User> getAllClerk() {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		list = userDao.getAllClerk();
		return list;
	}

	@Override
	public void deleteClerk(String id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		userDao.delete(id);
		System.out.println(id+"UsreService");
	}

	@Override
	public List<Dessert> getAllDessert() {
		// TODO Auto-generated method stub
		List<Dessert> list = new ArrayList<Dessert>();
		list = dessertDao.getAllDessert();
		return list;
	}

	@Override
	public int getBiggistPlanId() {
		int result = 0;
		System.out.println(result+"userService");
		result = salePlanDao.getBiggistPlanId();
		System.out.println(result+"userService");
		return result;
	}

	@Override
	public Dessert getDessertByName(String name) {
		// TODO Auto-generated method stub
		return dessertDao.getDessertByName(name);
	}

	@Override
	public void saveSalePlan(SalePlan salePlan) {
		// TODO Auto-generated method stub
		salePlanDao.save(salePlan);
	}

	@Override
	public int getIdOfPlan() {
		// TODO Auto-generated method stub
		
		return salePlanDao.getBiggistId();
	}

	@Override
	public List<SalePlan> getAllSalePlan() {
		// TODO Auto-generated method stub
		
		return salePlanDao.getAllSalePlan();
	}
	
	public List<String> getDessertInfoByPlanId(String id){
			List<SalePlan> salePlanList = salePlanDao.getSalePlan(id);
			List<String> dessertInfo = new ArrayList<String>();
			for(int i = 0;i<salePlanList.size();i++){
				dessertInfo.add(dessertDao.getDessertById(salePlanList.get(i).getDessert()).getName()+";"+
						salePlanList.get(i).getPrice()+";"+salePlanList.get(i).getNum());
			}
			return dessertInfo;
		}

	@Override
	public Branch getBranchByName(String name) {
		// TODO Auto-generated method stub
		
		return branchDao.getBranchByName(name);
	}

	@Override
	public List<SalePlan> getPlanByStatus(String status) {
		// TODO Auto-generated method stub
		
		return (List<SalePlan>)salePlanDao.getSalePlanByStatus(status);
	}

	@Override
	public SalePlan getSalePlanByPlanId(String id) {
		// TODO Auto-generated method stub
		
		return salePlanDao.getSalePlan(id).get(0);
	}

	@Override
	public List<SalePlan> getSalePlanListByPlanId(String id) {
		// TODO Auto-generated method stub
		return salePlanDao.getSalePlan(id);
	}

	@Override
	public void updateSalePlan(SalePlan salePlan) {
		// TODO Auto-generated method stub
		salePlanDao.update(salePlan);
	}

	@Override
	public List<SalePlan> getPlanByValidBranch(Branch branch, String status) {
		// TODO Auto-generated method stub
		
		
		return salePlanDao.getPlanByValidBranch(branch, status);
	}

	@Override
	public Dessert getDessert(String id) {
		// TODO Auto-generated method stub
		
		return dessertDao.getDessertById(id);
	}

	@Override
	public int getBiggistSaleRecId() {
		// TODO Auto-generated method stub
		int result = saleRecDao.getBiggistId();
		return result;
	}

	@Override
	public void saveSaleRec(SaleRec saleRec) {
		// TODO Auto-generated method stub
		saleRecDao.save(saleRec);
	}

	@Override
	public List<SaleRec> getSaleRecByCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		return saleRecDao.getSaleRecByCus(customer);
	}

	@Override
	public int getCount(Class c, String column, String con) {
		// TODO Auto-generated method stub
		int result = 0;
		if(c == Customer.class){
			result = this.getCusCount(column, con);
		}
		return result;
	}
	
	public int getCusCount(String column,String con){
		return customerDao.getCount(column, con);
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerDao.getAllCustomer();
	}

	@Override
	public List<SaleRec> getAllSaleRec() {
		// TODO Auto-generated method stub
		return saleRecDao.getAllSaleRec();
	}

	@Override
	public List<SaleRec> getReserveByBranch(Branch branch) {
		// TODO Auto-generated method stub
		return saleRecDao.getReserveByBranch(branch);
	}

	@Override
	public SaleRec loadSaleRec(int id) {
		// TODO Auto-generated method stub
		return saleRecDao.load(id);
	}

	@Override
	public void updateSaleRec(SaleRec saleRec) {
		// TODO Auto-generated method stub
		saleRecDao.update(saleRec);
	}

	@Override
	public Branch getBranch(String id) {
		// TODO Auto-generated method stub
		
		return branchDao.getbranch(id);
	}
	
	public void updateBranch(Branch branch){
		
		branchDao.updateBranch(branch);
	}

}
