package edu.nju.dessertHouse.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CustomerList {
	List<Customer> list = new ArrayList<Customer>();
	
	public void setList(ArrayList<Customer> list){
		this.list = list;
	}
	
	public List<Customer> getList(){
		return this.list;
	}
	
	public void add(Customer customer){
		
		list.add(customer);
	}
	
	public void remove(Customer customer){
		list.remove(customer);
	}
	
	public Customer getCustomer(int i){
		return this.list.get(i);
	}
	
	public int getBiggistId(){
		int result = 0;
		for(int i=0;i<list.size();i++){
			if(Integer.parseInt(list.get(i).getId())>=result){
				result = Integer.parseInt(list.get(i).getId());
			}
			
		}
		return result;
		
	}
	
	public ArrayList<Integer> getGenderCount(){
		int man=0;
		int woman = 0;
		ArrayList<Integer> genderList = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getGender().equals("MAN")){
				man++;
			}else{
				woman++;
			}
		}
		genderList.add(0, man);
		genderList.add(1, woman);
		return genderList;
	}
	
	public ArrayList<Integer> getAgeCount(){
		ArrayList<Integer> ageList = new ArrayList<Integer>();
		Date date = new Date();
		for(int j=0;j<10;j++){
			int result = 0;
			for(int i=0;i<list.size();i++){
					if((date.getYear()-list.get(i).getBirth().getYear())>j*10&&(date.getYear()-list.get(i).getBirth().getYear())>(j+1)*10){
						result++;
					}
				}
			ageList.add(j, result);
		}
		return ageList;
	}
	
	public ArrayList<Integer> getConsumeCount(){
		ArrayList<Integer> consumeList = new ArrayList<Integer>();
		Date date = new Date();
		int total = 0;
		for(int j=0;j<10;j++){
			int result = 0;
			for(int i=0;i<list.size();i++){
					if(list.get(i).getConsumeMoney()>=j*500&&list.get(i).getConsumeMoney()<(j+1)*500){
						result++;
						total++;
					}
				}
			consumeList.add(j, result);
		}
		consumeList.add(list.size()-total);
		return consumeList;
	}
	
	public ArrayList<Integer> getCardCount(){
		int valid = 0;
		int pause = 0;
		int stop = 0;
		
		ArrayList<Integer> cardList = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getStatus().equals("VALID")){
				valid++;
			}else if(list.get(i).getStatus().equals("PAUSE")){
				pause++;
			}else if(list.get(i).getStatus().equals("STOP")){
				stop++;
			}
		}
		cardList.add(0, valid);
		cardList.add(1, pause);
		cardList.add(2, stop);
		return cardList;
	}
	
	
}
