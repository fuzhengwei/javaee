// JavaScript Document

	$(function(){
		
		var regexName1 = new RegExp("^[a-zA-Z]{2,10}$");
		/*���ǳ�*/
		$("#cnickname").focus(function(){
			
			$(".eisok2").empty();
			
			if(regexName1.test($(this).val())){
				$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;��</span>");
			}else{
				$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;2-10��Ӣ����ĸ</span>");
			}

		}).blur(function(){
				
				$(".eisok2").empty();
				
				if(regexName1.test($(this).val())){
					$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;��</span>");
				}else{
					$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;��</span>");
				}
		
		});
		
		var regexName = new RegExp("^[\u4E00-\u9FA5]{2,3}$");
		/*���ǳ�*/
		$("#cname").focus(function(){
			
			$(".eisok1").empty();
			
			if(regexName.test($(this).val())){
				$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;��</span>");
			}else{
				$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;2-3������</span>");
			}

		}).blur(function(){
				
				$(".eisok1").empty();
				
				if(regexName.test($(this).val())){
					$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;��</span>");
				}else{
					$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;��</span>");
				}
		
		});
		
		
		var regexAge = new RegExp("^[1]{1}[0-9]{10}$");
		/*���ֻ��Ž���ƥ��*/
		$("#ctel").focus(function(){
								   
			$(".eisok3").empty();
			
			if(regexAge.test($(this).val())){
				$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;��</span>");
			}else{
				$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;11λ�����ֻ���</span>");
			}
					   
		}).blur(function(){
				
				$(".eisok3").empty();
				
				if(regexAge.test($(this).val())){
					$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;��</span>");
				}else{
					$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;��</span>");
				}
			
		});
		
		var regexEmail = new RegExp("^[a-zA-Z0-9]+@[a-zA-Z]{2,5}\\56{1}(com|cn)$");
		/*��email��ƥ��*/
		$("#cemail").focus(function(){
			$(".eisok4").empty();
			
			if(regexEmail.test($(this).val())){
				$(this).after("<span class='eisok4' style='color:red; width:15px;'>&nbsp;��</span>");
			}else{
				$(this).after("<span class='eisok4' style='color:red; width:15px;'>&nbsp;���������</span>");
			}
		}).blur(function(){
			
			$(".eisok4").empty();
				
			if(regexEmail.test($(this).val())){
				$(this).after("<span class='eisok4' style='color:red; width:15px;'>&nbsp;��</span>");
			}else{
				$(this).after("<span class='eisok4' style='color:red; width:15px;'>&nbsp;��</span>");
			}
		});
		
		/*������֤**/
		
		var regexPwd = new RegExp("^[0-9A-Za-z]{6,15}$");
		$("#cpwd").focus(function(){
								   
			$(".eisok5").empty();
			
			if(regexPwd.test($(this).val())){
				$(this).after("<span class='eisok5' style='color:red; width:15px;'>&nbsp;��</span>");
			}else{
				$(this).after("<span class='eisok5' style='color:red; width:15px;'>&nbsp;6-15������Ӣ������</span>");
			}
					   
		}).blur(function(){
				
				$(".eisok5").empty();
				
				if(regexPwd.test($(this).val())){
					$(this).after("<span class='eisok5' style='color:red; width:15px;'>&nbsp;��</span>");
				}else{
					$(this).after("<span class='eisok5' style='color:red; width:15px;'>&nbsp;��</span>");
				}
			
		});
		/*����ȷ��*/
		$("#cpwd2").focus(function(){
								   
			$(".eisok7").empty();
			
			if(regexPwd.test($(this).val())){
				$(this).after("<span class='eisok7' style='color:red; width:15px;'>&nbsp;��</span>");
			}else{
				$(this).after("<span class='eisok7' style='color:red; width:15px;'>&nbsp;6-15������Ӣ������</span>");
			}
					   
		}).blur(function(){
				
				$(".eisok7").empty();
				
				if(regexPwd.test($(this).val()) && $(this).val() == $("#cpwd").val()){
					$(this).after("<span class='eisok7' style='color:red; width:15px;'>&nbsp;��</span>");
				}else{
					$(this).after("<span class='eisok7' style='color:red; width:15px;'>&nbsp;�����벻ͳһ</span>");
				}
			
		});
		
	});