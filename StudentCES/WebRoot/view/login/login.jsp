<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>StudentCES 登录</title>
<link type="text/css" rel="stylesheet" href="view/login/css/ces.css" />
</head>

<body>
	<form action="LoginServlet" method="post">
	<div class="topDiv">
	</div>
	<div class="bodyDiv">
		<div class="loginImg"></div>
		<input type="text" name="name" class="name"/>
		<input type="password" name="password" class="password"/>
		<div class="radiodiv">
			<label><input type="radio" name="us" value="user" checked="checked"/> user</label>&nbsp;&nbsp;
			<label><input type="radio" name="us" value="student"/> student</label>
		</div>
		<input type="submit" value="登&nbsp;&nbsp;录" class="loginBut"/>
	</div>
	</form>
</body>
</html>
