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
    
    <title>emp update</title>
	<script type="text/javascript" language="javascript" src="res/scripts/lib/jquery.min.js"></script>
	<script type="text/javascript" src="res/EasyValidator3.0/EasyValidator/js/easy_validator.pack.js"></script>
	<link href="res/EasyValidator3.0/EasyValidator/css/validate.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
		function ismaxlength(obj){
			var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
			if (obj.getAttribute && obj.value.length>mlength)
			obj.value=obj.value.substring(0,mlength)
		}
		
		$(function(){
			$(".emp_power option[value='${model.emp_power}']").attr("selected","selected");
			$(".emp_state option[value='${model.emp_state}']").attr("selected","selected");
		    $(".emp_i18n option[value='${model.emp_i18n}']").attr("selected","selected");
		});
	</script>
  </head>
  
  <body>
  <c:if test="${sessionScope.spotic_emp.emp_power == 1}">
  	<form action="Spotic_EmpServlet?type=empupdate&emp_id=${ model.emp_id }" method="post">
  </c:if>
  <c:if test="${sessionScope.spotic_emp.emp_power != 1}">
  	<form action="Spotic_EmpServlet?type=empupdate&emp_id=${ model.emp_id }" method="post" target="_parent">
  </c:if>
  
    <table border="1">
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_emp.emp_name"/><%--雇员姓名：--%></td>
		<td><input type="text" name="emp_name" value="${ model.emp_name }" maxlength="20" reg="^\w{3,20}$" tip="雇员姓名[3到20个英文字母] 如: generalfu"/><span style="color: red;margin-left: 5px;">*</span></td>
	</tr>
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_emp.emp_pwd"/><%--登录密码：--%></td>
		<td><input type="text" name="emp_pwd" value="${ model.emp_pwd }" maxlength="22" reg="^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,22}$" tip="登录密码[大写字母小写字母数字组合] 如: Pp123456"/><span style="color: red;margin-left: 5px;">*</span></td>
	</tr>
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_emp.emp_phone"/><%--联系电话：--%></td>
		<td><input type="text" name="emp_phone" value="${ model.emp_phone }" maxlength="11" reg="^[1][358]\d{9}$" tip="联系电话[中国电话] 如: 13689890001"/><span style="color: red;margin-left: 5px;">*</span></td>
	</tr>
	<c:if test="${ sessionScope.spotic_emp.emp_power == 1}">
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_emp.emp_power"/><%--权限：--%></td>
		<td>
			<select name="emp_power" class="emp_power">
				<option value="1">admin</option>
				<option value="2">sales</option>
				<option value="3">buyer</option>
			</select>
		</td>
	</tr>
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_emp.emp_state"/><%--状态：--%></td>
		<td>
			<select name="emp_state" class="emp_state">
				<option value="0">open</option>
				<option value="1">close</option>
			</select>
		</td>
	</tr>
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_emp.emp_i18n"/><%--国际化：--%></td>
		<td>
			<select name="emp_i18n" class="emp_i18n">
				<option value="en_US">US</option>
				<option value="zh_CN">CN</option>
			</select>
		</td>
	</tr>
	<tr>
		<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_emp.emp_remarks"/><%--备注：--%></td>
		<td>
			<textarea rows="10" cols="30" name="emp_remarks" onkeyup="return ismaxlength(this)" maxlength="20">${ model.emp_remarks }</textarea>
		</td>
	</tr>
	</c:if>
	<c:if test="${ sessionScope.spotic_emp.emp_power != 1}">
		<input type="hidden" value="${ sessionScope.spotic_emp.emp_power}" name="emp_power"/>
		<input type="hidden" value="${ sessionScope.spotic_emp.emp_state}" name="emp_state"/>
		<input type="hidden" value="${ sessionScope.spotic_emp.emp_remarks}" name="emp_remarks"/>
	</c:if>
	<tr>
		<td colspan="2">
			<input type="submit" value="Availability" style="font-weight: bolder;cursor: pointer;"/>
		</td>
	</tr>
  </table>
</form>
  </body>
</html>
