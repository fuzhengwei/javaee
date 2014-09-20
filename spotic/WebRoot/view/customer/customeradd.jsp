<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="error/error.jsp"%>
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
    
    <title>customer add</title>
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
  <form action="Spotic_CustomerServlet?type=customeradd" method="post">
    <table border="1">
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_customer.customer_company"/><%--客户公司：--%></td>
		<td><input type="text" name="customer_company" reg="^.{2,20}$" tip="客户公司[3到20个长度] 如：百度"/><span style="color: red;margin-left: 5px;">*</span></td>
	</tr>
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_customer.customer_name"/><%--客户姓名：--%></td>
		<td><input type="text" name="customer_name"  reg="^[a-zA-Z]{3,20}$" tip="客户姓名[3到20个英文字母] 如: generalfu"/><span style="color: red;margin-left: 5px;">*</span></td>
	</tr>
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_customer.customer_phone"/><%--客户电话：--%></td>
		<td><input type="text" name="customer_phone" reg="^[1][358]\d{9}$" tip="客户电话[中国电话] 如: 13689890001"/><span style="color: red;margin-left: 5px;">*</span></td>
	</tr>
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_customer.customer_fax"/><%--客户传真：--%></td>
		<td><input type="text" name="customer_fax" reg="^\d{3}-\d{8}$|^\d{4}-\d{7}$" tip="客户传真 如：010-87888822"/><span style="color: red;margin-left: 5px;">*</span></td>
	</tr>
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_customer.customer_email"/><%--客户邮箱：--%></td>
		<td><input type="text" name="customer_email" reg="^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$" tip="客户邮箱，如generalfu@drdg.com"/><span style="color: red;margin-left: 5px;">*</span></td>
	</tr>
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_customer.customer_type"/><%--客户类型：--%></td>
		<td>
			<select name="customer_type">
				<option value="1">inventory<%--本公司库存--%></option>
				<option value="2">customer<%--客户--%></option>
				<option value="3">excess<%--供应商--%></option>
				<option value="4">outside<%--市场--%></option>
			</select>
		</td>
	</tr>
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_customer.customer_remarks"/><%--客户备注：--%></td>
		<td>
			<textarea cols="50" rows="10" name="customer_remarks" onkeyup="return ismaxlength(this)" maxlength="20" ></textarea>
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
