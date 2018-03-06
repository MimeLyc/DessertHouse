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
    <script type="text/javascript" src="../js/transIframe.js"></script>
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
        <s:form  method='post'  action = "accountRecharge_customer" namespace="/DessertHouse">
          <table class="table"  style="margin-top:40px" >
            <tbody>
              <tr>
                <td><h3 style="margin:0px">Bank Card Number</h3></td>
                <td><jsp:getProperty name="customer" property="bankCard" /></td>
              </tr>
              <!--    <tr>
                <td><h3 style="margin:0px">Remaining Money in Bank Card</h3></td>
                <td><p><jsp:getProperty name="customer" property="allMoney" /></p></td>
              </tr> -->
              <tr>
                <td><h3 style="margin:0px">Remaining Balance in VIP Card</h3></td>
                <td><p><jsp:getProperty name="customer" property="money" /></p></td>
              </tr>
              <tr>
                <td><h3 style="margin:0px">Recharge Money</h3></td>
                <td><p><input type="text" placeholder="Input The Money" name="recharge"></p></td>
              </tr>
              <tr>
                <td><h3 style="margin:0px">Submit</h3></td>
                <td> <input type="submit" class="btn btn-success" > </td>
            </tbody>
          </table>
          </s:form>
        </div>
					</div>
					
				
					
</body>
</html>