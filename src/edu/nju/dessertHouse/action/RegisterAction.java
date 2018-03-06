package edu.nju.dessertHouse.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.nju.dessertHouse.model.Branch;
import edu.nju.dessertHouse.model.BranchList;
import edu.nju.dessertHouse.model.ClerkList;
import edu.nju.dessertHouse.model.Customer;
import edu.nju.dessertHouse.model.Dessert;
import edu.nju.dessertHouse.model.DessertList;
import edu.nju.dessertHouse.model.SalePlan;
import edu.nju.dessertHouse.model.SalePlanList;
import edu.nju.dessertHouse.model.SaleRec;
import edu.nju.dessertHouse.model.SaleRecList;
import edu.nju.dessertHouse.service.UserService;

@Controller
public class RegisterAction extends BaseAction {
	private static final long serialVersionUID = 1L;
//	private static ApplicationContext applicationContext;
	
	SalePlanList salePlanList = new SalePlanList();
	BranchList storeList = new BranchList();
	ClerkList clerkList = new ClerkList();
	DessertList dessertList = new DessertList();
	SaleRecList saleRecList = new SaleRecList();
    Branch branch = new Branch();
    Customer customer;
   @Autowired
    UserService userService ;
   
   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAction() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String execute(){
		Random random = new Random();
		String id;
		if(request.getParameter("passwordOne").equals(request.getParameter("passwordTwo"))==false){
			return "fail";
		}else{
			int tempId = random.nextInt(9999999);
			id =this.modifyId(Integer.toString(tempId));
			while(userService.getCustomerInfo(id)!=null){
				tempId = random.nextInt(9999999);
				id =this.modifyId(Integer.toString(tempId));
			}
			Date date = new Date();
			String actTime = dateFormat.format(date);
			customer.setId(id);
			customer.setActTime(actTime);
			customer.setMoney(0);
			customer.setAllMoney(0);
			customer.setRegisterTime(actTime);
			customer.setLevel(0);
			customer.setGender(request.getParameter("gender"));
			customer.setStatus("PAUSE");
			customer.setPassword(request.getParameter("passwordOne"));
			customer.setPoint(0);
			userService.saveCustomer(customer);
			
			
			
			branch = userService.getBranchByName("dessertC");
			salePlanList.setList((ArrayList<SalePlan>) userService.getPlanByValidBranch(branch, "VALID"));
			for(int i = 0;i<salePlanList.getList().size();i++){
				dessertList.add(userService.getDessert(salePlanList.getSalePlan(i).getDessert()));
			}
//			dessertList.setList((ArrayList<Dessert>) userService.getAllDessert());
			
			saleRecList.setList((ArrayList<SaleRec>)userService.getSaleRecByCustomer(customer));
			session.put("dessertList", dessertList);
			session.put("planShopping",salePlanList);
			session.put("customer", customer);
			session.put("saleRecList", saleRecList);
//			session.put("customer", customer);
			System.out.println(customer.getId());
			System.out.println(customer.getBankCard());
			
			System.out.println(userService.getCustomerInfo(id).getName());
			return "success";
		}
    	
    }
    
    private String modifyId(String tempId){
    	String result = tempId;
    	while(result.length()<7){
    		result = "0"+result;
    	}
    	return result;
    }
    
    public void setCustomer(Customer customer){
    	this.customer = customer;
    }
    
    public Customer getCustomer(){
    	return this.customer;
    }


}
