<%@ page language="java" contentType="text/html; charset=utf-8" import="edu.nju.dessertHouse.action.LoginAction"%>
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
<body style="overflow-x:hidden;">
			<jsp:useBean id="saleRecList"
	type="edu.nju.dessertHouse.model.SaleRecList"
	scope="session"></jsp:useBean> 
	<jsp:useBean id="dessertList"
	type="edu.nju.dessertHouse.model.DessertList"
	scope="session"></jsp:useBean> 
		<jsp:useBean id="storeList"
	type="edu.nju.dessertHouse.model.BranchList"
	scope="session"></jsp:useBean> 
	
         <div class="row" style="overflow: hidden;scroll:no">
        <div class="col-md-6">
        <%for(int i=0;i<storeList.getList().size();i++){ %>
          <table class="table"  style="margin-top:10px" >
            <thead>
				    <tr>
						      <th><%=storeList.getList().get(i).getName() %></th>
						      <th>预订人数</th>
						      <th>现买人数</th>
				    </tr>
				  </thead>
            <tbody>
            <%for(int j = 0;j<dessertList.getList().size();j++){ %>
	            <tr>
	            				<td><%=dessertList.getList().get(j).getName() %></td>
		                			<td><%=saleRecList.getConsumeCount(storeList.getList().get(i), dessertList.getList().get(j)).get(0)%></td>
						    
						      	<td><%=saleRecList.getConsumeCount(storeList.getList().get(i), dessertList.getList().get(j)).get(1)%></td>
	              </tr>
	              <%} %>
	                    <tr>
	            				<td>总计</td>
		                			<td><%=saleRecList.getConsumeCountByBranch(storeList.getList().get(i)).get(0)%></td>
						    
						      	<td><%=saleRecList.getConsumeCountByBranch(storeList.getList().get(i)).get(1)%></td>
	              </tr>
            </tbody>
          </table>
          <%} %>
          
          <table class="table"  style="margin-top:10px" >
            <thead>
				    <tr>
						      <th>总计</th>
						      <th>预订人数</th>
						      <th>现买人数</th>
				    </tr>
				  </thead>
            <tbody>
	            <tr>
	            				<td>#</td>
		                			<td><%=saleRecList.getConsumeCountTotal().get(0)%></td>
						    
						      	<td><%=saleRecList.getConsumeCountTotal().get(1)%></td>
	              </tr>
            </tbody>
          </table>
          <!-- hot dessert -->
                   <table class="table"  style="margin-top:10px" >
            <thead>
				    <tr>
						      <th>热门糕点</th>
						      <th>购买人数</th>
						 
				    </tr>
				  </thead>
            <tbody>
            <%	saleRecList.getHotDessert();%>
            <%for(int i=0;i<saleRecList.getDessertList().size();i++){ %>
	            <tr>
	            				<td><%=saleRecList.getDessertList().get(i).getName()%></td>
		                			<td><%=saleRecList.getHotDessert().get(i)%></td>

	              </tr>
	              <%} %>
            </tbody>
          </table>
       
        </div>
					</div>
					
				
					
</body>
</html>