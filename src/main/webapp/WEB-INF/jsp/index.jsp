<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="common/head.jsp"%>
<title>首页</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${basePath}js/modules/main/index.js"></script>
<script type="text/javascript">
	//初始化
	index.init();
</script>

<title>Index</title>
</head>
<body>
	<div class="head"><br/></div>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="text-center">用户列表</h3>
				<span>这里，以管理员(admin)角色是可以操作所有功能点的，而一般用户(employee)在数据库配置只有查看功能，其中删除功能按钮使用shiro标签做限制，修改功能页面没有限制，但后台也做了shiro注解，总之，各种各样都写下^_^</span>
				<p class="text-right">
					<span>欢迎<shiro:principal/>登录！</span>
					<a href="${basePath }logout">退出</a>
				</p>
			</div>
			<div class="panel-body">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>用户</th>
							<th>角色</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="v" items="${list }">
							<tr>
								<td>${v.username }</td>
								<td>${v.rolename }</td>
								<td>
									<a href="javascript:void(0);" class="btn btn-primary" id="view" onclick="index.openShow(index.url.viewUrl, '查看信息')">查看</a>
									<a href="javascript:index.openShow(index.url.editUrl, '修改信息')" class="btn btn-primary">修改</a>
									<shiro:hasRole name="admin"><a href="javascript:alert(${v.id });" class="btn btn-primary">删除</a></shiro:hasRole>
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