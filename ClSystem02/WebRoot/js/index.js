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
			 * @�ж϶�ֹ����
			 * */
			if(userAge.length>2){
				alert("��������λ����������");
				return false;
			}else if(userAge.length == 1){
				alert("ʮ��һ�¶�ͯ��ֹ������");
				return false
			}else if(userAge*0 != 0){
				alert("��������������");
				return false;
			}
			
			
			/*
			 * @�ж϶�ֹ����Ϊ��
			 * */
			if(userName == null || userName ==""){
				alert("��������Ϊ�գ�");
				return false;
			}
			if(userAge == null || userAge == ""){
				alert("���䲻��Ϊ��");
				return false;
			}
			if(userPw == null || userPw == ""){
				alert("���벻��Ϊ��");
				return false;
			}
		});
	});