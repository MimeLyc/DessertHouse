package edu.nju.dessertHouse.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User  implements Serializable{
	
	@Id
	private String id;
	@Column(name="password")
	private String password;
	@Column(name="type")
	private String type;
	@ManyToOne(cascade={ CascadeType.ALL })
	 @JoinColumn(name="branch")
	private Branch branch;
	@Column(name="name")
	private String name;
	@Column(name="registerTime")
	private Date registerTime;
	
	 @OneToMany(cascade={ CascadeType.ALL },fetch=FetchType.LAZY,mappedBy="waiter")
	 private List<SaleRec> saleRec = new ArrayList<SaleRec>();
	
	
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return this.id;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public String getType(){
		return this.type;
	}
	
	public void setBranch(Branch branch){
		this.branch = branch;
	}
	
	public Branch getBranch(){
		return this.branch;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setRegisterTime(String time){
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			this.registerTime = dateFormat.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Date getRegisterTime(){
		return this.registerTime;
	}
	
	public void setSaleRec(List<SaleRec> saleRec){
		this.saleRec = saleRec;
	}
	
	public List<SaleRec> getSaleRec(){
		return this.saleRec;
	}

}
