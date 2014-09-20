// JavaScript Document
	$(function(){  
			   
		$(document).mousemove(function(e){		
			var numX = e.pageX;
			if(numX >= 680){
				$(".lubiao").css("background-image","url(E:/pictures/Climgs/red.png)");
				$(".imgAdd").css("background-image","url(E:/pictures/Climgs/userAdd.jpg)");
				$(".imgLogin").css("background-image","url(E:/pictures/Climgs/userlogin2.jpg)");
			}else{
				$(".lubiao").css("background-image","url(E:/pictures/Climgs/green.png)");
				$(".imgLogin").css("background-image","url(E:/pictures/Climgs/userLogin.jpg)");
				$(".imgAdd").css("background-image","url(E:/pictures/Climgs/useradd2.jpg)");
			}
		});
		
		$(".PdSub").click(function(){
			var userName = $("#addName").val();
			var userAge = $("#addAge").val();
			var userPw = $("#addPw").val();
			
			/*
			 * @判断遏止长度
			 * */
			if(userAge.length>2){
				alert("请输入两位整数的年龄");
				return false;
			}else if(userAge.length == 1){
				alert("十岁一下儿童禁止上网！");
				return false
			}else if(userAge*0 != 0){
				alert("请输入整数数字");
				return false;
			}
			
			
			/*
			 * @判断遏止不能为空
			 * */
			if(userName == null || userName ==""){
				alert("姓名不能为空！");
				return false;
			}
			if(userAge == null || userAge == ""){
				alert("年龄不能为空");
				return false;
			}
			if(userPw == null || userPw == ""){
				alert("密码不能为空");
				return false;
			}
		});
	});