<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	pageContext.setAttribute("path", "http://localhost:8080/BankAdmin");
	
%>
<style type="text/css">
	body{
		background: url(${path}/images/ground.jpg) no-repeat;
		background-repeat: no repeat;
		background-size: 100% 100%;
		background-attachment: fixed;
	}
	label{
		font-size: 20px;
		color: red
	}


</style>
<script type="text/javascript" src="${path}/static/js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="${path}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" >
<script src="${path}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	欢迎${sessionScope.teller}<br>
	 <form  class="form-horizontal" action="${pageContext.request.contextPath}/teller/updateClient.do" method="post" id="adminform">
		<input type="hidden" name="id" class="form-control" id="inputEmail3" value="${client.id}">		
		<div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">账号</label>
		    <div class="col-sm-10">
		      <input type="text" name="client_id" class="form-control" id="inputEmail3" value="${client.client_id}">
	    	</div>
  		</div>
  		<div class="form-group">
		    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
		    <div class="col-sm-10">
		      <input type="password" name="client_ps" class="form-control" id="inputPassword3" value="${client.client_ps}">
		    </div>
  		</div>
  		<div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
		    <div class="col-sm-10">
		      <input type="text" name="client_name" class="form-control" id="inputEmail3" value="${client.client_name}">
	    	</div>
  		</div>
  		<div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">电话</label>
		    <div class="col-sm-10">
		      <input type="text" name="client_phone" class="form-control" id="inputEmail3" value="${client.client_phone}">
	    	</div>
  		</div>
  		<div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">金额</label>
		    <div class="col-sm-10">
		      <input type="text" name="client_money" class="form-control" id="inputEmail3" value="${client.client_money}">
	    	</div>
  		</div>
  		<div class="row">
	  		<div class="col-md-6 col-md-offset-6">
			 <button type="submit" class="btn btn-primary btn-lg">提交</button>
			 </div>	
		</div>
	</form>
	</div>
</body>
</html>