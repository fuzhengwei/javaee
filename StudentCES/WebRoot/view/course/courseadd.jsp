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
    <title>course</title>
  </head>
  
  <body>
  	<form action="CourseServlet?type=courseadd" method="post">
  	<table align="center" border="1" width="100%">
  		<tr>
  			<td>课程分类：</td>
  			<td>
  				<select name="fk_cat_id">
  					<option value="3">智育</option>
  					<option value="2">德育</option>
  					<option value="4">体育</option>
  					<option value="5">实践与创新能力</option>
  				</select>
  			</td>
  		</tr>
  		<tr>
  			<td>课程名称：</td>
  			<td><input type="text" name="cou_name"/></td>
  		</tr>
  		<tr>
  			<td>备注：</td>
  			<td>
  				<textarea rows="5" cols="80" name="cou_remark"></textarea>
  			</td>
  		</tr>
  		<tr>
  			<td colspan="2"><input type="submit" value="保存"/></td>
  		</tr>
  	</table>
  	</form>
  </body>
</html>
