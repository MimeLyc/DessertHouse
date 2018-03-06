package edu.nju.dessertHouse.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.dessertHouse.dao.BaseDao;
import edu.nju.dessertHouse.dao.UserDao;
import edu.nju.dessertHouse.model.Branch;
import edu.nju.dessertHouse.model.Customer;
import edu.nju.dessertHouse.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private BaseDao baseDao;
	private static UserDaoImpl userDao = new UserDaoImpl();
	@Override
	public boolean login(String id, String password) {
		User user = new User();
		user = (User) baseDao.load(user.getClass(),id);
		if(user!=null){
			if(user.getPassword().equals(password)){
				System.out.println("true(UserDao)");
				return true;
			}else{
				System.out.println("false(UserDao)");
				return false;
			}
		}else{
			System.out.println("not found+"+id+"?"+password);
			return false;
		}
	}

	@Override
	public User find(String id) {
		User user = new User();
		user = (User) baseDao.load(user.getClass(),id);
		return user;
	}
	
	public static UserDaoImpl getInstance() {
		return userDao;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		baseDao.save(user);
		
	}

	@Override
	public List<User> getAllClerk() {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		list  = (ArrayList<User>)baseDao.getAllList(User.class);
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		baseDao.delete(User.class, id);
	}
	
	

}
