package edu.nju.dessertHouse.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.dessertHouse.dao.BaseDao;
import edu.nju.dessertHouse.dao.DessertDao;
import edu.nju.dessertHouse.model.Dessert;
import edu.nju.dessertHouse.model.User;
@Repository
public class DessertDaoImpl implements DessertDao {

	@Autowired
	private BaseDao baseDao;
	private static DessertDaoImpl dessertDao = new DessertDaoImpl();
	@Override
	public Dessert find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dessert find(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dessert> getAllDessert() {
		List<Dessert> list = new ArrayList<Dessert>();
		list  = (ArrayList<Dessert>)baseDao.getAllList(Dessert.class);
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Dessert getDessertByName(String name) {
		// TODO Auto-generated method stub
		Dessert result;
		if(baseDao.getSearch(Dessert.class, "name", name)!=null){
			result=(Dessert) baseDao.getSearch(Dessert.class, "name", name).get(0);
		}else{
			result = null;
		}
		return result;
	}

	@Override
	public Dessert getDessertById(String id) {
		// TODO Auto-generated method stub
		Dessert dessert = (Dessert) baseDao.load(Dessert.class, id);
		return dessert;
	}
	
	
	

}
