<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="resources/bootstrap/3.0.3/css/bootstrap.css"
	rel="stylesheet">
<script src="resources/jquery/1.10.2/jquery-1.10.2.min.js"></script>
<script src="resources/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container">
		<form class="form-horizontal" style="max-width: 330px;padding: 15px;margin: 0 auto;" role="form">
			<div class="form-group" >
				<div class="input-group input-group-lg" style="width:100%">
					<span class="input-group-addon glyphicon glyphicon-user"></span> <input
						type="email" class="form-control" id="exampleInputEmail1" 
						placeholder="Enter email">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group input-group-lg" style="width:100%">
					<span class="input-group-addon glyphicon glyphicon-lock"></span><input
						type="password" class="form-control" id="exampleInputPassword1"
						placeholder="Password">
				</div>
			</div>
			<div class="checkbox">
				<label> <input type="checkbox"> ¼Ç×¡ÎÒ
				</label>
			</div>
			<button type="submit" class="btn btn-lg btn-primary btn-block">µÇÂ¼</button>
		</form>
	</div>
</body>

</html>
