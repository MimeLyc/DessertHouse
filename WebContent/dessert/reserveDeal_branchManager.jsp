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
<jsp:useBean id="reserveList"
	type="edu.nju.dessertHouse.model.SaleRecList"
	scope="session"></jsp:useBean>
		<div class="templatemo-content col-1 light-gray-bg blockClass">
	         <div class="templatemo-content-container"  style="padding-bottom:50px">
			<div class="templatemo-flex-row flex-content-row"  style="height:100%;width:100%">
			<div class="templatemo-content-widget white-bg col-2"  style="height:100%;width:100%">
								        
			 <div class="row" style="overflow-x: hidden;height:470px">
        <div class="col-md-6" >	
        
        
					          <table class="table"  style="margin:10px;width:800px" >
									<thead>
									<tr>
										<th>用户</th>
										<th>糕点</th>
										<th>数目</th>
										<th>总额</th>
										<th>地址</th>
										<th>日期</th>
					
									</tr>
									</thead>
					            <tbody>
					        <%for(int i = 0;i<reserveList.getList().size();i++) {%>
					        		<tr >
					        			<td><%=reserveList.getList().get(i).getCustomer().getName()%></td>
					        			<td><%=reserveList.getList().get(i).getDessert().getName()%></td>
					        			<td><%=reserveList.getList().get(i).getNum()%></td>
					        			<td><%=reserveList.getList().get(i).getTotalMoney()%></td>
					        			<td><%=reserveList.getList().get(i).getAddress()%></td>
					        			<td><%=reserveList.getList().get(i).getDate()%></td>
					        			<%if(reserveList.getList().get(i).getStatus().contains("PAYED")){ %>
					        				<td style="float:left"><span class="label label-default" style="float:left">已受理</span></td>
					        			<%}else{ %>
					        				<td style="float:left">
					      	<s:form action="dealReserve" namespace="/DessertHouse" >
					        				<input type="hidden" name="reserveId" value="<%=reserveList.getList().get(i).getId()%>">
					        				<input type="submit" value="处理" class="btn btn-success" >
					        		</s:form>
					        				</td>
					        			<%} %>
					        		</tr>
					         <%} %>
					            </tbody>
					          </table>
     						 </div>
						</div>
					  </div>
					</div>
				 </div>
				 </div>
</body>
</html>