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
    <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
	
		<script src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/transIframe.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="../js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body style="overflow-x:hidden;">
			<jsp:useBean id="customerList"
	type="edu.nju.dessertHouse.model.CustomerList"
	scope="session"></jsp:useBean> 
	
         <div class="row" style="overflow: hidden;scroll:no">
        <div class="col-md-6">
        <!-- gender -->
          <table class="table"  style="margin-top:10px" >
            <thead>
				    <tr>
						      <th>性别</th>
						      <th>人数</th>
						      <th>百分比</th>
				    </tr>
				  </thead>
            <tbody>
	            <tr>
	            				<td>MAN</td>
		                			<td><%=customerList.getGenderCount().get(0)%></td>
						    
						      	<td><%=((double)customerList.getGenderCount().get(0)/(double)customerList.getList().size()*100)+"%"%></td>
	              </tr>
	                 <tr>
	            				<td>WOMAN</td>
		                			<td><%=customerList.getGenderCount().get(1)%></td>
						    
						      	<td><%=((double)customerList.getGenderCount().get(1)/(double)customerList.getList().size()*100)+"%"%></td>
	              </tr>
            </tbody>
          </table>
          <!-- age -->
          <table class="table"  style="margin-top:40px" >
            <thead>
				    <tr>
						      <th>年龄段</th>
						      <th>人数</th>
						      <th>百分比</th>
				    </tr>
				  </thead>
            <tbody>
	            <%for(int i=0;i<customerList.getAgeCount().size();i++){ %>
	            <tr>
	            				<td><%=i*10+"-"+(i+1)*10 %></td>
		                			<td><%=customerList.getAgeCount().get(i)%></td>
						    
						      	<td><%=((double)customerList.getAgeCount().get(i)/(double)customerList.getList().size()*100)+"%"%></td>
	              </tr>
	              <%} %>
            </tbody>
          </table>
          
          <!-- consume -->
           <table class="table"  style="margin-top:40px" >
            <thead>
				    <tr>
						      <th>消费水平</th>
						      <th>人数</th>
						      <th>百分比</th>
				    </tr>
				  </thead>
            <tbody>
	            <%for(int i=0;i<customerList.getConsumeCount().size()-1;i++){ %>
	            <tr>
	            				<td><%=i*500+"-"+(i+1)*500 %></td>
		                			<td><%=customerList.getConsumeCount().get(i)%></td>
						    
						      	<td><%=((double)customerList.getConsumeCount().get(i)/(double)customerList.getList().size()*100)+"%"%></td>
	              </tr>
	              <%} %>
	                      <tr>
	            				<td><%=(customerList.getConsumeCount().size()-1)*500+"+" %></td>
		                			<td><%=customerList.getConsumeCount().get((customerList.getConsumeCount().size()-1))%></td>
						    
						      	<td><%=((double)customerList.getConsumeCount().get((customerList.getConsumeCount().size()-1))/(double)customerList.getList().size()*100)+"%"%></td>
	              </tr>
            </tbody>
          </table>
          <!-- Status -->
           <table class="table"  style="margin-top:10px" >
            <thead>
				    <tr>
						      <th>卡状态</th>
						      <th>人数</th>
						      <th>百分比</th>
				    </tr>
				  </thead>
            <tbody>
	            <tr>
	            				<td>VALID</td>
		                			<td><%=customerList.getCardCount().get(0)%></td>
						    
						      	<td><%=((double)customerList.getCardCount().get(0)/(double)customerList.getList().size()*100)+"%"%></td>
	              </tr>
	                  <tr>
	            				<td>PAUSE</td>
		                			<td><%=customerList.getCardCount().get(1)%></td>
						    
						      	<td><%=((double)customerList.getCardCount().get(1)/(double)customerList.getList().size()*100)+"%"%></td>
	              </tr>
	               <tr>
	            				<td>STOP</td>
		                			<td><%=customerList.getCardCount().get(2)%></td>
						    
						      	<td><%=((double)customerList.getCardCount().get(2)/(double)customerList.getList().size()*100)+"%"%></td>
	              </tr>
            </tbody>
          </table>
        </div>
					</div>
					
				
					
</body>
</html>