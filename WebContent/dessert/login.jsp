<%@ page language="java" contentType="text/html; charset=utf-8"%>
        <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=utf-8">
	<link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/landingPage.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../css/font.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
	
	<script src="../js/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="../js/bootstrap.min.js"></script>
<title>Login</title>
</head>
<body class="landing">
	
	<div id="page-wrapper">
	<div class="intro-header">
		<section id="login" style="height:100%">
	        <div class="container">
	
	            <div class="row">
	                <div class="col-lg-12">
	                    <div class="intro-message">
	                        	 <s:form method='post' action="login" namespace="/DessertHouse">
	                        	 	<div class="input-group input-group-lg" style="padding-left:37%;">
										<span class="input-group-addon" style="width:10%;">id: </span><input type="text" name='id' value=""  class="form-control"  placeholder="Input Your Account" style="width:50%"/>
									</div>
										<br />
									<div class="input-group input-group-lg" style="padding-left:37%;">
								       	<span class="input-group-addon" style="width:20%">password:</span> <input type="password" name='password' value="" class="form-control"  placeholder="Input Your Password" style="width:40%"/>
				                        </div>
				                        <hr class="intro-divider">
				                        <ul class="list-inline intro-social-buttons">
					                            <li>
					                                <input type="submit" value='Login'  class="network-name btn btn-default btn-lg"/>
					                            </li>
					                            <li>
					                                 <a href="#register" class="network-name btn btn-default btn-lg">
																 <span class="network-name">Register</span>            
														</a>
					                            </li>
								        </ul>
								
							   </s:form>
	                    </div>
	                </div>
	            </div>
	
	        </div>
	        <!-- /.container -->
			</section>
			<!-- register -->
			<section id="register" style="height:100%;padding-top:15px" >
				<s:form action = "register" namespace = "/DessertHouse">
							<div class="input-group" style="padding-left:35%;margin:15px;width:100%" >
								<span class="input-group-addon" style="width:15%;">password: </span><input type="password" name = "passwordOne"   class="form-control"  style="width:30%;"/>
							</div>
							<br />
							<div class="input-group" style="padding-left:35%;margin:15px;width:100%">
								<span class="input-group-addon" style="width:15%;">password confirm:</span><input type="password" name = "passwordTwo"  class="form-control" style="width:30%;" />
							</div>
							<br />		
							<div class="input-group" style="padding-left:35%;margin:15px;width:100%">
								<span class="input-group-addon" style="width:15%;">name:</span><input type="text" name="customer.name"  class="form-control"   style="width:30%;">
							</div>
							<br />
							<ul class="list-inline intro-social-buttons">
									<li>
										<input type="radio" name="gender" value="MAN" checked="checked"  >MAN
									</li>
									<li>
										<input type="radio" name="gender" value="WOMEN"  >WOMEN
									</li>
							</ul>
							<div class="input-group" style="padding-left:35%;margin:15px;width:100%">
								<span class="input-group-addon" style="width:15%;">birthday:</span><input type="date" name="customer.birth"  class="form-control"  style="width:30%;" />
							</div>
							<br />
							<div class="input-group" style="padding-left:35%;margin:15px;width:100%">
								<span class="input-group-addon" style="width:15%;">bank card:</span><input type="text" name="customer.bankCard"  class="form-control"   style="width:30%;"/>
							</div>
							<br />
							<div class="input-group" style="padding-left:35%;margin:15px;width:100%">
								<span class="input-group-addon" style="width:15%;">address:</span><input type="text" name = "customer.address" class="form-control"  style="width:30%;">		
							</div>
							<br />
							<input type="submit" value='register'  class="network-name btn btn-default btn-lg"/>
					</s:form>
			
			</section>
	    </div>
	    <!-- /.intro-header -->
	    </div>

</body>
</html>