// JavaScript Document
	var bool = false;
	$(function(){
			   
		var regex = new RegExp("^[\u4E00-\u9FA5]{1,2}[A-Z]{1} [0-9A-Z]{5,6}$");

		/*�Գ��ƺ���֤*/
		$("#cbrand").focus(function(){
				
				$(".eisok").empty();
				
				if(regex.test($(this).val())){
					$(this).after("<span class='eisok' style='color:red; width:15px;'>&nbsp;��</span>");
					bool = true;
				}else{
					$(this).after("<span class='eisok' style='color:red; width:15px;'>&nbsp;��Ч���ƺ�</span>");
					bool = false;
				}
			
		}).blur(function(){
			
			$(".eisok").empty();
			
			if($(this).val().length = 10){
				
				if(regex.test($(this).val())){
					$(this).after("<span class='eisok' style='color:red; width:15px;'>&nbsp;��</span>");
					bool = true;
				}else{
					$(this).after("<span class='eisok' style='color:red; width:15px;'>&nbsp;��</span>");
					bool = false;
				}
				
			}else{
				$(this).after("<span class='eisok' style='color:red; width:15px;'>&nbsp;��</span>");
				bool = false;
			}
			
		});		
		
		var regexName1 = new RegExp("^[\u4E00-\u9FA5]{2,3}$");
		/*���û���*/
		$("#cpripal").focus(function(){
			
			$(".eisok21").empty();
			
			if(regexName1.test($(this).val())){
				$(this).after("<span class='eisok21' style='color:red; width:15px;'>&nbsp;��</span>");
				bool = true;
			}else{
				$(this).after("<span class='eisok21' style='color:red; width:15px;'>&nbsp;2-3��������</span>");
				bool = false;
			}

		}).blur(function(){
				
				$(".eisok21").empty();
				
				if(regexName1.test($(this).val())){
					$(this).after("<span class='eisok21' style='color:red; width:15px;'>&nbsp;��</span>");
					bool = true;
				}else{
					$(this).after("<span class='eisok21' style='color:red; width:15px;'>&nbsp;��</span>");
					bool = false;
				}
		
		});
		
		var regexName2 = new RegExp("^[0-9]{1,10}$");

		/*���������ƥ��*/
		$("#cvolume").focus(function(){
				
				$(".eisok2").empty();
				
				if(regexName2.test($(this).val())){
					$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;��</span>");
					bool = true;
				}else{
					$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;1-10λ����</span>");
					bool = false;
				}
			
		}).blur(function(){
			
			$(".eisok2").empty();
			
			if($(this).val().length = 10){
				
				if(regexName2.test($(this).val())){
					$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;��</span>");
					bool = true;
				}else{
					$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;��</span>");
					bool = false;
				}
				
			}else{
				$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;��</span>");
				bool = false;
			}
			
		});	
		
		var regexName = new RegExp("^[0-9]{1,10}$");

		/*���������ƥ��*/
		$("#capac").focus(function(){
				
				$(".eisok3").empty();
				
				if(regexName.test($(this).val())){
					$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;��</span>");
					bool = true;
				}else{
					$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;1-10λ����</span>");
					bool = false;
				}
			
		}).blur(function(){
			
			$(".eisok3").empty();
			
			if($(this).val().length =10){
				
				if(regexName.test($(this).val())){
					$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;��</span>");
					bool = true;
				}else{
					$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;��</span>");
					bool = false;
				}
				
			}else{
				$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;��</span>");
				bool = false;
			}
			
		});		
	
	});
	
	function doLogin(){
		return bool;
	}