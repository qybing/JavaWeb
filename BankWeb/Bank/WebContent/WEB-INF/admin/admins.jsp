<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>账户</th>
			<th>密码</th>
		</tr>
		<c:forEach items="${admins}" var="admin"> 
		<tr>
			<td>${ admin.name} </td>
			<td>${ admin.password}</td>
		</tr>	
		
		
		
		</c:forEach>   
		
	</table>
</body>
</html>