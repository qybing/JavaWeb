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
		<table border="1" style="margin: 0 auto">
		<tr>
			<th>序列</th>
			<th>名字</th>
			<th>账号</th>
			<th>密码</th>
			<th>金额</th>
			<th>电话</th>
			<th colspan="2">操作</th>
			
		</tr>
		<c:forEach items="${clients1}" var="client"> 
		<tr>
			<td>${ client.id}           </td>
			<td>${ client.client_name}  </td>
			<td>${ client.client_id}    </td>
			<td>${ client.client_ps}    </td>
			<td>${ client.client_money} </td>
			<td>${ client.client_phone} </td>
			<td><a href="${pageContext.request.contextPath}">编辑</a> </td>
			<td><a href="#">删除</a> </td>
		</tr>	
		
		
		
		</c:forEach>   
		
	</table>
</body>
</html>