<%@ page language="java" contentType="text/html; charset=utf-8"%>
         <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=utf-8">
	<link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
	<link href="../css/mainPage.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="../css/font.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
	
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		<script type="text/javascript" src="../js/transIframe.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
		
					<jsp:useBean id="user"
	type="edu.nju.dessertHouse.model.User"
	scope="session"></jsp:useBean> 
						<div class="templatemo-flex-row" style="heigh:100%">
								      <div class="templatemo-sidebar">
								        <header class="templatemo-site-header">
								          <div class="square"></div>
								     <!--      <h1 id="name"><jsp:getProperty name="user" property="name" /> -->
 								        <h1>  <jsp:getProperty name="user" property="id" /></h1>
								        </header>
								        <!-- Search box 
								        <form class="templatemo-search-form" role="search">
								          <div class="input-group">
								              <button type="submit" class="fa fa-search"></button>
								              <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">           
								          </div>
								        </form> -->
								        <div class="mobile-menu-icon">
								            <i class="fa fa-bars"></i>
								        </div>
								        <nav class="templatemo-left-nav">          
								          <ul>
								            <li onclick="iframeTransfer('../dessert/salePlan_centerManager.jsp')" style="cursor:pointer"><a><i class="fa fa-database fa-fw"></i>Marketing Plan</a></li>
								            <li><a href="../dessert/login.jsp"><i class="fa fa-eject fa-fw"></i>SIGN OUT</a></li>
								          </ul>  
								        </nav>
								      </div>
								      
								        <iframe id="mainInf" src="../dessert/salePlan_centerManager.jsp" style="height:650px;width:1200px"></iframe>
					  
						<div id="container">
						
			
						
					
					</div>
					<!-- end div -->
					</div>
					
</body>
</html>