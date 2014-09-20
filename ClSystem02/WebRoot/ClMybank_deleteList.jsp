<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  <title>����ɾ��</title>
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
	
	.topLogo{
		width:800px;
		height:150px;
		background-image:url(E:/pictures/Climgs/deleteLogo.png);
	}
	
	.caidanLogo{
		width:800px;
		height:50px;
		background-image:url(E:/pictures/Climgs/updateCaiDan.png);
	}
	
	.caidanLogo ul li{
		list-style:none;
		margin-left:10px;
		margin-top:10px;
		font-size:28px;
		font-family:"����_GB2312";
		float:left;
	}
	
	#selectMyTextName{
		width:120px;
	}
	
	.rightControl{
	    width:176px;
		height:200px;
		float:right;
		background-image:url(E:/pictures/Climgs/deleteCon.png);
	}
	
	.userMess{
		width:90px;
	}
	
	.but{
		margin-left:10px;
		margin-top:10px;
		width:74px;
		height:30px;
		cursor:pointer;
		background-image:url(E:/pictures/Climgs/deleteBut.png);
		border:0;
		color:#FFFFFF;
		font-family:"����_GB2312";
		font-size:16px;
	}
	
	.sub{
		width:158px;
		height:30px;
		margin-left:10px;
		margin-top:10px;
		background-image:url(E:/pictures/Climgs/deleteSub.png);
		border:0;
		color:#0000FF;
		font-size:24px;
		font-family:"����_GB2312";
	}
	
	.leftUser{
		width:624px;
		height:400px;
		float:left;
	}
	
	.leftUser ul{
		margin-top:10px;
	} 
	
	.leftUser ul li{
		margin-top:10px;
		width:145px;
		float:left;
	}
  </style>
  <script language="javascript" type="text/javascript" src="e:/jquery-1.4.2.js"></script>
  <script language="javascript" type="text/javascript">
  $(function(){
		
		var pdCon = 0;
		
		
		$(document).mousemove(function(e){	
			if(e.pageX < 890){
				if(e.pageY >= 200 && pdCon == 0){
					var topY =  e.pageY - 200;
					$(".rightControl").css("margin-top",topY);
				}else if(e.pageY < 200){
					$(".rightControl").css("margin-top","0");
				}
			}
		});
	
		$("#moveCheck").click(function(){
			$("#onlyCheck").css("color","#FFFFFF");
			$(this).css("color","red");
			
			$(".leftUser ul li label input").mousemove(function(){
										$(this).attr("checked",true);
									});
		});
		
		$("#onlyCheck").click(function(){
			$("#moveCheck").css("color","#FFFFFF");
			$(this).css("color","red");
			$(".leftUser ul li label input").unbind('mousemove');
		})
		
		$("#clearCheck").click(function(){
			$("input[type=checkbox]").attr("checked",false);
		});
		
		$("#allCheck").click(function(){
			$("input[type=checkbox]").attr("checked",true);
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
	<!--�����-->
	<div class="mainDiv">
		<!--top����logo-->
		<div class="topLogo"></div>
		<!--top�˵�logo-->
		<div class="caidanLogo">
			<ul>
				<li>�û���Ϣ:</li>
			    <li><s:property value="clName"/></li>
				<li><s:property value="clTime"/></li>
				<li><s:property value="clWhat"/></li>
				<li style="float:right; margin-right:5px;"><input type="text" id="selectMyTextName"/><input type="button" value="����" id="selectClName"/></li>
			</ul>
		</div>
		<form action="<%=basePath%>user/ClMybank_delete" method="post">
			<!--left�û���-->
			<div class="leftUser">
				<ul>
					<s:iterator value="listClMess" var="c">
						<li><label><input type="checkbox" name="checkId" class="checkId" value="<s:property value="#c.ClId"/>"/><span><s:property value="#c.ClWho"/></span><span><s:property value="#c.ClMoney"/></span>Ԫ</label></li>
					</s:iterator>
				</ul>
			</div>
			<!--right������-->
			<div class="rightControl">
				&nbsp;�û�����<input type="text"  value="<s:property value="clName"/>" class="userMess" name="clName"/>
				&nbsp;ʱ&nbsp;&nbsp;�䣺<input type="text"  value="<s:property value="clTime"/>" class="userMess" name="clTime"/>
				&nbsp;��&nbsp;&nbsp;����<input type="text"  value="<s:property value="clWhat"/>" class="userMess" name="clWhat"/>
				<input type="button" value="��һ��ȡ" class="but" id="onlyCheck"/>
				<input type="button" value="������ȡ" class="but" style="margin-left:2px;" id="moveCheck"/>
				<input type="button" value="ȫ��ѡȡ" class="but" id="allCheck"/>
				<input type="button" value="���ѡȡ" class="but" style="margin-left:2px;" id="clearCheck"/>
				<input type="submit" value="�ύɾ����Ϣ" class="sub"/>
			</div>
		</form>
	</div>
</body>
</html>
