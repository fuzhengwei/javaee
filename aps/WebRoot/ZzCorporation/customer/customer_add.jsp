<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<title>���ӿͻ�</title>
<head>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/customer/js/jquery-1.4.2.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/customer/js/customer_add.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/customer/js/gettime.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/customer/js/getaddress.js"></script>
<link type="text/css" rel="stylesheet" href="css/customer_add.css" />
</head>

<body onLoad="setup()">
<form action="<%=basePath %>Corporation?type=14&key=1&pageNow=1" method="post">
<table border="1" class="tt" align="center">
	<tr>
		<td width="70px;">�ǳ�</td>
		<td><input type="text" id="cnickname" name="cnickname" class="tt2" maxlength="10"/></td>
	</tr>
	<tr>
		<td>����</td>
		<td><input type="text" id="cname" name="cname" class="tt2" maxlength="4"/></td>
	</tr>
	<tr>
		<td>�Ա�</td>
		<td>
			<label><input type="radio" name="csex" value="��" checked="checked"/>��</label>
			<label><input type="radio" name="csex" value="Ů"/>Ů</label>
		</td>
	</tr>
	<tr>
		<td>����</td>
		<td><input type="password" id="cpwd" name="cpwd" class="tt2" maxlength="15"/></td>
	</tr>
	<tr>
		<td>ȷ������</td>
		<td><input type="password" id="cpwd2" name="cpwd2" class="tt2" maxlength="15"/></td>
	</tr>
	<tr>
		<td>�ֻ�</td>
		<td><input type="text" id="ctel" name="ctel" class="tt2" maxlength="11"/></td>
	</tr>
	<tr>
		<td>����</td>
		<td><input type="text" id="cemail" name="cemail" class="tt2" maxlength="20"/></td>
	</tr>
	<tr>
		<td>����</td>
		<td><input type="text" id="cbirthday" name="cbirthday" readonly="true" onClick="setDay(this);" class="tt2"/></td>
	</tr>
	<tr>
		<td>��ַ</td>
		<td>
			<select id="tid1" name="tid1"></select>
    		<select id="tid2" name="tid2"></select>
    		<select id="tid3" name="tid3"></select>
		</td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="" id="sub"/></td>
	</tr>


</table>
</form>
</body>
</html>
