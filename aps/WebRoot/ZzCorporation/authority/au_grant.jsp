<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="com.aps.db.model.V_EmpDetail"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>��Ȩ��</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/authority/css/au_grant.css" />
</head>

<body>
	
	<div class="mainDiv">
		<div class="topDiv">
			<div class="grantDiv">����Ȩ��</div>
		</div>
		
		<%
			ArrayList<V_EmpDetail> almodel = (ArrayList<V_EmpDetail>)request.getAttribute("almodel"); 
		%>
		
		<form action="<%=basePath %>Corporation?type=13&key=5" method="post">
		<table border="1">
			<tr>
				<td>���͵�</td>
				<td>
					<select name="fk_dpid">
						<%
							for(V_EmpDetail c:almodel){
								
								if(c.getDpoint()!=null){
						%>
							<option value="<%=c.getDpoint().getDpid() %>"><%=c.getDpoint().getDppro() %></option>
						<%
								}
							}
						%>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>Ա��</td>
				<td>
					<select name="fk_eid">
						<%
							for(V_EmpDetail c:almodel){
								if(c.getEmp()!=null){
						%>
							<option value="<%=c.getEmp().getEid() %>"><%=c.getEmp().getEname() %></option>
						<%
								}
							}
						%>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>Ȩ��</td>
				<td>
					<select name="fk_auid">
						<%
							for(V_EmpDetail c:almodel){
								if(c.getAuthority()!=null){
						%>
							<option value="<%=c.getAuthority().getAuno() %>"><%=c.getAuthority().getAudesc() %></option>
						<%
								}
							}
						%>
					</select>
				</td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="" id="subgrant"/></td>
			</tr>
			
		</table>
		</form>
	</div>

</body>
</html>
