<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<title>cateory</title>
	</head>

	<body>
		<form action="CategoryServlet?type=categoryadd" method="post">
		<table align="center" border="1" width="100%">
			<tr>
				<td width="150px">课程分类名称：</td>
				<td><input type="text" name="cat_name"/></td>
			</tr>
			<tr>
				<td>课程权重：</td>
				<td><input type="text" name="cat_weight"/></td>
			</tr>
			<tr>
				<td>备注</td>
				<td>
					<textarea rows="5" cols="80" name="cat_remark"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="保存"/>
				</td>
			</tr>
		</table>
		</form>
	</body>
</html>
