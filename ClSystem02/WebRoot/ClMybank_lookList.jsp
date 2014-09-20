<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  <title>彩礼查看</title>
  <style type="text/css">
  	*{
		margin-top:0;
		margin-left:0;
	}

	.mainDiv{
		width:800px;
		height:600px;
		margin:0 auto;
		background-image:url(E:/pictures/Climgs/looklistBg.png);
	}
	
	.topBiaoTi{
		width:800px;
		height:150px;
		background-image:url(E:/pictures/Climgs/listHead.png);
	}
	
	.leftShiJian{
		width:150px;
		height:450px;
		background-image:url(E:/pictures/Climgs/shijianKuang.png);
		float:left;
	}
	
	.inSJ{
		width:50px;
		height:350px;
		margin-top:50px;
		margin-left:50px;
		font-size:50px;
		font-family:"华文行楷";
		color:#FF0000;
		float:left;
	}
	
	.bottomDiv{
		width:800px;
		height:50px;
		margin:0 auto;
		background-image:url(E:/pictures/Climgs/bottomDiv.png);
	}
	
	.pageHead{
		width:635px;
		height:30px;
		border:2px #000000 solid;
		background-color:#FF0000;
		
	}
	
	.pageHead ul{
		list-style:none;
	}
	
	.pageHead ul li{
		margin-left:10px;
		margin-top:7px;
		font-size:18px;
		font-weight:bold;
		float:left;
	}

	a{
		text-decoration: none;
		color:#0000FF;
	}
	
	.userClMe{
		width:640px;
		height:380px;
		
	}
	
	.userClMe tr td{
		border:2px #000000 solid;
		background-color:#FF0000;
	}
	
	.topTr td{	
		height:30px;
		width:80px;
	}
	
	.bottomTr td{
		font-weight:bold;
		font-size:14px;
		width:77px;
		height:20px;
	}
	
	.inTopTable{
		width:58px;
		height:180px;
		float:right;
		font-size:45px;
		font-family:"华文行楷";
		margin:0 auto;
	}
	
	.fenPage{
		width:634px;
		height:32px;
		background-color:#FF0000;
		border:2px #000000 solid;
		
	}
	
	.fenPage ul{
		list-style:none;
	}
	
	.fenPage ul li{
		float:left;
		margin-top:10px;
		margin-left:5px;
	}
	
	.fenPage ul input{
		width:20px;
	}
  </style>
  </head>
  
<body>
<!--主体框架-->
<div class="mainDiv">
	<!--标题-->
	<div class="topBiaoTi"></div>
	<!--彩礼事件-->
	<div class="leftShiJian">
		<div class="inSJ"><s:property value="clWhat"/></div>
	</div>
	<!--随礼人列表-->
	<div class="pageHead">
		<ul>
			<li><s:property value="clName"/></li>
			<li><s:property value="clTime"/></li>
			<li><s:property value="clWhat"/></li>
			<li>共<s:property value="list.get(0)[1]"/>人随礼</li>
			<li>总共收<s:property value="list.get(0)[0]"/>礼钱元</li>
		</ul>
	</div>
		<!--用table装随礼人-->
		<table class="userClMe">
			<tr class="topTr">
				<td><div class="inTopTable">当前累计</div></td>
			    <td><div class="inTopTable">当前总计</div></td>
			    <s:iterator value="listClMess" var="c">
			    	<td><div class="inTopTable"><s:property value="#c.ClWho"/></div></td>
			    </s:iterator>
			</tr>
			<tr class="bottomTr">
				<td><s:property value="list.get(0)[0]"/></td>
				<td><s:property value="clMoneySum"/></td>
				<s:iterator value="listClMess" var="c">
					<td><s:property value="#c.ClMoney"/></td>
				</s:iterator>
			</tr>
		</table>
	<div class="fenPage">
		<ul>
			<li><a href="<%=basePath%>user/ClMybank_lookList?pageNumber=0&clName=<s:property value="clName"/>&clWhat=<s:property value="clWhat"/>&clTime=<s:property value="clTime"/>">首页</a></li>|
			<li><a href="<%=basePath%>user/ClMybank_lookList?pageTopBot=top&pageNumber=<s:property value="pageNumber"/>&clName=<s:property value="clName"/>&clWhat=<s:property value="clWhat"/>&clTime=<s:property value="clTime"/>">上一页</a></li>|
			<li><a href="<%=basePath%>user/ClMybank_lookList?pageTopBot=bot&pageNumber=<s:property value="pageNumber"/>&clName=<s:property value="clName"/>&clWhat=<s:property value="clWhat"/>&clTime=<s:property value="clTime"/>">下一页</a></li>|
			<li><a href="<%=basePath%>user/ClMybank_lookList?pageTopBot=bb&pageNumber=<s:property value="pageCount"/>&clName=<s:property value="clName"/>&clWhat=<s:property value="clWhat"/>&clTime=<s:property value="clTime"/>">末页</a></li>
			<li>共<s:property value="pageCount"/>页</li>
		</ul>
	</div>
	
</div>
<div class="bottomDiv">
	<span><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	          东软帝国|彩礼系统|版权所有|盗版必究|@20120208|QQ184172133</span>
</div>
</body>
</html>
