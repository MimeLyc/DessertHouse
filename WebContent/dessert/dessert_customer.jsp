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
	
		<script src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/transIframe.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="../js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
		<div id="customer_dessert" class="templatemo-content col-1 light-gray-bg blockClass">
										<!-- 顶部选框 -->
								        <div class="templatemo-top-nav-container">
								          <div class="row">
								            <nav class="templatemo-top-nav col-lg-12 col-md-12">
								              <ul class="text-uppercase">
								                <li  onclick="iframeTransfer('hot_customer.jsp')" style="cursor:pointer"><a>Hot Dessert</a></li>
								                <li  onclick="iframeTransfer('shopSearch_customer.jsp')" style="cursor:pointer"><a>Dessert Shopping</a></li>
								              </ul>  
								            </nav> 
								          </div>
								        </div>
								            <div class="templatemo-content-container"  style="padding:20px">
								      		<div class="templatemo-flex-row flex-content-row"  style="height:100%;width:100%;">
								      			<div class="templatemo-content-widget white-bg col-2"  style="height:100%;width:100%;">
								      		
							   								   <iframe id="mainInf" src="hot_customer.jsp"  style="height:460px;width:100%;border:none;"></iframe>
								        		</div>
								        		</div>
							      </div>
							      </div>

					
</body>
</html>