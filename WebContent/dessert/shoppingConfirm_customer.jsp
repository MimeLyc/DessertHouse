<%@ page language="java" contentType="text/html; charset=utf-8"  import="edu.nju.dessertHouse.action.ShoppingAction"%>
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
<body style="overflow-x:hidden;" class="white-bg" >
<jsp:useBean id="shoppingConfirm"
	type="edu.nju.dessertHouse.model.SaleRec"
	scope="session"></jsp:useBean>
		<jsp:useBean id="shoppingDet"
	type="edu.nju.dessertHouse.model.SalePlan"
	scope="session"></jsp:useBean>  
		
								        
			 <div class="row" style="overflow-x: hidden;height:470px">
        <div class="col-md-6" >	
			       				        
					  			<s:form action="deal" namespace="/DessertHouse">
					                	<table class="table"  style="margin:40px;;width:800px" >
						                		<tr>
						                			<td><h3><%=shoppingConfirm.getDessert().getName()%></h3></td>
						                			<td></td>
						                		</tr>
						                		 <tr>
						                			<td><h3 style="float:left">单价</h3></td>
						                			<td><p style="float:left"><%=shoppingDet.getPrice()%></p></td>
						                		</tr>
						                		<tr>
						                			<td><h3 style="float:left">数目</h3></td>
						                			<td><p style="float:left"><%=shoppingConfirm.getNum()%></p></td>
						                		</tr>
						                		<tr>
						                			<td><h3 style="float:left">原价</h3></td>
						                			<td><p style="float:left"><%=session.getAttribute("originalCost")%></p></td>
						                		</tr>
						                		 <tr>
						                			<td><h3>折后</h3></td>
						                			<td><p style="float:left"><%=shoppingConfirm.getTotalMoney()%></p></td>
						                		</tr>
						                		<tr>
						                			<td><h3>用户</h3></td>
						                			<td><p style="float:left"><%=shoppingConfirm.getCustomer().getName()%></p></td>
						                		</tr>
						                		<tr>
						                			<td><h3>送达日期</h3></td>
						                			<td><p style="float:left"><%=shoppingConfirm.getDate()%></p></td>
						                		</tr>
						                		<tr>
						                			<td><h3>地址</h3></td>
						                			<td><p style="float:left"><%=shoppingConfirm.getAddress()%></p></td>
						                		</tr>
						          						
						           				<tbody>
						           				</tbody>
						          				</table>	
						          				<input type = "submit" class="btn btn-success" value = "确认">
						          	</s:form>			
     						 </div>
						</div>

</body>
</html>