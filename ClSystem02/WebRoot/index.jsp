<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  <title>������ҳ</title>
  <link rel="stylesheet" href="css/index.css" type="text/css"></link>
  <script language="javascript" type="text/javascript" src="js/jquery-1.4.2.js"></script>
  <script language="javascript" type="text/javascript" src="js/index.js"></script>
  </head>
  
  <body>
    <!--����-->
<div class="headName"></div>
<!--ע��͵�¼��-->
<div class="loginAdd">
	<div class="lubiao"></div>
	<div class="login">
	<div class="imgLogin"></div>
	
	<form action="<%=basePath%>user/ClUser_login" method="post">
		<table>
			<tr><td>�û�����</td><td><input type="text" class="userLogin" name="usertable.userName"/></td></tr>
			<tr><td>��&nbsp;&nbsp;�룺</td><td><input type="password" class="userLogin" name="usertable.userPw"/></td></tr>
			<tr><td></td><td colspan="2"><input type="submit" value="��¼"/>|<input type="reset" value="����" />|<input type="button" value="�һ�����"/></td></tr>
		</table>
	</form>
	</div>
	<div class="add">
	<div class="imgAdd"></div>
	<form action="<%=basePath%>user/ClUser_add" method="post">
		<table>
			<tr><td>�û�������</td><td><input type="text" class="userAdd" name="usertable.userName" id="addName"/></td></tr>
			<tr><td>�û��Ա�</td><td>��<input type="radio" name="usertable.userSex" checked="checked" value="boy"/>
									   Ů<input type="radio" name="usertable.userSex" value="gril"/></td></tr>
			<tr><td>�û����䣺</td><td><input type="text" class="userAdd" name="usertable.userAge" id="addAge"/></td></tr>
			<tr><td>�û����룺</td><td><input type="password" class="userAdd" name="usertable.userPw" id="addPw"/></td></tr>
			<tr><td></td><td><input type="submit" value="ע��" class="PdSub"/>|<input type="reset" value="����"/></td></tr>
		</table>
	</form>
	
	</div>
	<span class="saySpan">��Ȩ����|����ؾ�</span>
</div>
    
  </body>
</html>
