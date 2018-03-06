package edu.nju.dessertHouse.action;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.nju.dessertHouse.model.Customer;
import edu.nju.dessertHouse.service.UserService;


@Controller
public class CusStatusDownAction extends BaseAction {
	private static final long serialVersionUID = 1L;
//	private static ApplicationContext applicationContext;
    Customer customer;
   @Autowired
    UserService userService ;
   
   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CusStatusDownAction() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String execute(){
    	customer = (Customer) session.get("customer");
			
			customer.setStatus("NONE");
			userService.updateCustomer(customer);
			
			session.put("customer", customer);
			return "success";

    	
    }
    
    public void setCustomer(Customer customer){
    	this.customer = customer;
    }
    
    public Customer getCustomer(){
    	return this.customer;
    }

}
