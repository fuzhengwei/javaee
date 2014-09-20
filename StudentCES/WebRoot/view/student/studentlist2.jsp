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
    
    <title>studentlist</title>
    
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
		<form action="" method="post">
			<table align="center" border="1" width="100%">
				<tr>
					<td>
						学号：
						<input type="text" />
					</td>
					<td>
						姓名：
						<input type="text" />
					</td>
					<td>
						<input type="submit" value="查询" />
					</td>
				</tr>

			</table>
		</form>
		
		<table align="center" border="1" width="100%">
			<tr>
				<td>学号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>生日</td>
				<td>民族</td>
				<td>政治面貌</td>
				<td>专业编号</td>
				<td>班级编号</td>
				<td>寝室编号</td>
				<td>联系方式</td>
			</tr>
			<c:forEach items="${requestScope.modelList}" var="key" varStatus="id" begin="0">
				<tr>
					<td>${ key.stu_id }</td>
					<td>${ key.stu_name }</td>
					<td>${ key.stu_sex }</td>
					<td>${ key.stu_birthday }</td>
					<td>${ key.stu_nation }</td>
					<td>${ key.stu_pa }</td>
					<td>${ key.stu_pro_number }</td>
					<td>${ key.stu_class_number }</td>
					<td>${ key.stu_bedroom_number }</td>
					<td>${ key.stu_contact }</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
