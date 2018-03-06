package edu.nju.dessertHouse.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.dessertHouse.dao.BaseDao;
import edu.nju.dessertHouse.dao.SaleRecDao;
import edu.nju.dessertHouse.model.Branch;
import edu.nju.dessertHouse.model.Customer;
import edu.nju.dessertHouse.model.SalePlan;
import edu.nju.dessertHouse.model.SaleRec;

@Repository
public class SaleRecDaoImpl implements SaleRecDao {
	@Autowired
	private BaseDao baseDao;
	@Override
	public int getBiggistId() {
		// TODO Auto-generated method stub
		Long result = (long) 0;
		result = baseDao.getTotalCount(SaleRec.class);
		return result.intValue();
	}

	@Override
	public void save(SaleRec saleRec) {
		// TODO Auto-generated method stub
		baseDao.save(saleRec);
	}

	@Override
	public List<SaleRec> getSaleRecByCus(Customer customer) {
		// TODO Auto-generated method stub
		List<SaleRec> saleRec = new ArrayList<SaleRec>();
		Session session = baseDao.getNewSession();
		String hql = "from SaleRec where customerID='"+customer.getId()+"'";
		saleRec=  (List<SaleRec>) session.createQuery(hql).list();
		session.close();

		return saleRec;
	}

	@Override
	public List<SaleRec> getAllSaleRec() {
		// TODO Auto-generated method stub
		List<SaleRec> list =new ArrayList<SaleRec>();
		list = baseDao.getAllList(SaleRec.class);
		return list;
	}

	@Override
	public List<SaleRec> getReserveByBranch(Branch branch) {
		// TODO Auto-generated method stub
		List<SaleRec> saleRec = new ArrayList<SaleRec>();
		Session session = baseDao.getNewSession();
		String hql = "from SaleRec where branch='"+branch.getId()+"' and status like '%RESERVE%' order by date desc";
		saleRec=  (List<SaleRec>) session.createQuery(hql).list();
		session.close();

		return saleRec;
	}

	@Override
	public SaleRec load(int id) {
		// TODO Auto-generated method stub
		
		return (SaleRec) baseDao.load(SaleRec.class, id);
	}

	@Override
	public void update(SaleRec saleRec) {
		// TODO Auto-generated method stub
		baseDao.update(saleRec);
	}

}
