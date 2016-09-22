<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="common/head.jsp"%>
<title>首页</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Index</title>
</head>
<body>
	<div class="head"><br/></div>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="text-left">欢迎<shiro:principal/>登录！</span>
				<span class="text-center">用户列表</span>
				<p class="text-right"><a href="${basePath }logout">退出</a></p>
			</div>
			<div class="panel-body">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th style="display: none;">id</th>
							<th>用户</th>
							<th>角色</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="v" items="${list }">
							<tr>
								<td style="display: none;">${v.id }</td>
								<td>${v.username }</td>
								<td>${v.rolename }</td>
								<td>
									<a href="${basePath }user/view" class="btn btn-primary">查看</a>
									<a href="${basePath }user/edit" class="btn btn-primary">修改</a>
									<shiro:hasRole name="admin"><a href="${basePath }user/del" class="btn btn-primary">删除</a></shiro:hasRole>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>