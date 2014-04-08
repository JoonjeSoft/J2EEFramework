<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">

<title>JoonjeSoft</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="JoonjeSoft login">
<meta http-equiv="description" content="login page">
<link href="resources/bootstrap/3.1.1/css/bootstrap.css"
	rel="stylesheet">
<link href="resources/css/home.css" rel="stylesheet">
<script src="resources/jquery/1.10.2/jquery-1.10.2.min.js"></script>
<script src="resources/bootstrap/3.1.1/js/bootstrap.js"></script>
</head>

<body>
	<nav id="nav" class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">JoonjeSoft</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="#">主页</a></li>
			<li><a href="#">关于</a></li>
		</ul>
		<div class="navbar-right">
			<a class="btn btn-primary navbar-btn " href="logout" role="button"><shiro:authenticated>退出</shiro:authenticated><shiro:notAuthenticated>登陆</shiro:notAuthenticated></a>
		</div>
	</div>
	</nav>
		<div class="row-fluid">
			<div class="col-md-2">
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Profile</a></li>
					<li><a href="#">Messages</a></li>
				</ul>
			</div>
		</div>
	
</body>

</html>
