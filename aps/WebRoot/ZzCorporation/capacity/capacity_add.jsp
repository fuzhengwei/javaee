<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="com.aps.db.model.CapacityS"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
<title>��������</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/capacity/css/capacity_add.css" />
</head>

<body>
	<%
		ArrayList<CapacityS> almodel = (ArrayList<CapacityS>)request.getAttribute("almodel");
	%>

	<form action="<%=basePath %>Corporation?type=4&key=1&pageNow=1" method="post">
	<table border="1" class="mainDiv" align="center">
		<tr>
			<td width="75px;">ѡ���͵�</td>
			<td width="375px;">
				<select name="fk_dpid">
					<%
						for(CapacityS model:almodel){
							if(null != model.getDpoint()){
					%>
							<option value="<%=model.getDpoint().getDpid() %>"><%="���͵�����"+model.getDpoint().getDpname()+" ��ַ��"+model.getDpoint().getDpaddress()+" ��Χ��"+model.getDrange().getDrend() %></option>	
					<%			
							}
						}
					%>
					
				</select>
			</td>
			<td style="border:0px; text-align:center">��</td>
		</tr>
		<tr>
			<td>ѡ��·��</td>
			<td>
				<select name="fk_rtid">
					<%
						for(CapacityS model:almodel){
							if(null != model.getRoute() && null != model.getRw()){
					%>
								<option value="<%=model.getRoute().getRtid() %>"><%="·������"+model.getRoute().getRtname()+";���㣺"+model.getRw().getRwroutend() %></option>
					<%			
							}
						}
					%>
				</select>
			</td>
			<td style="border:0px; text-align:center">��</td>
		</tr>
		<tr>
			<td>ѡ����</td>
			<td>
				<select name="fk_cid">
					<%
						for(CapacityS model:almodel){
							if(null != model.getCar()){
					%>
							<option value="<%=model.getCar().getCid() %>"><%="���ƣ�"+model.getCar().getCbrand()+"�ͺţ�"+model.getCar().getCmodel() %></option>	
					<%			
							}
						}
					%>
				</select>
			</td>
			<td style="border:0px; text-align:center">��</td>
		</tr>
		<tr>
			<td>ѡ��˾��</td>
			<td>
				<select name="fk_eid">
					<%
						for(CapacityS model:almodel){
							if(null != model.getEmpDetail()){
					%>
								<option value="<%=model.getEmpDetail().getEmp().getEid() %>"><%="Ա����"+model.getEmpDetail().getEmp().getEname()+"�绰��"+model.getEmpDetail().getEmp().getEphone()+"���͵㣺"+model.getEmpDetail().getDpoint().getDpname() %></option>
					<%			
							}
						}
					%>
				</select>
			</td>
			<td style="border:0px; text-align:center">��</td>
		</tr>
		<tr>
			<td>ѡ��״̬</td>
			<td>
				<select name="capstate">
					<option value="����">����</option>
					<option value="æµ">æµ</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="3"  style="border:0px;">
				<input type="submit" value="" id="sub" />
			</td>
		</tr>
		
	</table>
	</form>
</body>
</html>
