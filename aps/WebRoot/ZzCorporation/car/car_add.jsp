<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
 <title>��������</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/car/css/car_add.css" />
<script language="javascript" type="text/javascript" src="<%=basePath %>ZzCorporation/car/js/jquery-1.4.2.js"></script>
<script language="javascript" type="text/javascript" src="<%=basePath %>ZzCorporation/car/js/getaddress.js"></script>
<script language="javascript" type="text/javascript" src="<%=basePath %>ZzCorporation/car/js/gettime.js"></script>
<script language="javascript" type="text/javascript" src="<%=basePath %>ZzCorporation/car/js/car_add.js"></script>
</head>

<body onLoad="setup()">
<div class="mainDiv">
		<form action="<%=basePath %>Corporation?type=1&key=1" method="post">
		<table border="1">
			<tr>
				<td width="85px;">���ƺ�</td>
				<td width="270px;">
					<input type="text" id="cbrand" name="cbrand"/>
				</td>
			</tr>
			
			<tr>
				<td>�ͺ�</td>
				<td>
					<select id="cmodel" name="cmodel">
						<option>��</option>
						<option>�г�</option>
						<option>С��</option>
					</select>
				</td>
				<td align="center" style="border:0px;">��</td>
			</tr>
			
			<tr>
				<td>����</td>
				<td>
					<select id="tid1" name="tid1"></select>
    				<select id="tid2" name="tid2"></select>
    				<select id="tid3" name="tid3"></select>
				</td>
				<td align="center" style="border:0px;">��</td>
			</tr>
			
			<tr>
				<td>����ʱ��</td>
				<td><input type="text" onClick="setDay(this);" readonly="true" name="cproduce" id="cproduce"/></td>
				<td align="center" style="border:0px;">��</td>
			</tr>
			
			<tr>
				<td>����ʱ��</td>
				<td><input type="text" onClick="setDay(this);" readonly="true" name="cbuy" id="cbuy"/></td>
				<td align="center" style="border:0px;">��</td>
			</tr>
			
			<tr>
				<td>����������</td>
				<td><input type="text" name="cpripal" id="cpripal" maxlength="3"/></td>
			</tr>
			
			<tr>
				<td>���</td>
				<td><input type="text" name="cvolume" id="cvolume" maxlength="10"/></td>
			</tr>
			
			<tr>
				<td>����</td>
				<td><input type="text" name="capac" id="capac" maxlength="10"/></td>
			</tr>
			<tr>
				<td colspan="3" style="border:0px;">
					<input type="submit" value="" id="sub" onclick="return doLogin()"/>
				</td>
			</tr>
		</table>
		<form>
</div>
</body>
</html>
