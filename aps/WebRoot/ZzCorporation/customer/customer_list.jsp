<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="com.aps.db.model._Customer"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
   <title>�鿴�ͻ�</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/customer/css/list.css" />
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/customer/js/jquery-1.4.2.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/customer/js/list.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/customer/js/jqajax.js" charset="gbk"></script>
<style type="text/css">
a:link {
		color:#FF0000;
		text-decoration: none;
	}
	a:visited {
		text-decoration: none;
		color: #FF0000;
	}
	a:hover {
		text-decoration: none;
		color: #FF0000;
	}
	a:active {
		text-decoration: none;
		color: #FF0000;
	}
	
	a{
		width:55px;
		height:25px;
		border:1px #FF0000 solid;
		background-color:#000000;
	}
</style>
</head>

<body>
<div class="mainDiv">
	<div class="topDiv">
		<div class="soso">
			<form action="<%=basePath %>Corporation?type=14&key=4&pageNow=1" method="post">
				<input type="text" class="sosotext"/>
				<input type="submit" value="" id="subsoso"/>
			</form>
		</div>
	</div>
	<div class="bodyDiv">
		<table border="1" id="editTable">
			<tr align="center">
				<td>
					<span id="isSelectAll">ȫ��ѡȡ</span><br />
					<span id="isDeleteChecked">ȷ��ɾ��</span>
				</td>
				<td>���</td>
				<td>�ǳ�</td>
				<td>����</td>
				<td>�Ա�</td>
				<td id="dne" class="dn">�绰</td>
				<td id="dne" class="dn">����</td>
				<td id="dne" class="dn">����</td>
				<td>��ַ</td>
				<td>����</td>
			</tr>
			   <%
					ArrayList<_Customer> almodel = (ArrayList<_Customer>)request.getAttribute("almodel");
					_Customer cpage = almodel.get(0);
					int i = 1;
					if(!"1".equals(cpage.getPageNow())){
						i += ((Integer.valueOf(cpage.getPageNow()) - 2) * Integer.valueOf(cpage.getPageSize()));
					}
					
					for(_Customer c:almodel){
				%>		
					<tr>
					<td align="center"><input type="checkbox" value="<%=c.getCtid() %>"/></td>
					<td><%=i++%></td>
					<td><%=c.getCnickname() %></td>
					<td><%=c.getCname() %></td>
					<td><%=c.getCsex() %></td>
					<td id="dne" class="dn"><%=c.getCtel() %></td>
					<td id="dne" class="dn"><%=c.getCemail() %></td>
					<td id="dne" class="dn"><%=c.getCbirthday() %></td>
					<td><%=c.getCaddress() %></td>
					<td><span style="color:#00FFFF;cursor:pointer;" id="deleteE" class="<%=c.getCtid() %>">ɾ��</span>|
					<span style="color:#FFFF00;cursor:pointer;" id="updateE" class="<%=c.getCtid() %>">�޸�</span>|
					<span class="detail">����</span></td>
					</tr>
				<%		
					}
				%>
			<tr>
				<td colspan="10" align="center">
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
					<a href="<%=basePath%>Corporation?type=14&key=4&pageNow=1">��ҳ</a>
					
					<%
						String urlUp = "#",urlDown = "#";
						int pageUp = 0;
						if((pageUp = Integer.valueOf(cpage.getPageNow())-2) > 0){
							urlUp = basePath + "Corporation?type=14&key=4&pageNow="+pageUp;
						}
						
						int pageDown = 0;
						if((pageUp = Integer.valueOf(cpage.getPageNow())) < Integer.valueOf(cpage.getPageS())){
							urlDown = basePath + "Corporation?type=14&key=4&pageNow="+pageUp;
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
							<a href="<%=basePath%>Corporation?type=14&key=4&pageNow=<%=g %>"><font id="cco" color="<%=fcolor%>"><%=g %></font></a>
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
							<a href="<%=basePath%>Corporation?type=14&key=4&pageNow=<%=p %>"><font id="cco" color="<%=fcolor%>"><%=p %></font></a>
					<%			
							}
						}
					%>
					
					<a href="<%=urlDown %>">��һҳ</a>
					<a href="<%=basePath%>Corporation?type=14&key=4&pageNow=<%=cpage.getPageS() %>">ĩҳ</a>
				</td>
			</tr>
				
		</table>
	</div>
</div>
</body>
</html>
