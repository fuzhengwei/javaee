// JavaScript Document
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