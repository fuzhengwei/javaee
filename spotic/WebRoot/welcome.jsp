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
    <title>welcome</title>
  </head>
  
  <body>
  	个人任务列表：
	<table border="1" width="100%" style="font-size: 14px;">
		<tr align="center">
			<td></td>
			<td><fmt:message key="spotic_inventory.inventory_part_no"/><%--物料编号：--%></td>
			<td><fmt:message key="spotic_emp_inventory.fk_emp_id"/><%--任务执行雇员--%></td>
			<td><fmt:message key="spotic_emp_inventory.ei_state"/><%--订单执行状态--%></td>
 			<td><fmt:message key="spotic_inventory.inventory_allto_state"/><%--任务分配状态:--%></td>
 			<td><fmt:message key="spotic_emp_inventory.ei_date_1"/><%--分配任务时间--%></td>
 			<td><fmt:message key="spotic_emp_inventory.ei_date_2"/><%--接收执行时间--%></td>
 			<td><fmt:message key="spotic_emp_inventory.ei_date_3"/><%--提交检查时间--%></td>
 			<td><fmt:message key="spotic_emp_inventory.ei_date_4"/><%--完成关闭时间--%></td>
			<td>操作</td>
		</tr>
		<c:forEach items="${requestScope.modelList}" var="key" varStatus="id" begin="0">
 			
 			<tr align="center">
	 			<td>${ id.index + 1 }</td>
	 			<td>${ key.inventory_part_no }</td>
	 			<td>${ key.emp_name }</td>
	 			<td>
	 			<c:choose>
						<c:when test="${key.inventory_state == 11}">
							准备销售
						</c:when>
						<c:when test="${key.inventory_state == 12}">
							开始销售
						</c:when>
						<c:when test="${key.inventory_state == 13}">
							销售完成
						</c:when>
						<c:when test="${key.inventory_state == 14}">
							销售异常
						</c:when>
						<c:when test="${key.inventory_state == 31}">
							准备供货
						</c:when>
						<c:when test="${key.inventory_state == 32}">
							开始供货
						</c:when>
						<c:when test="${key.inventory_state == 33}">
							供货完成
						</c:when>
						<c:when test="${key.inventory_state == 34}">
							供货异常
						</c:when>
						<c:when test="${key.inventory_state == 41}">
							准备上货
						</c:when>
						<c:when test="${key.inventory_state == 42}">
							开始上货
						</c:when>
						<c:when test="${key.inventory_state == 43}">
							上货完成
						</c:when>
						<c:when test="${key.inventory_state == 44}">
							上货异常
						</c:when>
					</c:choose>
				</td>
				<td>
	 			<c:choose>
					<c:when test="${key.ei_state  == 1}">
						分配完成
					</c:when>
					<c:when test="${key.ei_state  == 2}">
						接受执行
					</c:when>
					<c:when test="${key.ei_state  == 3}">
						提交检查
					</c:when>
					<c:when test="${key.ei_state  == 4}">
						完成关闭
					</c:when>
				</c:choose>
				</td>
	 			<td>${ key.ei_date_1 }</td>
	 			<td>${ key.ei_date_2 == "" ? "-":key.ei_date_2}</td>
	 			<td>${ key.ei_date_3 == "" ? "-":key.ei_date_3}</td>
	 			<td>${ key.ei_date_4 == "" ? "-":key.ei_date_4 }</td>
	 			<td width="80">
	 				<c:choose>
					<c:when test="${key.ei_state  == 1}">
						<a href="AhServlet?type=eiupdate&ei_id=${ key.ei_id }&ei_state=2">接受执行</a>
					</c:when>
					<c:when test="${key.ei_state  == 2}">
						<a href="AhServlet?type=eiupdate&ei_id=${ key.ei_id }&ei_state=3">提交检查</a>
					</c:when>
					<c:when test="${key.ei_state  == 3}">
						完成关闭
					</c:when>
					<c:when test="${key.ei_state  == 4}">
						<span style="color: green;"><b>√</b></span>
					</c:when>
				</c:choose>
 				</td>
	 		</tr>
 				
 		</c:forEach>
		
	</table>
  </body>
</html>
