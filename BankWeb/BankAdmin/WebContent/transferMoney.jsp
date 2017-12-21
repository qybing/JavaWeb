<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/teller/transferMoney.do" method="post" id="adminform">
		 	转出账号：<input type="text" name="fromeName"><br/> 
		 	转入账号：<input type="text" name="toName"><br/>
		           金额：<input type="text" name="money"><br/> 
		 	<input type="submit" value="验证">  
	</form>
</body>
</html>