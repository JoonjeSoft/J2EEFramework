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
	<div id="login_top">
		<img alt="JoonjeSoft" src="resources/images/joonje.png" />
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-12"></div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-primary">
					<div class="panel-heading">系统登录</div>
					<div class="panel-body">
						<form class="form-horizontal" role="form" action="/">
							<div class="form-group">
								<div class="col-md-12">
									<div class="input-group">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-user"></span></span> <input type="text"
											name="username1" class="form-control" placeholder="请输入用户名">
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-12">
									<div class="input-group">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-lock"></span></span> <input
											type="password" name="password" class="form-control"
											placeholder="请输入密码">
									</div>
								</div>
							</div>

							<div class="form-group">
								<div class="col-md-12">
									<div class="checkbox">
										<label> <input type="checkbox" name="rememberMe">
											记住我
										</label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-12">
									<button type="submit" class="btn btn-primary">登陆</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
