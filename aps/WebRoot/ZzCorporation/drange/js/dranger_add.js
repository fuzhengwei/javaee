// JavaScript Document
	$(function(){
			   
		var regex = new RegExp("^[0-9]{1,5}$");

		/*��������׹�����֤*/
		$("#drfkg").focus(function(){
				
			$(".eisok").empty();
			
			if(regex.test($(this).val())){
				$(this).after("<span class='eisok' style='color:red; width:15px;'>&nbsp;��</span>");
			}else{
				$(this).after("<span class='eisok' style='color:red; width:15px;'>&nbsp;1-5λ��Ч����</span>");
			}
			
		}).blur(function(){
			
			$(".eisok").empty();
				
			if(regex.test($(this).val())){
				$(this).after("<span class='eisok' style='color:red; width:15px;'>&nbsp;��</span>");
			}else{
				$(this).after("<span class='eisok' style='color:red; width:15px;'>&nbsp;��</span>");
			}
		});
		/*������Ĵι�����֤*/	
		$("#drokg").focus(function(){
				
			$(".eisok1").empty();
			
			if(regex.test($(this).val())){
				$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;��</span>");
			}else{
				$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;1-5λ��Ч����</span>");
			}
			
		}).blur(function(){
			
			$(".eisok1").empty();
			
			if(regex.test($(this).val())){
				$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;��</span>");
			}else{
				$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;��</span>");
			}
		});
	});