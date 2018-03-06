<%@ page language="java" contentType="text/html; charset=utf-8" import="edu.nju.dessertHouse.action.LoginAction,edu.nju.dessertHouse.action.ShoppingAction"%>
         <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=utf-8">
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<link href="../../dist/css/bootstrap-theme.min.css" rel="stylesheet">
    <!-- Custom CSS -->
 <!-- 	<link href="../css/mainPage.css" rel="stylesheet"> 
     -->
    <!-- Custom Fonts -->
    <link href="../css/font.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
	
		<script src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/transIframe.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="../js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body style="overflow-x:hidden;scroll:no">
			<jsp:useBean id="dessertList"
	type="edu.nju.dessertHouse.model.DessertList"
	scope="session"></jsp:useBean> 
	<jsp:useBean id="planShopping"
	type="edu.nju.dessertHouse.model.SalePlanList"
	scope="session"></jsp:useBean> 
	
         <div class="row" style="overflow: hidden;scroll:no">
        <div class="col-md-6">
        	<s:form action="shopSearch" namespace="/DessertHouse">
        		<div class="input-group">
					<input type="text" class="form-control" name = "branchSearch" placeholder="Input Shop Name">
					<span class="input-group-addon"><input type="submit" value="Search" style="border: none;height:100%;width:100%"></span>
			</div>
			</s:form>
					        <%for(int i = 0;i<planShopping.getList().size();i++) {%>
					        
					        
					          <table class="table"  style="margin:10px;width:800px" >
					          
					            <tbody>
					              <tr>
					                <td style="width:50px;height:50px"><img src="<%=dessertList.getList().get(i).getImg()%>"   style="width:150px;height:150px"/></td>
					                <td >
					                <s:form  action="toInput" namespace="/DessertHouse">
					                	<table class="table"  style="margin:0px;" >
						                		<tr>
						                			<td><h3><%=dessertList.getList().get(i).getName() %></h3></td>
						                		</tr>
						                		 <tr>
						                			<td><h3 style="float:left">单价:<%=planShopping.getList().get(i).getPrice()%></h3></td>
						                		</tr>
						                		 <tr>
						                			<td><input type = "submit" class="btn btn-success" value = "购买">
						                					<input type="hidden" name="dessert" value="<%=dessertList.getList().get(i).getName()%>">
						                					<input type="hidden" name="salePlan" value="<%=i%>">
						                				
						                			</td>				                		
						                		</tr>
						          						
						           				<tbody>
						           				</tbody>
						          				</table>		
					          				</s:form>
					                </td>
					              </tr>
					            </tbody>
					          </table>
					         <%} %>
        	</div>
        </div>
					
				
					
</body>
</html>