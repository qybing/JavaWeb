<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<base href=" <%=basePath%>"> 
<script type="text/javascript" src="static/js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" >
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<title>查询结果</title>
欢迎${sessionScope.teller}<br>
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
					<c:forEach items="${PageInfo.list}" var="client">
					<tr>
						<th>${ client.id}</th>
						<th>${ client.client_name}</th>
						<th>${ client.client_id}</th>
						<th>${ client.client_ps}</th>
						<th>${ client.client_money}</th>
						<th>${ client.client_phone}</th>
						<th>
						<button class="btn btn-primary btn-sm" type="button" id="myButton" name="${client.id}" ><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑</button>
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
					当前${PageInfo.pageNum}页,总共${PageInfo.pages}页,总${PageInfo.total}记录
				</div>
				<!-- 分页条信息 -->
				<div class="col-md-6">
					<nav aria-label="Page navigation">
						  <ul class="pagination">
						   <li><a href="teller/clients.do?pn=1">首页</a></li>
						  <c:if test="${PageInfo.hasPreviousPage }">
						  	<li>
						      <a href="teller/clients.do?pn=${PageInfo.pageNum-1}" aria-label="Previous">
						        <span aria-hidden="true">&laquo;</span>
						      </a>
						    </li>
						  </c:if>
						    
						    <c:forEach items="${PageInfo.navigatepageNums }" var="page_Num">
						    	<c:if test="${page_Num==PageInfo.pageNum}">
						    		<li class="active"><a href="teller/clients.do?pn=${page_Num}">${page_Num}</a></li>
						    	</c:if>
						    	<c:if test="${page_Num!=PageInfo.pageNum}">
						    		<li><a href="teller/clients.do?pn=${page_Num}">${page_Num}</a></li>
						    	</c:if>
						    	
						    </c:forEach>
						    <li><a href="teller/clients.do?pn=${PageInfo.pages}">末页</a></li>
						  	<c:if test="${PageInfo.hasNextPage }">
							  	<li>
							      <a href="teller/clients.do?pn=${PageInfo.pageNum+1}" aria-label="Next">
							        <span aria-hidden="true">&raquo;</span>
							      </a>
							    </li>
						    </c:if>
						 
						    
						  </ul>
					</nav>
				
				
				</div>
			
			</div>
	</div>
</body>
<script type="text/javascript">
  $('button#myButton').click(function() {
	  var id = parseInt($(this).attr("name"));
	  var url = "teller/findClientById.do?acc_id="+id;
	  window.location.href = url;	
})
</script>
</html>