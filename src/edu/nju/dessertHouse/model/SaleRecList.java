package edu.nju.dessertHouse.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nju.dessertHouse.dao.DessertDao;
import edu.nju.dessertHouse.dao.SalePlanDao;
import edu.nju.dessertHouse.dao.impl.DessertDaoImpl;
import edu.nju.dessertHouse.dao.impl.SalePlanDaoImpl;

public class SaleRecList {
	List<SaleRec> list = new ArrayList<SaleRec>();
	int bigId=0;
	List<Dessert> dessertList  =new ArrayList<Dessert>();
//	@Autowired
//	DessertDao dessertDao;
	List<String> dessertInfo = new ArrayList<String>();
	public void setList(ArrayList<SaleRec> list){
		this.list = list;
	}
	
	public List<SaleRec> getList(){
		return this.list;
	}
	
	public void add(SaleRec saleRec){
		
		list.add(saleRec);
	}
	
	public void remove(SaleRec saleRec){
		list.remove(saleRec);
	}
	
	public SaleRec getSaleRec(int i){
		return this.list.get(i);
	}
	
	public int getBiggistId(){
		
		return bigId;		
	}
	
	public void setBiggistId(int id){
		
	}
	
	public ArrayList<Integer> getConsumeCount(Branch branch,Dessert dessert){
		int reserve = 0;
		int cash = 0;

		for(int i=0;i<list.size();i++){
//			System.out.println(branch.getId()+list.get(i).getBranch().getId());
//			System.out.println(dessert.getId()+list.get(i).getDessert().getId());
//			System.out.println(list.size()+list.get(1).getStatus());
			if(list.get(i).getBranch().getId().equals(branch.getId())&&list.get(i).getDessert().getId().equals(dessert.getId())&&list.get(i).getStatus().contains("RESERVE")){
				reserve++;
			}else if(list.get(i).getBranch().getId().equals(branch.getId())&&list.get(i).getDessert().getId().equals(dessert.getId())){
				cash++;
			}
		}
		ArrayList<Integer> consumeList = new ArrayList<Integer>();
		consumeList.add(0,reserve);
		consumeList.add(1,cash);
		return consumeList;
	}
	
	public ArrayList<Integer> getConsumeCountByBranch(Branch branch){
		int reserve = 0;
		int cash = 0;

		for(int i=0;i<list.size();i++){
//			System.out.println(branch.getId()+list.get(i).getBranch().getId());
//			System.out.println(dessert.getId()+list.get(i).getDessert().getId());
//			System.out.println(list.size()+list.get(1).getStatus());
			if(list.get(i).getBranch().getId().equals(branch.getId())&&list.get(i).getStatus().contains("RESERVE")){
				reserve++;
			}else if(list.get(i).getBranch().getId().equals(branch.getId())){
				cash++;
			}
		}
		ArrayList<Integer> consumeList = new ArrayList<Integer>();
		consumeList.add(0,reserve);
		consumeList.add(1,cash);
		return consumeList;
	}
	
	public Integer getConsumeCountByDessert(Dessert dessert){
		int num = 0;

		for(int i=0;i<list.size();i++){
			if(list.get(i).getDessert().getId().equals(dessert.getId())){
				num++;
			}
		}

		return num;
	}
	
	public ArrayList<Integer> getConsumeCountTotal(){
		int reserve = 0;
		int cash = 0;

		for(int i=0;i<list.size();i++){
//			System.out.println(branch.getId()+list.get(i).getBranch().getId());
//			System.out.println(dessert.getId()+list.get(i).getDessert().getId());
//			System.out.println(list.size()+list.get(1).getStatus());
			if(list.get(i).getStatus().contains("RESERVE")){
				reserve++;
			}else{
				cash++;
			}
		}
		ArrayList<Integer> consumeList = new ArrayList<Integer>();
		consumeList.add(0,reserve);
		consumeList.add(1,cash);
		return consumeList;
	}

	public void setDessertList(ArrayList<Dessert> dessert){
		dessertList = dessert;
		
	}
	
	public List<Dessert> getDessertList(){
		return dessertList;
	}
	
	public ArrayList<Integer> getHotDessert(){
		ArrayList<Integer> num = new ArrayList<Integer>();
		for(int i=0;i<dessertList.size();i++){
			num.add(i,this.getConsumeCountByDessert(dessertList.get(i)));
		}
		
		for(int i=0;i<num.size()-1;i++){
			for(int j=i+1;j<num.size();j++){
				if(num.get(i)<num.get(j)){
					int tem = num.get(i);
					num.set(i, num.get(j));
					num.set(j, tem);
					Dessert temD = dessertList.get(i);
					dessertList.set(i,dessertList.get(j));
					dessertList.set(j,temD);
				}
			}
		}
		return num;
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
