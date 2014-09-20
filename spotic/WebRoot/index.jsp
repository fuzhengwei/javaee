<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.spotic.emp.bean.Spotic_EmpBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${ sessionScope.spotic_emp.emp_i18n }"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:if test="${empty sessionScope.spotic_emp.emp_name }">
	<c:redirect url="login/login.jsp"></c:redirect>
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>SPOTIC V1.0</title>
		<link rel="stylesheet" href="res/scripts/components/easyui/themes/default/easyui.css" type="text/css" />
		<link rel="stylesheet" href="res/scripts/components/easyui/themes/icon.css" type="text/css" />
		<link rel="stylesheet" href="res/styles/main.css" type="text/css" />
		<link rel="stylesheet" href="res/styles/common.css" type="text/css" />

		<script type="text/javascript" src="res/scripts/lib/jquery.min.js"></script>
	    <script type="text/javascript" src="res/scripts/components/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="res/scripts/common/main.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				top.menuCall('&nbsp;&nbsp;SPOTIC V1.0&nbsp;&nbsp;','<%=basePath%>AhServlet?type=welcome&emp_id=${sessionScope.spotic_emp.emp_id}&emp_power=${sessionScope.spotic_emp.emp_power}',false);
				tabCloseEven();
				showtime();

				$(".logout").click(function(){
					var r=confirm("Are you sure to logout !");
					if (r == true){
					  return true;
					}else{
					  return false;
					}
				});	
			});
			
			function showtime(){
			
				var d = new Date();
				var year = d.getFullYear();
				var month = d.getMonth() + 1;
				var day = d.getDate();
				
				var h=d.getHours()
				var m=d.getMinutes()
				var s=d.getSeconds()
				
				if(m < 10){
					m ="0"+m;
					
				}else if(s < 10){
					s = "0"+s;
				}

				var nowtime;
				nowtime = year+"/"+month+"/"+day+" "+h+":"+m+":"+s;
				
				$(".north-tool-wrap div font").html(nowtime);
				
				setTimeout('showtime()',500);
			}
		</script>
	</head>
    <body class="easyui-layout">
		<div region="north" class="north-back-main" style="height:80px" border="false" ondblclick="menuTop()">
			<div class="north-tool-wrap">
				<div style="padding-left:160px; color:#FFFFFF;">
					<font color="#FF0000"></font> 
					<span>Welcome 
						<a onclick="javascript:top.menuCall('EmpUpdate','Spotic_EmpServlet?type=empforupdate&emp_id=${ sessionScope.spotic_emp.emp_id }')" style="cursor: pointer;">${ sessionScope.spotic_emp.emp_name }</a>
					</span>
				</div>
				<div style="padding:25px 0px 0px 400px;">
					<a href="<%=basePath%>Spotic_EmpServlet?type=logout" class="logout"><span class="icon-exitsystem"></span></a>
				</div>
			</div>
		</div>
		<div region="west" split="true" title="&nbsp;<fmt:message key="jsp.manageoptions"/> &gt;&gt;<fmt:message key="jsp.operationmenu"/>" icon="icon-destop"
			style="width: 280px;overflow: hidden;">
			<div class="easyui-accordion" fit="true" border="true" animate="false" style="padding-bottom:0.5px;">
			<c:if test="${ sessionScope.spotic_emp.emp_power == 1}">
				<!-- 雇员管理 -->
				<div title="&nbsp;<fmt:message key="spotic_emp"/>" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('<fmt:message key="spotic_emp.emplist"/>','<%=basePath%>Spotic_EmpServlet?type=emplist');">
            				<span class="icon-submenu-frame icon-submenu"></span><fmt:message key="spotic_emp.emplist"/>
               			</a>
               		</div>
               		<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('<fmt:message key="spotic_emp.empadd"/>','view/emp/empadd.jsp');">
            				<span class="icon-submenu-frame icon-submenu"></span><fmt:message key="spotic_emp.empadd"/>
               			</a>
               		</div>
				</div>
			
				<!-- 客户管理 -->
				<div title="&nbsp;<fmt:message key="spotic_customer"/>" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('<fmt:message key="spotic_customer.customerlist"/>','<%=basePath%>Spotic_CustomerServlet?type=customerlist');">
            				<span class="icon-submenu-frame icon-submenu"></span><fmt:message key="spotic_customer.customerlist"/>
               			</a>
               		</div>
               		<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('<fmt:message key="spotic_customer.customeradd"/>','view/customer/customeradd.jsp');">
            				<span class="icon-submenu-frame icon-submenu"></span><fmt:message key="spotic_customer.customeradd"/>
               			</a>
               		</div>
				</div>
				</c:if>
				<!-- 采购管理 -->
				<div title="&nbsp;<fmt:message key="spotic_rfq"/>" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('<fmt:message key="spotic_rfq.rfqlist"/>','<%=basePath%>Spotic_RfqServlet?type=rfqlist');">
            				<span class="icon-submenu-frame icon-submenu"></span><fmt:message key="spotic_rfq.rfqlist"/>
               			</a>
               		</div>
               		<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('<fmt:message key="spotic_rfq.rfqadd"/>','Spotic_RfqServlet?type=rfqforadd');">
            				<span class="icon-submenu-frame icon-submenu"></span><fmt:message key="spotic_rfq.rfqadd"/>
               			</a>
               		</div>
				</div>
				
				<!-- 需求管理 -->
				<div title="&nbsp;<fmt:message key="spotic_inventory"/>" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('<fmt:message key="spotic_inventory.inventorystocklist"/>','<%=basePath%>Spotic_InventoryServlet?type=inventoryselectmodellist_t1&inventory_type=1');">
            				<span class="icon-submenu-frame icon-submenu"></span><fmt:message key="spotic_inventory.inventorystocklist"/>
               			</a>
               		</div>
               		<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('<fmt:message key="spotic_inventory.inventorysupplierlist"/>','<%=basePath%>Spotic_InventoryServlet?type=inventoryselectmodellist_t1&inventory_type=3');">
            				<span class="icon-submenu-frame icon-submenu"></span><fmt:message key="spotic_inventory.inventorysupplierlist"/>
               			</a>
               		</div>
               		<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('<fmt:message key="spotic_inventory.inventorymarketlist"/>','<%=basePath%>Spotic_InventoryServlet?type=inventoryselectmodellist_t1&inventory_type=4');">
            				<span class="icon-submenu-frame icon-submenu"></span><fmt:message key="spotic_inventory.inventorymarketlist"/>
               			</a>
               		</div>
               		<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('<fmt:message key="spotic_inventory.inventoradd"/>','view/inventory/addforinventory.jsp');">
            				<span class="icon-submenu-frame icon-submenu"></span><fmt:message key="spotic_inventory.inventoradd"/>
               			</a>
               		</div>
				</div>
				<!-- 历史订单查看管理 -->
				<div title="&nbsp;<fmt:message key="spotic_hitory"/>" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('<fmt:message key="spotic_hitory.supply"/>','<%=basePath%>AhServlet?type=4&inventory_type=4');">
            				<span class="icon-submenu-frame icon-submenu"></span><fmt:message key="spotic_hitory.supply"/>
               			</a>
               		</div>
               		<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('<fmt:message key="spotic_hitory.purchase"/>','<%=basePath%>AhServlet?type=3&inventory_type=3');">
            				<span class="icon-submenu-frame icon-submenu"></span><fmt:message key="spotic_hitory.purchase"/>
               			</a>
               		</div>
               		<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('<fmt:message key="spotic_hitory.sale"/>','<%=basePath%>AhServlet?type=1&inventory_type=1');">
            				<span class="icon-submenu-frame icon-submenu"></span><fmt:message key="spotic_hitory.sale"/>
               			</a>
               		</div>
				</div>
				<!-- BOM -->
				<div title="&nbsp;<fmt:message key="spotic_emp_inventory"/>" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('<fmt:message key="spotic_emp_inventory.eilist"/>','<%=basePath%>Spotic_Emp_InventoryServlet?type=eiselect');">
            				<span class="icon-submenu-frame icon-submenu"></span><fmt:message key="spotic_emp_inventory.eilist"/>
               			</a>
               		</div>
				</div>
			</div>
		</div>
		<div region="center">
			<div id="main-center" class="easyui-tabs" fit="true" border="false">
				<!--选项卡右键功能-->			
				<div id="mm" class="easyui-menu" style="width:150px;">
			        <div id="mm-tabclose">关闭</div>
			        <div id="mm-tabcloseall">关闭所有</div>
			        <div id="mm-tabcloseother">关闭其它页面</div>
			        <div class="menu-sep"></div>
			        <div id="mm-tabcloseright">关闭右侧所有页面</div>
			        <div id="mm-tabcloseleft">关闭左侧所有页面</div>
	  			</div>
			</div>
		</div>
		<div region="south" class="south-back-main" style="height:36px" border="false">
			<table width="100%" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td align="center">SPOTIC--版权所有--盗版必究</td>
				</tr>
			</table>
		</div>
	</body>
</html>

