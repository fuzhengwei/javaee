<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="com.aps.db.model._Emp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  <title>Ա���б�</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>ZzCorporation/emp/css/list.css" />
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/emp/js/jquery-1.4.2.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/emp/js/list.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>ZzCorporation/emp/js/pageGunZhou.js"></script>
</head>

<body>
<div class="mainDiv">
	<div class="topDiv">
		<div class="soso">
			<form action="<%=basePath %>ZzCorporation/emp/Corporation?type=6&key=6" method="post">
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
				<td>����</td>
				<td>�Ա�</td>
				<td id="dne" class="dn">����</td>
				<td id="dne" class="dn">����</td>
				<td id="dne" class="dn">������ò</td>
				<td>��ַ</td>
				<td>�ֻ�</td>
				<td>email</td>
				<td>ְλ</td>
				<td>����</td>
				<td id="dne" class="dn">��ְʱ��</td>
				<td id="dne" class="dn">нˮ</td>
				<td id="dne" class="dn">״̬</td>
				<td id="dne" class="dn">��ע</td>
				<td>����</td>
			</tr>
				<%
					ArrayList<_Emp> almodel = (ArrayList<_Emp>)request.getAttribute("almodel");
					_Emp cpage = almodel.get(0);
					int i = 1;
					if(!"1".equals(cpage.getPageNow())){
						i += ((Integer.valueOf(cpage.getPageNow()) - 2) * Integer.valueOf(cpage.getPageSize()));
					}
					
					for(_Emp c:almodel){
				%>		
					<tr>
					<td><input type="checkbox" /></td>
					<td><%=i++%></td>
					<td><%=c.getEname() %></td>
					<td><%=c.getEsex() %></td>
					<td id="dne" class="dn"><%=c.getEage() %></td>
					<td id="dne" class="dn"><%=c.getEbirthday() %></td>
					<td id="dne" class="dn"><%=c.getEpa() %></td>
					<td><%=c.getEaddress() %></td>
					<td><%=c.getEphone() %></td>
					<td><%=c.getEemail() %></td>
					<td><%=c.getEpost() %></td>
					<td><%=c.getEdept() %></td>
					<td id="dne" class="dn"><%=c.getEindate() %></td>
					<td id="dne" class="dn"><%=c.getEsal() %></td>
					<td id="dne" class="dn"><%=c.getEstate() %></td>
					<td id="dne" class="dn"><%=c.getEnote() %></td>
					<td>ɾ��|�޸�|<span class="detail">����</span></td>
					</tr>
				<%		
					}
				%>
			
			<tr>
				<td colspan="17" align="center">
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
					<a href="<%=basePath%>Corporation?type=6&key=5&pageNow=1">��ҳ</a>
					
					<%
						String urlUp = "#",urlDown = "#";
						int pageUp = 0;
						if((pageUp = Integer.valueOf(cpage.getPageNow())-2) > 0){
							urlUp = basePath + "Corporation?type=6&key=5&pageNow="+pageUp;
						}
						
						int pageDown = 0;
						if((pageUp = Integer.valueOf(cpage.getPageNow())) < Integer.valueOf(cpage.getPageS())){
							urlDown = basePath + "Corporation?type=6&key=5&pageNow="+pageUp;
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
							<a href="<%=basePath%>Corporation?type=6&key=5&pageNow=<%=g %>"><font id="cco" color="<%=fcolor%>"><%=g %></font></a>
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
							<a href="<%=basePath%>Corporation?type=6&key=5&pageNow=<%=p %>"><font id="cco" color="<%=fcolor%>"><%=p %></font></a>
					<%			
							}
						}
					%>
					
					<a href="<%=urlDown %>">��һҳ</a>
					<a href="<%=basePath%>Corporation?type=6&key=5&pageNow=<%=cpage.getPageS() %>">ĩҳ</a>
					
					<input type="text" onfocus="ufocus(this)" onblur="ublur()" style="background:transparent;width:30px;color:#00FF00;" id="gzz" readonly="true"/>
					<a href="#" onclick="sumSub()" id="agzz" style="border: 1px green solid;color: maroon">��ת</a>
				</td>
			</tr>
			
		</table>
	</div>
</div>
</body>
</html>
