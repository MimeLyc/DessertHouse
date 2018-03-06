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
<body style="overflow:hidden;scroll:no">
			<jsp:useBean id="customer"
	type="edu.nju.dessertHouse.model.Customer"
	scope="session"></jsp:useBean> 
	
	<!-- 
		 <div class="col-sm-4">
          <div class="list-group" style="margin:5px">
	        <h3 ><span class="label label-info" >Default</span></h3>
	        <h3 ><span class="label label-info" >Primary</span></h3>
	        <h3><span class="label label-info">Success</span></h3>
	        <h3><span class="label label-info">Info</span></h3>
	       <h3> <span class="label label-info">Warning</span></h3>
	        <h3><span class="label label-info">Danger</span></h3>
	        <h3><span class="label label-info">Danger</span></h3>
	        <h3 style="margin-bottom: 0px"><span class="label label-info">Danger</span></h3>
      </div>
          </div>
	     <div class="col-sm-4">
          <div class="list-group"  style="border:0">
            <a href="#" class="list-group-item ">Id:<jsp:getProperty name="customer" property="id" /></a>
            <a href="#" class="list-group-item">Name:<jsp:getProperty name="customer" property="name" /></a>
            <a href="#" class="list-group-item">Level:<jsp:getProperty name="customer" property="level" /></a>
            <a href="#" class="list-group-item">Card Status:<jsp:getProperty name="customer" property="status" /></a>
            <a href="#" class="list-group-item">Point:</a>
            <a href="#" class="list-group-item">Address:</a>
            <a href="#" class="list-group-item">Birthday:</a>
            <a href="#" class="list-group-item">Register Time:</a>
          </div>
          </div> -->
         <div class="row" style="overflow: hidden;scroll:no">
        <div class="col-md-6">
          <table class="table"  style="margin-top:40px" >
            <tbody>
              <tr>
                <td><h3 style="margin:0px">Id</h3></td>
                <td><p><jsp:getProperty name="customer" property="id" /></p></td>
              </tr>
              <tr>
                <td><h3 style="margin:0px">Name</h3></td>
                <td><jsp:getProperty name="customer" property="name" /></td>
              </tr>
              <tr>
                <td><h3 style="margin:0px">Level</h3></td>
                <td><jsp:getProperty name="customer" property="level" /></td>
              </tr>
                   <tr>
                <td><h3 style="margin:0px">Card Status</h3></td>
                <td><jsp:getProperty name="customer" property="status" /></td>
              </tr>
                   <tr>
                <td><h3 style="margin:0px">Point</h3></td>
                <td><jsp:getProperty name="customer" property="point" /></td>
              </tr>
                   <tr>
                <td><h3 style="margin:0px">Address</h3></td>
                <td><jsp:getProperty name="customer" property="address" /></td>
              </tr>
                   <tr>
                <td><h3 style="margin:0px">Birthday</h3></td>
                <td><jsp:getProperty name="customer" property="birth" /></td>
              </tr>
                   <tr>
                <td style="width:20%"><h3 style="margin:0px">Register Time</h3></td>
                <td style="width:80%"><jsp:getProperty name="customer" property="registerTime" /></td>
              </tr>
            </tbody>
          </table>
        </div>
					</div>
</body>
</html>