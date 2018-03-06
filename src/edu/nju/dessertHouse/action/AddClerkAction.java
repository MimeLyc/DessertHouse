package edu.nju.dessertHouse.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class AddClerkAction extends BaseAction {
	private static final long serialVersionUID = 1L;
//	private static ApplicationContext applicationContext;
    Branch branch;
    User user;
    BranchList branchList;
    ClerkList clerkList = new ClerkList();
   @Autowired
    UserService userService ;
   
   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClerkAction() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String execute(){
	    	branch = new Branch();
	    	branchList  =new BranchList();
    		branchList.setList(((ArrayList<Branch>)userService.getAllBranch()));//TODO
    		Date date = new Date();
			String registerTime = dateFormat.format(date);
			Random random = new Random();
			String id;
				int tempId = random.nextInt(99999);
				id =this.modifyId(Integer.toString(tempId));
			
				if(request.getParameter("type").equals("总店服务员")){
					id = "c"+id;
					while(userService.getUserInfo(id)!=null){
						tempId = random.nextInt(999999);
						id =this.modifyId(Integer.toString(tempId));
						id = "c"+id;
					}
					user.setId(id);
					user.setType("centerManager");
					user.setBranch(null);
				}else if(request.getParameter("type").equals("分店服务员")){
					id = "b"+id;
					while(userService.getUserInfo(id)!=null){
						tempId = random.nextInt(999999);
						id =this.modifyId(Integer.toString(tempId));
						id = "b"+id;
					}
					user.setId(id);
					user.setType("branchManager");
					user.setBranch(((Branch)session.get("selectBranch")));
				}else if(request.getParameter("type").equals("经理")){
					id = "m"+id;
					while(userService.getUserInfo(id)!=null){
						tempId = random.nextInt(999999);
						id =this.modifyId(Integer.toString(tempId));
						id = "m"+id;
					}
					user.setId(id);
					user.setType("manager");
					user.setBranch(null);
				}
				user.setRegisterTime(registerTime);
				userService.saveUser(user);
				
				clerkList.setList((ArrayList<User>) userService.getAllClerk());
				session.put("clerkList",clerkList);
				session.put("newUser", user);
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


}

