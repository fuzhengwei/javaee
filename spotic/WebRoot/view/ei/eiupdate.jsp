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
    
    <title>emp add</title>
	<script type="text/javascript" language="javascript" src="res/scripts/lib/jquery.min.js"></script>
	<script type="text/javascript">
		function ismaxlength(obj){
			var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
			if (obj.getAttribute && obj.value.length>mlength)
			obj.value=obj.value.substring(0,mlength)
		}
	</script>
  </head>
  
  <body>
  <form action="Spotic_Emp_InventoryServlet?type=eiupdate&ei_id=${ ei_id }" method="post">
    <table border="1">
	<tr>
		<td><fmt:message key="spotic_emp_inventory.fk_emp_id"/><%--分配雇员：--%></td>
		<td>
			${ emp_name }
		</td>
	</tr>
	<tr>
		<td><fmt:message key="spotic_emp_inventory.fk_inventory_id"/><%--当前订单：--%></td>
		<td>
			${ inventory_part_no }
		</td>
	</tr>
	<tr>
		<td><fmt:message key="spotic_emp_inventory.ei_state"/><%--订单状态：--%></td>
		<td>
			<select name="ei_state">
				<option value="1">分配完成</option>
				<option value="2">接受执行</option>
				<option value="3">提交检查</option>
				<option value="4">完成关闭</option>
			</select>
		</td>
	</tr>
	<tr>
		<td><fmt:message key="spotic_emp_inventory.ei_remarks"/><%--备注：--%></td>
		<td>
			<textarea cols="20" rows="10" name="ei_remarks" onkeyup="return ismaxlength(this)" maxlength="40">${ ei_remarks }</textarea>
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
