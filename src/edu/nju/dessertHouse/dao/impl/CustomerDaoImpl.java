package edu.nju.dessertHouse.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.dessertHouse.dao.BaseDao;
import edu.nju.dessertHouse.dao.CustomerDao;
import edu.nju.dessertHouse.model.Customer;
import edu.nju.dessertHouse.model.SaleRec;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	@Autowired
	private BaseDao baseDao;
//	private Configuration config;
//	private ServiceRegistry serviceRegistry;
//	@Autowired
//	private SessionFactory sessionFactory;
//	private Session session;
	private static CustomerDaoImpl customerDao = new CustomerDaoImpl();
	@Override
	public boolean login(String id, String password) {
		Customer customer = new Customer();
		customer = (Customer) baseDao.load(customer.getClass(),id);
		if(customer!=null){
			if(customer.getPassword().equals(password)){
				System.out.println("true(CustomerDao)");
				return true;
			}else{
				System.out.println("false(CustomerDao)");
				return false;
			}
		}else{
			System.out.println("not found");
			return false;
		}

	}

	@Override
	public Customer find(String id) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer = (Customer) baseDao.load(customer.getClass(),id);
		return customer;
	}

	@Override
	public boolean register(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void save(Customer customer){
		baseDao.save(customer);
	}
	
	public static CustomerDaoImpl getInstance() {
		return customerDao;
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		baseDao.update(customer);
	}

	@Override
	public int getCount(String column, String con) {
		// TODO Auto-generated method stub
		int result = 0;
		result = baseDao.getSearch(Customer.class, column, con).size();
		return result;
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		List<Customer> list =new ArrayList<Customer>();
		list = baseDao.getAllList(Customer.class);
		return list;
	}

}
