<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="error/error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<fmt:setLocale value="${ sessionScope.spotic_emp.emp_i18n }"/>
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
	<title>雇员列表</title>
	<script type="text/javascript" language="javascript" src="res/scripts/lib/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){

			$(".delete").click(function(){
				var r=confirm("Are you sure to delete !");
				
				if (r == true){
				  return true;
				}else{
				  return false;
				}
				
			});	
		});
	</script>
</head>
<body>
	
		<!-- 查询 -->
		<form action="Spotic_EmpServlet?type=empselectserach" method="post">
		<table border="1" class="searchTable" >
			<tr>
				<td><fmt:message key="spotic_emp.emp_name"/><%--雇员姓名：--%></td>
				<td>
					<input type="text" name="emp_name" value="${ emp_name }" maxlength="20"/>
				</td>
				<td><fmt:message key="spotic_emp.emp_power"/><%--权限：--%></td>
				<td>
					<select name="emp_power">
						<option value="1">admin</option>
						<option value="2">sales</option>
						<option value="3">buyer</option>
					</select>
				</td>
				<td>
					<input type="submit" value="Find" style="cursor: pointer; font-weight: bolder;"/>
					<input type="reset" value="Clear" style="cursor: pointer; font-weight: bolder;"/>
				</td>
			</tr>
		</table>
		</form>
		<hr />
		 <c:if test="${fn:length(requestScope.modelList) == 0}">
	  	Can't find valid infomation
	  </c:if>
  	<c:if test="${fn:length(requestScope.modelList) != 0}">
		<!-- 列表 -->
		 <table border="1" style="font-size: 12px; width: 100%;">
		<thead>
			<tr align="center" style="background-color: #333333; color: white; font-weight: bolder;">
				<th></th>
				<th><fmt:message key="spotic_emp.emp_name"/><%--雇员姓名：--%></th>
				<th><fmt:message key="spotic_emp.emp_phone"/><%--联系电话：--%></th>
				<th><fmt:message key="spotic_emp.emp_creatdate"/><%--创建日期：--%></th>
				<th><fmt:message key="spotic_emp.emp_power"/><%--权限：--%></th>
				<th><fmt:message key="spotic_emp.emp_state"/><%--状态：--%></th>
				<th><fmt:message key="spotic_emp.emp_i18n"/><%--国际化：--%></th>
				<th><fmt:message key="spotic_emp.emp_remarks"/><%--备注：--%></th>
				<th><fmt:message key="jsp.operation"/></th>
			</tr>
		</thead>
			<c:forEach items="${requestScope.modelList}" var="key" varStatus="id" begin="0">
			<tr align="center">
				<td>
					${ id.index + 1 }
				</td>
				<td>
					${ key.emp_name }
				</td>
				<td>
					${ key.emp_phone }
				</td>
				<td>
					${ key.emp_createdate }
				</td>
				<td>
				<c:choose>
					<c:when test="${key.emp_power == 1}">
						admin
					</c:when>
					<c:when test="${key.emp_power == 2}">
						sales
					</c:when>
					<c:otherwise>
						buyer
					</c:otherwise>
				</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${key.emp_state == 0}">
							open
						</c:when>
						<c:otherwise>
							close
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					${ key.emp_i18n }
				</td>
				<td>
					${ key.emp_remarks }
				</td>
				<td>
					<a href="Spotic_EmpServlet?type=empforupdate&emp_id=${ key.emp_id }"><fmt:message key="jsp.update"/></a>
					|
					<a href="Spotic_EmpServlet?type=empdelete&emp_id=${ key.emp_id }" class="delete"><fmt:message key="jsp.delete"/></a>
				</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="9" align="right">
					<c:if test="${page > 1}">
						<a href="Spotic_EmpServlet?type=emplist&page=${ page <= 1?1:page-1 }"><fmt:message key="jsp.onpage"/></a>
						|
					</c:if>
					<a href="Spotic_EmpServlet?type=emplist&page=${ page + 1 }"><fmt:message key="jsp.nextpage"/></a>
				</td>
			</tr>
		</table>
		</c:if>
	</body>
</html>
