<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<base href=" <%=basePath%>"> 
<style type="text/css">
	body{
		background: url(images/ground.jpg) no-repeat;
		background-repeat: no repeat;
		background-size: 100% 100%;
		background-attachment: fixed;
	}
	#lianjie{
		color:red;
		font-size: 30px;	
	}


</style>
<script type="text/javascript" src="static/js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" >
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<title>主菜单</title>
</head>
<body>
	<div class="container">
	<div class="row">
		<div class="col-md-12"> 
			<a id="lianjie" href="addClient.jsp">开户</a><br>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<a id="lianjie" href="transferMoney.jsp">转账</a><br>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
				<a id="lianjie" href="teller/clients.do">富豪</a><br>
		</div>
	</div>
	<div class="row"></div>
	</div>
	
</body>
</html>