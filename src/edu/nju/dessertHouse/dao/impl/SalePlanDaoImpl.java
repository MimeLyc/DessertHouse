package edu.nju.dessertHouse.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.dessertHouse.dao.BaseDao;
import edu.nju.dessertHouse.dao.SalePlanDao;
import edu.nju.dessertHouse.model.Branch;
import edu.nju.dessertHouse.model.Dessert;
import edu.nju.dessertHouse.model.SalePlan;

@Repository
public class SalePlanDaoImpl implements SalePlanDao {
	@Autowired
	private BaseDao baseDao;
	@Override
	public int getBiggistPlanId() {
		// TODO Auto-generated method stub
		int id = 0;
		System.out.println(id+"spdaoimpl");
		if(baseDao.getTotalCount(SalePlan.class)==0){
			id=-1;
		}else{
			Session session = baseDao.getNewSession();
			String hql = "select max(sp.planID) from SalePlan as sp";
			int count = Integer.parseInt((String)session.createQuery(hql).uniqueResult());
			id=count;
			session.close();
			System.out.println(id+"spdaoimpl");
		}
		System.out.println(id+"spdaoimpl");
		return id;
	}
	@Override
	public void save(SalePlan salePlan) {
		// TODO Auto-generated method stub
		baseDao.save(salePlan);
		
	}
	@Override
	public int getBiggistId() {
		// TODO Auto-generated method stub
		Long result = (long) 0;
		result = baseDao.getTotalCount(SalePlan.class);
		return result.intValue();
	}
	@Override
	public List<SalePlan> getAllSalePlan() {
		// TODO Auto-generated method stub
		List<SalePlan> list = new ArrayList<SalePlan>();
		list  = (ArrayList<SalePlan>)baseDao.getAllList(SalePlan.class);
		return list;
	}
	@Override
	public List<SalePlan> getSalePlan(String id) {
		// TODO Auto-generated method stub
		List<SalePlan> salePlan = new ArrayList<SalePlan>();
		System.out.println(baseDao+"?");
		System.out.println(salePlan+"?");
		salePlan = (ArrayList<SalePlan>)baseDao.getSearch(SalePlan.class, "planID", id);
		return salePlan;
	}
	@Override
	public List<String> getSalePlanId() {
		// TODO Auto-generated method stub
		List<String> planid = new ArrayList<String>();
			Session session = baseDao.getNewSession();
			String hql = "select distinct planID from SalePlan";
			planid=  (List<String>) session.createQuery(hql).uniqueResult();
			session.close();
	
		return planid;
	}
	@Override
	public List<SalePlan> getSalePlanByStatus(String status) {
		// TODO Auto-generated method stub
		
		return (List<SalePlan>) baseDao.getSearch(SalePlan.class,"status",status);
	}
	@Override
	public void update(SalePlan salePlan) {
		// TODO Auto-generated method stub
		baseDao.update(salePlan);
		
	}
	@Override
	public List<SalePlan> getPlanByValidBranch(Branch branch,String status) {
		// TODO Auto-generated method stub
		List<SalePlan> salePlan = new ArrayList<SalePlan>();
		Session session = baseDao.getNewSession();
		String hql = "from SalePlan where branch='"+branch.getId()+"' and status='"+status+"'";
		salePlan=  (List<SalePlan>) session.createQuery(hql).list();
		session.close();

		return salePlan;
	}

}
