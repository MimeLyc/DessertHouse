<%@ page language="java" contentType="text/html; charset=utf-8" import="edu.nju.dessertHouse.action.CheckPlanAction"%>
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
    		<link href="../css/mainPage.css" rel="stylesheet">
    <link href="../css/font.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
	
		<script src="../js/jquery.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="../js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body style="overflow-x:hidden;scroll:no">

	<jsp:useBean id="salePlanInfo"
	type="edu.nju.dessertHouse.model.SalePlan"
	scope="session"></jsp:useBean> 
	
			<div class="templatemo-content col-1 light-gray-bg blockClass">
	         <div class="templatemo-content-container"  style="padding-bottom:50px">
			<div class="templatemo-flex-row flex-content-row"  style="height:100%;width:100%">
			<div class="templatemo-content-widget white-bg col-2"  style="height:100%;width:100%">
								        
			 <div class="row" style="overflow-x: hidden;height:470px">
        <div class="col-md-6" >	
          <table class="table"  style="margin-top:40px;width:800px" >
          
            <tbody>
              <tr>
                <td><h3 style="margin:0px">Branch</h3></td>
                <td ><p ><%=salePlanInfo.getBranch().getName()%></p></td>
              </tr>
              <tr>
                <td><h3 style="margin:0px">date</h3></td>
                <td><p><%=salePlanInfo.getBeginDate()%>——<%=salePlanInfo.getEndDate()%></p></td>
              </tr>
             	
               	<tr>
	                <td><h3 style="margin:0px">Dessert</h3></td>
              <td>
          
              	<%for(int i = 0;i<session.getAttribute("dessertPlanInfo").toString().split("\\|").length;i++) {%>      
              		<p><%=session.getAttribute("dessertPlanInfo").toString().split("\\|")[i].split(";")[0] %>
              		单价<%=session.getAttribute("dessertPlanInfo").toString().split("\\|")[i].split(";")[1] %>
              		数量<%=session.getAttribute("dessertPlanInfo").toString().split("\\|")[i].split(";")[2] %>
              		</p>
              	<%  }%>
              	  
     	         </td>
     	         </tr>    
     	         
     	       <tr>
                <td><h3 style="margin:0px">status</h3></td>
                <td><p><%=salePlanInfo.getStatus()%></p></td>
              </tr>
            </tbody>
          </table>
          <ul style="float: left">
          	<li style="float: left">
		          <s:form action="passPlan" namespace="/DessertHouse">
		           	<input type = "submit" class="btn btn-success" value = "通过">
		        </s:form>
		     </li>
		     <li style="float: left">
		       <i class="fa fa-bars"></i>
		     </li>
		     <li style="float: left">
		        <s:form action="denyPlan" namespace="/DessertHouse">
		           	<input type = "submit" class="btn btn-success" value = "驳回">
		        </s:form>
		        </li>
        </ul>
        </div>
        </div>
        </div>
        </div>
        </div>
					</div>
</body>
</html>