package edu.nju.dessertHouse.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.nju.dessertHouse.model.Branch;
import edu.nju.dessertHouse.model.Customer;
import edu.nju.dessertHouse.model.Dessert;
import edu.nju.dessertHouse.model.SalePlan;
import edu.nju.dessertHouse.model.SaleRec;
import edu.nju.dessertHouse.model.SaleRecList;
import edu.nju.dessertHouse.model.User;
import edu.nju.dessertHouse.model.SalePlanList;
import edu.nju.dessertHouse.service.UserService;

@Controller
public class SaleAction extends BaseAction {
	private static final long serialVersionUID = 1L;
//	private static ApplicationContext applicationContext;
	User user;
	Branch branch;
	VIPCard level = new VIPCard();
//	private  dessert;
//	private SalePlan salePlan;
	SaleRec saleRec = new SaleRec();
	SaleRecList saleRecList = new SaleRecList();
	
    Customer customer;
   @Autowired
    UserService userService ;
   
   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaleAction() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String execute(){
    	return null;
		}
    
    @SuppressWarnings("unchecked")
	public String toInput(){
    	Dessert dessert = new Dessert();
    	SalePlan salePlan = new SalePlan();
    	salePlan = ((SalePlanList)session.get("salePlanList")).getSalePlan(Integer.parseInt(request.getParameter("salePlan")));
    	dessert = userService.getDessertByName(request.getParameter("dessert"));
    	session.put("dessertSale",dessert);
    	session.put("planSale",salePlan);
    	return "success";
    }
    
    public String inputMessage(){
    	user = (User)session.get("user");
    	System.out.println(user);
    	branch = user.getBranch();
    	saleRec.setBranch(branch);
    	saleRec.setAddress(branch.getAddress());
    	System.out.println(branch.getAddress());
    	Date date = new Date();
    	int num = Integer.parseInt(request.getParameter("num"));
    	saleRec.setNum(num);
    	int price = Integer.parseInt(((SalePlan)session.get("planSale")).getPrice());
    	saleRec.setWaiter(user);
    	int id = 0;
    	id = userService.getBiggistSaleRecId();
    	saleRec.setId(id);
    	Dessert dessert = new Dessert();
    	dessert = ((Dessert)session.get("dessertSale"));
    	saleRec.setDessert(dessert);
    	saleRec.setDate(dateFormat.format(date));
    	System.out.println(request.getParameter("customerID")+"???");
    	if(request.getParameter("customerID").equals("")==false){
		    	customer = userService.getCustomerInfo(request.getParameter("customerID"));
		    	saleRec.setCustomer(customer);
		    	saleRec.setPayType("CARD");
		    	saleRec.setTotalMoney(Integer.toString((int)(num*price*level.discount(customer.getLevel()))));
    	}else{
		    	customer = null;
		    	saleRec.setCustomer(customer);
		    	saleRec.setPayType("CASH");
		    	saleRec.setTotalMoney(Integer.toString(num*price));
    	}
    	int totalPrice = num*price;
    	session.put("originalCost", totalPrice);
    	session.put("saleConfirm",saleRec);
    	
    	return "success";
    }
    
    public String confirm(){
    	saleRec.setStatus("PAYED");
    	if(customer!=null){
    	customer.setMoney(customer.getMoney()-Integer.parseInt(saleRec.getTotalMoney()));
    	customer.setPoint(customer.getPoint()+(Integer.parseInt(saleRec.getTotalMoney())/10));
    	customer.setConsumeMoney(customer.getConsumeMoney()+Integer.parseInt(saleRec.getTotalMoney()));
    	userService.updateCustomer(customer);
    	}
    	userService.saveSaleRec(saleRec);
    	return "success";
    }
    
    public String dealReserve(){
    	user = (User)session.get("user");
    	saleRec = userService.loadSaleRec(Integer.parseInt(request.getParameter("reserveId")));
    	saleRec.setStatus("RESERVE-PAYED");
//    	saleRec.setWaiter(user);
    	userService.updateSaleRec(saleRec);
    	saleRecList.setList((ArrayList<SaleRec>)userService.getReserveByBranch(user.getBranch()));
		session.put("reserveList", saleRecList);
    	return "success";
    }

    public void setCustomer(Customer customer){
    	this.customer = customer;
    }
    
    public Customer getCustomer(){
    	return this.customer;
    }
    
    
    public void setSaleRec(SaleRec saleRec){
    	this.saleRec = saleRec;
    }
    
    public SaleRec getSaleRec(){
    	return this.saleRec;
    }


}
