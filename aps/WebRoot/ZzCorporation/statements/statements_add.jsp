<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
   <title>�鿴����</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/statements/css/statements_add.css" />
<script language="javascript" type="text/javascript" src="<%=basePath %>ZzCorporation/statements/js/jquery-1.4.2.js"></script>
<script language="javascript" type="text/javascript" src="<%=basePath %>ZzCorporation/statements/js/statements_list.js"></script>
</head>

<body>
	
	<div class="mainDiv">
		<div class="leftDiv">
			<ul>
				<li><a href="javascript:void(0)" id="2012">2012��</a>
					<ul>
						<li><a href="javascript:void(0)">��һ����</a>
							<ul>
								<li><a href="javascript:void(0)">1</a>
								    <a href="javascript:void(0)">2</a>
									<a href="javascript:void(0)">3</a></li>
							</ul>
						</li>
						<li><a href="javascript:void(0)">�ڶ�����</a>
							<ul>
								<li><a href="javascript:void(0)">4</a>
								    <a href="javascript:void(0)">5</a> 
								    <a href="javascript:void(0)">6</a></li>
							</ul>
						</li>
						<li><a href="javascript:void(0)">��������</a>
							<ul>
								<li><a href="javascript:void(0)">7</a>
								    <a href="javascript:void(0)">8</a>
								    <a href="javascript:void(0)">9</a></li>
							</ul>
						</li>
						<li><a href="javascript:void(0)">���ļ���</a>
							<ul>
								<li><a href="javascript:void(0)">10</a> 
								    <a href="javascript:void(0)">11</a> 
								    <a href="javascript:void(0)">12</a></li>
							</ul>
						</li>
					</ul>
				</li>
				
				<!--2011-->
				<li><a href="javascript:void(0)">2011��</a>
					<ul>
						<li><a href="javascript:void(0)">��һ����</a>
							<ul>
								<li><a href="javascript:void(0)">1</a>
								    <a href="javascript:void(0)">2</a>
									<a href="javascript:void(0)">3</a></li>
							</ul>
						</li>
						<li><a href="javascript:void(0)">�ڶ�����</a>
							<ul>
								<li><a href="javascript:void(0)">4</a>
								    <a href="javascript:void(0)">5</a> 
								    <a href="javascript:void(0)">6</a></li>
							</ul>
						</li>
						<li><a href="javascript:void(0)">��������</a>
							<ul>
								<li><a href="javascript:void(0)">7</a>
								    <a href="javascript:void(0)">8</a>
								    <a href="javascript:void(0)">9</a></li>
							</ul>
						</li>
						<li><a href="javascript:void(0)">���ļ���</a>
							<ul>
								<li><a href="javascript:void(0)">10</a> 
								    <a href="javascript:void(0)">11</a> 
								    <a href="javascript:void(0)">12</a></li>
							</ul>
						</li>
					</ul>
				</li>
				
				
			</ul>
		</div>
		
		<div class="rightDiv">
			<textarea style="width:694px;height:370px;border:1px #FFFFFF solid;background:transparent;font-size:18px;color:#FFFFFF;" id="tta"></textarea>
			<table border="1" style="color:#FFFFFF;width:698px;">
				<tr>
					<td>�ļ�·����</td>
					<td>
						<input type="file" id="fileurl" style="width:70px;height:30px;border:1px #FF0000 solid;"/>
					</td>
					<td>�ļ�����</td>
					<td>
						<input type="text" id="filename" style="background:transparent;border:1px #00FFFF solid; width:150px;height:30px;color:#FFFF00;font-size:26px;"/>
					</td>
					<td>�ļ�����</td>
					<td>
						<select id="fileleix" style="background:transparent;color:#FF00FF;border:0px;">
							<option value=".txt">txt</option>
							<option value=".doc">word</option>
							<option value=".xsl">excel</option>
						</select>
					</td>
					<td><input type="button" value="ȷ��д��" id="wbb" style="width:100px;height:30px;background-color:#000000;border:1px #FF0000 solid;color:#FF0000;"/></td>
				</tr>	
				<tr>
					<td colspan="7">
						<form action="<%=basePath %>Corporation?type=12" method="post">
							<input type="text" name="url" style="background: transparent;"/>
							<input type="submit" value="���汨��" style="width:100px;height:30px;background-color:#000000;border:1px #FF0000 solid;color:#FF0000;"/> 
							<a href="F:/���������ѵ/WEB-Project/aps/WebRoot/bb" target="_black">��ʷ����</a>
						</form>
					</td>
				</tr>
				
			</table>
		</div>
		
	</div>
	
</body>

</html>
