<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">

<title>JoonjeSoft</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="resources/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="resources/jquery/1.10.2/jquery-1.10.2.min.js"></script>
<script src="resources/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container">
		<form class="form-horizontal" role="form" action="/">
			 <div class="form-group">
    			<label for="username" class="col-md-2 control-label">用户名</label>
    			<div class="col-md-10">
    				<input type="text" class="form-control" id="username" name="username" placeholder="输入用户名">
    			</div>
  			</div>
  			<div class="form-group">
    			<label for="password" class="col-md-2 control-label">密码</label>
    			<div class="col-md-10">
    				<input type="password" class="form-control" id="password" placeholder="输入密码">
    			</div>
  			</div>
  			<div class="form-group">
    			<div class="col-md-offset-2 col-md-10">
		  			<div class="checkbox">
					    <label>
					      <input type="checkbox" name="rememberMe"> 记住我
					    </label>
				  	</div>
			  	</div>
		  	</div>
		  	<div class="form-group">
			  	<div class="input-group input-group-lg">
	  				<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
	  				<input type="text" name="username1" class="form-control" placeholder="Username">
				</div>
			</div>
		  	<div class="form-group">
    			<div class="col-md-offset-2 col-md-10">
  					<button type="submit" class="btn btn-default">登陆</button>
  				</div>
  			</div>
		</form>
	</div>
</body>

</html>
