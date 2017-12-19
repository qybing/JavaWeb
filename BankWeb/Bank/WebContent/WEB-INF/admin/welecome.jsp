<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	ID= ${admin.id}<br>
	账号=${admin.name}<br>
	密码=${admin.password} <br>
	<a href="${pageContext.request.contextPath}/admin/findAllAdmin.do">所有</a>

</body>
</html>