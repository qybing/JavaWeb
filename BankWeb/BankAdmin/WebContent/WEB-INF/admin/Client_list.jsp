<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	pageContext.setAttribute("path", "http://localhost:8080/BankAdmin");
	
%>
<script type="text/javascript" src="${path}/static/js/jquery-3.2.1.js"></script>
<link rel="stylesheet" type="text/css" href="${path}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" >
<script src="${path}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
			<div class="row">
				<div class="col-md-12"><h1>所有信息列表</h1></div>
			</div>
			<div class="row">
					<div class="col-md-4 col-md-offset-8">
						<button type="button" class="btn btn-primary">新增</button>
						<button type="button" class="btn btn-danger">删除</button>
					</div>
			</div>
			<div class="row">
				<div class="col-md-12">
				<table class="table">
					<tr>
						<th>序列</th>
						<th>名字</th>
						<th>账号</th>
						<th>密码</th>
						<th>金额</th>
						<th>电话</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${PageInfo.list }" var="client">
					<tr>
						<th>${ client.id}</th>
						<th>${ client.client_name}</th>
						<th>${ client.client_id}</th>
						<th>${ client.client_ps}</th>
						<th>${ client.client_money}</th>
						<th>${ client.client_phone}</th>
						<th>
						<button class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑</button>
						<button class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除</button>
						</th>
					</tr>
					</c:forEach>
				</table>
				
				</div>
			
			</div>
			<div class="row">
				<!-- 分页文字信息 -->
				<div class="col-md-6">
					当前${PageInfo.pageNum}页,总共${PageInfo.pages}页,总${PageInfo.total}记录。
				
				</div>
				<!-- 分页条信息 -->
				<div class="col-md-6">
					<nav aria-label="Page navigation">
						  <ul class="pagination">
						   <li><a href="#">首页</a></li>
						    <li>
						      <a href="#" aria-label="Previous">
						        <span aria-hidden="true">&laquo;</span>
						      </a>
						    </li>
						    <c:forEach items="${PageInfo.navigatepageNums }" var="page_Num">
						    	<c:if test="${page_Num==PageInfo.pageNum}">
						    		<li class="active"><a href="${path}/teller/clients.do?pn=${page_Num}">${page_Num}</a></li>
						    	</c:if>
						    	<c:if test="${page_Num!=PageInfo.pageNum}">
						    		<li><a href="${path}/teller/clients.do?pn=${page_Num}">${page_Num}</a></li>
						    	</c:if>
						    	
						    </c:forEach>
						  
						    <li>
						      <a href="#" aria-label="Next">
						        <span aria-hidden="true">&raquo;</span>
						      </a>
						    </li>
						    <li><a href="#">末页</a></li>
						  </ul>
					</nav>
				
				
				</div>
			
			</div>
	</div>


<%-- <button type="button" class="btn btn-primary">（首选项）Primary</button>
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
		
	</table> --%>
</body>
</html>