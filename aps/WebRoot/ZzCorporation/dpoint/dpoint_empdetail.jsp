<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="com.aps.db.model._Dpoint" %>
<%@page import="com.aps.db.model.V_EmpDetail"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/dpoint/css/dpoint_list.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/dpoint/css/list.css" />
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/dpoint/js/jquery-1.4.2.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/dpoint/js/list.js"></script>

<title>�鿴���͵�</title>
</head>

<body>
<div class="mainDiv">
	<div class="topDiv">
		<div class="soso">
			<form action="#" method="post">
				<input type="text" class="sosotext"/>
				<input type="submit" value="" id="subsoso"/>
			</form>
		</div>
	</div>
	<div class="bodyDiv" style="width:2000px;height: 600px;">
		<table border="1">
			<tr align="center">
				<td>ѡȡ����</td>
				<td>���</td>
				<td>����</td>
				<td id="dne" class="dn">�Ա�</td>
				<td id="dne" class="dn">����</td>
				<td id="dne" class="dn">����</td>
				<td id="dne" class="dn">������ò</td>
				<td id="dne" class="dn">��ַ</td>
				<td>�ֻ���</td>
				<td id="dne" class="dn">email</td>
				<td id="dne" class="dn">ְλ</td>
				<td id="dne" class="dn">����</td>
				<td id="dne" class="dn">��ְʱ��</td>
				<td>нˮ</td>
				<td id="dne" class="dn">��ע</td>
				<td id="dne" class="dn">״̬</td>
				
				<td>Ȩ������</td>
				
				<td>���͵�����</td>
				<td id="dne" class="dn">���͵�ʡ��</td>
				<td>���͵��ַ</td>
				<td>���͵�绰</td>
				<td id="dne" class="dn">���͵�����</td>
				<td id="dne" class="dn">���͵㱸ע</td>
				
				<td>���͵�;����</td>
				<td>�׹���۸�</td>
				<td>�ι���۸�</td>
				<td>����</td>
			</tr>
			<%
					ArrayList<V_EmpDetail> almodel = (ArrayList<V_EmpDetail>)request.getAttribute("almodel");
					V_EmpDetail cpage = almodel.get(0);
					int i = 1;
					if(!"1".equals(cpage.getPageNow())){
						i += ((Integer.valueOf(cpage.getPageNow()) - 2) * Integer.valueOf(cpage.getPageSize()));
					}
					
					for(V_EmpDetail c:almodel){
				%>		
					<tr>
					<td><input type="checkbox" /></td>
					<td><%=i++%></td>
					<td><%=c.getEmp().getEname() %></td>
					<td id="dne" class="dn"><%=c.getEmp().getEsex() %></td>
					<td id="dne" class="dn"><%=c.getEmp().getEage() %></td>
					<td id="dne" class="dn"><%=c.getEmp().getEbirthday() %></td>
					<td id="dne" class="dn"><%=c.getEmp().getEpa() %></td>
					<td id="dne" class="dn"><%=c.getEmp().getEaddress() %></td>
					<td><%=c.getEmp().getEphone() %></td>
					<td id="dne" class="dn"><%=c.getEmp().getEemail() %></td>
					<td id="dne" class="dn"><%=c.getEmp().getEpost() %></td>
					<td id="dne" class="dn"><%=c.getEmp().getEdept() %></td>
					<td id="dne" class="dn"><%=c.getEmp().getEindate() %></td>
					<td><%=c.getEmp().getEsal() %></td>
					<td id="dne" class="dn"><%=c.getEmp().getEstate() %></td>
					<td id="dne" class="dn"><%=c.getEmp().getEnote() %></td>

					<td><%=c.getAuthority().getAudesc() %></td>
					
					<td><%=c.getDpoint().getDpname() %></td>
					<td id="dne" class="dn"><%=c.getDpoint().getDppro() %></td>
					<td><%=c.getDpoint().getDpaddress() %></td>
					<td><%=c.getDpoint().getDptel() %></td>
					<td id="dne" class="dn"><%=c.getDpoint().getDpemail() %></td>
					<td id="dne" class="dn"><%=c.getDpoint().getDpnote() %></td>
					
					<td><%=c.getDrange().getDrend() %></td>
					<td><%=c.getDrange().getDrfkg() %></td>
					<td><%=c.getDrange().getDrokg() %></td>
					
					<td>ɾ��|�޸�|<span class="detail">����</span></td>
					</tr>
				<%		
					}
				%>
				<tr>
				<td colspan="27" align="left">
					<span>
						<%=cpage.getPageCount() %>����¼
					</span>
					<span>
						��<%=cpage.getPageS() %>ҳ
					</span>
					<span id="dqpage">
						<%
							int pageDq = 1;
							if(!"1".equals(cpage.getPageNow())){
								pageDq = (Integer.valueOf(cpage.getPageNow())-1); 
							}
						%>
						��ǰ��<%=pageDq %>ҳ
					
					</span>
					<a href="<%=basePath%>Corporation?type=3&key=7&pageNow=1">��ҳ</a>
					
					<%
						String urlUp = "#",urlDown = "#";
						int pageUp = 0;
						if((pageUp = Integer.valueOf(cpage.getPageNow())-2) > 0){
							urlUp = basePath + "Corporation?type=3&key=7&pageNow="+pageUp;
						}
						
						int pageDown = 0;
						if((pageUp = Integer.valueOf(cpage.getPageNow())) < Integer.valueOf(cpage.getPageS())){
							urlDown = basePath + "Corporation?type=3&key=7&pageNow="+pageUp;
						}
					%>
					
					<a href="<%=urlUp %>">��һҳ</a>
					
					<%
						int pageNow = Integer.valueOf(cpage.getPageNow());
						String fcolor = "red";
						if(pageNow - 3 > 0){
							//													ÿҳ�����������
							for(int p = 1,g = pageNow-3,z = Integer.valueOf(cpage.getPageNum()); p <= z && g <= Integer.valueOf(cpage.getPageS()); p++,g++){
								if(g == pageDq){
									fcolor = "yellow";
								}else{
									fcolor = "red";
								}
					%>
							<a href="<%=basePath%>Corporation?type=3&key=7&pageNow=<%=g %>"><font id="cco" color="<%=fcolor%>"><%=g %></font></a>
					<%			
							}
						}else{
							for(int p = 1,z = Integer.valueOf(cpage.getPageNum()); p <= z && p <= Integer.valueOf(cpage.getPageS()); p++){
								if(p == pageDq){
									fcolor = "yellow";
								}else{
									fcolor = "red";
								}
					%>
							<a href="<%=basePath%>Corporation?type=3&key=7&pageNow=<%=p %>"><font id="cco" color="<%=fcolor%>"><%=p %></font></a>
					<%			
							}
						}
					%>
					
					<a href="<%=urlDown %>">��һҳ</a>
					<a href="<%=basePath%>Corporation?type=3&key=7&pageNow=<%=cpage.getPageS() %>">ĩҳ</a>
				</td>
			</tr>
				
			
		</table>
	</div>
</div>
</body>
</html>