<%@ page language="java" contentType="text/html; charset=utf-8" import="edu.nju.dessertHouse.action.LoginAction"%>
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
<body  style="overflow-x:hidden">
<jsp:useBean id="user"
	type="edu.nju.dessertHouse.model.User"
	scope="session"></jsp:useBean> 
	<jsp:useBean id="storeList"
	type="edu.nju.dessertHouse.model.BranchList"
	scope="session"></jsp:useBean> 
	
	<jsp:useBean id="dessertList"
	type="edu.nju.dessertHouse.model.DessertList"
	scope="session"></jsp:useBean> 
         <div class="row" style="overflow: hidden;scroll:no">
        <div class="col-md-6">
        <s:form action = "addSalePlan" namespace="/DessertHouse">
          <table class="table"  style="margin-top:20px" >
          
            <tbody>
                 <tr id="subbranch">
	                <td><h3 style="margin:0px">Subbranch</h3></td>
	                <td><div class="form-group">
					      <select  class="form-control"  name="branchm"> 
					      <%for(int i = 0;i<storeList.getList().size();i++) {%> 
					        <option><%=storeList.getList().get(i).getName()%></option> 
					        <%} %>
					      </select>
					  </div>					
	  					</td>
              </tr>
    
              <tr id="subbranch">
                <td><h3 style="margin:0px">Dessert</h3></td>
                <td><div class="form-group">
				      <%for(int i = 0;i<dessertList.getList().size();i++) {%> 
				      <div class="form-group" style="width:100%" >
					       	<input  name="chkDessert" type="checkbox" value="<%=dessertList.getList().get(i).getName()%>" /><%=dessertList.getList().get(i).getName()%>
					        <input  name="<%=dessertList.getList().get(i).getName()%>:p" type="text" value="" placeholder="input price per unit"  style="width:140px"/>
					        <input  name="<%=dessertList.getList().get(i).getName()%>:n"  type="text" value="" placeholder="input number for sale" style="width:140px;margin-right:20px" />
				      </div>
				        <%;} %>
				  </div>	
  					</td>
              </tr>
              
              <tr>
                <td nowrap><h3 style="margin:0px;width:40%">Begin Date</h3><input type="date" style="width:40%;display:inline;" name="beginDatem"  class="form-control"  value="<%=session.getAttribute("nextMonday")%>"></td>
                <td style="width:50%" nowrap><h3 style="margin:0px;width:40%">End Date</h3><input type="date" style="width:40%;display:inline;" name="endDatem"  class="form-control"   value="<%=session.getAttribute("nextSunday")%>"></td>
              </tr>
                  
            </tbody>
          </table>
              <input type="submit" class="btn btn-success" >
              </s:form>
        </div>
					</div>
</body>
</html>