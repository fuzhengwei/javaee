<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  <title>ϵͳ��������</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/Systemparameter/css/Systemparameter_add.css" />
<script language="javascript" type="text/javascript" src="<%=basePath %>ZzCorporation/Systemparameter/js/gunzhou.js"></script>
</head>

<body>
	<form action="<%=basePath %>Corporation?type=5&key=1" method="post">
	<table border="1" align="center">
		<tr>
			<td width="135px;">�ֳɱ�������</td>
			<td><input type="text" name="spinto" onfocus="ufocus(this)" onblur="ublur(this)" readonly="true"/>%</td>
		</tr>
		<tr>
			<td>���ñ��۷ѱ���</td>
			<td><input type="text" name="spof" onfocus="ufocus(this)" onblur="ublur(this)" readonly="true"/>%</td>
		</tr>
		<tr>
			<td>�����Զ�ɾ������</td>
			<td><input type="text" name="spdeletetime" onfocus="ufocus(this)" onblur="ublur(this)" readonly="true"/>��</td>
		</tr>
		<tr>
			<td>�׹���������</td>
			<td><input type="text" name="spfirstkg" onfocus="ufocus(this)" onblur="ublur(this)" readonly="true"/>����</td>
		</tr>
		<tr>
			<td>������������</td>
			<td><input type="text" name="spfirstvo" onfocus="ufocus(this)" onblur="ublur(this)" readonly="true"/>ǧ��</td>
		</tr>
		<tr>
			<td style="border:0px;" colspan="2">
				<input type="submit" value="" id="sub" />
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
