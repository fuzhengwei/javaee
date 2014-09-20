<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  <title>彩礼新建</title>
  <style type="text/css">
  *{
		margin-left:0;
		margin-top:0;
	}
	
	.mainDiv{
		width:800px;
		height:600px;
		margin:0 auto;
	}

	.mainBti{
		width:800px;
		height:150px;
		background-image:url(E:/pictures/Climgs/createLogo.png);
	}
	
	.mainCdan{
		width:800px;
		height:50px;
		background-image:url(E:/pictures/Climgs/updateCaiDan.png);
	}
	
	.mainCdan ul li{
		margin-top:10px;
		margin-left:10px;
		float:left;
		list-style:none;
		font-size:24px;
	}
	
	#createCl{
		width:80px;
		height:30px;
		background-image:url(E:/pictures/Climgs/createButCl.png);
		color:#FF0000;
		font-size:16px;
		border:0;
	}
	
	.leftCon{
		width:175px;
		height:180px;
		float:right;
		background-image:url(E:/pictures/Climgs/createCon.png);
	}
	
	.leftCon input{
		width:120px;
		height:60px;
		margin-top:20px;
		margin-left:30px;
		color:#FFFFFF;
		font-size:24px;
		font-family:"楷体_GB2312";
		background-image:url(E:/pictures/Climgs/createBut.png);
		border:0;
	}
	
	.leftCre{
		width:175px;
		height:105px;
		float:left;
		color:#FFFFFF;
		position:absolute;
		margin-top:60px;
		margin-left:-330px;
		background-image:url(E:/pictures/Climgs/create.png);
		display:none;
	}
	
	.leftCre table{
		margin-top:10px;
		margin-left:10px;
	}
	
	.creaText{
		width:90px;
	}
	
	.creaBut{
		margin-left:20px;
		margin-top:2px;
	}
	
	.rightMes{
		width:600px;
		height:400px;
		background-color:#CCCCCC;
		float:left;
	}
	
	.rightMes ul li{
		float:left;
		margin-top:5px;
		margin-left:70px;
		width:200px;
	}
	
	.rightMes ul li span input{
		width:40px;
		border:1px #FF0000 solid;
	}
	
	.checkVal{
		display:none;
	}
	
  </style>
  <script language="javascript" type="text/javascript" src="e:/jquery-1.4.2.js"></script>
 <script language="javascript" type="text/javascript" >
 $(function(){
	    //点击新建礼单，出现创建表。再点击就没了
		$("#createCl").click(function(){
			$(".leftCre").slideToggle('slow');
			$(".mainCdan ul li:last").css("color","red");
		});	
		//当点击确认时候，获得事件时间，装到菜单用户信息位置
		$("#butEn").click(function(){
				//事件
				var getWhat_ = $("#what").val();
				//时间
				var getTime_ = $("#time").val();
				if(getTime_.length == 10){
					var getYY = parseFloat(getTime_.substring(0,getTime_.indexOf("-")));
					var getMM = parseFloat(getTime_.substring(getTime_.indexOf("-")+1,getTime_.lastIndexOf("-")));
					var getDD = parseFloat(getTime_.substring(getTime_.lastIndexOf("-")+1));
					
					if(getYY > 1900 && getYY <2500 && getMM >= 1 && getMM <= 12 &&getDD>=1 &&getDD<=31){
						if(getWhat_.length <= 10){
							//判断符合后，新建内容装载到用户信息栏
							$("#setWhat_").text(getWhat_);
							$("#setTime_").text(getTime_);
							$("#HclWhat").val(getWhat_);
							$("#HclTime").val(getTime_);
							//新建内容定义为空
							$("#what").val("");
							$("#time").val("");
							$(".leftCre").fadeOut('slow');	
							$(".mainCdan ul li:last").css("color","#999999");
							
						}else{
							alert("事件内容太长，请在十个字之内");
						}
					}else{
						alert("请输入整数符合时间内容的正确格式yy-MM-dd");
					}
				}else{
					alert("时间长度不正确，请安装用户信息后面的时间格式输入");
				}	
		});
		//当点击取消时候，直接把create关闭
		$("#butEsc").click(function(){
			//新建内容定义为空
			$("#what").val("");
			$("#time").val("");
			$(".leftCre").fadeOut('slow');	
			$(".mainCdan ul li:last").css("color","#999999");
		});
		//点击提交信息，把礼人和礼钱，提取出来装载到checkbox
		$("#postMess").click(function(){
			$(".checkVal").attr("checked",false);
			for(var i = 1; i <= 30; i++){
				var checkName = "#checkName_"+i;
				var checkMoney = "#checkMoney_"+i;
				var checkNm = "#checkNm_"+i;
				
				var name = $(checkName).val();
				var money = $(checkMoney).val();
				if(name!=null&&name!=""&&money!=null&&money!=""){
					$(checkNm).val(name+"*"+money).attr("checked",true);
				}
			}		
		});
		//清空提交信息
		$("#enterMess").click(function(){
			$(".rightMes ul li input").val("");
		});
	});
 </script> 
  </head>
  
  <body>
	<!--主框架-->
	<div class="mainDiv">
		<!--top标题logo-->
		<div class="mainBti"></div>
		<!--top菜单logo-->
		<div class="mainCdan">
			<ul>
				<li>用户信息:</li>
				<li><span><s:property value="clName"/></span></li>
				<li><span id="setTime_"><s:property value="clTime"/></span></li>
				<li><span id="setWhat_"><s:property value="clWhat"/></span></li>
				<li><input type="button" value="新建礼单" id="createCl"/></li>
				<li style="float:right; color:#999999; font-size:12px;">当不选择新建礼单时候，将按照<br />当前用户信息，添加随礼用户。</li>
			</ul>
		</div>
		<!--rightMes信息-->
		<form action="<%=basePath%>user/ClMybank_create" method="post">
		
		<div class="rightMes">
			<ul>
				<li><input type="checkbox" class="checkVal" id="checkNm_1" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_1"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_1"/></span></li>
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_2" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_2"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_2"/></span></li>
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_3" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_3"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_3"/></span></li>
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_4" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_4"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_4"/></span></li>
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_5" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_5"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_5"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_6" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_6"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_6"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_7" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_7"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_7"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_8" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_8"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_8"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_9" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_9"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_9"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_10" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_10"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_10"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_11" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_11"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_11"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_12" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_12"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_12"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_13" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_13"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_13"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_14" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_14"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_14"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_15" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_15"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_15"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_16" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_16"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_16"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_17" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_17"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_17"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_18" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_18"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_18"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_19" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_19"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_19"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_20" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_20"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_20"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_21" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_21"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_21"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_22" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_22"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_22"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_23" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_23"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_23"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_24" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_24"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_24"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_25" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_25"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_25"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_26" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_26"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_26"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_27" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_27"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_27"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_28" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_28"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_28"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_29" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_29"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_29"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_30" name="NameMoney"/>
				    <span>礼人：<input type="text" value="" id="checkName_30"/></span>
					<span>礼钱：<input type="text" value="" id="checkMoney_30"/></span></li>	
				
			</ul>
		</div>
		<!--leftCon控制-->
		<div class="leftCon">
			<input type="hidden" value="<s:property value="clName"/>" name="clName"/>
			<input type="hidden" value="<s:property value="clTime"/>" name="clTime" id="HclTime"/>
			<input type="hidden" value="<s:property value="clWhat"/>" name="clWhat" id="HclWhat"/>
			<input type="button" value="清空信息" id="enterMess"/>
			<input type="submit" value="提交信息" id="postMess"/>
		</div>
		</form>
		<!--leftCre创建hidden-->
		<div class="leftCre">
			<table>
				<tr><td>事件：</td><td><input type="text" class="creaText" id="what"/></td></tr>
				<tr><td>时间：</td><td><input type="text" class="creaText" id="time"/></td></tr>
				<tr><td colspan="2"><input type="button" value="确认" class="creaBut" id="butEn"/>
				                    <input type="button" value="取消" class="creaBut" id="butEsc"/></td></tr>
			</table>
		</div>
	</div>
	
</body>
</html>
