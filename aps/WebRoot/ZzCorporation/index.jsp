<%@ page language="java" import="java.util.*" pageEncoding="GB18030" errorPage="../error.jsp"%>
<%@ page import="com.aps.db.model.V_PdLogin" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  <title>������-��̨���ƹ���</title>
		<link rel="stylesheet" href="res/scripts/components/easyui/themes/default/easyui.css" type="text/css" />
		<link rel="stylesheet" href="res/scripts/components/easyui/themes/icon.css" type="text/css" />
		<link rel="stylesheet" href="res/styles/main.css" type="text/css" />
		<link rel="stylesheet" href="res/styles/common.css" type="text/css" />

		<script type="text/javascript" src="res/scripts/lib/jquery.min.js"></script>
	    <script type="text/javascript" src="res/scripts/components/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="res/scripts/common/main.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				top.menuCall('&nbsp;&nbsp;�ҵİ�����&nbsp;&nbsp;','<%=basePath%>JqAjax.jsp',false);
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
		<div region="north" class="north-back-main" style="height:30px" border="false" ondblclick="menuTop()">
			<!--<div class="north-back-logo"></div>-->
			<div class="north-tool-wrap">
				<div style="padding-left:160px; color:#FFFFFF;">
					<font color="#FF0000"></font> <span>��ӭ<%=((V_PdLogin)session.getAttribute("vpl")).getEname()%>��¼</span>
				</div>
				<div style="padding:25px 0px 0px 400px;">
					<a href="${ctx.contextPath}/rest/default/logout"><span class="icon-exitsystem"></span></a>
				</div>
			</div>
		</div>
		<div region="west" split="true" title="&nbsp;����ѡ�� &gt;&gt;�����˵�" icon="icon-destop"
			style="width: 280px;overflow: hidden;">
			<div class="easyui-accordion" fit="true" border="true" animate="false" style="padding-bottom:0.5px;">
				<!--��������-->
				<div title="&nbsp;��������" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('���ӳ���','car/car_add.jsp');">
            				<span class="icon-submenu-frame icon-submenu"></span>���ӳ���
               			</a>
               		</div>
               		<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('�鿴����','<%=basePath%>Corporation?type=1&key=4');">
            				<span class="icon-submenu-frame icon-submenu"></span>�鿴����
               			</a>
               		</div>
				</div>
				<!--·�߹���-->
				<div title="&nbsp;·�߹���" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('�������·��','route/route_add.jsp');">
            				<span class="icon-submenu-frame icon-submenu"></span>�������·��
               			</a>
               		</div>
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('����;��·��','<%=basePath%>Corporation?type=2&key=6&pageNow=1');">
            				<span class="icon-submenu-frame icon-submenu"></span>����;��·��
               			</a>
               		</div>
               		<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('�鿴·��','<%=basePath%>Corporation?type=2&key=4&pageNow=1');">
            				<span class="icon-submenu-frame icon-submenu"></span>�鿴·������
               			</a>
               		</div>
				</div>
				<!--���͵����-->
				<div title="&nbsp;���͵����" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('�������͵�','dpoint/dpoint_add.jsp');">
            				<span class="icon-submenu-frame icon-submenu"></span>�������͵�
               			</a>
               		</div>
               		<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('�鿴���͵�','<%=basePath%>Corporation?type=3&key=4');">
            				<span class="icon-submenu-frame icon-submenu"></span>�鿴���͵�
               			</a>
               		</div>
               		<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('���͵�����','<%=basePath%>Corporation?type=3&key=7&pageNow=1');">
            				<span class="icon-submenu-frame icon-submenu"></span>���͵�����
               			</a>
               		</div>
               	</div>
				
				<!--��������-->
               	<div title="&nbsp;��������" icon="icon-menu" style="padding:10px;">
               		<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('��������','<%=basePath%>Corporation?type=4&key=6');">
            				<span class="icon-submenu-frame icon-submenu"></span>��������
               			</a>
               		</div>
               		<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('�鿴����','<%=basePath%>Corporation?type=4&key=4&pageNow=1');">
            				<span class="icon-submenu-frame icon-submenu"></span>�鿴����
               			</a>
               		</div>
               	</div>
				<!--ϵͳ��������-->
				<div title="&nbsp;ϵͳ��������" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('���ò���','Systemparameter/Systemparameter_add.jsp');">
            				<span class="icon-submenu-frame icon-submenu"></span>���ò���
               			</a>
               		</div>
               	</div>
				<!--Ա������-->
				<div title="&nbsp;Ա������" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('����Ա��','emp/emp_add.jsp');">
            				<span class="icon-submenu-frame icon-submenu"></span>����Ա��
               			</a>
               		</div>
					
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('�鿴Ա��','<%=basePath%>Corporation?type=6&key=5&pageNow=1');">
            				<span class="icon-submenu-frame icon-submenu"></span>�鿴Ա��
               			</a>
               		</div>
               	</div>
				<!--���ͷ�Χ����-->
               	<div title="&nbsp;���ͷ�Χ����" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('�������ͷ�Χ','<%=basePath%>Corporation?type=7&key=6');">
            				<span class="icon-submenu-frame icon-submenu"></span>�������ͷ�Χ
               			</a>
               		</div>
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('�鿴���ͷ�Χ','<%=basePath %>Corporation?type=7&key=4&pageNow=1');">
            				<span class="icon-submenu-frame icon-submenu"></span>�鿴���ͷ�Χ
               			</a>
               		</div>
               	</div>
				<!--����۸����-->
				<div title="&nbsp;����۸����" icon="icon-menu" style="padding:10px;">
					
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('����۸�����','<%=basePath %>Corporation?type=4&key=4&pageNow=1');">
            				<span class="icon-submenu-frame icon-submenu"></span>����۸�����
               			</a>
               		</div>
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('����۸��ѯ','price_route_and_drange/price_route_list.html');">
            				<span class="icon-submenu-frame icon-submenu"></span>����۸��ѯ
               			</a>
               		</div>
				</div>
				<!--���ͼ۸����-->
				<div title="&nbsp;���ͼ۸����" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('���ͼ۸�����','price_route_and_drange/price_drange_add.html');">
            				<span class="icon-submenu-frame icon-submenu"></span>���ͼ۸�����
               			</a>
               		</div>
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('����۸��ѯ','price_route_and_drange/price_drange_list.html');">
            				<span class="icon-submenu-frame icon-submenu"></span>���ͼ۸��ѯ
               			</a>
               		</div>
				</div>
				<!--��������-->
               	<div title="&nbsp;��������" icon="icon-menu" style="padding:10px;">
               		<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('�鿴����','<%=basePath %>Corporation?type=10&key=4&pageNow=1');">
            				<span class="icon-submenu-frame icon-submenu"></span>�鿴����
               			</a>
               		</div>
               	</div>
				<!--���ӵ�����-->
				<div title="&nbsp;���ӵ�����" icon="icon-menu" style="padding:10px;">
				
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('�鿴���ӵ�','<%=basePath %>Corporation?type=11&key=4&pageNow=1');">
            				<span class="icon-submenu-frame icon-submenu"></span>�鿴���ӵ�
               			</a>
               		</div>
				</div>
				
				<!--�������-->
				<div title="&nbsp;�������" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('�鿴����','statements/statements_add.jsp');">
            				<span class="icon-submenu-frame icon-submenu"></span>�鿴����
               			</a>
               		</div>
               	</div>
				
				<!--Ȩ�޹���-->
				<div title="&nbsp;Ȩ�޹���" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('����Ȩ��','authority/au_add.jsp');">
            				<span class="icon-submenu-frame icon-submenu"></span>����Ȩ��
               			</a>
               		</div>
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('�鿴Ȩ��','<%=basePath%>Corporation?type=13&key=4&pageNow=1');">
            				<span class="icon-submenu-frame icon-submenu"></span>�鿴Ȩ��
               			</a>
               		</div>
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('����Ȩ��','<%=basePath%>Corporation?type=13&key=6');">
            				<span class="icon-submenu-frame icon-submenu"></span>����Ȩ��
               			</a>
               		</div>
               	</div>
				
				<!--�û�����-->
				<div title="&nbsp;�ͻ�����" icon="icon-menu" style="padding:10px;">
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('���ӿͻ�','customer/customer_add.jsp');">
            				<span class="icon-submenu-frame icon-submenu"></span>���ӿͻ�
               			</a>
               		</div>
					<div style="padding: 5px 0pt 5px 10px;">
						<a href="javascript:void(0)" onclick="javascript:top.menuCall('�鿴�ͻ�','<%=basePath %>Corporation?type=14&key=4&pageNow=1');">
            				<span class="icon-submenu-frame icon-submenu"></span>�鿴�ͻ�
               			</a>
               		</div>
               	</div>
				
				
				
				
			</div>
		</div>
		<div region="center">
			<div id="main-center" class="easyui-tabs" fit="true" border="false">
				<!--ѡ��Ҽ�����-->			
				<div id="mm" class="easyui-menu" style="width:150px;">
			        <div id="mm-tabclose">�ر�</div>
			        <div id="mm-tabcloseall">�ر�����</div>
			        <div id="mm-tabcloseother">�ر�����ҳ��</div>
			        <div class="menu-sep"></div>
			        <div id="mm-tabcloseright">�ر��Ҳ�����ҳ��</div>
			        <div id="mm-tabcloseleft">�ر��������ҳ��</div>
	  			</div>
			</div>
		</div>
		<div region="south" class="south-back-main" style="height:36px" border="false">
			<table width="100%" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td align="center">������������̨��������--��Ȩ����--����ؾ�</td>
				</tr>
			</table>
		</div>
	</body>
</html>