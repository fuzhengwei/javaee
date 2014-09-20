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
    <title>results</title>
  </head>
  
  <body>
  	<table align="center" border="1" width="100%">
  		<tr>
  			<td>课程名称：
  				<input type="text"/>
  			</td>
  			<td>
  				学生姓名：
  				<input type="text"/>
  			</td>
  			<td>录入状态：
  				<select>
  					<option value="0">待审核</option>
  					<option value="1">已审核</option>
  				</select>
  			</td>
  			<td>
  				<input type="submit" value="查询"/>
  			</td>
  		</tr>
  	</table>
  
  	<table align="center" border="1" width="100%">
  		<tr align="center">
  			<td>序号</td>
  			<td>课程类别</td>
  			<td>课程名称</td>
  			<td>学生姓名</td>
  			<td>分数</td>
  			<td>录入时间</td>
  			<td>状态</td>
  			<td>备注</td>
  			<td>操作</td>
  		</tr>
  		<c:forEach items="${requestScope.modelList}" var="key" varStatus="id" begin="0">
  			<tr align="center">
	  			<td>${ id.index + 1 }</td>
	  			<td>${ key.cat_name }</td>
	  			<td>${ key.cou_name }</td>
	  			<td>${ key.stu_name }</td>
	  			<td>${ key.res_fraction }</td>
	  			<td>${ key.res_entrydate }</td>
	  			<td>${ key.res_state == '0' ? "待审核":"已审核"}</td>
	  			<td>${ key.res_remark }</td>
	  			<td>
					<a href="ResultsServlet?type=resultsbean&res_id=${ key.res_id }">修改</a>|
					<a href="ResultsServlet?type=resultsdelete&res_id=${ key.res_id }">删除</a>
				</td>
	  		</tr>
  		</c:forEach>
  		
  	</table>
  </body>
</html>
