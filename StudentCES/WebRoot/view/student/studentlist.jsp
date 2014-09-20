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
				<td>操作</td>
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
					<td>
						<a href="StudentServlet?type=userupdate_1&stu_id=${ key.stu_id }">修改</a>|
						<a href="StudentServlet?type=deletestudent&stu_id=${ key.stu_id }">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
