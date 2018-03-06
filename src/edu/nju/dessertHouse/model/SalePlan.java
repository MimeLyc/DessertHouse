package edu.nju.dessertHouse.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import edu.nju.dessertHouse.enumP.SalePlanStatus;

@Entity
@Table(name="saleplan")
public class SalePlan   implements Serializable{
	@Id
	private int id;
	@Column(name="dessertId")
	private String dessert;
	@Column(name="planID")
	private String planID;
	@Column(name="num")
	private int num;
	@Column(name="price")
	private String price;
	@Column(name="status")
	private String status;
	@ManyToOne(cascade={ CascadeType.ALL })
	 @JoinColumn(name="branch")
	private Branch branch;
	@Column(name="beginDate")
	private Date beginDate;
	@Column(name="endDate")
	private Date endDate;
	
	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return this.id;
	}
	
	public void setDessert(String dessert){
		this.dessert = dessert;
	}

	public String getDessert(){
		return this.dessert;
	}
	
	public void setPlanID(String planID){
		this.planID = planID;
	}

	public String getPlanID(){
		return this.planID;
	}
	
	public void setNum(int num){
		this.num = num;
	}

	public int getNum(){
		return this.num;
	}
	
	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return this.price;
	}
	
	public void setStatus(String status){
		this.status = status.toUpperCase();
	}

	public String getStatus(){
		return this.status;
	}
	
	public void setBranch(Branch branch){
		this.branch = branch;
	}

	public Branch getBranch(){
		return this.branch;
	}
	
	public void setBeginDate(String beginDate){
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
			this.beginDate = dateFormat.parse(beginDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Date getBeginDate(){
		return this.beginDate;
	}
	
	public void setEndDate(String endDate){
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
			this.endDate = dateFormat.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Date getEndDate(){
		return this.endDate;
	}
}
