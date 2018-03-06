<%@ page language="java" contentType="text/html; charset=utf-8" import="edu.nju.dessertHouse.action.AddClerkAction"%>
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
<script>
			
</script>
</head>
<body style="overflow:hidden;scroll:no" onload="selectIndex();">
<jsp:useBean id="user"
	type="edu.nju.dessertHouse.model.User"
	scope="session"></jsp:useBean> 
	<jsp:useBean id="storeList"
	type="edu.nju.dessertHouse.model.BranchList"
	scope="session"></jsp:useBean> 
         <div class="row" style="overflow: hidden;scroll:no">
        <div class="col-md-6">
        <s:form action = "addClerk" namespace="/DessertHouse">
          <table class="table"  style="margin-top:40px" >
          
            <tbody>
              <tr>
                <td><h3 style="margin:0px">Name</h3></td>
                <td><input type="text" placeholder="Input Name" name="user.name"  class="form-control"  ></td>
              </tr>
              <tr>
                <td><h3 style="margin:0px">Password</h3></td>
                <td><input type="password" placeholder="Input Password" style="width:80%" name="user.password"  class="form-control"  ></td>
              </tr>
              
                    <tr>
                <td><h3 style="margin:0px">Type</h3></td>
                <td><div class="form-group">
				      <select class="form-control" name = "type"> 
				        <option onclick="changeType()">总店服务员</option> 
				        <option>分店服务员</option> 
				        <option  onclick="changeType()">经理</option>  

				      </select>
				  </div>					
  					</td>
              </tr>
              
              <tr id="subbranch">
                <td><h3 style="margin:0px">Subbranch</h3></td>
                <td><div class="form-group">
				      <select  class="form-control"  name="branch"> 
				      <option selected="selected"  style="display:none">分店服务员选择</option>
				      <%for(int i = 0;i<storeList.getList().size();i++) {%> 
				        <option><%=storeList.getList().get(i).getName()%></option> 
				        <%session.setAttribute("selectBranch", storeList.getList().get(i));} %>
				      </select>
				  </div>					
  					</td>
              </tr>
              
                  
            </tbody>
          </table>
              <input type="submit" class="btn btn-success" >
              </s:form>
        </div>
					</div>
</body>
</html>