<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="error/error.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript" type="text/javascript" src="../res/scripts/lib/jquery.min.js"></script>
<script language="javascript" type="text/javascript" src="../res/scripts/lib/jquery.corner.js"></script>
<script type="text/javascript" src="../res/EasyValidator3.0/EasyValidator/js/easy_validator.pack2.js"></script>
<link href="../res/EasyValidator3.0/EasyValidator/css/validate.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript">
$(function(){
	//圆角
	$(".emp_name,.emp_pwd").corner("5px");
	
})
</script>
<link type="text/css" rel="stylesheet" href="css/login.css" />
<title>SPOTIC LOGIN</title>
</head>

<body>
<!-- logo start-->
<div class="logoDiv">
</div>
<!-- logo end-->

<!-- login start-->
<div class="loginTopDiv"></div>
<div class="loginDiv">
	<form action="<%=basePath%>Spotic_EmpServlet?type=emplogin" method="post">
	<input type="text" name="emp_name" class="emp_name" maxlength="20" reg="^\w{3,20}$" tip="雇员姓名[3到20个英文字母] 如: generalfu"/>
	<input type="password" name="emp_pwd" class="emp_pwd" maxlength="202" reg="^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,22}$" tip="雇员密码 如: ******" />
	<input type="submit" class="sub" value=""/>
	</form>
</div>
<div class="loginBottomDiv"></div>
<!-- login end-->
</body>
</html>
