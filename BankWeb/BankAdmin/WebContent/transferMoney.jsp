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
	label{
		font-size: 20px;
		color: red
	}
	input {
	width:120px;
}


</style>
<script type="text/javascript" src="static/js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" >
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<title>转账</title>
</head>
<body>
	<form action="teller/transferMoney.do" method="post" id="adminform">
		<div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">转出账号</label>
		    <div class="col-sm-10">
      		<input type="text" name="fromeName" style="width:200px;" class="form-control" id="inputEmail3" placeholder="Email">
    		</div>
  		</div>
  		<div class="form-group">
		    <label for="inputPassword3" class="col-sm-2 control-label">转入账号</label>
		    <div class="col-sm-10">
		      <input type="text" name="toName" style="width:200px;" class="form-control" id="inputPassword3" placeholder="Password">
		    </div>
  		</div>
  		<div class="form-group">
		    <label for="inputPassword3" class="col-sm-2 control-label">金额</label>
		    <div class="col-sm-10">
		      <input type="text" name="money" style="width:200px;" class="form-control" id="inputPassword3" placeholder="Password">
		    </div>
  		</div>
			
		 	
		 	<!-- 转出账号：<input type="text" name="fromeName"><br/> 
		 	转入账号：<input type="text" name="toName"><br/>
		           金额：<input type="text" name="money"><br/>  -->
		 	<div class="row">
		  		<div class="col-md-10 col-md-offset-2">
				 <button type="submit" class="btn btn-primary btn-lg">提交</button>
				 </div>	
			</div>
	</form>
</body>
</html>