<%@ page language="java" contentType="text/html; charset=utf-8" import="edu.nju.dessertHouse.action.LoginAction"%>
         <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html;  charset=utf-8">
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<link href="../css/bootstrap-theme.min.css" rel="stylesheet">
    <!-- Custom CSS -->
<!-- 	<link href="../css/mainPage.css" rel="stylesheet"> -->
    <!-- Custom Fonts -->
    <link href="../css/font.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
	
		<script src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/transIframe.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="../js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body style="overflow:hidden;scroll:no;padding:0px">
			<jsp:useBean id="dessertList"
	type="edu.nju.dessertHouse.model.DessertList"
	scope="session"></jsp:useBean> 
	
           <div class="container" style="width:900px;height:460px;text-align:center;padding:0px">
           <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" style="width:900px;height:460px;text-align:center;padding:0px">
				        <ol class="carousel-indicators" >
				          <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
				          <li data-target="#carousel-example-generic" data-slide-to="1"></li>
				          <li data-target="#carousel-example-generic" data-slide-to="2"></li>
				        </ol>
				        <div class="carousel-inner" role="listbox" style="width:900px;height:460px;">
					          <div class="item active" style="text-align: center;margin:0 auto;" >
					            <img data-src="holder.js/1140x500/auto/#777:#555/text:First slide" alt="First slide" src="<%=dessertList.getList().get(0).getImg() %>" style="margin:0 auto;height:460px;width:900px">
					          </div>
					          <div class="item" style="text-align: center;margin:0 auto;">
					            <img data-src="holder.js/1140x500/auto/#666:#444/text:Second slide" alt="Second slide" src="<%=dessertList.getList().get(1).getImg() %>" style="margin:0 auto;height:460px;width:900px">
					          </div>
					          <div class="item" style="text-align: center;margin:0 auto;" >
					            <img data-src="holder.js/1140x500/auto/#555:#333/text:Third slide" alt="Third slide" src="<%=dessertList.getList().get(2).getImg() %>" style="margin:0 auto;height:460px;width:900px">
					          </div>
					        </div>
				        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev" style="margin-left: 0px">
				          <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				          <span class="sr-only">Previous</span>
				        </a>
				        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next"  style="margin-right:0px">
				          <span class="glyphicon glyphicon-chevron-right" aria-hidden="true" style="margin-right: 0px"></span>
				          <span class="sr-only">Next</span>
				        </a>
      </div>
        </div>

					
				
					
</body>
</html>