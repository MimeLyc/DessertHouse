package edu.nju.dessertHouse.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.nju.dessertHouse.model.Branch;
import edu.nju.dessertHouse.model.BranchList;
import edu.nju.dessertHouse.model.Customer;
import edu.nju.dessertHouse.service.UserService;

@Controller
public class AddStoreAction extends BaseAction {
	private static final long serialVersionUID = 1L;
//	private static ApplicationContext applicationContext;
    Branch branch;
    BranchList branchList;
   @Autowired
    UserService userService ;
   
   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStoreAction() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String execute(){
    	branch = new Branch();
    		branchList = (BranchList)session.get("storeList");
    		System.out.println(branchList.getList().size());
    		branch.setId(Integer.toString(branchList.getBiggistId()+1));
    		branch.setName(request.getParameter("name"));
    		branch.setAddress(request.getParameter("address"));

			userService.saveBranch(branch);
//			session.put("customer", customer);
			branchList.add(branch);
			session.put("storeList", branchList);
			return "success";

    	
    }
    
    
    public void setBranch(Branch branch){
    	this.branch = branch;
    }
    
    public Branch getBranch(){
    	return this.branch;
    }


}

