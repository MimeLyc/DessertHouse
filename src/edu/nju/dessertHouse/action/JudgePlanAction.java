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
public class JudgePlanAction extends BaseAction {
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
    public JudgePlanAction() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String execute(){
		return null;
    }
    
    public String passPlan(){
    	branch = new Branch();
    	salePlan = new SalePlan();
    	salePlanList = new SalePlanList();
    	dessertList = new DessertList();
    	user = (User) session.get("user");
    	salePlan = (SalePlan)session.get("salePlanInfo");
    	salePlanList.setList((ArrayList<SalePlan>) userService.getSalePlanListByPlanId(salePlan.getPlanID()));
    	for(int i=0;i<salePlanList.getList().size();i++){
    		salePlanList.getSalePlan(i).setStatus("PASS");
    		userService.updateSalePlan(salePlanList.getSalePlan(i));
    	}
    	
		dessertList.setList((ArrayList<Dessert>) userService.getAllDessert());
		salePlanList.setList((ArrayList<SalePlan>) userService.getPlanByStatus("UNCHECK"));
		SalePlanList uniqSalePlanList =new SalePlanList();
		if(salePlanList.getList()!=null){
			boolean contain = false;
			for(int i=0;i<salePlanList.getList().size();i++){
				for(int j=0;j<uniqSalePlanList.getList().size();j++){
					if(uniqSalePlanList.getList().get(j).getPlanID().equals(salePlanList.getList().get(i).getPlanID())==true){
						contain = true;
					}
				}
				if(contain ==false){
					uniqSalePlanList.getList().add(salePlanList.getList().get(i));
				}
				contain = false;
			}		
		}
		System.out.println(user.getName()+"??");
		session.put("dessertList", dessertList);
		session.put("salePlanList", uniqSalePlanList);
    	return "pass";
    }
    //²µ»Ø¼Æ»®
    public String denyPlan(){
    	branch = new Branch();
    	salePlan = new SalePlan();
    	salePlanList = new SalePlanList();
    	dessertList = new DessertList();
    	user = (User) session.get("user");
    	salePlan = (SalePlan)session.get("salePlanInfo");
    	salePlanList.setList((ArrayList<SalePlan>) userService.getSalePlanListByPlanId(salePlan.getPlanID()));
    	for(int i=0;i<salePlanList.getList().size();i++){
    		salePlanList.getSalePlan(i).setStatus("UNPASS");
    		userService.updateSalePlan(salePlanList.getSalePlan(i));
    	}
    	
		dessertList.setList((ArrayList<Dessert>) userService.getAllDessert());
		salePlanList.setList((ArrayList<SalePlan>) userService.getPlanByStatus("UNCHECK"));
		SalePlanList uniqSalePlanList =new SalePlanList();
		if(salePlanList.getList()!=null){
			boolean contain = false;
			for(int i=0;i<salePlanList.getList().size();i++){
				for(int j=0;j<uniqSalePlanList.getList().size();j++){
					if(uniqSalePlanList.getList().get(j).getPlanID().equals(salePlanList.getList().get(i).getPlanID())==true){
						contain = true;
					}
				}
				if(contain ==false){
					uniqSalePlanList.getList().add(salePlanList.getList().get(i));
				}
				contain = false;
			}		
		}
		System.out.println(user.getName()+"??");
		session.put("dessertList", dessertList);
		session.put("salePlanList", uniqSalePlanList);
    	return "deny";
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

