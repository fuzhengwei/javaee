<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>results</title>
	</head>

	<body>
		<form action="ResultsServlet?type=resultsadd" method="post">
		<table>
			<tr>
				<td>
					课程：
				</td>
				<td>
					<select name="fk_cou_id">
						<c:forEach items="${requestScope.modelListCou}" var="key" varStatus="id" begin="0">
					  		<option value="${ key.cou_id }">${ key.cou_name }</option>
				  		</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>学生：</td>
				<td>
					<select name="fk_stu_id">
					<c:forEach items="${requestScope.modelListStu}" var="key" varStatus="id" begin="0">
						<option value="${ key.stu_id }">${ key.stu_name }</option>
					</c:forEach>
						
					</select>
				</td>
			</tr>
			<tr>
				<td>分数：</td>
				<td><input type="text" name="res_fraction"/></td>
			</tr>
			<tr>
				<td>备注：</td>
				<td>
					<textarea rows="5" cols="80" name="res_remark"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="保存"/></td>
			</tr>
		</table>
		</form>
	</body>
</html>
