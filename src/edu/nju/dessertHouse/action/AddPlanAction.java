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
import edu.nju.dessertHouse.model.Dessert;
import edu.nju.dessertHouse.model.DessertList;
import edu.nju.dessertHouse.model.SalePlan;
import edu.nju.dessertHouse.model.SalePlanList;
import edu.nju.dessertHouse.model.User;
import edu.nju.dessertHouse.service.UserService;

@Controller
public class AddPlanAction extends BaseAction {
	private static final long serialVersionUID = 1L;
//	private static ApplicationContext applicationContext;
	private String branchm;
	private String[] chkDessert;
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
    public AddPlanAction() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String execute(){
	    	branch = new Branch();
	    	salePlan = new SalePlan();
	    	salePlanList = new SalePlanList();
	    	dessertList = (DessertList)session.get("session");
    		Date date = new Date();
			int id;
			id=userService.getBiggistPlanId();
			System.out.println(id);
			if(id==-1){
				id = 0;
			}else{
				id = id+1;
			}
			salePlan.setPlanID(Integer.toString(id));
			salePlan.setBeginDate(request.getParameter("beginDatem"));
			salePlan.setEndDate(request.getParameter("endDatem"));
			Branch branch = userService.getBranchByName(branchm);
			salePlan.setBranch(branch);
			 for(int i=0;i<this.getChkDessert().length;i++){  
	                String chkDessertValue=this.getChkDessert()[i];  
	                //TODO通过dessertName获得dessertId,并获得单价和数量后存储
	                System.out.println(chkDessertValue+"addplanACTION");
	               String price = request.getParameter(chkDessertValue+":p");
	               String number = request.getParameter(chkDessertValue+":n");
	               String getDessertByName = userService.getDessertByName(chkDessertValue).getId();
	   				salePlan.setId(userService.getIdOfPlan()+1);
	               salePlan.setDessert(getDessertByName);
	               salePlan.setNum(Integer.parseInt(number));
	               salePlan.setPrice(price);
	               salePlan.setStatus("uncheck");
	               userService.saveSalePlan(salePlan);
			 }  
	    		salePlanList.setList((ArrayList<SalePlan>) userService.getAllSalePlan());
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
				session.put("salePlanList", uniqSalePlanList);
			return "success";

    	
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
    
    public String[] getChkDessert(){  
        return chkDessert;  
        }  
     public void setChkDessert(String[] chkDessert){  
        this.chkDessert=chkDessert;  
        }  
     
     public String getBranchm(){  
         return branchm;  
         }  
      public void setBranchm(String branchm){  
         this.branchm = branchm;  
         }  


}

