<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="com.aps.db.model.V_PdLogin"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  <title>�鿴Ȩ��</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/authority/css/au_list.css" />
<link rel="stylesheet" href="<%=basePath %>ZzCorporation/authority/css/list.css" type="text/css"></link>

<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/authority/js/jquery-1.4.2.js"></script>

</head>

<body>

	<div class="mainDiv">
		<div class="topDiv">
		<form action="<%=basePath %>Corporation?type=13&key=4&pageNow=1" method="post">
			<input type="text" id="dea" name="dea"/>
			<input type="submit" value="" id="deasub"/>
		</form>
		</div>
		<div class="bodyDiv" style="width: 500px;">
			<table border="1" style="width: 500px;">
				<tr align="center">
					<td>���</td>
					<td>���͵�</td>
					<td>Ա��</td>
					<td>Ȩ��</td>
					<td>����</td>
				</tr>
				
				<%
					ArrayList<V_PdLogin> almodel = (ArrayList<V_PdLogin>)request.getAttribute("almodel");
					V_PdLogin cpage = almodel.get(0);
					int i = 1;
					if(!"1".equals(cpage.getPageNow())){
						i += ((Integer.valueOf(cpage.getPageNow()) - 2) * Integer.valueOf(cpage.getPageSize()));
					}
					
					for(V_PdLogin c:almodel){
				%>		
					<tr>
					<td><%=i++%></td>
					<td><%=c.getDpname() %></td>
					<td><%=c.getEname() %></td>
					<td><%=c.getAudesc() %></td>
					<td>ɾ��|�޸�</td>
					</tr>
				<%		
					}
				%>
				<tr style="border: 0px;">
				<td colspan="4" align="left" style="border: 0px;">
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
						
					
					</span>
					<a href="<%=basePath%>Corporation?type=13&key=4&pageNow=1">��ҳ</a>
					
					<%
						String urlUp = "#",urlDown = "#";
						int pageUp = 0;
						if((pageUp = Integer.valueOf(cpage.getPageNow())-2) > 0){
							urlUp = basePath + "Corporation?type=13&key=4&pageNow="+pageUp;
						}
						
						int pageDown = 0;
						if((pageUp = Integer.valueOf(cpage.getPageNow())) < Integer.valueOf(cpage.getPageS())){
							urlDown = basePath + "Corporation?type=13&key=4&pageNow="+pageUp;
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
							<a href="<%=basePath%>Corporation?type=13&key=4&pageNow=<%=g %>"><font id="cco" color="<%=fcolor%>"><%=g %></font></a>
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
							<a href="<%=basePath%>Corporation?type=13&key=4&pageNow=<%=p %>"><font id="cco" color="<%=fcolor%>"><%=p %></font></a>
					<%			
							}
						}
					%>
					
					<a href="<%=urlDown %>">��һҳ</a>
					<a href="<%=basePath%>Corporation?type=13&key=4&pageNow=<%=cpage.getPageS() %>">ĩҳ</a>
				</td>
			</tr>
			</table>
		</div>
	</div>

</body>
</html>
