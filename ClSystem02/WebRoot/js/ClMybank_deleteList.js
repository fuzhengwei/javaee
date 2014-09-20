// JavaScript Document
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
