<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${ sessionScope.spotic_emp.emp_i18n }"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>welcome admin</title>
  </head>
  <body>
  <hr/>
基础数据报表
  <hr/>
	<table>
		<tr>
			<td>雇员人数：</td>
			<td>${ empCount }</td>
		</tr>
		<tr>
			<td>客户人数：</td>
			<td>${ customerCount }</td>
		</tr>
		<tr>
			<td>客户需求订单数：</td>
			<td>${ rfqCount }</td>
		</tr>
		<tr>
			<td>库存订单数：</td>
			<td>${ iUsCount }</td>
		</tr>
		<tr>
			<td>供货商订单数：</td>
			<td>${ iExcessCount }</td>
		</tr>
		<tr>
			<td>市场订单数：</td>
			<td>${ iOutsideCount }</td>
		</tr>
	</table>
	<hr/>
当天任务数据
<hr/>
	<table>
		<tr>
			<td>分配完成量：</td>
			<td>${ ieNow_1 }</td>
		</tr>
		<tr>
			<td>接受执行量：</td>
			<td>${ ieNow_2 }</td>
		</tr>
		<tr>
			<td>提交检查量：</td>
			<td>${ ieNow_3 }</td>
		</tr>
		<tr>
			<td>完成关闭量：</td>
			<td>${ ieNow_4 }</td>
		</tr>
	</table>
<hr/>
历史任务数据
<hr/>
	<table>
		<tr>
			<td>分配完成量：</td>
			<td>${ ie_1 }</td>
		</tr>
		<tr>
			<td>接受执行量：</td>
			<td>${ ie_2 }</td>
		</tr>
		<tr>
			<td>提交检查量：</td>
			<td>${ ie_3 }</td>
		</tr>
		<tr>
			<td>完成关闭量：</td>
			<td>${ ie_4 }</td>
		</tr>
	</table>
<hr/>
  </body>
</html>
