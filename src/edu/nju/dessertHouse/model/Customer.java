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
@Table(name="customer")
public class Customer  implements Serializable{
	
	@Id
	private String id;
	@Column(name="password")
	private String password;
	@Column(name="bankcard")
	private String bankCard;
	@Column(name="money")
	private int money;
	@Column(name="allmoney")
	private int allMoney;
	@Column(name="status")
	private String status;
	@Column(name="acttime")
	private Date actTime;
	@Column(name="registertime")
	private Date registerTime;
	@Column(name="name")
	private String name;
	@Column(name="level")
	private int level;
	@Column(name="birth")
	private Date birth;
	@Column(name="gender")
	private String gender;
	@Column(name="address")
	private String address;
	@Column(name="point")
	private int point;
	@Column(name="consumeMoney")
	private int consumeMoney;
	
	 @OneToMany(cascade={ CascadeType.ALL },fetch=FetchType.LAZY,mappedBy="customer")
	 private List<SaleRec> saleRec = new ArrayList<SaleRec>();
	
//	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	
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
	
	public void setBankCard(String bankCard){
		this.bankCard = bankCard;
	}
	
	public String getBankCard(){
		return this.bankCard;
	}
	
	public void setMoney(int money){
		this.money = money;
	}
	
	public int getMoney(){
		return this.money;
	}
	
	public void setAllMoney(int allMoney){
		this.allMoney = allMoney;
	}
	
	public int getAllMoney(){
		return this.allMoney;
	}
	
	public void setStatus(String status){
		this.status = status;
	}
	
	public String getStatus(){
		return this.status;
	}
	
	public void setActTime(String actTime){
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			this.actTime = dateFormat.parse(actTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Date getActTime(){
		return this.actTime;
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
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setLevel(int level){
		this.level = level;
	}
	
	public int getLevel(){
		return this.level;
	}
	
	public void setBirth(String birth){
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
			this.birth = dateFormat.parse(birth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Date getBirth(){
		return this.birth;
	}
	
	public void setGender(String gender){
		this.gender = gender.toUpperCase();
	}
	
	public String getGender(){
		return this.gender;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public void setPoint(int point){
		this.point = point;
	}
	
	public int getPoint(){
		return this.point;
	}
	
	public void setConsumeMoney(int consumnMoney){
		this.consumeMoney = consumnMoney;
	}
	
	public int getConsumeMoney(){
		return this.consumeMoney;
	}

	public void setSaleRec(List<SaleRec> saleRec){
		this.saleRec = saleRec;
	}
	
	public List<SaleRec> getSaleRec(){
		return this.saleRec;
	}
	
	
}
