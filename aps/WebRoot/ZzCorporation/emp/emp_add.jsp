<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    
<title>Ա����</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/emp/css/add.css" />
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/emp/js/jquery-1.4.2.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/emp/js/gettime.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/emp/js/getaddress.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/emp/js/gunzhou.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/emp/js/checked.js"></script>
</head>

<body onLoad="setup()">
	<!--������-->
	<div class="mainDiv">
		<div class="bottom">
		
			<form action="<%=basePath %>Corporation?type=6&key=1&pageNow=1" method="post">
			<table  border="1"class="tab">
				<tr>
					<td>����</td>
					<td>
						<input type="text" id="ztcss" name="ename" maxlength="3" class="ename"/>
					</td>
					
				</tr>
				<tr>
					<td>�Ա�</td>
					<td>
						<label><input type="radio" value="��" checked="checked" name="esex"/>��</label>
						<label><input type="radio" value="Ů" name="esex"/>Ů</label>
					</td>	
				</tr>
				
				<tr>
					<td>����</td>
					<td>
						<input type="text" name="ebirthday" readonly="true" onClick="setDay(this);" id="ztcss" class="ebir"/>&nbsp;age:
						<input type="text" value="24" name="eage" id="ztcss" readonly="true" class="eage" style="width:20px; border:1px #FF0000 solid; "/>��
					</td>
					<td align="center" style="border:0px;">Ա</td>
				</tr>
				<tr>
					<td>������ò</td>
					<td>
						<label><input type="radio" value="��Ա" name="epa" checked="checked"/>��Ա</label>
						<label><input type="radio" value="��Ա" name="epa"/>��Ա</label>
						<label><input type="radio" value="�޵���ʿ" name="epa"/>�޵���ʿ</label>
					</td>
					<td align="center" style="border:0px;">��</td>
				</tr>
				<tr>
					<td>��ַ</td>
					<td><select id="tid1" name="tid1"></select>
    					<select id="tid2" name="tid2"></select>
    					<select id="tid3" name="tid3"></select>
					</td>
					<td align="center" style="border:0px;">ע</td>
				</tr>
				<tr>
					<td>�ֻ���</td>
					<td><input type="text" name="ephone" id="ztcss" class="ztcss" maxlength="11"/></td>
					<td align="center" style="border:0px;">��</td>
				</tr>
				<tr>
					<td>email</td>
					<td><input type="text" name="eemail"id="ztcss" class="eemail" style="width:120px;"/></td>
					
				</tr>
				<tr>
					<td>ְλ</td>
					<td>
						<select name="epost">
							<option value="˾��">˾��</option>
							<option value="Ա��">Ա��</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>����</td>
					<td>
						<select name="edept">
							<option value="���䲿��">��������</option>
							<option value="������">������</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>��ְʱ��</td>
					<td>
						<input type="text" name="eindate" readonly="true" onClick="setDay(this);" id="ztcss">
					</td>
				</tr>
				<tr>
					<td>нˮ</td>
					<td><input type="text" name="esal" onfocus="ufocus(this)" onblur="ublur(this)" id="ztcss" class="esal" maxlength="5" style="width:40px;"/>
						+<span id="esal1" class="esal1">1000</span>
						+<span id="esal1" class="esal2">2000</span>
						+<span id="esal1" class="esal3">4000</span>
						+<span id="esal1" class="esal4">8000</span>
					</td>
				</tr>
				<tr>
					<td>״̬</td>
					<td>Ա��
						<select name="estate">
							<option >��ѵ</option>
							<option >ʵϰ</option>
							<option >��ʽ</option>
							<option >����</option>
						</select>
					</td>
					
				</tr>
				<tr>
					<td>��ע</td>
					<td>
						<textarea name="enote" id="ztcss" class="beizhu" style="height:120px; width:300px; font-size:18px; font-family:'����_GB2312';"></textarea>
					</td>
					<td><input type="submit" class="sub" value="" onclick="return pdsub()"/></td>
				</tr>
				
			</table>
			</form>	
		</div>	
	</div>
</body>
</html>
