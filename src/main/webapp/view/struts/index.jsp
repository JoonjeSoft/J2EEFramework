<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>struts2 demo列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<div>
  		<ol>
  			<li><a href="<%=basePath%>">默认action</a></li>
  			<li><a href="hello!dynamicMethod">动态方法调用</a></li>
  			<li>参数传递
  				<form action="hello!param">
  					<input type="text" name="user.name"/>
  					<input type="password" name="user.password"/>
  					<input type="submit"/>
  				</form>
  			</li>
  			<li>
  				<a href="hello!httpElement"> http元素</a>
  			</li>
  			<li>
  				<a href="hello!input">重复提交</a>
  			</li>
  		</ol>
  		<ol>
  			<li><a href="hello!dispatcher">dispatcher</a></li>
  			<li><a href="hello!redirect">redirect</a></li>
  			<li><a href="hello!redirectAction">redirectAction</a></li>
  		</ol>
  	</div>
    <s:debug></s:debug>
  </body>
</html>
