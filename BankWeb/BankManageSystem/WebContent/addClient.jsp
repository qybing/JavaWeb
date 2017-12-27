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


</style>
<script type="text/javascript" src="static/js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" >
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<title>添加用户</title>
</head>
<body>
	<div class="container">
	欢迎${sessionScope.teller}<br>
	${error}<br>
	 <form  class="form-horizontal" action="teller/openAccount.do" enctype="multipart/form-data" method="post" id="adminform">
		<div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">账号</label>
		    <div class="col-sm-10">
		      <input type="text" name="client_id" class="form-control" id="inputEmail3" placeholder="Email">
	    	</div>
  		</div>
  		<div class="form-group">
		    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
		    <div class="col-sm-10">
		      <input type="password" name="client_ps" class="form-control" id="inputPassword3" placeholder="Password">
		    </div>
  		</div>
  		<div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
		    <div class="col-sm-10">
		      <input type="text" name="client_name" class="form-control" id="inputEmail3" placeholder="Email">
	    	</div>
  		</div>
  		<div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">电话</label>
		    <div class="col-sm-10">
		      <input type="text" name="client_phone" class="form-control" id="inputEmail3" placeholder="Email">
	    	</div>
  		</div>
  		<div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">金额</label>
		    <div class="col-sm-10">
		      <input type="text" name="client_money" class="form-control" id="inputEmail3" placeholder="Email">
	    	</div>
  		</div>
  		<div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">头像请上传文件</label>
		    <div class="col-sm-10">
		      <input type="file" name="file" class="form-control" id="inputEmail3" placeholder="Email">
	    	</div>
  		</div>
  		<div class="row">
	  		<div class="col-md-6 col-md-offset-6">
			 <button type="submit" class="btn btn-primary btn-lg">提交</button>
			 </div>	
		</div>
	<!-- 	 	
		 	1：<input type="text" name="client_id"><br/> 
		 	2：<input type="text" name="client_name"><br/>
		    3：<input type="text" name="client_phone"><br/> 
		 	4：<input type="text" name="client_money"><br/>
		 	5：<input type="text" name="client_ps"><br/> 
		 	<input type="submit" value="验证">   -->
	</form>
	</div>
</body>
</html>