package edu.nju.dessertHouse.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.nju.dessertHouse.model.Customer;
import edu.nju.dessertHouse.service.UserService;

@Controller
public class CusChangeInfoAction extends BaseAction {
	private static final long serialVersionUID = 1L;
//	private static ApplicationContext applicationContext;
    Customer customer;
   @Autowired
    UserService userService ;
   
   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CusChangeInfoAction() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String execute(){
    	customer = (Customer) session.get("customer");
			if(request.getParameter("password").equals("")==false){
				System.out.println(request.getParameter("password"));
				customer.setPassword(request.getParameter("password"));
			}
			if(request.getParameter("address").equals("")==false){
				customer.setAddress(request.getParameter("address"));
			}
			if(request.getParameter("name").equals("")==false){
				customer.setName(request.getParameter("name"));
			}
			userService.updateCustomer(customer);
			
//			session.put("customer", customer);
			System.out.println(customer.getId());
			System.out.println(customer.getBankCard());
			session.put("customer", customer);
			return "success";

    	
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
