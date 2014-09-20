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
    
    <title>inventorylist_t1</title>
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
  <form action="Spotic_InventoryServlet?type=empselectserach&inventory_type=${ inventory_type }" method="post">
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
  	<table border="1" style="font-size: 12px;width: 100%;">
		<tr align="center" style="background-color: #333333; color: white; font-weight: bolder;">
			<td></td>
			<td><fmt:message key="spotic_inventory.fk_customer_id"/><%--客户：--%></td>
			<td><fmt:message key="spotic_inventory.inventory_part_no"/><%--物料编号：--%></td>
			<td><fmt:message key="spotic_inventory.inventory_mfg"/><%--物料产地：--%></td>
			<td><fmt:message key="spotic_inventory.inventory_dc"/><%--物料年份：--%></td>
			<td><fmt:message key="spotic_inventory.inventory_cost"/><%--成本价：--%></td>
			<td><fmt:message key="spotic_inventory.inventory_loc"/><%--产地：--%></td>
			<td><fmt:message key="spotic_inventory.inventory_lt"/><%--指定到货周期LT：--%></td>
			<td><fmt:message key="spotic_inventory.inventory_type"/><%--需求类型：--%></td>
			<td><fmt:message key="spotic_inventory.inventory_date"/><%--日期--%></td>
			<td><fmt:message key="spotic_inventory.inventory_state"/><%--状态：--%></td>
			<td><fmt:message key="spotic_inventory.inventory_allto_state"/><%--任务分配状态:--%></td>
			<td><fmt:message key="spotic_inventory.inventory_remarks"/><%--备注：--%></td>
			<td><fmt:message key="jsp.operation"/></td>
		</tr>
	
	<c:forEach items="${requestScope.modelList}" var="key" varStatus="id" begin="0">
			<tr align="center">
				<td>${ id.index+1 }</td>
				<td>${ key.customer_name }</td>
				<td>${ key.inventory_part_no }</td>
				<td>${ key.inventory_mfg }</td>
				<td>${ key.inventory_dc }</td>
				<td>${ key.inventory_cost }</td>
				<td>${ key.inventory_loc }</td>
				<td>${ key.inventory_lt }</td>
				<td>
					<c:choose>
						<c:when test="${key.inventory_type == 1}">inventory<%--本公司库存--%></c:when>
						<c:when test="${key.inventory_type == 2}">customer<%--客户--%></c:when>
						<c:when test="${key.inventory_type == 3}">excess<%--供应商--%></c:when>
						<c:when test="${key.inventory_type == 4}">outside<%--市场--%></c:when>
					</c:choose>
				</td>
				<td>${ key.inventory_date }</td>
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
						<c:when test="${key.inventory_allto_state == 0}">
							<c:if test="${sessionScope.spotic_emp.emp_power == 1}">
								<a href="Spotic_Emp_InventoryServlet?type=eiforadd&inventory_part_no=${ key.inventory_part_no }&inventory_id=${ key.inventory_id }&inventory_type=${ key.inventory_type }">no assigned</a>
							</c:if>
							<c:if test="${sessionScope.spotic_emp.emp_power != 1}">
								no assigned
							</c:if>
						</c:when>
						<c:when test="${key.inventory_allto_state == 1}">
							assigned
						</c:when>
					</c:choose>
				</td>
				<td>${ key.inventory_remarks }</td>
				<td>
					<a href="Spotic_InventoryServlet?type=inventoryforupdate&inventory_id=${ key.inventory_id }&inventory_type=${ key.inventory_type }"><fmt:message key="jsp.update"/></a>
					|
					<a href="Spotic_InventoryServlet?type=inventorydelete&inventory_id=${ key.inventory_id }&inventory_type=${ key.inventory_type }" class="delete"><fmt:message key="jsp.delete"/></a>
				</td>
			</tr>
	</c:forEach>
	<tr>
	<td colspan="14" align="right">
		<c:if test="${page > 1}">
			<a href="Spotic_InventoryServlet?type=inventoryselectmodellist_t1&page=${ page <= 1?1:page-1 }&inventory_type=${inventory_type}"><fmt:message key="jsp.onpage"/></a>
			|
		</c:if>
		<a href="Spotic_InventoryServlet?type=inventoryselectmodellist_t1&page=${ page + 1 }&inventory_type=${inventory_type}"><fmt:message key="jsp.nextpage"/></a>
	</td>
</tr>
	</table>
	</c:if>
  </body>
</html>
