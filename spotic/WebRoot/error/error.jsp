<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="error/error.jsp"%>
<%@page import="com.spotic.emp.bean.Spotic_EmpBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<base href="<%=basePath%>">
	<title>error</title>
<style type="text/css">
	*{
		margin:0px;
	}

	.mainDiv{
		width:700px;
		height:400px; 
		background-color:#CCCCCC;
		margin:0 auto;
		margin-top:100px;
	}

</style>

</head>

<body>
<div class="mainDiv">
	<div style="font-size:300px;color: red;">Err</div>
	<div style="float:right;font-size:36px;margin-top:-20px;">${ error }<hr/>
	<a href="index.jsp" style="font-size:12px;position:absolute;margin-top:10px;">返回主页</a>
	</div>
</div>

</body>
</html>
