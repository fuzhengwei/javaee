<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="error/error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<fmt:setLocale value="${ sessionScope.spotic_emp.emp_i18n }"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>供货记录 Delivery record</title>
  </head>
  
  <body>
  <form action="AhServlet?type=eiselectserach&inventory_type=${ inventory_type }" method="post">
	<!-- 查询 -->
	<table border="1" class="searchTable" style="font-size: 12px;">
		<tr>
			<td><fmt:message key="spotic_rfq.rfq_part_no"/><%--物料号：--%></td>
			<td>
				<input type="text" name="inventory_part_no" maxlength="20" value="${ inventory_part_no }"/>
			</td>
			<td>
				<input type="submit" value="Find" style="cursor: pointer; font-weight: bolder;"/>
				<input type="reset" value="Clear" style="cursor: pointer; font-weight: bolder;"/>
			</td>
		</tr>
	</table>
	</form>
				<%--<td><fmt:message key="spotic_emp_inventory.fk_emp_id"/>任务执行雇员</td>
			<td>
				<input type="text" name="emp_name" maxlength="20" value="${ emp_name }"/>
			</td>
			<td><fmt:message key="spotic_emp_inventory.ei_state"/>任务分配状态</td>
			<td>
				<select name="ei_state">
					<option value="1">assigend分配完成</option>
					<option value="2">accept接受执行</option>
					<option value="3">submit提交检查</option>
					<option value="4">close完成关闭</option>
				</select>
			</td>
	--%>
	 <c:if test="${fn:length(requestScope.modelList) == 0}">
	  	Can't find valid infomation
	  </c:if>
  	<c:if test="${fn:length(requestScope.modelList) != 0}">
 	<table border="1" style="font-size: 12px;" width="100%">
 		<tr align="center" style="background-color: #333333; color: white; font-weight: bolder;">
 			<td></td>
 			<td><fmt:message key="spotic_rfq.rfq_part_no"/><%--物料号：--%></td>
 			<td><fmt:message key="spotic_emp_inventory.fk_emp_id"/><%--任务执行雇员--%></td>
 			<td><fmt:message key="spotic_emp_inventory.ei_state"/><%--订单执行状态--%></td>
 			<td><fmt:message key="spotic_inventory.inventory_allto_state"/><%--任务分配状态:--%></td>
 			<td><fmt:message key="spotic_emp_inventory.ei_date_1"/><%--分配任务时间--%></td>
 			<td><fmt:message key="spotic_emp_inventory.ei_date_2"/><%--接收执行时间--%></td>
 			<td><fmt:message key="spotic_emp_inventory.ei_date_3"/><%--提交检查时间--%></td>
 			<td><fmt:message key="spotic_emp_inventory.ei_date_4"/><%--完成关闭时间--%></td>
 		</tr>
 		<c:forEach items="${requestScope.modelList}" var="key" varStatus="id" begin="0">
 			
 			<tr align="center">
	 			<td>${ id.index + 1 }</td>
	 			<td>${ key.inventory_part_no }</td>
	 			<td>${ key.emp_name }</td>
	 			<td>
	 			<c:choose>   
						<c:when test="${key.inventory_state == 11}">ready<%--准备销售--%></c:when>
						<c:when test="${key.inventory_state == 12}">Start<%--开始销售--%></c:when>
						<c:when test="${key.inventory_state == 13}">Complete<%--销售完成--%></c:when>
						<c:when test="${key.inventory_state == 14}">Close<%--销售异常--%></c:when>
						<c:when test="${key.inventory_state == 31}">ready<%--准备供货--%></c:when>
						<c:when test="${key.inventory_state == 32}">Start<%--开始供货--%></c:when>
						<c:when test="${key.inventory_state == 33}">Complete<%--供货完成--%></c:when>
						<c:when test="${key.inventory_state == 34}">Close<%--供货异常--%></c:when>
						<c:when test="${key.inventory_state == 41}">ready<%--准备上货--%></c:when>
						<c:when test="${key.inventory_state == 42}">Start<%--开始上货--%></c:when>
						<c:when test="${key.inventory_state == 43}">Complete<%--上货完成--%></c:when>
						<c:when test="${key.inventory_state == 44}">Close<%--上货异常--%></c:when>
					</c:choose>
				</td>
				<td>
	 			<c:choose>
					<c:when test="${key.ei_state  == 1}">assigend<%--分配完成--%></c:when>
					<c:when test="${key.ei_state  == 2}">accept<%--接受执行--%></c:when>
					<c:when test="${key.ei_state  == 3}">submit<%--提交检查--%></c:when>
					<c:when test="${key.ei_state  == 4}">close<%--完成关闭--%></c:when>
				</c:choose>
				</td>
	 			<td><span style="color:blue;font-size: 11px;">${ key.ei_date_1 }</span></td>
	 			<td>
	 				<c:if test="${fn:length(key.ei_date_2) <= 0 }">
	 					<span style="color: red;"><b>×</b></span>
	 				</c:if>
	 				<c:if test="${fn:length(key.ei_date_2) > 0 }">
	 					<span style="color: purple;font-size: 11px;">${ key.ei_date_2 }</span>
	 				</c:if>
	 			</td>
	 			<td>
	 				<c:if test="${fn:length(key.ei_date_3) <= 0 }">
	 					<span style="color: red;"><b>×</b></span>
	 				</c:if>
	 				<c:if test="${fn:length(key.ei_date_3) > 0 }">
	 					<span style="color: fuchsia;font-size: 11px;">${ key.ei_date_2 }</span>
	 				</c:if>
	 			</td>
	 			<td>
	 				<c:if test="${fn:length(key.ei_date_4) <= 0 }">
	 					<span style="color: red;"><b>×</b></span>
	 				</c:if>
	 				<c:if test="${fn:length(key.ei_date_4) > 0 }">
	 					<span style="color: green;font-size: 11px;">${ key.ei_date_2 }</span>
	 				</c:if>
	 			</td>
	 		</tr>
 			
 		</c:forEach>
 		<tr>
			<td colspan="9" align="right">
				<c:if test="${page > 1}">
					<a href="AhServlet?type=4&page=${ page <= 1?1:page-1 }&inventory_type=${ inventory_type }"><fmt:message key="jsp.onpage"/></a>
					|
				</c:if>
				<a href="AhServlet?type=4&page=${ page + 1 }&inventory_type=${ inventory_type }"><fmt:message key="jsp.nextpage"/></a>
			</td>
		</tr>
 	</table>
 	</c:if>
  </body>
</html>
