<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%-- ${ teller.teller_id}<br>
		${ teller.teller_name}<br>
		${ teller.teller_ps}<br>
		${ teller.subbank_id}<br>
		<a href="${pageContext.request.contextPath}/"></a> --%>
		<form action="${pageContext.request.contextPath}/teller/transferMoney.do" method="post">
		转钱账号：<input type="text" name="A"/><br>
		转钱账号：<input type="text" name="B"/><br>
		钱:<input type="text" name="money"/><br>
		<input type="submit" value="注册">
	</form>
		
</body>
</html>