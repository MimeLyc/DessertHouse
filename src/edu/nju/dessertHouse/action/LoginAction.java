package edu.nju.dessertHouse.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import edu.nju.dessertHouse.model.Customer;
import edu.nju.dessertHouse.model.CustomerList;
import edu.nju.dessertHouse.model.Dessert;
import edu.nju.dessertHouse.model.DessertList;
import edu.nju.dessertHouse.model.SalePlan;
import edu.nju.dessertHouse.model.SalePlanList;
import edu.nju.dessertHouse.model.SaleRec;
import edu.nju.dessertHouse.model.SaleRecList;
import edu.nju.dessertHouse.model.Branch;
import edu.nju.dessertHouse.model.BranchList;
import edu.nju.dessertHouse.model.User;
import edu.nju.dessertHouse.model.ClerkList;
import edu.nju.dessertHouse.service.UserService;
import edu.nju.dessertHouse.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginBussiness
 */
@Controller
public class LoginAction extends BaseAction {
	private static final long serialVersionUID = 1L;
//	private static ApplicationContext applicationContext;
	SalePlanList salePlanList = new SalePlanList();
	BranchList storeList = new BranchList();
	ClerkList clerkList = new ClerkList();
	DessertList dessertList = new DessertList();
	SaleRecList saleRecList = new SaleRecList();
	List<User> userList = new ArrayList<User>();
	CustomerList customerList = new CustomerList();
    Customer customer;
    Branch branch = new Branch();
    User user;
   @Autowired
    UserService userService ;
   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
   /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String execute(){
		boolean login;
		this.setMonday();
		this.setPlanStatus();
		if(request.getParameter("id").split("")[0].equals("s")){
			
			
			login = userService.valideUser(request.getParameter("id"), request.getParameter("password"));
			System.out.println(login+"what???");
			if(login == true){
				user = userService.getUserInfo(request.getParameter("id"));
				storeList.setList((ArrayList<Branch>) userService.getAllBranch());
				clerkList.setList((ArrayList<User>) userService.getAllClerk());
				System.out.println(user.getName()+"??");
				session.put("user", user);
				session.put("storeList", storeList);
				session.put("clerkList",clerkList);
				return "systemmanager";
			}else{
				return "falt";
			}
		
		
		}else if(request.getParameter("id").split("")[0].equals("c")){
			
			
			login = userService.valideUser(request.getParameter("id"), request.getParameter("password"));
			if(login == true){
				user = userService.getUserInfo(request.getParameter("id"));
				storeList.setList((ArrayList<Branch>) userService.getAllBranch());
				clerkList.setList((ArrayList<User>) userService.getAllClerk());
				dessertList.setList((ArrayList<Dessert>) userService.getAllDessert());
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
				System.out.println(user.getName()+"??");
				session.put("user", user);
				session.put("storeList", storeList);
				session.put("clerkList",clerkList);
				session.put("dessertList", dessertList);
				session.put("salePlanList", uniqSalePlanList);
				return "centerManager";
			}else{
				return "falt";
			}
		
		
		}else if(request.getParameter("id").split("")[0].equals("m")){
			
			
			login = userService.valideUser(request.getParameter("id"), request.getParameter("password"));
			if(login == true){
				user = userService.getUserInfo(request.getParameter("id"));
				
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
				session.put("user", user);
				session.put("storeList", storeList);
				session.put("clerkList",clerkList);
				session.put("dessertList", dessertList);
				session.put("salePlanList", uniqSalePlanList);
				customerList.setList((ArrayList<Customer>)userService.getAllCustomer());
				saleRecList = new SaleRecList();
				saleRecList.setList((ArrayList<SaleRec>) userService.getAllSaleRec());
				saleRecList.setDessertList((ArrayList<Dessert>) dessertList.getList());
				session.put("customerList", customerList);
				session.put("saleRecList",saleRecList);
				storeList = new BranchList();
				storeList.setList((ArrayList<Branch>) userService.getAllBranch());
				session.put("storeList", storeList);
				return "manager";
			}else{
				return "falt";
			}
		
		
		}else if(request.getParameter("id").split("")[0].equals("b")){
			
			
			login = userService.valideUser(request.getParameter("id"), request.getParameter("password"));
			if(login == true){
				user = userService.getUserInfo(request.getParameter("id"));
				branch = user.getBranch();
				salePlanList.setList((ArrayList<SalePlan>) userService.getPlanByValidBranch(branch, "VALID"));
				for(int i = 0;i<salePlanList.getList().size();i++){
					dessertList.add(userService.getDessert(salePlanList.getSalePlan(i).getDessert()));
				}
				
				saleRecList.setList((ArrayList<SaleRec>) userService.getReserveByBranch(user.getBranch()));
				session.put("reserveList", saleRecList);
				session.put("user", user);
				session.put("dessertList", dessertList);
				session.put("salePlanList", salePlanList);
				return "branchManager";
			}else{
				return "falt";
			}
		
		
		}else{
			login = userService.valideCustomer(request.getParameter("id"), request.getParameter("password"));
			if(login == true){
					branch = userService.getBranchByName("dessertC");
				salePlanList.setList((ArrayList<SalePlan>) userService.getPlanByValidBranch(branch, "VALID"));
				for(int i = 0;i<salePlanList.getList().size();i++){
					dessertList.add(userService.getDessert(salePlanList.getSalePlan(i).getDessert()));
				}
//				dessertList.setList((ArrayList<Dessert>) userService.getAllDessert());
				
				customer = userService.getCustomerInfo(request.getParameter("id"));
				Date date  = new Date();
		        Date lastAct = customer.getActTime();
		        Calendar cal = Calendar.getInstance();    
		        cal.setTime(date);    
		        long time1 = cal.getTimeInMillis();                 
		        cal.setTime(lastAct);    
		        long time2 = cal.getTimeInMillis();         
		        long between_days=(time1-time2)/(1000*3600*24);
//		 到期后余额不足则暂停
		        if(Integer.parseInt(String.valueOf(between_days))>365&&customer.getStatus().equals("VALID")&&customer.getMoney()<10){
		        	customer.setStatus("PAUSE");
		        }else if(Integer.parseInt(String.valueOf(between_days))>365&&customer.getStatus().equals("PAUSE")){
		        	customer.setStatus("STOP");
		        }
				userService.updateCustomer(customer);
				saleRecList.setList((ArrayList<SaleRec>)userService.getSaleRecByCustomer(customer));
				session.put("dessertList", dessertList);
				session.put("planShopping",salePlanList);
				session.put("customer", customer);
				session.put("saleRecList", saleRecList);
				return "customer";
			}else{
				return "falt";
			}
		}
    	
    }
    
