package edu.nju.dessertHouse.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.dessertHouse.dao.BaseDao;
import edu.nju.dessertHouse.dao.BranchDao;
import edu.nju.dessertHouse.model.Branch;
@Repository
public class BranchDaoImpl implements BranchDao {

	
	@Autowired
	private BaseDao baseDao;
	private static BranchDaoImpl branchDao = new BranchDaoImpl();
	@Override
	public List<Branch> getAllBranch() {
		List<Branch> list = new ArrayList<Branch>();
		list  = (ArrayList<Branch>)baseDao.getAllList(Branch.class);
		// TODO Auto-generated method stub
		return list;
	}
	
	@Override
	public void save(Branch branch) {
		baseDao.save(branch);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		System.out.println(id+"branchDao");
		baseDao.delete(Branch.class, id);
	}
	
	public Branch getBranchByName(String name){
		
		return (Branch)baseDao.getSearch(Branch.class,"name",name).get(0);
		
	}

	@Override
	public Branch getbranch(String id) {
		// TODO Auto-generated method stub
		return (Branch) baseDao.load(Branch.class, id);
	}

	public void updateBranch(Branch branch) {
		// TODO Auto-generated method stub
		baseDao.update(branch);
	}

}
