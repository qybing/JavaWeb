<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/admin/login.do" method="post">
		账号：<input type="text" name="name"/><br>
		密码:<input type="text" name="password"/><br>
		<input type="submit" value="注册">
	</form>
</body>
</html>