    public void setMonday(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
    	Calendar cal = Calendar.getInstance(Locale.CHINA);
    	cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    	cal.add(Calendar.DAY_OF_MONTH,7);
    	String date = dateFormat.format(cal.getTime());
    	session.put("nextMonday", date);
    	cal.add(Calendar.DAY_OF_MONTH,7);
    	date = dateFormat.format(cal.getTime());
    	session.put("nextSunday", date);
    }
    public void setPlanStatus(){
    	
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date date = new Date();
		String actTime = dateFormat.format(date);
		SalePlanList allSalePlan = new SalePlanList();
				allSalePlan.setList((ArrayList<SalePlan>) userService.getAllSalePlan());
		for(int i = 0;i<allSalePlan.getList().size();i++){
			if(allSalePlan.getSalePlan(i).getStatus().equals("PASS")){
				if(date.before(allSalePlan.getSalePlan(i).getEndDate())&&date.after(allSalePlan.getSalePlan(i).getBeginDate())){
					allSalePlan.getSalePlan(i).setStatus("VALID");
					userService.updateSalePlan(allSalePlan.getSalePlan(i));
				}
			}else if(allSalePlan.getSalePlan(i).getStatus().equals("VALID")){
				if(date.after(allSalePlan.getSalePlan(i).getEndDate())){
					allSalePlan.getSalePlan(i).setStatus("PAST");
					userService.updateSalePlan(allSalePlan.getSalePlan(i));
				}
			}
		}
		
    }
    public void setCustomer(Customer customer){
    	this.customer = customer;
    }
    
    public Customer getCustomer(){
    	return this.customer;
    }
    
    public void setUser(User user){
    	this.user = user;
    }
    
    public User getUser(){
    	return this.user;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		System.out.println(request.getParameter("userid"));
//		boolean login = userService.valideCustomer(request.getParameter("userid"), request.getParameter("password"));
//		System.out.println(login+"(LoginBussiness)");
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
