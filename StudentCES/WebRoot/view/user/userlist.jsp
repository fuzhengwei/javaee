<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户列表</title>
    
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
    <form action="#">
	<table border="1" align="center" width="100%">
		<tr>
			<td>用户名：<input type="text" name="user_name"/></td>
			<td>
				职务：
				<select name="user_jur">
					<option value="1">管理员</option>
					<option value="2">导员</option>
					<option value="3">班长</option>
				</select>
			</td>
			<td><input type="submit" value="查询"/></td>
		</tr>
	</table>
	</form>
	
	<table border="1" align="center" width="100%">
		<tr>
			<td>序号</td>
			<td>用户名</td>
			<td>职务</td>
			<td>联系方式</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${requestScope.modelList}" var="key" varStatus="id" begin="0">
		<tr>
			<td>${id.index + 1} </td>
			<td>${key.user_name}</td>
			<td>${key.user_jur}</td>
			<td>${key.user_contact}</td>
			<td>
				<a href="UserServlet?type=userupdate_1&user_id=${ key.user_id }">修改</a>|
				<a href="UserServlet?type=userdelete&user_id=${ key.user_id }">删除</a>
			</td>
		</tr>
		</c:forEach>
	</table>
  </body>
</html>
