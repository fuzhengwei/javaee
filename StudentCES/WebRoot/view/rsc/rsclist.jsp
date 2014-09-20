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
    
    <title>综合成绩列表</title>
  </head>
  
  <body>
    <form action="RscServlet?type=serach" method="post">
	<table border="1" align="center" width="100%">
		<tr>
			<td>学生姓名：<input type="text" name="stu_name"/></td>
			<td><input type="submit" value="查询"/></td>
		</tr>
	</table>
	</form>
	
	<table border="1" align="center" width="100%">
		<tr align="center">
			<td>序号</td>
			<td>学生姓名</td>
			<td>个人总分</td>
			<td>课程类别</td>
			<td>当前类别分</td>
			<td>权重比</td>
			<td>各科权重分</td>
		</tr>
		<c:forEach items="${requestScope.modelList}" var="key" varStatus="id" begin="0">
		<tr align="center">
			<td>${ id.index + 1 } </td>
			<td>${ key.stu_name }</td>
			<td>${ requestScope.modelMap[key.rsc_id] }</td>
			<td>${ key.cat_name }</td>
			<td>${ key.rsc_o_fraction }</td>
			<td>${ key.rsc_weight }%</td>
			<td>${ key.rsc_fraction }</td>
		</tr>
		</c:forEach>
	</table>
  </body>
</html>
