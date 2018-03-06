package edu.nju.dessertHouse.action;

import java.text.ParseException;
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
import edu.nju.dessertHouse.model.DessertList;
import edu.nju.dessertHouse.model.SalePlan;
import edu.nju.dessertHouse.model.SaleRec;
import edu.nju.dessertHouse.model.SaleRecList;
import edu.nju.dessertHouse.model.User;
import edu.nju.dessertHouse.model.SalePlanList;
import edu.nju.dessertHouse.service.UserService;

@Controller
public class ShoppingAction extends BaseAction {
	private static final long serialVersionUID = 1L;
//	private static ApplicationContext applicationContext;
	Branch branch = new Branch();
	VIPCard level = new VIPCard();
//	private  dessert;
//	private SalePlan salePlan;
	SaleRec saleRec = new SaleRec();
	SaleRecList saleRecList = new SaleRecList();
    Customer customer;
   @Autowired
    UserService userService ;
   
   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingAction(){
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String execute(){
    	return null;
		}
    
    @SuppressWarnings("unchecked")
	public String shoppingSearch(){
    	DessertList dessertList = new DessertList();
    	SalePlanList salePlanList = new SalePlanList();
    	branch = userService.getBranchByName(request.getParameter("branchSearch"));
    	salePlanList.setList((ArrayList<SalePlan>) userService.getPlanByValidBranch(branch, "VALID"));
    	for(int i = 0;i<salePlanList.getList().size();i++){
			dessertList.add(userService.getDessert(salePlanList.getSalePlan(i).getDessert()));
		}
    	session.put("dessertList",dessertList);
    	session.put("planShopping",salePlanList);
    	return "success";
    }
    
    public String toInput(){
    	Dessert dessert = new Dessert();
    	SalePlan salePlan = new SalePlan();
    	salePlan = ((SalePlanList)session.get("planShopping")).getSalePlan(Integer.parseInt(request.getParameter("salePlan")));
    	dessert = userService.getDessertByName(request.getParameter("dessert"));
    	session.put("dessertShopping",dessert);
    	session.put("shoppingDet",salePlan);
    	return "success";
    	
    }
    
    public String toConfirm(){
//    	user = (User)session.get("user");
//    	System.out.println(user);
//    	branch = user.getBranch();
    	branch = ((SalePlan)session.get("shoppingDet")).getBranch();
    	saleRec.setBranch(branch);
    	saleRec.setAddress(request.getParameter("address"));
    	int num = Integer.parseInt(request.getParameter("num"));
    	saleRec.setNum(num);
    	int price = Integer.parseInt(((SalePlan)session.get("shoppingDet")).getPrice());
//    	saleRec.setWaiter(user);
    	int id = 0;
    	id = userService.getBiggistSaleRecId();
    	saleRec.setId(id);
    	Dessert dessert = new Dessert();
    	dessert = ((Dessert)session.get("dessertShopping"));
    	saleRec.setDessert(dessert);
    	Date date  = new Date();
    	try {
			date=dateFormat.parse(request.getParameter("date")+" 00:00:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	saleRec.setDate(dateFormat.format(date));
		    	customer = (Customer)session.get("customer");
		    	saleRec.setCustomer(customer);
		    	saleRec.setPayType("CARD-NET");
		    	saleRec.setTotalMoney(Integer.toString((int)(num*price*level.discount(customer.getLevel()))));
    	
    	int totalPrice = num*price;
    	session.put("originalCost", totalPrice);
    	session.put("shoppingConfirm",saleRec);
    	
    	return "success";
    }
    
    public String confirm(){
    	saleRec.setStatus("RESERVE");
    	customer = (Customer)session.get("customer");
    	customer.setMoney(customer.getMoney()-Integer.parseInt(saleRec.getTotalMoney()));
    	customer.setPoint(customer.getPoint()+(Integer.parseInt(saleRec.getTotalMoney())/10));
    	customer.setConsumeMoney(customer.getConsumeMoney()+Integer.parseInt(saleRec.getTotalMoney()));
    	userService.updateCustomer(customer);
    	userService.saveSaleRec(saleRec);
    	saleRecList = new SaleRecList();
    	saleRecList.setList((ArrayList<SaleRec>)userService.getSaleRecByCustomer(customer));
    	session.put("saleRecList", saleRecList);
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
