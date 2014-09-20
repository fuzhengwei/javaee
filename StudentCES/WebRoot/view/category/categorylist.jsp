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
  <table align="center" border="1" width="100%">
  	<tr>
  		<td>序号</td>
  		<td>类别名称</td>
  		<td>分类权重</td>
  		<td>备注</td>
  		<td>操作</td>
  	</tr>
  	<c:forEach items="${requestScope.modelList}" var="key" varStatus="id" begin="0">
  		<tr>
	  		<td>${ id.index + 1 }</td>
	  		<td>${ key.cat_name }</td>
	  		<td>${ key.cat_weight }%</td>
	  		<td>${ key.cat_remark }</td>
	  		<td>
	  			<a href="CategoryServlet?type=categoryupdate&update_=update_one&cat_id=${ key.cat_id }">修改</a>
	  		</td>
	  	</tr>
  	</c:forEach>
  </table>
  </body>
</html>
