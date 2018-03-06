package edu.nju.dessertHouse.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.FetchType;

//import edu.nju.dessertHouse.enumP.Gender;

@Entity
@Table(name="branch")
public class Branch  implements Serializable{
	
	@Id
	private String id;
	@Column(name="name")
	private String name;
	@Column(name="address")
	private String address;

	 @OneToMany(cascade={ CascadeType.ALL },fetch=FetchType.LAZY,mappedBy="branch")
	 private List<SalePlan> salePlan = new ArrayList<SalePlan>();
	
	 @OneToMany(cascade={ CascadeType.ALL },fetch=FetchType.LAZY,mappedBy="branch")
	 private List<SaleRec> saleRec = new ArrayList<SaleRec>();
	 
	 @OneToMany(cascade={ CascadeType.ALL },fetch=FetchType.LAZY,mappedBy="branch")
	 private List<User> user = new ArrayList<User>();
	
//	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return this.id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public void setSalePlan(List<SalePlan> salePlan){
		this.salePlan = salePlan;
	}
	
	public List<SalePlan> getSalePlan(){
		return this.salePlan;
	}

	public void setSaleRec(List<SaleRec> saleRec){
		this.saleRec = saleRec;
	}
	
	public List<SaleRec> getSaleRec(){
		return this.saleRec;
	}
	
	public void setUser(List<User> user){
		this.user = user;
	}
	
	public List<User> getUser(){
		return this.user;
	}
	
}
