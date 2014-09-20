<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="error/error.jsp"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
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
		<form action="Spotic_CustomerServlet?type=empselectserach" method="post">
		<!-- 查询 -->
		<table border="1" class="searchTable">
			<tr>
				<td><fmt:message key="spotic_customer.customer_name"/><%--客户姓名：--%></td>
				<td>
					<input type="text" name="customer_name" maxlength="20" value="${ customer_name }"/>
				</td>
				<td>
					<input type="submit" value="Find" style="cursor: pointer; font-weight: bolder;"/>
					<input type="reset" value="Clear" style="cursor: pointer; font-weight: bolder;"/>
				</td>
			</tr>
		</table>
		</form>
		 <c:if test="${fn:length(spotic_customer) == 0}">
		  	Can't find valid infomation
		  </c:if>
	  	<c:if test="${fn:length(spotic_customer) != 0}">
		<!-- 列表 -->
		<table border="1" style="font-size: 14px;" width="100%">
			<tr align="center" style="background-color: #333333; color: white; font-weight: bolder;">
				<td></td>
				<td><fmt:message key="spotic_customer.customer_company"/><%--客户公司：--%></td>
				<td><fmt:message key="spotic_customer.customer_name"/><%--客户姓名：--%></td>
				<td><fmt:message key="spotic_customer.customer_phone"/><%--客户电话：--%></td>
				<td><fmt:message key="spotic_customer.customer_fax"/><%--客户传真：--%></td>
				<td><fmt:message key="spotic_customer.customer_email"/><%--客户邮箱：--%></td>
				<td><fmt:message key="spotic_customer.customer_type"/><%--客户类型：--%></td>
				<td><fmt:message key="spotic_customer.customer_remarks"/><%--客户备注：--%></td>
				<td><fmt:message key="jsp.operation"/></td>
			</tr>
			<c:forEach items="${spotic_customer}" var="key" varStatus="id" begin="0">
				<tr align="center">
					<td>${ id.index + 1 }</td>
					<td>${ key.customer_company }</td>
					<td>${ key.customer_name }</td>
					<td>${ key.customer_phone }</td>
					<td>${ key.customer_fax }</td>
					<td>${ key.customer_email }</td>
					<td>
						<c:choose>
							<c:when test="${key.customer_type  == 1}">inventory<%--本公司库存--%></c:when>
							<c:when test="${key.customer_type  == 2}">customer<%--客户--%></c:when>
							<c:when test="${key.customer_type  == 3}">excess<%--供应商--%></c:when>
							<c:when test="${key.customer_type  == 4}">outside<%--市场--%></c:when>
						</c:choose>
					</td>
					<td>${ key.customer_remarks }</td>
					<td>
						 <a href="Spotic_CustomerServlet?type=customerforupdate&customer_id=${ key.customer_id }"><fmt:message key="jsp.update"/></a>
						 |
						 <a href="Spotic_CustomerServlet?type=customerdelete&customer_id=${ key.customer_id }" class="delete"><fmt:message key="jsp.delete"/></a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="9" align="right">
					<c:if test="${page > 1}">
						<a href="Spotic_CustomerServlet?type=customerlist&page=${ page <= 1?1:page-1 }"><fmt:message key="jsp.onpage"/></a>
						|
					</c:if>
					<a href="Spotic_CustomerServlet?type=customerlist&page=${ page + 1 }"><fmt:message key="jsp.nextpage"/></a>
				</td>
			</tr>
		</table>
		</c:if>
	</body>
</html>
