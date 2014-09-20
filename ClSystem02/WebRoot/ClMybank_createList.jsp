<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  <title>�����½�</title>
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
		font-family:"����_GB2312";
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
	    //����½��񵥣����ִ������ٵ����û��
		$("#createCl").click(function(){
			$(".leftCre").slideToggle('slow');
			$(".mainCdan ul li:last").css("color","red");
		});	
		//�����ȷ��ʱ�򣬻���¼�ʱ�䣬װ���˵��û���Ϣλ��
		$("#butEn").click(function(){
				//�¼�
				var getWhat_ = $("#what").val();
				//ʱ��
				var getTime_ = $("#time").val();
				if(getTime_.length == 10){
					var getYY = parseFloat(getTime_.substring(0,getTime_.indexOf("-")));
					var getMM = parseFloat(getTime_.substring(getTime_.indexOf("-")+1,getTime_.lastIndexOf("-")));
					var getDD = parseFloat(getTime_.substring(getTime_.lastIndexOf("-")+1));
					
					if(getYY > 1900 && getYY <2500 && getMM >= 1 && getMM <= 12 &&getDD>=1 &&getDD<=31){
						if(getWhat_.length <= 10){
							//�жϷ��Ϻ��½�����װ�ص��û���Ϣ��
							$("#setWhat_").text(getWhat_);
							$("#setTime_").text(getTime_);
							$("#HclWhat").val(getWhat_);
							$("#HclTime").val(getTime_);
							//�½����ݶ���Ϊ��
							$("#what").val("");
							$("#time").val("");
							$(".leftCre").fadeOut('slow');	
							$(".mainCdan ul li:last").css("color","#999999");
							
						}else{
							alert("�¼�����̫��������ʮ����֮��");
						}
					}else{
						alert("��������������ʱ�����ݵ���ȷ��ʽyy-MM-dd");
					}
				}else{
					alert("ʱ�䳤�Ȳ���ȷ���밲װ�û���Ϣ�����ʱ���ʽ����");
				}	
		});
		//�����ȡ��ʱ��ֱ�Ӱ�create�ر�
		$("#butEsc").click(function(){
			//�½����ݶ���Ϊ��
			$("#what").val("");
			$("#time").val("");
			$(".leftCre").fadeOut('slow');	
			$(".mainCdan ul li:last").css("color","#999999");
		});
		//����ύ��Ϣ�������˺���Ǯ����ȡ����װ�ص�checkbox
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
		//����ύ��Ϣ
		$("#enterMess").click(function(){
			$(".rightMes ul li input").val("");
		});
	});
 </script> 
  </head>
  
  <body>
	<!--�����-->
	<div class="mainDiv">
		<!--top����logo-->
		<div class="mainBti"></div>
		<!--top�˵�logo-->
		<div class="mainCdan">
			<ul>
				<li>�û���Ϣ:</li>
				<li><span><s:property value="clName"/></span></li>
				<li><span id="setTime_"><s:property value="clTime"/></span></li>
				<li><span id="setWhat_"><s:property value="clWhat"/></span></li>
				<li><input type="button" value="�½���" id="createCl"/></li>
				<li style="float:right; color:#999999; font-size:12px;">����ѡ���½���ʱ�򣬽�����<br />��ǰ�û���Ϣ����������û���</li>
			</ul>
		</div>
		<!--rightMes��Ϣ-->
		<form action="<%=basePath%>user/ClMybank_create" method="post">
		
		<div class="rightMes">
			<ul>
				<li><input type="checkbox" class="checkVal" id="checkNm_1" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_1"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_1"/></span></li>
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_2" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_2"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_2"/></span></li>
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_3" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_3"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_3"/></span></li>
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_4" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_4"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_4"/></span></li>
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_5" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_5"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_5"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_6" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_6"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_6"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_7" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_7"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_7"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_8" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_8"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_8"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_9" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_9"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_9"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_10" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_10"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_10"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_11" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_11"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_11"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_12" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_12"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_12"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_13" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_13"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_13"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_14" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_14"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_14"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_15" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_15"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_15"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_16" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_16"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_16"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_17" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_17"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_17"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_18" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_18"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_18"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_19" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_19"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_19"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_20" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_20"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_20"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_21" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_21"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_21"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_22" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_22"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_22"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_23" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_23"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_23"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_24" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_24"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_24"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_25" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_25"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_25"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_26" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_26"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_26"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_27" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_27"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_27"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_28" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_28"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_28"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_29" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_29"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_29"/></span></li>	
				<li><input type="checkbox" value="" class="checkVal" id="checkNm_30" name="NameMoney"/>
				    <span>���ˣ�<input type="text" value="" id="checkName_30"/></span>
					<span>��Ǯ��<input type="text" value="" id="checkMoney_30"/></span></li>	
				
			</ul>
		</div>
		<!--leftCon����-->
		<div class="leftCon">
			<input type="hidden" value="<s:property value="clName"/>" name="clName"/>
			<input type="hidden" value="<s:property value="clTime"/>" name="clTime" id="HclTime"/>
			<input type="hidden" value="<s:property value="clWhat"/>" name="clWhat" id="HclWhat"/>
			<input type="button" value="�����Ϣ" id="enterMess"/>
			<input type="submit" value="�ύ��Ϣ" id="postMess"/>
		</div>
		</form>
		<!--leftCre����hidden-->
		<div class="leftCre">
			<table>
				<tr><td>�¼���</td><td><input type="text" class="creaText" id="what"/></td></tr>
				<tr><td>ʱ�䣺</td><td><input type="text" class="creaText" id="time"/></td></tr>
				<tr><td colspan="2"><input type="button" value="ȷ��" class="creaBut" id="butEn"/>
				                    <input type="button" value="ȡ��" class="creaBut" id="butEsc"/></td></tr>
			</table>
		</div>
	</div>
	
</body>
</html>
