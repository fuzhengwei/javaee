	
	/*****************************************
	 *���������table����					 *
	 *ʹ�õ�ʱ���tableһ��					 *
	 *id=editTable							 *
	 *����������Ƕ���õ����ݿ��ֶ�		 	 *
	 *��ʹ��jqAjaxʱ��ֱ�ӱ���carSub���󼴿�   *
	 *****************************************/
	
	$(function(){
		
		//�����Ҫ���������ֶ�
		var colmes = new Array("ctid","","cnickname","cname","csex","ctel","cemail","cbirthday","caddress");		
		//����һ����װ���û�װ����
		var carSub = "";
	
		var Einput = "<input type='text' style='background:transparent;border:0px;color:yellow;width:100px;'></input>";		   
		var regex = new RegExp("^[\u4E00-\u9FA5]+$");
		
		$("#editTable tr:gt(0) td:gt(1)").click(function(){
			
			var now_ = $(this).text();
		
			if($(this).children().val()==null){
				
				$(this).empty();
				$(this).append(Einput).focus();
				if(regex.test(now_)){
					$(this).children().focus().val(now_).css('width',now_.length*16);
				}else{
					$(this).children().focus().val(now_).css('width',now_.length*10);
				}
			}
			
		});
		
		
		$("#editTable tr:gt(0) td span[id='updateE']").click(function(){
				
				//���ԭ�����ڵ�����
				carSub = "";
				
				//���id��װ��
				carSub = "{\""+colmes[0]+"\":\""+$(this).attr("class")+"\",";

				//������޸�ʱ�򣬻�ø�Ԫ�أ�֮���ø�Ԫ�����µĺ���Ԫ��
				var obj = $(this).parent().parent().children();
				
				for(var i = 2; i < obj.length - 1; i ++){
					
					//�������ı����ֵ�ǿ�˵������ı����Ѿ���input textȡ��
					if(obj.eq(i).text().length == ""){
						carSub += "\""+colmes[i]+"\":\""+obj.eq(i).children().val() + "\",";
					}else{
						carSub += "\""+colmes[i]+"\":\""+obj.eq(i).text() + "\",";	
					}
					
					//�޸��Ժ����Ժ���ı���ȥ��
					obj.eq(i).text(obj.eq(i).children().val());	
					obj.eq(i).children().empty();
			    }
				//��������������ĵ�ȥ��,֮������������ţ����ת��Ϊ������eval
				carSub = eval("("+carSub.substr(0,carSub.lastIndexOf(","))+"})");
				//�첽���̨������Ϣ
				AjaxJq(carSub);
		});
		
		function AjaxJq(carSub){
			var time = new Date();
			var url = "http://localhost:8088/aps/Corporation?type=14&key=3&"+time.getTime();
			 $.get(url,
						{
					 		ctid:carSub["ctid"],
					 		cnickname:carSub["cnickname"],
					 		cname:carSub["cname"],
					 		csex:carSub["csex"],
					 		ctel:carSub["ctel"],
					 		cemail:carSub["cemail"],
					 		cbirthday:carSub["cbirthday"],
					 		caddress:carSub["caddress"]
						}
			 		 ,function(date){
					alert(date);
	         })
		}
		//2012��9��12�� 08:33:38
		//�����ɾ����ʱ��ɾ�����Ԫ��
		$("span[id=deleteE]").click(function(){
			
			var isDelete = confirm("ȷ��ɾ��������");
			//ȷ���Ƿ�ɾ��
			if(isDelete){
				
				$(this).parent().parent().empty();
				var url = "http://localhost:8088/aps/Corporation?type=14&key=2&deleteId="+$(this).attr("class");
				$.get(url,null,function(date){
					alert(date);
				});
				
			}
		});
		
		
		/*
		 *2012��9��12�� 15:54:33��������ɾ��
		 */
		 
		//����һ������������ɾ����id��һ����ϵ��������
		var witeDeleteNoS = "";
		
		//2012��9��12�� 13:58:00
		//���û���껬������ѡ���ϵ�ʱ��������ѡȡ��
		$("table tr td input[type=checkbox]").mouseover(function(){
			
			if(!$(this).attr("checked")){
				$(this).attr("checked",true);
			}else{
				$(this).attr("checked",false);
			}
			
		});
		
		//�����ѡȡȫ����ʱ��
		//��һ�ε����ôѡȡȫ����
		//�ڶ��ε����ȫ�� ��ѡȡ
		$("#isSelectAll").toggle(function(){						  
			$(this).text("ȫ�����");
			$("table tr td input[type=checkbox]").attr("checked",true);
		},function(){
			$(this).text("ȫ��ѡȡ");
			$("table tr td input[type=checkbox]").attr("checked",false);
		});
		
		//�����ɾ������ʱ��
		//var name=prompt("��������������","Bill Gates")
		$("#isDeleteChecked").click(function(){
			
			var mouseKey = prompt("������ִ�п���","");
			
			//���õ�����ڣ��������첽�ύ���жϴο����Ƿ���ȷ
			if("tiger" == mouseKey){
				
				var Eobj = $("table tr td input[type=checkbox]");
				$.each(Eobj,function(i,n){
						//��װҪɾ����id
						if(n.checked){
							witeDeleteNoS += n.value + ",";	
							$("table tr td span[class="+n.value+"]").parent().parent().empty();
						}
								
				})
				
				alert("delete ok! ��ɾ�ֶ�id��"+witeDeleteNoS);
			}else{
				alert("�������")
			}
		
		
		});
	});
	