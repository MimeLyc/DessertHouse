<%@ page language="java" contentType="text/html; charset=utf-8" import="edu.nju.dessertHouse.action.LoginAction,edu.nju.dessertHouse.action.ShoppingAction"%>
         <%@ taglib prefix="s" uri="/struts-tags" %>
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
	
		<script src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/transIframe.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="../js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body style="overflow:hidden;scroll:no">
			<jsp:useBean id="saleRecList"
	type="edu.nju.dessertHouse.model.SaleRecList"
	scope="session"></jsp:useBean> 
	
         <div class="row" style="overflow: hidden;scroll:no">
        <div class="col-md-6">
          <table class="table"  style="margin-top:40px" >
            <thead>
				    <tr>
						      <th>商店</th>
						      <th>受理服务员</th>
						      <th>糕点</th>
						      <th>数量</th>
						      <th>单价</th>
						      <th>总价</th>
						      <th>地址</th>
						      <th>送达日期</th>
				    </tr>
				  </thead>
            <tbody>
            <%for(int i=0;i<saleRecList.getList().size();i++){ %>
	            <tr>
	                			<td><%=saleRecList.getSaleRec(i).getBranch().getName() %></td>
						      <%if(saleRecList.getSaleRec(i).getWaiter()!=null){%>
						      <td><%=saleRecList.getSaleRec(i).getWaiter().getName() %></td>
						      	<%}else{ %>
						      	<td>null</td>
						      <%} %>
						      <td><%=saleRecList.getSaleRec(i).getDessert().getName()%></td>
						      <td><%=saleRecList.getSaleRec(i).getNum()%></td>
						      <td><%=(Integer.parseInt(saleRecList.getSaleRec(i).getTotalMoney())/saleRecList.getSaleRec(i).getNum())%></td>
						      <td><%=saleRecList.getSaleRec(i).getTotalMoney()%></td>
						      <td><%=saleRecList.getSaleRec(i).getAddress()%></td>
						      <td><%=saleRecList.getSaleRec(i).getDate()%></td>
	              </tr>
              <%} %>
            </tbody>
          </table>
        </div>
					</div>
					
				
					
</body>
</html>