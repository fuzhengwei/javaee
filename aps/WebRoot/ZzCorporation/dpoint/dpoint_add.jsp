<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
   <title>�������͵�</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/dpoint/css/dpoint.css" />
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/dpoint/js/jquery-1.4.2.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/dpoint/js/getaddress.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/dpoint/js/dpchecked.js"></script>

</head>

<body onLoad="setup()">
<!--��div-->
	<div class="mainDiv">
		<div class="leftDiv">
		<form action="<%=basePath %>Corporation?type=3&key=1" method="post">
			<table border="1">
				<tr>
					<td>����</td>
					<td><input type="text" id="dpname" name="dpname" maxlength="10"/></td>
					<td align="center" style="border:0px;">��</td>
				</tr>
				<tr>
					<td>ʡ��</td>
					<td>
						<select id="tid1" name="tid1"></select>
    					<select id="tid2" name="tid2"></select>
    					<select id="tid3" name="tid3"></select>
					</td>
					<td align="center" style="border:0px;">��</td>
				</tr>
				<tr>
					<td>��ַ</td>
					<td>
						<input type="text" id="dpaddress" maxlength="20" name="dpaddress"/>
					</td>
					<td align="center" style="border:0px;">��</td>
				</tr>
				<tr>
					<td>�绰</td>
					<td><input type="text" id="dptel" maxlength="11" name="dptel"/></td>
					<td align="center" style="border:0px;">��</td>
				</tr>
				<tr>
					<td>����</td>
					<td><input type="text" id="dpemail" name="dpemail"/></td>
					<td align="center" style="border:0px;">��</td>
				</tr>
				<tr>
					<td>��ע</td>
					<td><textarea style="width:400px; height:250px;background:transparent; color:#FFFFFF;"></textarea></td>
					<td style="border:0px;">
					<input type="submit" value="" onclick="return doLogin()" style="background-image:url(images/add3.png); width:128px; height:128px; border:0px; cursor:pointer;" /></td>
				</tr>
			</table>
		</form>
		</div>
	</div>
</body>
</html>