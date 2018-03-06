<%@ page language="java" contentType="text/html; charset=utf-8" import="edu.nju.dessertHouse.action.LoginAction"%>
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
<body style="overflow-x:hidden;scroll:no">

	<jsp:useBean id="clerkList"
	type="edu.nju.dessertHouse.model.ClerkList"
	scope="session"></jsp:useBean> 
         <div class="row" style="overflow: hidden;scroll:no">
        <div class="col-md-6">
        <%for(int i = 0;i<clerkList.getList().size();i++) {%>
        <s:form method="post" action ="deleteClerk" namespace="/DessertHouse">
          <table class="table"  style="margin-top:40px" >
          
            <tbody>
              <tr>
                <td><h3 style="margin:0px">id</h3></td>
                <td ><p ><%=clerkList.getList().get(i).getId()%></p></td>
              </tr>
              <tr>
                <td><h3 style="margin:0px">Name</h3></td>
                <td><p><%=clerkList.getList().get(i).getName()%></p></td>
              </tr>
              <tr>
                <td><h3 style="margin:0px">Type</h3></td>
 				<td><p><%=clerkList.getList().get(i).getType()%></p></td>
              </tr>
                  <%
              if(clerkList.getList().get(i).getBranch()!=null){
            	  %>
            	      <tr>
			                <td><h3 style="margin:0px">subbranch</h3></td>
			                <td><%=clerkList.getList().get(i).getBranch().getName() %></td>
			             </tr>
            	  <%
              }
              %>
              <tr>
              	<td style="width: 50%"><input  name="<%=clerkList.getList().get(i).getId()%>"  type="hidden"></td>
              	<td><input type="submit" class="btn btn-success" value = "删除"></td>
              </tr>
              
                  
            </tbody>
          </table>
          </s:form>
         <%} %>
        </div>
					</div>
</body>
</html>