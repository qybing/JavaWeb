<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	欢迎${sessionScope.teller}<br>
	 <form action="${pageContext.request.contextPath}/teller/openAccount.do" method="post" id="adminform">
		 	1：<input type="text" name="client_id"><br/> 
		 	2：<input type="text" name="client_name"><br/>
		    3：<input type="text" name="client_phone"><br/> 
		 	4：<input type="text" name="client_money"><br/>
		 	5：<input type="text" name="client_ps"><br/> 
		 	<input type="submit" value="验证">  
	</form>
</body>
</html>