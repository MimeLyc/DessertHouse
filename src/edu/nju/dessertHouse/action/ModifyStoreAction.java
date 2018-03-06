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
import edu.nju.dessertHouse.model.Customer;
import edu.nju.dessertHouse.service.UserService;

@Controller
public class ModifyStoreAction extends BaseAction {
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
    public ModifyStoreAction() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String execute(){
    		branch = new Branch();
    		branchList = (BranchList)session.get("storeList");
    		Enumeration pNames=request.getParameterNames();
    		System.out.println(branchList.getList().size());
    		while(pNames.hasMoreElements()){
    		    String id=(String)pNames.nextElement();
//    		    System.out.println(id+"??");
//    		    userService.deleteBranch(id);
//    		    System.out.println(id+"???");
    		    session.put("storeToChange",userService.getBranch(id));
    		}
//    		branchList = new BranchList();
//    		branchList.setList((ArrayList<Branch>)userService.getAllBranch());
////			session.put("customer", customer);
//			session.put("storeList", branchList);
			return "success";

    	
    }
    
    public String confirmModity(){
    	branch = new Branch();
    	branch = (Branch) session.get("storeToChange");
    	branch.setAddress(request.getParameter("address"));
    	branch.setName(request.getParameter("name"));
    	userService.updateBranch(branch);
    	
		branchList = new BranchList();
		branchList.setList((ArrayList<Branch>)userService.getAllBranch());
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

