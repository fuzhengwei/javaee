<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  <title>彩礼主页</title>
  <link rel="stylesheet" href="css/index.css" type="text/css"></link>
  <script language="javascript" type="text/javascript" src="js/jquery-1.4.2.js"></script>
  <script language="javascript" type="text/javascript" src="js/index.js"></script>
  </head>
  
  <body>
    <!--标题-->
<div class="headName"></div>
<!--注册和登录区-->
<div class="loginAdd">
	<div class="lubiao"></div>
	<div class="login">
	<div class="imgLogin"></div>
	
	<form action="<%=basePath%>user/ClUser_login" method="post">
		<table>
			<tr><td>用户名：</td><td><input type="text" class="userLogin" name="usertable.userName"/></td></tr>
			<tr><td>密&nbsp;&nbsp;码：</td><td><input type="password" class="userLogin" name="usertable.userPw"/></td></tr>
			<tr><td></td><td colspan="2"><input type="submit" value="登录"/>|<input type="reset" value="重置" />|<input type="button" value="找回密码"/></td></tr>
		</table>
	</form>
	</div>
	<div class="add">
	<div class="imgAdd"></div>
	<form action="<%=basePath%>user/ClUser_add" method="post">
		<table>
			<tr><td>用户姓名：</td><td><input type="text" class="userAdd" name="usertable.userName" id="addName"/></td></tr>
			<tr><td>用户性别：</td><td>男<input type="radio" name="usertable.userSex" checked="checked" value="boy"/>
									   女<input type="radio" name="usertable.userSex" value="gril"/></td></tr>
			<tr><td>用户年龄：</td><td><input type="text" class="userAdd" name="usertable.userAge" id="addAge"/></td></tr>
			<tr><td>用户密码：</td><td><input type="password" class="userAdd" name="usertable.userPw" id="addPw"/></td></tr>
			<tr><td></td><td><input type="submit" value="注册" class="PdSub"/>|<input type="reset" value="重置"/></td></tr>
		</table>
	</form>
	
	</div>
	<span class="saySpan">版权所有|盗版必究</span>
</div>
    
  </body>
</html>
