<%@ page language="java" contentType="text/html; charset=utf-8"%>
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
	
		<script src="../js/jquery.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="../js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body style="overflow-x:hidden;">

	<jsp:useBean id="salePlanList"
	type="edu.nju.dessertHouse.model.SalePlanList"
	scope="session"></jsp:useBean> 
	<jsp:useBean id="clerkList"
	type="edu.nju.dessertHouse.model.ClerkList"
	scope="session"></jsp:useBean> 
         <div class="row" style="overflow: hidden;scroll:no">
        <div class="col-md-6">
        <%for(int i = 0;i<salePlanList.getList().size();i++) {%>
        <s:form action="salePlanDet" method="post" namespace="/DessertHouse">
          <table class="table"  style="margin-top:40px" >
          
            <tbody>
              <tr>
                <td><h3 style="margin:0px">Branch</h3></td>
                <td ><p ><%=salePlanList.getList().get(i).getBranch().getName()%></p></td>
              </tr>
              <tr>
                <td><h3 style="margin:0px">date</h3></td>
                <td><p><%=salePlanList.getList().get(i).getBeginDate()%>——<%=salePlanList.getList().get(i).getEndDate()%></p></td>
              </tr>
              <!-- 	<tr>
	                <td><h3 style="margin:0px">Dessert</h3></td>
              <td>
              		for(int j=0;j<salePlanList.getDessertInfoByPlanId(salePlanList.getList().get(i).getPlanID()).size();j++){%>

	 				<p>=salePlanList.getDessertInfoByPlanId(salePlanList.getList().get(i).getPlanID())%></p>
     	         <i++;} 
     	         i--;%>             
     	         </td>
     	         </tr>    --> 
            </tbody>
          </table>
          <input  name="<%=salePlanList.getList().get(i).getPlanID()%>"  type="hidden">
          <input type = "submit" class="btn btn-success" value = "查看">
          </s:form>
         <%} %>
        </div>
					</div>
</body>
</html>