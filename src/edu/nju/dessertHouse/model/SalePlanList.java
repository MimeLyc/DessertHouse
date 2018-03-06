package edu.nju.dessertHouse.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nju.dessertHouse.dao.DessertDao;
import edu.nju.dessertHouse.dao.SalePlanDao;
import edu.nju.dessertHouse.dao.impl.DessertDaoImpl;
import edu.nju.dessertHouse.dao.impl.SalePlanDaoImpl;

public class SalePlanList {
	List<SalePlan> list = new ArrayList<SalePlan>();
	int bigId=0;
	@Autowired
	SalePlanDao salePlanDao;
//	@Autowired
//	DessertDao dessertDao;
	List<String> dessertInfo = new ArrayList<String>();
	public void setList(ArrayList<SalePlan> list){
		this.list = list;
	}
	
	public List<SalePlan> getList(){
		return this.list;
	}
	
	public void add(SalePlan branch){
		
		list.add(branch);
	}
	
	public void remove(SalePlan branch){
		list.remove(branch);
	}
	
	public SalePlan getSalePlan(int i){
		return this.list.get(i);
	}
	
	public int getBiggistId(){
		
		return bigId;		
	}
	
	public void setBiggistId(int id){
		
	}
	
	public List<String> getPlanID(){
		return salePlanDao.getSalePlanId();
	}
	
//	public List<String> getDessertInfoByPlanId(String id){
//		salePlanDao = new SalePlanDaoImpl();
//		List<SalePlan> salePlanList = salePlanDao.getSalePlan(id);
//		for(int i = 0;i<salePlanList.size();i++){
//			dessertInfo.add(dessertDao.getDessertById(salePlanList.get(i).getDessert()).getName()+";"+
//					salePlanList.get(i).getPrice()+";"+salePlanList.get(i).getNum());
//		}
//		return dessertInfo;
//	}
}
