<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  <title>彩礼更新</title>
  <style type="text/css">
  	
  	*{
		margin-top:0;
		margin-left:0;
	}
	
	.mainDiv{
		width:800px;
		height:600px;
		margin:0 auto;
	}
	
	.topDiv{
		width:800px;
		height:150px;
		background-image:url(E:/pictures/Climgs/updatelist.png);
	}

	.caidan{
		width:800px;
		height:50px;
		background-image:url(E:/pictures/Climgs/updateCaiDan.png);
		
	}
	
	
	.caidan ul li{
		list-style:none;
		margin-left:10px;
		margin-top:10px;
		font-size:28px;
		font-family:"楷体_GB2312";
		float:left;
	}
	
	.rightDiv{
		width:200px;
		height:140px;
		background-image:url(E:/pictures/Climgs/updateForm.png);
		float:right;
	}
	
	.rightDiv input{
		width:100px;
	}
	
	.rightDiv form{
		margin-left:15px;
	}
	
	.leftDiv{
		width:580px;
		height:400px;
		float:left;
		
	}
	
	.leftDiv ul li{
		list-style:none;
		width:180px;
		float:left;
	}
	
	.leftDiv ul li input{
		cursor:pointer;
	}
  </style>
  <script language="javascript" type="text/javascript" src="e:/jquery-1.4.2.js"></script>
  <script language="javascript" type="text/javascript" src="js/jquery-1.4.2.js"></script>
  <script type="text/javascript">
  $(function(){
		$(".leftDiv ul li input").click(function(){
			var clName = $(this).next("span").text();
			var clMeony = $(this).next("span").next("span").text();
			$("#ClWho").val(clName);
			$("#ClMeony").val(clMeony);
		});
		
		$(document).mousemove(function(){
			var scrollNumber = $(this).scrollTop();
			if(scrollNumber > 200){
				scrollNumber = scrollNumber;
				$(".rightDiv").css("margin-top",scrollNumber+"px");
			}else{
				$(".rightDiv").css("margin-top","0px");
			}
		});
		$("#selectClName").click(function(){
			var clName = $("#selectMyTextName").val();
			var cZu = "span:contains("+clName+")";
			$("span").css("color","black");
			$(cZu).css("color","red");
		});

	});
  </script>
  </head>
  
  <body>
	<!--主框架-->
	<div class="mainDiv">
		<!--标题图片域-->
		<div class="topDiv"></div>
		<!--菜单栏-->
		
		<div class="caidan">
	
			<ul>
				<li>用户信息:</li>
			    <li><s:property value="clName"/></li>
				<li><s:property value="clTime"/></li>
				<li><s:property value="clWhat"/></li>
				<li style="float:right"><input type="text" id="selectMyTextName"/><input type="button" value="搜索" id="selectClName"/></li>
			</ul>
		
		</div>
		<!--靠在左面的内容栏-->
		<div class="leftDiv">
			<ul>
			  <s:iterator value="listClMess" var="c">
			  	 <li><input type="button" value="提取" id="getMes"/>
			  	 <span><s:property value="#c.ClWho"/></span>--
			  	 <span><s:property value="#c.ClMoney"/></span>元</li>
			  </s:iterator>
			</ul>
		</div>
		<!--靠在右面的更新栏-->
		<div class="rightDiv">
			<form action="<%=basePath%>user/ClMybank_update" method="post">
				用户名：<input type="text" value="<s:property value="clName"/>" disabled="disabled"/>
				      <input type="hidden" value="<s:property value="clName"/>" name="ct.ClHome" id="clName"/><br/>
				时&nbsp;&nbsp;间：<input type="text" value="<s:property value="clTime"/>" disabled="disabled"/>
								  <input type="hidden" value="<s:property value="clTime"/>" name="ct.ClTime"/><br/>
				事&nbsp;&nbsp;件：<input type="text" value="<s:property value="clWhat"/>" disabled="disabled"/>
								  <input type="hidden" value="<s:property value="clWhat"/>" name="ct.ClWhat"/><br/>
				随礼人：<input type="text" name="ct.ClWho" id="ClWho"/><br/>
				随钱数：<input type="text" name="ct.ClMoney" id="ClMeony"/><br/>
				<input type="submit" value="提交更新" style="margin-left:35px;"/>
			</form>
		</div>
	</div>
</body>
</html>
