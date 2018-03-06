package edu.nju.dessertHouse.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Random;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.nju.dessertHouse.model.Branch;
import edu.nju.dessertHouse.model.BranchList;
import edu.nju.dessertHouse.model.ClerkList;
import edu.nju.dessertHouse.model.Customer;
import edu.nju.dessertHouse.model.User;
import edu.nju.dessertHouse.service.UserService;

@Controller
public class DeleteClerkAction extends BaseAction {
	private static final long serialVersionUID = 1L;
//	private static ApplicationContext applicationContext;
    Branch branch;
    User user;
    ClerkList clerkList;
   @Autowired
    UserService userService ;
   
   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteClerkAction() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String execute(){

    		clerkList = (ClerkList)session.get("clerkList");
    		Enumeration pNames=request.getParameterNames();
    		System.out.println(clerkList.getList().size());
    		while(pNames.hasMoreElements()){
    		    String id=(String)pNames.nextElement();
    		    System.out.println(id+"??");
    		    userService.deleteClerk(id);
    		    System.out.println(id+"???");
    		}
    		clerkList = new ClerkList();
    		clerkList.setList((ArrayList<User>)userService.getAllClerk());
//			session.put("customer", customer);
			session.put("clerkList", clerkList);
			return "success";

    	
    }
    
    
    public void setUser(User user){
    	this.user = user;
    }
    
    public User getUser(){
    	return this.user;
    }


}

