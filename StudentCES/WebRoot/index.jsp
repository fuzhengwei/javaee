<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>StudentCES</title>
		<link rel="stylesheet" href="res/scripts/components/easyui/themes/default/easyui.css" type="text/css" />
		<link rel="stylesheet" href="res/scripts/components/easyui/themes/icon.css" type="text/css" />
		<link rel="stylesheet" href="res/styles/main.css" type="text/css" />
		<link rel="stylesheet" href="res/styles/common.css" type="text/css" />

		<script type="text/javascript" src="res/scripts/lib/jquery.min.js"></script>
	    <script type="text/javascript" src="res/scripts/components/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="res/scripts/common/main.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				top.menuCall('&nbsp;&nbsp;SCES首页&nbsp;&nbsp;','RscServlet?type=rsclist',false);
				tabCloseEven();

				showtime();
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
			<!--<div class="north-back-logo"></div>-->
			<div class="north-tool-wrap">
				<div style="padding-left:160px; color:#FFFFFF;">
					<font color="#FF0000"></font> <span>
						<c:if test="${fn:length(sessionScope.login.name) == 0}">
							<c:redirect url="view/login/login.jsp"></c:redirect>
						</c:if>
					欢迎${ login.name }登录</span>
				</div>
				<div style="padding:25px 0px 0px 400px;">
					<a href="LoginServlet?type=loginout"><span class="icon-exitsystem"></span></a>
				</div>
			</div>
		</div>
		<div region="west" split="true" title="&nbsp;管理选项 &gt;&gt;操作菜单" icon="icon-destop"
			style="width: 280px;overflow: hidden;">
			<div class="easyui-accordion" fit="true" border="true" animate="false" style="padding-bottom:0.5px;">
				<c:if test="${sessionScope.login.jur == 1}">
				<!--用户管理-->
				<div title="&nbsp;用户管理" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('用户列表','UserServlet?type=userlist');">
            				<span class="icon-submenu-frame icon-submenu"></span>用户列表
               			</a>
               		</div>
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('新增雇员','view/user/useradd.jsp');">
            				<span class="icon-submenu-frame icon-submenu"></span>新增用户
               			</a>
               		</div>
				</div>
				</c:if>
				<!--学生管理-->
				<div title="&nbsp;学生管理" icon="icon-menu" style="padding:10px;">
					<c:if test="${sessionScope.login.jur == 3 ||sessionScope.login.jur == 0 }">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('学生列表','StudentServlet?type=studentlist&w=0');">
            				<span class="icon-submenu-frame icon-submenu"></span>学生列表
               			</a>
               		</div>
					</c:if>
					<c:if test="${sessionScope.login.jur == 1 || sessionScope.login.jur == 2}">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('学生列表','StudentServlet?type=studentlist&w=1');">
            				<span class="icon-submenu-frame icon-submenu"></span>学生列表
               			</a>
               		</div>
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('新增学生','view/student/studentadd.jsp');">
            				<span class="icon-submenu-frame icon-submenu"></span>新增用户
               			</a>
               		</div>
               		</c:if>
				</div>
				<c:if test="${sessionScope.login.jur == 1 || sessionScope.login.jur == 2}">
				<!--课程类别管理-->
				<div title="&nbsp;课程类别管理" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('课程类别列表','CategoryServlet?type=categorylist');">
            				<span class="icon-submenu-frame icon-submenu"></span>课程类别列表
               			</a>
               		</div>
               		<!-- 
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('新增课程类别','view/category/categoryadd.jsp');">
            				<span class="icon-submenu-frame icon-submenu"></span>新增课程类别
               			</a>
               		</div>
               		 -->
				</div>
				</c:if>
				<c:if test="${sessionScope.login.jur == 1 || sessionScope.login.jur == 2}">
				<!--课程管理-->
				<div title="&nbsp;课程管理" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('课程列表','CourseServlet?type=courselist');">
            				<span class="icon-submenu-frame icon-submenu"></span>课程列表
               			</a>
               		</div>
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('新增课程','view/course/courseadd.jsp');">
            				<span class="icon-submenu-frame icon-submenu"></span>新增课程
               			</a>
               		</div>
				</div>
				</c:if>
				
				<!--基础成绩管理-->
				<div title="&nbsp;基础成绩管理" icon="icon-menu" style="padding:10px;">
					<c:if test="${sessionScope.login.jur == 1 || sessionScope.login.jur == 2 || sessionScope.login.jur == 3 }">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('基础成绩列表','ResultsServlet?type=resultslist');">
            				<span class="icon-submenu-frame icon-submenu"></span>基础成绩列表
               			</a>
               		</div>
               		</c:if>
               		<c:if test="${sessionScope.login.jur == 0}">
               		<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('基础成绩列表','ResultsServlet?type=resultslist&w=0');">
            				<span class="icon-submenu-frame icon-submenu"></span>基础成绩列表
               			</a>
               		</div>
               		</c:if>
               		
               		<c:if test="${sessionScope.login.jur == 1 || sessionScope.login.jur == 2 || sessionScope.login.jur == 3 }">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('新增基础成绩','ResultsServlet?type=resultsaddmessage');">
            				<span class="icon-submenu-frame icon-submenu"></span>新增基础成绩
               			</a>
               		</div>
               		</c:if>
               		
				</div>
				
				<!--综合成绩管理-->
				<div title="&nbsp;综合成绩管理" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('综合成绩列表','RscServlet?type=rsclist');">
            				<span class="icon-submenu-frame icon-submenu"></span>综合成绩列表
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
					<td align="center">StudentCES管理中心--版权所有--盗版必究</td>
				</tr>
			</table>
		</div>
	</body>
</html>

