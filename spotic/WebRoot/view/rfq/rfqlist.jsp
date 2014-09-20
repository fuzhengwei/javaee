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
    
    <title>rfq list</title>
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
			$(".detatil").toggle(
				function(){
					$(".isdetatil").show();
				},
				function(){
					$(".isdetatil").hide();
				}
			);

		});
	</script>
  <link rel="stylesheet" href="res/styles/fzw.css" type="text/css"></link>
  </head>
  <body>
  <form action="Spotic_RfqServlet?type=empselectserach" method="post">
  <table>
  	<tr>
  		<td><fmt:message key="spotic_rfq.rfq_part_no"/><%--物料号：--%></td>
  		<td><%--<input type="text" value="" name="rfq_part_no" class="sText"/>
  			--%><textarea rows="1" cols="10" name="rfq_part_no"></textarea>
  		</td>
  		<td><input type="submit" value="Find" style="cursor: pointer; font-weight: bolder;width: 60px;"/><br/>
  			<input type="reset" class="rs" value="Clear" style="cursor: pointer; font-weight: bolder;width: 60px;"/>
  			<%--<input type="button" name="detatil" class="detatil" value="Detatil" style="cursor: pointer; font-weight: bolder;width: 80px;"/>
  		--%></td>
  	</tr>
  </table>
  </form>
  <c:if test="${fn:length(requestScope.modelList) == 0}">
  	Can't find valid infomation
  </c:if>
  <c:if test="${fn:length(requestScope.modelList) != 0}">
  	<table style="font-size: 12px; width: 100%;margin-top: -20px;" class="listTable">
		<tr align="center" style="background-color: #333333; color: white; font-weight: bolder;border: 1px black solid;">
			<td></td>
			<td style="display: none;background-color: green;" class="isdetatil"><fmt:message key="spotic_rfq.fk_sp_emp_id"/><%--销售人员：--%></td>
			<td style="display: none;background-color: green;" class="isdetatil"><fmt:message key="spotic_rfq.fk_ppa_emp_id"/><%--初选采购人员：--%></td>
			<td style="display: none;background-color: green;" class="isdetatil"><fmt:message key="spotic_rfq.fk_apa_emp_id"/><%--备选采购人员：--%></td>
			<td style="display: none;background-color: green;" class="isdetatil"><fmt:message key="spotic_rfq.fk_customer_id"/><%--客户：--%></td>
			<td><fmt:message key="spotic_rfq.rfq_part_no"/><%--物料号：--%></td>
			<td style="display: none;background-color: green;" class="isdetatil"><fmt:message key="spotic_rfq.rfq_cust_part_no"/><%--客户物料号：--%></td>
			<td><fmt:message key="spotic_rfq.rfq_mfg"/><%--物料产地：--%></td>
			<td><fmt:message key="spotic_rfq.rfq_dc"/><%--物料年份：--%></td>
			<td><fmt:message key="spotic_rfq.rfq_alternative"/><%--可替代物料：--%></td>
			<td><fmt:message key="spotic_rfq.rfq_quantity"/><%--需求数量：--%></td>
			<td><fmt:message key="spotic_rfq.rfq_packaging"/><%--包装：--%></td>
			<td><fmt:message key="spotic_rfq.rfq_target_price"/><%--目标价格：--%></td>
			<td><fmt:message key="spotic_rfq.rfq_resale"/><%--卖价：--%></td>
			<td><fmt:message key="spotic_rfq.rfq_cost"/><%--成本价：--%></td>
			<td><fmt:message key="spotic_rfq.rfq_internal"/><%--内部信息：--%></td>
			<td><fmt:message key="spotic_rfq.rfq_routing_history"/><%--历史：--%></td>
			<td><fmt:message key="spotic_rfq.rfq_loc"/><%--产地--%></td>
			<td><fmt:message key="spotic_rfq.rfq_date"/><%--日期--%></td>
			<td><fmt:message key="spotic_rfq.rfq_state"/><%--状态--%></td>
			<td><fmt:message key="jsp.operation"/></td>
		</tr>
		
		<c:forEach items="${requestScope.modelList}" var="key" varStatus="id" begin="0">
			<tr align="center">
				<td>${ id.index + 1 }</td>
				<td style="display: none;background-color: red;color: white;" class="isdetatil">${ key.fk_sp_emp_name }</td>
				<td style="display: none;background-color: red;color: white;" class="isdetatil">${ key.fk_ppa_emp_name}</td>
				<td style="display: none;background-color: red;color: white;" class="isdetatil">${ key.fk_apa_emp_name }</td>
				<td style="display: none;background-color: red;color: white;" class="isdetatil">${ key.fk_customer_name }</td>
				<td>${ key.rfq_part_no }</td>
				<td style="display: none;background-color: red;color: white;" class="isdetatil">${ key.rfq_cust_part_no }</td>
				<td>${ key.rfq_mfg }</td>
				<td>${ key.rfq_dc }</td>
				<td>${ key.rfq_alternative }</td>
				<td>${ key.rfq_quantity }</td>
				<td>${ key.rfq_packaging }</td>
				<td>${ key.rfq_target_price }</td>
				<td>${ key.rfq_resale }</td>
				<td>${ key.rfq_cost }</td>
				<td>${ key.rfq_internal }</td>
				<td>${ key.rfq_routing_history }</td>
				<td>${ key.rfq_loc }</td>
				<td>${ key.rfq_date }</td>
				<td>
					<c:choose>
						<c:when test="${key.rfq_state == 1}">
							Ready
						</c:when>
						<c:when test="${key.rfq_state == 2}">
							Start
						</c:when>
						<c:when test="${key.rfq_state == 3}">
							Complete
						</c:when>
						<c:when test="${key.rfq_state == 4}">
							Close
						</c:when>
					</c:choose>
				</td>
				<td>
					<a href="Spotic_RfqServlet?type=rfqforupdate&rfq_id=${ key.rfq_id }"><fmt:message key="jsp.update"/></a>
					
					<a href="Spotic_RfqServlet?type=rfqdelete&rfq_id=${ key.rfq_id }" class="delete"><fmt:message key="jsp.delete"/></a>
				</td>
				
			</tr>
			
		</c:forEach>
		<tr>
	<td colspan="21" align="right" style="border-bottom: 0;">
		<c:if test="${pageBean.pageNow > 1}">
			<a href="Spotic_RfqServlet?type=rfqlist&page=1"><span style="font-weight: bolder;color: black;border: 1px black solid;">&lt;&lt;</span></a>&nbsp;
			<a href="Spotic_RfqServlet?type=rfqlist&page=${ pageBean.pageNow <= 1?1:pageBean.pageNow-1 }"><span style="font-weight: bolder;color: black;border: 1px black solid;">&lt;</span></a>
		</c:if>&nbsp;
		${pageBean.pageNow }/${ pageBean.pageCount }&nbsp;
		<a href="Spotic_RfqServlet?type=rfqlist&page=${ pageBean.pageNow + 1 }"><span style="font-weight: bolder;color: black;border: 1px black solid;">&gt;</span></a>&nbsp;
		<a href="Spotic_RfqServlet?type=rfqlist&page=${ pageBean.pageCount }"><span style="font-weight: bolder;color: black;border: 1px black solid;">&gt;&gt;</span></a>
	</td>
</tr>
	</table>
	 </c:if>
  </body>
</html>
