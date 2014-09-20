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
		<form action="emp/doUpdateEmp.do?empId=${ model.empId }" method="post">
		<table border="1">
			<tr>
				<td>雇员姓名</td>
				<td><input type="text" name="empName" value="${ model.empName }"/></td>
			</tr>
			<tr>
				<td>雇员年龄</td>
				<td><input type="text" name="empAge" value="${ model.empAge }"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="update"/>
				</td>
			</tr>
		</table>
		</form>
	</body>
</html>
