<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 引入JSTL表达式 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
	</head>

	<body>
		${ stack }
		<ul>
			<li><a href="view/emp/empadd.jsp" target="_blank">添加Emp信息</a></li>
			<li><a href="view/emp/empaddselective.jsp" target="_blank">添加Emp部分字段信息</a></li>
			<li><a href="emp/doGetEmpList.do" target="_blank">查询Emp信息</a></li>
		</ul>
	</body>
</html>
