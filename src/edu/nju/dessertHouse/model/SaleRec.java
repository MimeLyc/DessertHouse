package edu.nju.dessertHouse.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.nju.dessertHouse.enumP.PayStatus;
import edu.nju.dessertHouse.enumP.PayType;

@Entity
@Table(name="salerec")
public class SaleRec   implements Serializable{
	
	@Id
	private int id;
	@ManyToOne(cascade={ CascadeType.ALL })
	 @JoinColumn(name="customerID")
	private Customer customer;
	@ManyToOne(cascade={ CascadeType.ALL })
	 @JoinColumn(name="branch")
	private Branch branch;
	@ManyToOne(cascade={ CascadeType.ALL })
	 @JoinColumn(name="waiter")
	private User waiter;
	@ManyToOne(cascade={ CascadeType.ALL })
	 @JoinColumn(name="dessertID")
	private Dessert dessert;
	@Column(name="num")
	private int num;
	@Column(name="totalMoney")
	private String totalMoney;
	@Column(name="payType")
	private String payType;
	@Column(name="status")
	private String status;
	@Column(name="address")
	private String address;
	@Column(name="date")
	private Date date;
	
	
	
	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return this.id;
	}

	public void setCustomer(Customer customer){
		this.customer = customer;
	}
	
	public Customer getCustomer(){
		return this.customer;
	}
	
	public void setBranch(Branch branch){
		this.branch = branch;
	}
	
	public Branch getBranch(){
		return this.branch;
	}

	public void setWaiter(User waiter){
		this.waiter = waiter;
	}
	
	public User getWaiter(){
		return this.waiter;
	}
	
	public void setDessert(Dessert dessert){
		this.dessert = dessert;
	}
	
	public Dessert getDessert(){
		return this.dessert;
	}
	
	public void setNum(int num){
		this.num = num;
	}
	
	public int getNum(){
		return this.num;
	}
	
	public void setTotalMoney(String money){
		this.totalMoney = money;
	}
	
	public String getTotalMoney(){
		return this.totalMoney;
	}
	
	public void setPayType(String payType){
		this.payType = payType.toUpperCase();
	}
	
	public String getPayType(){
		return this.payType;
	}
	
	public void setStatus(String status){
		this.status = status.toUpperCase();
	}
	
	public String getStatus(){
		return this.status;
	}
	
	
	public void setAddress(String address){
		this.address =address;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public void setDate(String date){
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			this.date = dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Date getDate(){
		return this.date;
	}
}
