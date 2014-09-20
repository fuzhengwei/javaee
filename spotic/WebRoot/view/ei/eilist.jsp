<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="error/error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    
    <title>emp list</title>
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
	<script language="javascript" type="text/javascript" src="res/my97/WdatePicker.js"></script>	
  </head>
  
  <body>
  <form action="Spotic_Emp_InventoryServlet?type=empselectserach" method="post">
	<!-- 查询 -->
	<table border="1" class="searchTable">
		<tr>
			<td><fmt:message key="spotic_inventory.inventory_part_no"/><%--物料编号：--%></td>
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
	 <c:if test="${fn:length(requestScope.modelList) == 0}">
	  	Can't find valid infomation
	  </c:if>
  	<c:if test="${fn:length(requestScope.modelList) != 0}">
  <table border="1" width="100%" style="font-size: 12px;width: 100%">
	<tr align="center"  style="background-color: #333333; color: white; font-weight: bolder;">
		<td></td>
		<td><fmt:message key="spotic_emp_inventory.fk_emp_id"/><%--分配雇员：--%></td>
		<td><fmt:message key="spotic_inventory.inventory_type"/><%--需求类型：--%></td>
		<td><fmt:message key="spotic_inventory.inventory_part_no"/><%--物料编号：--%></td>
		<td><fmt:message key="spotic_inventory.inventory_date"/><%--任务日期：--%></td>
		<td><fmt:message key="spotic_inventory.inventory_allto_state"/><%--执行状态：--%></td>
		<td><fmt:message key="spotic_emp_inventory.ei_remarks"/><%--备注--%></td>
		<c:if test="${ sessionScope.spotic_emp.emp_power == 1}">	
		<td><fmt:message key="jsp.operation"/></td>
		</c:if>
	</tr>
	<c:forEach items="${requestScope.modelList}" var="key" varStatus="id" begin="0">
		<tr align="center">
			<td>${ id.index + 1 }</td>
			<td>${ key.emp_name }</td>
			<td>
				<c:choose>
					<c:when test="${key.inventory_type == 1}">inventory<%--本公司库存--%></c:when>
					<c:when test="${key.inventory_type == 2}">customer<%--客户--%></c:when>
					<c:when test="${key.inventory_type == 3}">excess<%--供应商--%></c:when>
					<c:when test="${key.inventory_type == 4}">outside<%--市场--%></c:when>
				</c:choose>
			</td>
			<td>${ key.inventory_part_no }</td>
			<td>
				<c:choose>
					<c:when test="${key.ei_state  == 1}">
						${ key.ei_date_1 }
					</c:when>
					<c:when test="${key.ei_state  == 2}">
						${ key.ei_date_2 }
					</c:when>
					<c:when test="${key.ei_state  == 3}">
						${ key.ei_date_3 }
					</c:when>
					<c:when test="${key.ei_state  == 4}">
						${ key.ei_date_4 }
					</c:when>
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
			<td>${ key.ei_remarks }</td>
			<c:if test="${ sessionScope.spotic_emp.emp_power == 1}">
			<td>
				<a href="Spotic_Emp_InventoryServlet?type=eiforupdate&ei_id=${ key.ei_id }&emp_name=${key.emp_name}&inventory_part_no=${ key.inventory_part_no }&ei_state=${key.ei_state}&ei_remarks=${key.ei_remarks}"><fmt:message key="jsp.update"/></a>
				|
				<a href="Spotic_Emp_InventoryServlet?type=eidelete&ei_id=${ key.ei_id }&fk_inventory_id=${key.inventory_id}" class="delete"><fmt:message key="jsp.delete"/></a>
			</td>
			</c:if>
		</tr>
	
	</c:forEach>
	<tr>
		<td colspan="8" align="right">
			<c:if test="${page > 1}">
				<a href="Spotic_Emp_InventoryServlet?type=eiselect&page=${ page <= 1?1:page-1 }"><fmt:message key="jsp.onpage"/></a>
				|
			</c:if>
			<a href="Spotic_Emp_InventoryServlet?type=eiselect&page=${ page + 1 }"><fmt:message key="jsp.nextpage"/></a>
		</td>
	</tr>
  </table>
  </c:if>
  </body>
</html>
