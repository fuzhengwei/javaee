<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  <title>用户控制</title>
  <style type="text/css">
  	*{
		margin-top:0;
		margin-left:0;
	}
	.mainDiv{
		width:800px;
		height:555px;
		margin:0 auto;
		background-image:url(E:/pictures/Climgs/mainhb2.png);
	}
	.topDiv{
		width:450px;
		height:100px;
		margin:0 auto;
	}
	.userMessage{
		width:150px;
		height:120px;
		float:left;
		margin-top:15px;
		margin-left:70px;
		background-image:url(E:/pictures/Climgs/loginName.png);
	}
	.userMessage span{
		margin-top:50px;
		margin-left:42px;
		font-weight:bold;
		font-family:"楷体_GB2312";
		font-size:22px;
		color:#FF0000;
		position:absolute;
	}
	
	.clMessage{
		width:500px;
		height:270px;
		float:right;
		margin-top:15px;
		margin-right:75px;
		background-image:url(E:/pictures/Climgs/textareaimg.png);
	}
	
	.clMessage textarea{
		width:440px;
		height:209px;
		border:0px;
		background:transparent;
		background-color:#FFFFFF;
		margin-top:27px;
		margin-left:27px;
		font-size:24px;
		color:#0000FF;
	}
	.xxxList{
		width:150px;
		height:270px;
		float:left;
		margin-top:20px;
		margin-left:70px;
	}
	.xxxList ul{
		list-style:none;
	}
	.xxxList ul li{
		width:90px;
		height:35px;
		margin-left:20px;
		margin-top:20px;
		background-image:url(E:/pictures/Climgs/aButton.png);
		background-repeat:no-repeat;
		font-size:18px;
	}
	.xxxList ul li a{
		position:absolute;
		margin-top:8px;
		margin-left:8px;
	} 
	a{
		text-decoration: none;
	}
	a:hover{
		color:#00FF00;
	}
	a:link{
		color:#FFFFFF;
	}
	
	a:visited{
		color:#999999;
	}
	.dl{
		width:500px;
		height:120px;
		float:right;
		margin-top:10px;
		margin-right:75px;
		background-image:url(E:/pictures/Climgs/clhuanbian.png);
	}
	
	.clWhatTime{
		width: 148px;
		float: right;
		margin-right: 5px;
		margin-top: 4px;
	}
	
	.clWhatTime select{
		width: 98px;
	}
  </style>
  <script type="text/javascript">
  	<!--
		function doGet(eve){
			var clTW;
			var clTime;
			var clWhat;
			var clName;
			
			clTW = eve.value;
			clName = document.getElementById("hiLoginName").value;
			clTime = clTW.substring(clTW.indexOf("**")+2);
			clWhat = clTW.substring(0,clTW.indexOf("*"));
			
			document.getElementById("lookId").href = "ClMybank_lookList?pageNumber=0&clName="+clName+"&clWhat="+clWhat+"&clTime="+clTime;
			document.getElementById("updateId").href = "ClMybank_updateList?clName="+clName+"&clWhat="+clWhat+"&clTime="+clTime;
			document.getElementById("deleteId").href = "ClMybank_deleteList?clName="+clName+"&clWhat="+clWhat+"&clTime="+clTime;
			document.getElementById("createId").href = "ClMybank_createList?clName="+clName+"&clWhat="+clWhat+"&clTime="+clTime;
		}

		function eveVal(){
			var clTW;
			var clTime;
			var clWhat;
			var clName;
			clName = document.getElementById("hiLoginName").value;
			clTW = document.getElementById("clSW").value;
			clTime = clTW.substring(clTW.indexOf("**")+2);
			clWhat = clTW.substring(0,clTW.indexOf("*"));

			document.getElementById("lookId").href = "ClMybank_lookList?pageNumber=0&clName="+clName+"&clWhat="+clWhat+"&clTime="+clTime;
			document.getElementById("updateId").href = "ClMybank_updateList?clName="+clName+"&clWhat="+clWhat+"&clTime="+clTime;
			document.getElementById("deleteId").href = "ClMybank_deleteList?clName="+clName+"&clWhat="+clWhat+"&clTime="+clTime;
			document.getElementById("createId").href = "ClMybank_createList?clName="+clName+"&clWhat="+clWhat+"&clTime="+clTime;
		}
  	-->
  </script>
  </head>
  
  <body onload="eveVal()">
   	 <!--主框-->
	<div class="mainDiv">
	<div class="topDiv"></div>
	<div class="userMessage">
		<span><s:property value="loginName"/></span>
		<input type="hidden" value="<s:property value="loginName"/>" id="hiLoginName"/>	
	</div>
	<div class="clMessage">
		<textarea><s:property value="loginClMessage"/></textarea>
	</div>
	
	<div class="clWhatTime">
		事件：<select name="clWhat" id="clSW" class="clselectwhat" onchange="doGet(this)">
				<s:iterator value="list" var="li">
					<option value="<s:property value="#li.ClWhat"/>**<s:property value="#li.ClTime"/>">
						<s:property value="#li.ClWhat"/>
					</option>
				</s:iterator>
			</select>
		<hr />
		时间：<select name="clTime">
				<s:iterator value="list" var="li">
					<option value="<s:property value="#li.ClTime"/>"><s:property value="#li.ClTime"/></option>
				</s:iterator>
		</select>
	</div>			
	<div class="xxxList">
		<ul>
			<li style="margin-top: -15px;"><a href="<%=basePath %>user/ClMybank_lookList" id="lookId" >查看礼单</a></li>
			<li><a href="<%=basePath %>user/ClMybank_updateList" id="updateId" >更新礼单</a></li>
			<li><a href="<%=basePath %>user/ClMybank_deleteList" id="deleteId" >删除礼单</a></li>
			<li><a href="<%=basePath %>user/ClMybank_createList" id="createId" >新建礼单</a></li>
		</ul>
	</div>
	<div class="dl"></div>
</div>

</body>
</html>
