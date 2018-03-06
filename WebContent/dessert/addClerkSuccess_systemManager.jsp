<%@ page language="java" contentType="text/html; charset=utf-8" import="edu.nju.dessertHouse.action.AddClerkAction"%>
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
	<link href="../css/landingPage.css" rel="stylesheet">
		<script src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/transIframe.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="../js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body style="overflow:hidden;scroll:no">
			<jsp:useBean id="newUser"
	type="edu.nju.dessertHouse.model.User"
	scope="session"></jsp:useBean> 
	
         <div class="row" style="overflow: hidden;scroll:no">
        <div class="col-md-6">
        <h2>创建成功</h2>
          <table class="table"  style="margin-top:40px" >
            <tbody>
            <tr>
                <td><h3 style="margin:0px">Id</h3></td>
                <td><p><jsp:getProperty name="newUser" property="id" /></p></td>
              </tr>
              <tr>
                <td><h3 style="margin:0px">Name</h3></td>
                <td><p><jsp:getProperty name="newUser" property="name" /></p></td>
              </tr>
              <tr>
                <td><h3 style="margin:0px">Type</h3></td>
                <td><jsp:getProperty name="newUser" property="type" /></td>
              </tr>
                            <tr>
                <td><h3 style="margin:0px">Password</h3></td>
                <td><jsp:getProperty name="newUser" property="password" /></td>
              </tr>
              <%
              if(newUser.getBranch()!=null){
            	  %>
            	      <tr>
			                <td><h3 style="margin:0px">subbranch</h3></td>
			                <td><%=newUser.getBranch().getName() %></td>
			             </tr>
            	  <%
              }
              %>
                

            </tbody>
          </table>
				<a href="../dessert/addClerk_systemManager.jsp" class="network-name btn btn-default btn-lg">
																 <span class="network-name">确定</span>            
														</a>
        </div>
					</div>
					
				
					
</body>
</html>