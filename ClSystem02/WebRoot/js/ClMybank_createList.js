// JavaScript Document
	
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