// JavaScript Document
	$(function(){
		
		$("#wbb").click(function(){
			
			var fileurl = $("#fileurl").val(),
				fileurlSave="",fileNum,fileurlNew="";

			
			while(fileurl.lastIndexOf("\\") > 0){
				fileNum = fileurl.indexOf("\\");
				fileurlSave += fileurl.substring(0,fileNum)+"/";
				fileurl = fileurl.substring((fileNum+1));
			}
			/*����*/
			fileurlNew = fileurlSave + $("#filename").val() + $("#fileleix").val();
			
			/*д��*/
			writeFile(fileurlNew,$("#tta").val());
		});
		
		$("#2012").click(function(){
			var xxx = "������������룬����ܿ���\r\nhttp://topic.csdn.net/u/20110331/23/f7ae08f2-5824-4162-8949-65e618fa5e82.html?47267";
			$("#tta").val(xxx);					  
		});
		
	});
	 
/*    
object.OpenTextFile(filename[, iomode[, create[, format]]])    
����    
object    
��ѡ�object ӦΪ FileSystemObject �����ơ�    
filename    
��ѡ�ָ��Ҫ���ļ����ַ������ʽ��    
iomode    
��ѡ���������������֮һ��ForReading �� ForWriting �� ForAppending ��    
create    
��ѡ�Boolean ֵ��ָ����ָ���� filename ������ʱ�Ƿ񴴽����ļ�������������ļ���ֵΪ True �������������Ϊ False ��������ԣ��򲻴������ļ���    
format    
��ѡ�ʹ����ֵ̬�е�һ����ָ�����ļ��ĸ�ʽ��������ԣ���ô�ļ����� ASCII ��ʽ�򿪡�    
����    
iomode �������������������е���һ�֣�    
���� ֵ         ����    
ForReading 1 ��ֻ����ʽ���ļ�������д����ļ���    
ForWriting 2 ��д��ʽ���ļ�    
ForAppending 8 ���ļ������ļ�ĩβ��ʼд��    
  
format �������������������е���һ�֣�    
ֵ              ����    
TristateTrue �� Unicode ��ʽ���ļ���    
TristateFalse �� ASCII ��ʽ���ļ���    
TristateUseDefault ʹ��ϵͳĬ��ֵ���ļ���    
*/     
   
//���ļ�     
function readFile(filename){     
var fso = new ActiveXObject("Scripting.FileSystemObject");     
var f = fso.OpenTextFile(filename,1);     
var s = "";     
while (!f.AtEndOfStream)     
s += f.ReadLine()+"\n";     
f.Close();     
return s;     
}     
   
//д�ļ�     
function writeFile(filename,filecontent){     
    var fso, f, s ;     
    fso = new ActiveXObject("Scripting.FileSystemObject");        
    f = fso.OpenTextFile(filename,8,true);     
    f.WriteLine(filecontent);       
    f.Close();     
	alert('д�����');     
}   