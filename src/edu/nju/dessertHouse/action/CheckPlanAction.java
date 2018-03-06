package edu.nju.dessertHouse.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
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
import edu.nju.dessertHouse.model.User;
import edu.nju.dessertHouse.service.UserService;

@Controller
public class CheckPlanAction extends BaseAction {
	private static final long serialVersionUID = 1L;
//	private static ApplicationContext applicationContext;
	DessertList dessertList;
	SalePlanList salePlanList;
	SalePlan salePlan;
    Branch branch;
    User user;
    BranchList branchList;
   @Autowired
    UserService userService ;
   
   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckPlanAction() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String execute(){
	    	branch = new Branch();
	    	salePlan = new SalePlan();
	    	salePlanList = new SalePlanList();
	    	user = (User) session.get("user");
	    	List<String> dessertInfo = new ArrayList<String>();
    		Date date = new Date();
    		Enumeration pNames=request.getParameterNames();
    		while(pNames.hasMoreElements()){
    		    String id=(String)pNames.nextElement();
    		    System.out.println(id+"??");
    		    salePlan = userService.getSalePlanByPlanId(id);
    		    dessertInfo = userService.getDessertInfoByPlanId(id);
    		    session.put("salePlanInfo",salePlan);
    		    String dessertPlanInfo="";
    		    for(int i=0;i<dessertInfo.size();i++){
    		    	dessertPlanInfo=dessertPlanInfo+"|"+dessertInfo.get(i);
    		    }
    		    dessertPlanInfo = dessertPlanInfo.substring(1);
    		    System.out.println(dessertPlanInfo);
    		    session.put("dessertPlanInfo",dessertPlanInfo);
    		    System.out.println(id+"???");
    		}
    		
    		if(user.getType().equals("centerManager")){
    			
    			return "centerManager";
    		}else if(user.getType().equals("manager")){
    			return "manager";
    		}
    		return null;

    	
    }
    
			    private String modifyId(String tempId){
			    	String result = tempId;
			    	while(result.length()<6){
			    		result = "0"+result;
			    	}
			    	return result;
			    }
    public void setUser(User user){
    	this.user = user;
    }
    
    public User getUser(){
    	return this.user;
    }
    
    public void setBranchList(BranchList branchList){
    	this.branchList = branchList;
    }
    
    public BranchList getBranchList(){
    	return this.branchList;
    }
    


}

