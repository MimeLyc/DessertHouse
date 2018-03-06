<%@ page language="java" contentType="text/html; charset=utf-8"  import="edu.nju.dessertHouse.action.SaleAction"%>
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
<jsp:useBean id="saleConfirm"
	type="edu.nju.dessertHouse.model.SaleRec"
	scope="session"></jsp:useBean>
		<jsp:useBean id="planSale"
	type="edu.nju.dessertHouse.model.SalePlan"
	scope="session"></jsp:useBean>  
		<div class="templatemo-content col-1 light-gray-bg blockClass">
	         <div class="templatemo-content-container"  style="padding-bottom:50px">
			<div class="templatemo-flex-row flex-content-row"  style="height:100%;width:100%">
			<div class="templatemo-content-widget white-bg col-2"  style="height:100%;width:100%">
								        
			 <div class="row" style="overflow-x: hidden;height:470px">
        <div class="col-md-6" >	
			       				        
					  			<s:form action="dealAction" namespace="/DessertHouse">
					                	<table class="table"  style="margin:40px;;width:800px" >
						                		<tr>
						                			<td><h3><%=saleConfirm.getDessert().getName()%></h3></td>
						                			<td></td>
						                		</tr>
						                		 <tr>
						                			<td><h3 style="float:left">单价</h3></td>
						                			<td><p style="float:left"><%=planSale.getPrice()%></p></td>
						                		</tr>
						                		<tr>
						                			<td><h3 style="float:left">数目</h3></td>
						                			<td><p style="float:left"><%=saleConfirm.getNum()%></p></td>
						                		</tr>
						                		<tr>
						                			<td><h3 style="float:left">原价</h3></td>
						                			<td><p style="float:left"><%=session.getAttribute("originalCost")%></p></td>
						                		</tr>
						                		 <tr>
						                			<td><h3>折后</h3></td>
						                			<td><p style="float:left"><%=saleConfirm.getTotalMoney()%></p></td>
						                		</tr>
						                		<%if(saleConfirm.getCustomer()!=null){%>
						                		<tr>
						                			<td><h3>用户</h3></td>
						                			<td><p style="float:left"><%=saleConfirm.getCustomer().getName()%></p></td>
						                		</tr>
						                		<%} %>	
						           				<tbody>
						           				</tbody>
						          				</table>	
						          				<input type = "submit" class="btn btn-success" value = "确认">
						          	</s:form>			
     						 </div>
						</div>
					  </div>
					</div>
				 </div>
				 </div>
</body>
</html>