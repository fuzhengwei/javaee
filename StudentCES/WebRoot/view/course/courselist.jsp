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
    <title></title>
  </head>
  
  <body>
  	<form action="" method="post">
  	<table align="center" border="1" width="100%">
  		<tr>
  			<td>
  				课程类别：
  				<select name="fk_cat_id">
  					<option value="3">智育</option>
  					<option value="2">德育</option>
  					<option value="4">体育</option>
  					<option value="5">实践与创新能力</option>
  				</select>
  			</td>
  			<td>
  				课程名称：
  				<input type="text" name="cou_name"/>
  			</td>
  			<td>
  				<input type="submit" value="查询"/>
  			</td>
  		</tr>
  	</table>
  	</form>
  	
  	<table border="1" align="center" width="100%">
  		<tr>
  			<td>序号</td>
  			<td>课程分类</td>
  			<td>课程名称</td>
  			<td>备注</td>
  			<td>操作</td>
  		</tr>
  		<c:forEach items="${requestScope.modelList}" var="key" varStatus="id" begin="0">
  			<tr>
	  			<td>${ id.index + 1 }</td>
	  			<td>${ key.fk_cat_id }</td>
	  			<td>${ key.cou_name }</td>
	  			<td>${ key.cou_remark }</td>
	  			<td>
	  				<a href="CourseServlet?type=coursebean&cou_id=${ key.cou_id }">修改</a>|
	  				<a href="CourseServlet?type=coursedelete&cou_id=${ key.cou_id }">删除</a>
	  			</td>
	  		</tr>
  		</c:forEach>
  	</table>
  	
  </body>
</html>
