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
		<form action="ResultsServlet?type=resultsupdate" method="post">
		<input type="hidden" value="${ model.res_id }" name="res_id"/>
		<table align="center" border="1" width="100%">
			<tr>
				<td width="150px">
					课程：
				</td>
				<td>
					<select name="fk_cou_id">
						<c:forEach items="${requestScope.modelListCou}" var="key" varStatus="id" begin="0">
					  		<c:if test="${ model.cou_name == key.cou_name }">
					  			<option value="${ key.cou_id }" selected="selected">${ key.cou_name }</option>
					  		</c:if>
					  		<c:if test="${ model.cou_name != key.cou_name }">
					  			<option value="${ key.cou_id }">${ key.cou_name }</option>
					  		</c:if>
				  		</c:forEach>
					</select>修改前：${ model.cou_name }
				</td>
			</tr>
			<tr>
				<td>学生：</td>
				<td>
					<select name="fk_stu_id">
					<c:forEach items="${requestScope.modelListStu}" var="key" varStatus="id" begin="0">
						<c:if test="${ model.stu_name == key.stu_name }">
					  		<option value="${ key.stu_id }" selected="selected">${ key.stu_name }</option>
				  		</c:if>
				  		<c:if test="${ model.stu_name != key.stu_name }">
				  			<option value="${ key.stu_id }">${ key.stu_name }</option>
				  		</c:if>
					</c:forEach>
					</select>修改前：${ model.stu_name }
				</td>
			</tr>
			<tr>
				<td>分数：</td>
				<td><input type="text" name="res_fraction" value="${ model.res_fraction }"/></td>
			</tr>
			<tr>
				<td>录入状态：</td>
				<td>
	  				<select name="res_state">
	  					<option value="0">待审核</option>
	  					<option value="1">已审核</option>
	  				</select>修改前：${ model.res_state == '0' ? "待审核":"已审核"}
	  			</td>
			</tr>
			<tr>
				<td>备注：</td>
				<td>
					<textarea rows="5" cols="80" name="res_remark">${ model.res_remark }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="修改"/></td>
			</tr>
		</table>
		</form>
	</body>
</html>
