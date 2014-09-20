<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="error/error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>inventory for add</title>
    
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
  	<ul>
		<li><a href="Spotic_InventoryServlet?type=inventoryforadd&customer_type=1" target="_self">inventoryAdd</a></li>
		<li><a href="Spotic_InventoryServlet?type=inventoryforadd&customer_type=3" target="_self">excessAdd</a></li>
		<li><a href="Spotic_InventoryServlet?type=inventoryforadd&customer_type=4" target="_self">outsideAdd</a></li>
	</ul>
  </body>
</html>
