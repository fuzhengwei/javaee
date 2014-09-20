<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="error/error.jsp"%>
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
    
    <title>inventory for add</title>
    <script type="text/javascript" language="javascript" src="res/scripts/lib/jquery.min.js"></script>
	<script type="text/javascript" src="res/EasyValidator3.0/EasyValidator/js/easy_validator.pack.js"></script>
	<link href="res/EasyValidator3.0/EasyValidator/css/validate.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
		function ismaxlength(obj){
			var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
			if (obj.getAttribute && obj.value.length>mlength)
			obj.value=obj.value.substring(0,mlength)
		}
	</script>
  </head>
  <body>
  <form action="Spotic_InventoryServlet?type=inventoryadd&inventory_type=${ customer_type }" method="post">
  <table border="1">
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_inventory.fk_customer_id"/><%--客户：--%></td>
		<td>
			<select name="fk_customer_id">
				<c:forEach items="${requestScope.customerList}" var="key" varStatus="id" begin="0">
					<option value="${ key.customer_id }">${ key.customer_name }</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_inventory.inventory_part_no"/><%--物料编号：--%></td>
		<td><input type="text" name="inventory_part_no" maxlength="30" reg="^[a-zA-Z0-9]{1,30}$" tip="物料号[30以内的字母数字组合] 如: P1009"/><span style="color: red;margin-left: 5px;">*</span></td>
	</tr>
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_inventory.inventory_mfg"/><%--物料产地：--%></td>
		<td><input type="text" name="inventory_mfg" maxlength="50" reg="^.{1,50}$" tip="物料产地[50个长度以内的组合] 如: 北京1号D001生产院"/><span style="color: red;margin-left: 5px;">*</span>
	</tr>
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_inventory.inventory_dc"/><%--物料年份：--%></td>
		<td><input type="text" name="inventory_dc" maxlength="4" reg="^[0-9]{1,4}$" tip="物料年份[4个数字以内] 如：12"/><span style="color: red;margin-left: 5px;">*</span>
	</tr>
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_inventory.inventory_cost"/><%--成本价：--%></td>
		<td><input type="text" name="inventory_cost" maxlength="11" reg="^[0-9]{1,11}$" tip="成本价[11个数字以内] 1100"/><span style="color: red;margin-left: 5px;">*</span>
	</tr>
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_inventory.inventory_loc"/><%--产地：--%></td>
		<td><input type="text" name="inventory_loc" maxlength="50" reg="^.{1,50}$" tip="产地[50个长度以内的组合] 如: 北京1号D001生产院"/><span style="color: red;margin-left: 5px;">*</span>
	</tr>
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_inventory.inventory_lt"/><%--指定到货周期LT：--%></td>
		<td><input type="text" name="inventory_lt" maxlength="20" reg="^.{1,20}$" tip="指定到货周期[20个长度以内的组合] "/><span style="color: red;margin-left: 5px;">*</span>
	</tr>
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_inventory.inventory_type"/><%--需求类型：--%></td>
		<td><input type="hidden" value="${customer_type}" name="inventory_type"/>
			<c:choose>
				<c:when test="${customer_type  == 1}">inventory<%--本公司库存--%></c:when>
				<c:when test="${customer_type  == 2}">customer<%--客户--%></c:when>
				<c:when test="${customer_type  == 3}">excess<%--供应商--%></c:when>
				<c:when test="${customer_type  == 4}">outside<%--市场--%></c:when>
			</c:choose>
		</td>
	</tr>
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_inventory.inventory_state"/><%--状态：--%></td>
		<td>
			<c:choose>   
				<c:when test="${customer_type  == 1}">
					<select name="inventory_state">
						<option value="11">ready<%--准备销售--%></option>
						<option value="12">Start<%--开始销售--%></option>
						<option value="13">Complete<%--销售完成--%></option>
						<option value="14">Close<%--销售异常--%></option>
					</select>
				</c:when>
				<c:when test="${customer_type  == 3}">
					<select name="inventory_state">
						<option value="31">ready<%--准备供货--%></option>
						<option value="32">Start<%--开始供货--%></option>
						<option value="33">Complete<%--供货完成--%></option>
						<option value="34">Close<%--供货异常--%></option>
					</select>
				</c:when>
				<c:when test="${customer_type  == 4}">
					<select name="inventory_state">
						<option value="41">ready<%--准备上货--%></option>
						<option value="42">Start<%--开始上货--%></option>
						<option value="43">Complete<%--上货完成--%></option>
						<option value="44">Close<%--上货异常--%></option>
					</select>
				</c:when>
			</c:choose>
		</td>
	</tr>
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_inventory.inventory_allto_state"/><%--任务分配状态:--%></td>
		<td>no assigned<input type="hidden" name="inventory_allto_state" value="0"/></td>
	</tr>
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_inventory.inventory_remarks"/><%--备注：--%></td>
		<td>
			<textarea rows="10" cols="30" name="inventory_remarks" onkeyup="return ismaxlength(this)" maxlength="40"></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="Availability" style="font-weight: bolder;cursor: pointer;"/>
		</td>
	</tr>
</table>
</form>
  </body>
</html>
