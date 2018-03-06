package edu.nju.dessertHouse.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dessert")
public class Dessert   implements Serializable {
	
	@Id
	private String id;
	@Column(name="name")
	private String name;
	@Column(name="img")
	private String img;
	
//	 @OneToMany(cascade={ CascadeType.ALL })
//	 @JoinColumn(name="dessertID")
//	 private List<SalePlan> salePlan = new ArrayList<SalePlan>();
	 
	 @OneToMany(cascade={ CascadeType.ALL })
	 @JoinColumn(name="dessertID")
	 private List<SaleRec> saleRec = new ArrayList<SaleRec>();
	 
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
	

	
	public void setImg(String img){
		this.img = img;
	}
	
	public String getImg(){
		return this.img;
	}
	
//	public void setSalePlan(List<SalePlan> salePlan){
//		this.salePlan = salePlan;
//	}
//	
//	public List<SalePlan> getSalePlan(){
//		return this.salePlan;
//	}
	
	public void setSaleRec(List<SaleRec> saleRec){
		this.saleRec = saleRec;
	}
	
	public List<SaleRec> getSaleRec(){
		return this.saleRec;
	}
	

}
