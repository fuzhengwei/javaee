// JavaScript Document
	
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