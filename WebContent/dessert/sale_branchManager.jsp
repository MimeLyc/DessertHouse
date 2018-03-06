<%@ page language="java" contentType="text/html; charset=utf-8"  import="edu.nju.dessertHouse.action.LoginAction"%>
         <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=utf-8">
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<link href="../../dist/css/bootstrap-theme.min.css" rel="stylesheet">
    <!-- Custom CSS -->
<!-- 	<link href="../css/mainPage.css" rel="stylesheet"> -->
    <!-- Custom Fonts -->
    <link href="../css/font.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
		<link href="../css/mainPage.css" rel="stylesheet">
		<script src="../js/jquery.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="../js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body style="overflow-x:hidden;">
<jsp:useBean id="dessertList"
	type="edu.nju.dessertHouse.model.DessertList"
	scope="session"></jsp:useBean>
	<jsp:useBean id="salePlanList"
	type="edu.nju.dessertHouse.model.SalePlanList"
	scope="session"></jsp:useBean>  
		<div class="templatemo-content col-1 light-gray-bg blockClass">
	         <div class="templatemo-content-container"  style="padding-bottom:50px">
			<div class="templatemo-flex-row flex-content-row"  style="height:100%;width:100%">
			<div class="templatemo-content-widget white-bg col-2"  style="height:100%;width:100%">
								        
			 <div class="row" style="overflow-x: hidden;height:470px">
        <div class="col-md-6" >	
        
        
					        <%for(int i = 0;i<salePlanList.getList().size();i++) {%>
					        
					        
					          <table class="table"  style="margin:10px;width:800px" >
					          
					            <tbody>
					              <tr>
					                <td style="width:50px;height:50px"><img src="<%=dessertList.getList().get(i).getImg()%>"   style="width:150px;height:150px"/></td>
					                <td >
					                <s:form action="sale" namespace="/DessertHouse">
					                	<table class="table"  style="margin:0px;" >
						                		<tr>
						                			<td><h3><%=dessertList.getList().get(i).getName() %></h3></td>
						                		</tr>
						                		<tr>
						                			<td><h3 style="float:left">单价：</h3><p style="float:left"><%=salePlanList.getList().get(i).getPrice()%></p></td>
						                		</tr>
						                		 <tr>
						                			<td><input type = "submit" class="btn btn-success" value = "销售">
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
					  </div>
					</div>
				 </div>
				 </div>
</body>
</html>