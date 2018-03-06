<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:form action = "register" namespace = "/DessertHouse">
		<h2>password:</h2><input type="password" name = "passwordOne" />
		<h2>password confirm:</h2><input type="password" name = "passwordTwo" />
		<h2>name:</h2><input type="text" name="customer.name">
			<input type="radio" name="gender" value="MAN" checked="checked">MAN
			<input type="radio" name="gender" value="WOMEN">WOMEN
		<h2>birthday:</h2><input type="date" name="customer.birth"/>
		<h2>bank card:</h2><input type="text" name="customer.bankCard"/>
		<h2>address:</h2><input type="text" name = "customer.address">		
		<input type="submit" value='register' />
	</s:form>
</body>
</html>