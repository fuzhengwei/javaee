<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="com.aps.db.model._Route" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>·�߲�ѯ</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/route/css/list.css" />
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/route/js/jquery-1.4.2.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/route/js/list.js"></script>
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
	<div class="bodyDiv">
		<table border="1">
			<tr align="center">
				<td>ѡȡ����</td>
				<td>���</td>
				<td>·������</td>
				<td>·�����</td>
				<td>·��;����</td>
				<td>�׹���۸�</td>
				<td id="dne" class="dn">�ι���۸�</td>
				<td>�׹������</td>
				<td id="dne" class="dn">�ι������</td>
				<td>����</td>
			</tr>
			
				<%
					ArrayList<_Route> alcar = (ArrayList<_Route>)request.getAttribute("alroute");
					_Route cpage = alcar.get(0);
					int i = 1;
					if(!"1".equals(cpage.getPageNow())){
						i += ((Integer.valueOf(cpage.getPageNow()) - 2) * Integer.valueOf(cpage.getPageSize()));
					}
					for(_Route c:alcar){
				%>		
					<tr>
					<td><input type="checkbox" /></td>
					<td><%=i++%></td>
					<td><%=c.getRtname() %></td>
					<td><%=c.getRtspoint() %></td>
					<td><%=c.getRtEnd() %></td>
					<td><%=c.getRtpefpkg() %></td>
					<td id="dne" class="dn"><%=c.getRtpeopkg() %></td>
					<td><%=c.getRtpefpvo() %></td>
					<td id="dne" class="dn"><%=c.getRtpeopvo() %></td>
					<td>ɾ��|�޸�|<span class="detail">����</span></td>
					</tr>
				<%		
					}
				%>
			<tr>
				<td colspan="11" align="center">
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
					<a href="<%=basePath%>Corporation?type=2&key=5&pageNow=1">��ҳ</a>
					
					<%
						String urlUp = "#",urlDown = "#";
						int pageUp = 0;
						if((pageUp = Integer.valueOf(cpage.getPageNow())-2) > 0){
							urlUp = basePath + "Corporation?type=2&key=5&pageNow="+pageUp;
						}
						
						int pageDown = 0;
						if((pageUp = Integer.valueOf(cpage.getPageNow())) < Integer.valueOf(cpage.getPageS())){
							urlDown = basePath + "Corporation?type=2&key=5&pageNow="+pageUp;
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
							<a href="<%=basePath%>Corporation?type=2&key=5&pageNow=<%=g %>"><font id="cco" color="<%=fcolor%>"><%=g %></font></a>
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
							<a href="<%=basePath%>Corporation?type=2&key=5&pageNow=<%=p %>"><font id="cco" color="<%=fcolor%>"><%=p %></font></a>
					<%			
							}
						}
					%>
					
					<a href="<%=urlDown %>">��һҳ</a>
					<a href="<%=basePath%>Corporation?type=2&key=5&pageNow=<%=cpage.getPageS() %>">ĩҳ</a>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>
