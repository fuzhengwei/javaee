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
		<table border="1">
			<tr>
				<td>
					序号
				</td>
				<td>
					姓名
				</td>
				<td>
					年龄
				</td>
				<td>
					操作
				</td>
			</tr>
			<c:forEach items="${requestScope.modelList}" var="key" varStatus="id"
				begin="0">
				<tr>
					<td>${ id.index +1 }</td>
					<td>${ key.empName }</td>
					<td>${ key.empAge }</td>
					<td align="right">
						<a href="emp/doGetEmpById.do?empId=${ key.empId }" target="_blank">修改</a>
						|
						<a href="emp/doDeleteEmpById.do?empId=${ key.empId }" target="_blank">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
