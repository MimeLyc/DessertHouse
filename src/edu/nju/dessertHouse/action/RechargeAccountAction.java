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
public class RechargeAccountAction extends BaseAction {
	private static final long serialVersionUID = 1L;
//	private static ApplicationContext applicationContext;
    Customer customer;
   @Autowired
    UserService userService ;
   
   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechargeAccountAction() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String execute(){
    	VIPCard card = new VIPCard();
    	Date date = new Date();
    	customer = (Customer) session.get("customer");
			if(request.getParameter("recharge").equals("")==false){
				customer.setMoney(customer.getMoney()+Integer.parseInt(request.getParameter("recharge")));
				customer.setAllMoney(customer.getAllMoney()-Integer.parseInt(request.getParameter("recharge")));
				customer.setLevel(card.judgeLevel(Integer.parseInt(request.getParameter("recharge")), customer.getLevel()));
				customer.setActTime(dateFormat.format(date));
				if(customer.getStatus().equals("PAUSE")&&customer.getConsumeMoney()==0&&Integer.parseInt(request.getParameter("recharge"))>=200){
					customer.setStatus("VALID");
				}else if(customer.getStatus().equals("PAUSE")&&customer.getConsumeMoney()!=0){
					customer.setStatus("VALID");
				}
			}

			userService.updateCustomer(customer);
			
//			session.put("customer", customer);
			System.out.println(customer.getId());
			System.out.println(customer.getBankCard());
			session.put("customer", customer);
			return "success";

    	
    }
    
    public String pointTrans(){
    	customer = (Customer) session.get("customer");
    	customer.setMoney(customer.getMoney()+customer.getPoint());
    	customer.setPoint(0);
    	userService.updateCustomer(customer);
    	return "success";
    }
    
    public void setCustomer(Customer customer){
    	this.customer = customer;
    }
    
    public Customer getCustomer(){
    	return this.customer;
    }


}

