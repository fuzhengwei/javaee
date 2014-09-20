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
    <title>用户新增</title>
  </head>
  
  <body>
    <form action="UserServlet?type=userupdate" method="post">
    <input type="hidden" name="user_id" value="${ model.user_id }"/>
	<table border="1" align="center" width="100%">
		<tr>
			<td>用户名：</td><td><input type="text" name="user_name" value="${ model.user_name }"/></td>
		</tr>
		<tr>
			<td>密码：</td><td><input type="text" name="user_password" value="${ model.user_password }"/></td>
		</tr>
		<tr>	
			<td>
				职务：
			</td>
			<td>
				<select name="user_jur">
					<option value="1">管理员</option>
					<option value="2">导员</option>
					<option value="3">班长</option>
				</select>修改前：${ model.user_jur }
			</td>
		</tr>
		<tr>
			<td>备注：</td>
			<td>
				<textarea rows="5" cols="80" name="user_contact">${ model.user_contact }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="修改"/></td>
		</tr>
	</table>
	</form>
	
  </body>
</html>
