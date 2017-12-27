<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<base href=" <%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录界面</title>
<script type="text/javascript" src="static/js/jquery-3.2.1.js"></script>
<link rel="stylesheet" type="text/css" href="js/css/bootstrap.css" >
<script type="text/javascript" src="js/js/bootstrap.bundle.js"></script>
<script type="text/javascript" src="js/js/bootstrap.js"></script>
<style type="text/css">
	body{
		margin: 0 auto;
		background: url(images/ground.jpg) no-repeat;
		text-align:center;
		background-repeat: no repeat;
		background-size: 100% 100%;
		background-attachment: fixed;	
	}
	#myTab{
		margin-top: 200px;
	}
	#home-tab,#profile-tab{
		margin-left: 100px;
		color:red;
	}
	input{background-color:#f0ffff}

</style>
</head>
<body>
<div class="container" >
 <ul class="nav nav-tabs" id="myTab" role="tablist">
  <li class="nav-item">
    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">管理员登录</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">客户登录</a>
  </li>
</ul>
<div class="tab-content" id="myTabContent" style="margin:0 auto;">
  <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
		 <form action="teller/login.do" method="post" id="adminform">
		 	管理员用户名：<input type="text" name="username"><br/> 
		 	管理员用户名：<input type="text" name="password"><br/> 
		 	验证码：<img src="image"onclick="imgclick()" id="checkimg" height="50" width="120"/><br>看不清？点击图片换一张<br>
		 	请输入上面的图片中的字符：<input type="text" name="inputcheckcode" id="inputcheckcode"><br>
		 	
		 	<br>${error}<br>
		 	<input type="submit" value="验证" onclick="return formsubmitclick()"><br>

		 </form>
</div>
  <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
    <form action="admin/login.do" method="post" id="customerform">
	 	客户用户名：<input type="text" name="username"><br/> 
	 	客户密码：  <input type="text" name="password"><br/> 
	 	<br>${error}<br>
	 	<input type="submit" value="验证">
 	</form>
  </div>
</div>

 <hr/>
 <script type="text/javascript">
 function formsubmitclick(){
		// 如果本方法返回true，会继续提交表单，如果返回fasle，则不提交表单
		//判断图片中的验证码和用户输入的是否一致，如果一致，要返回true。如果不一致，返回false */
		var userinput=document.getElementById("inputcheckcode").value;
		//var checkcode="${sessionScope.checkcode}";
		var checkcode="";
		$.ajax({
			url:"GetCode.do",
			type:"post",
			dataType:"text",
			success:function(result){
				var form =$("#adminform");
				if(result==userinput){
					//相等了要提交表单
					form.submit();
				}else{
					alert("验证码输入不正确请重新输入");
				}
				//checkcode=result;
			}
		});
		return false;
	}

	function imgclick(){
		//获取img对象
		var img=$("#checkimg");
		img.attr('src','getImgCode.do?'+new Date().getTime()+Math.random())
		
	}
 
 
 
 	
 
 
 
 </script>
</body>
</html>