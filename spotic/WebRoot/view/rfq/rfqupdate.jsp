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
    <title>rfq update</title>
    <script type="text/javascript" language="javascript" src="res/scripts/lib/jquery.min.js"></script>
	<script type="text/javascript" src="res/EasyValidator3.0/EasyValidator/js/easy_validator.pack.js"></script>
	<link href="res/EasyValidator3.0/EasyValidator/css/validate.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
		function ismaxlength(obj){
			var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
			if (obj.getAttribute && obj.value.length>mlength)
			obj.value=obj.value.substring(0,mlength)
		}

		
		/*加载修改信息*/
		$(function(){
			 $(".fk_sp_emp_id option[value='${rfqBean.fk_sp_emp_id}']").attr("selected","selected");
			 $(".fk_ppa_emp_id option[value='${rfqBean.fk_ppa_emp_id}']").attr("selected","selected");
			 $(".fk_apa_emp_id option[value='${rfqBean.fk_apa_emp_id}']").attr("selected","selected");
			 $(".fk_customer_id option[value='${rfqBean.fk_customer_id}']").attr("selected","selected");
			
		});
	</script>
	<script language="javascript" type="text/javascript" src="res/my97/WdatePicker.js"></script>
  </head>
  <body>
  <form action="Spotic_RfqServlet?type=rfqupdate&rfq_id=${ rfqBean.rfq_id }" method="post">
    <table border="1">
		<tr>
			<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_rfq.fk_sp_emp_id"/><%--销售人员：--%></td>
			<td>
				<select name="fk_sp_emp_id" class="fk_sp_emp_id">
					<c:forEach items="${requestScope.empList}" var="key" varStatus="id" begin="0">
						<option value="${ key.emp_id }">${key.emp_name}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		
		<tr>	
			<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_rfq.fk_ppa_emp_id"/><%--初选采购人员：--%></td>
			<td>
				<select name="fk_ppa_emp_id" class="fk_ppa_emp_id">
					<c:forEach items="${requestScope.empList}" var="key" varStatus="id" begin="0">
						<option value="${ key.emp_id }">${ key.emp_name }</option>
					</c:forEach>
				</select>
			</td>
			<c:if test="${sessionScope.spotic_emp.emp_power == 1}">
			<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_rfq.fk_apa_emp_id"/><%--备选采购人员：--%></td>
			<td>
				<select name="fk_apa_emp_id" class="fk_apa_emp_id">
					<c:forEach items="${requestScope.empList}" var="key" varStatus="id" begin="0">
						<option value="${ key.emp_id }">${ key.emp_name }</option>
					</c:forEach>
				</select>
			</td>
			</c:if>
		</tr>
		<tr>
			<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_rfq.fk_customer_id"/><%--客户：--%></td>
			<td>
				<select name="fk_customer_id">
					<c:forEach items="${requestScope.customerList}" var="key" varStatus="id" begin="0">
						<option value="${ key.customer_id }">${ key.customer_name }</option>
					</c:forEach>
				</select>
			</td>
			<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_rfq.rfq_quantity"/><%--需求数量：--%></td>
			<td>
				<input type="text" name="rfq_quantity" value="${ rfqBean.rfq_quantity }" maxlength="10" reg="^[0-9]{1,10}$" tip="需求数量[1到10个数字] 如: 1001"/><span style="color: red;margin-left: 5px;">*</span>
			</td>
			<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_rfq.rfq_loc"/><%--产地：--%></td>
			<td>
				<input type="text" name="rfq_loc" value="${ rfqBean.rfq_loc }" maxlength="50" reg="^.{1,50}$" tip="产地[50个长度以内的组合] 如: 北京1号D001生产院"/><span style="color: red;margin-left: 5px;">*</span>
			</td>
		</tr>
		<tr>
			<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_rfq.rfq_part_no"/><%--物料号：--%></td>
			<td><input type="text" name="rfq_part_no" value="${ rfqBean.rfq_part_no }" maxlength="30" reg="^[a-zA-Z0-9]{1,30}$" tip="物料号[30以内的字母数字组合] 如: P1009"/><span style="color: red;margin-left: 5px;">*</span></td>
			<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_rfq.rfq_cust_part_no"/><%--客户物料号：--%></td>
			<td><input type="text" name="rfq_cust_part_no" value="${ rfqBean.rfq_cust_part_no }" maxlength="30" reg="^[a-zA-Z0-9]{1,30}$" tip="客户物料号[30以内的字母数字组合] 如: P1009"/><span style="color: red;margin-left: 5px;">*</span></td>
			<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_rfq.rfq_dock_date"/><%--指定到货日期：--%></td>
			<td><input type="text" name="rfq_dock_date" value="${ rfqBean.rfq_dock_date }" maxlength="10" reg="^((((19|20)\d{2})-(0?[13-9]|1[012])-(0?[1-9]|[12]\d|30))|(((19|20)\d{2})-(0?[13578]|1[02])-31)|(((19|20)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|((((19|20)([13579][26]|[2468][048]|0[48]))|(2000))-0?2-29))$" onClick="WdatePicker()" class="Wdate" tip="指定到货日期  如: 2014-08-24 "/><span style="color: red;margin-left: 5px;">*</span></td>
		</tr>
		<tr>
			<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_rfq.rfq_mfg"/><%--物料产地：--%></td>
			<td>
				<input type="text" name="rfq_mfg" value="${ rfqBean.rfq_mfg }" maxlength="50" reg="^.{1,50}$" tip="物料产地[50个长度以内的组合] 如: 北京1号D001生产院"/><span style="color: red;margin-left: 5px;">*</span>
			</td>
			<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_rfq.rfq_dc"/><%--物料年份：--%></td>
			<td>
				<input type="text" name="rfq_dc" value="${ rfqBean.rfq_dc }" maxlength="4" reg="^[0-9]{1,4}$" tip="物料年份[4个数字以内] 如：12"/><span style="color: red;margin-left: 5px;">*</span>
			</td>
			<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_rfq.rfq_alternative"/><%--可替代物料：--%></td>
			<td>
				<input type="text" name="rfq_alternative" value="${ rfqBean.rfq_alternative }" maxlength="50" reg="^.{1,50}$" tip="可替代物料[50个以内长度] 如：Xxx"/><span style="color: red;margin-left: 5px;">*</span>
			</td>
		</tr>
		<tr>
			<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_rfq.rfq_target_price"/><%--目标价格：--%></td>
			<td>
				<input type="text" name="rfq_target_price" value="${ rfqBean.rfq_target_price }" maxlength="11" reg="^[0-9]{1,11}$" tip="目标价格[11个数字以内] 1100"/><span style="color: red;margin-left: 5px;">*</span>
			</td>
			<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_rfq.rfq_resale"/><%--卖价：--%></td>
			<td>
				<input type="text" name="rfq_resale" value="${ rfqBean.rfq_resale }" maxlength="11" reg="^[0-9]{1,11}$" tip="卖价[11个数字以内] 1100"/><span style="color: red;margin-left: 5px;">*</span>
			</td>
			<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_rfq.rfq_cost"/><%--成本价：--%></td>
			<td>
				<input type="text" name="rfq_cost" value="${ rfqBean.rfq_cost }" maxlength="11" reg="^[0-9]{1,11}$" tip="成本价[11个数字以内] 1100"/><span style="color: red;margin-left: 5px;">*</span>
			</td>
		</tr>
		<tr>
			<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_rfq.rfq_packaging"/><%--包装：--%></td>
			<td>
				<input type="text" name="rfq_packaging" value="${ rfqBean.rfq_packaging }" maxlength="50" reg="^.{1,50}$" tip="包装[50个长度内的包装信息]"/><span style="color: red;margin-left: 5px;">*</span>
			</td>
			<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_rfq.rfq_internal"/><%--内部信息：--%></td>
			<td>
				<input type="text" name="rfq_internal" value="${ rfqBean.rfq_internal }" maxlength="100" reg="^.{1,100}$" tip="内部信息[100个长度内的内部信息]"/><span style="color: red;margin-left: 5px;">*</span>
			</td>
			<td style="background-color: blue;color: white;font-weight: bolder;"><fmt:message key="spotic_rfq.rfq_routing_history"/><%--历史：--%></td>
			<td>
				<input type="text" name="rfq_routing_history" value="${ rfqBean.rfq_routing_history }" maxlength="100" reg="^.{1,100}$" tip="历史信息[100个长度内的历史信息]"/><span style="color: red;margin-left: 5px;">*</span>
			</td>
		</tr>
		<tr>
			<td style="background-color: red;color: white;font-weight: bolder;"><fmt:message key="spotic_rfq.rfq_state"/><%--状态--%></td>
			<td>
				<select name="rfq_state">
					<option value="1">Ready</option>
					<option value="2">Start</option>
					<option value="3">Complete</option>
					<option value="4">Close</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="6">
				<input type="submit" value="Availability" style="font-weight: bolder;cursor: pointer;"/>
			</td>
		</tr>
	</table>
  </form>
  </body>
</html>
