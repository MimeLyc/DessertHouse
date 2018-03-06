<%@ page language="java" contentType="text/html; charset=utf-8"%>
         <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=utf-8">
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<link href="../../dist/css/bootstrap-theme.min.css" rel="stylesheet">
    <!-- Custom CSS -->
     <link href="../css/landingPage.css" rel="stylesheet">
<!-- 	<link href="../css/mainPage.css" rel="stylesheet"> -->
    <!-- Custom Fonts -->
    <link href="../css/font.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
	
		<script src="../js/jquery.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="../js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body style="overflow:hidden;scroll:no">
			<jsp:useBean id="customer"
	type="edu.nju.dessertHouse.model.Customer"
	scope="session"></jsp:useBean> 
         <div class="row" style="overflow: hidden;scroll:no">
        <div class="col-md-6">
          		 <s:form method='post' action="changeInfo_customer" namespace="/DessertHouse">
          <table class="table"  style="margin-top:40px" >
            <tbody>
            <thead>
              <tr>
                <th>#</th>
                <th>old</th>
                <th>new</th>
              </tr>
              <tr>
                <td><h3 style="margin:0px">Password</h3></td>
                <td><p><jsp:getProperty name="customer" property="password" /></p></td>
                <td><input type="text" name='password' value="" class="form-control"  /></td>
              </tr>
              <tr>
                <td><h3 style="margin:0px">Address</h3></td>
                <td><jsp:getProperty name="customer" property="address" /></td>
                   <td><input type="text" name='address' value="" class="form-control"  /></td>
              </tr>
              <tr>
                <td style="width:20%"><h3 id="changeName" style="margin:0px">Name</h3></td>
                <td style="width:40%"><jsp:getProperty name="customer" property="name" /></td>
                   <td style="width:40%"><input type="text" name='name' value="" class="form-control"  /></td>
                   </tr>
            </tbody>
          </table>
         			 <button type="submit" class="btn btn-success">Submit</button>
         			 </s:form>
        </div>
					</div>
</body>
</html>