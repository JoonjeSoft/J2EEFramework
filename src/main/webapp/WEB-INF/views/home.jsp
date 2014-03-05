<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
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
<link href="resources/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
<link href="resources/css/home.css" rel="stylesheet">
<script src="resources/jquery/1.10.2/jquery-1.10.2.min.js"></script>
<script src="resources/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container">
		<a class="btn btn-primary" href="logout" role="button">退出</a>
	</div>
</body>

</html>
