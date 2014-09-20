package com.aps.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aps.db.conn.OracleConn;
import com.aps.db.model.Counts;

public class asynchronous extends HttpServlet {
	
	private Connection conn;		//
	private PreparedStatement ps;	//
	private ResultSet rs;			//
	private Counts counts;			//���и���������
	private StringBuffer sb;
	private int num;
	private int nu;	

	public void init() throws ServletException {
		num= 152;nu=89;
		conn = OracleConn.getConn();
		String sql = 	"select a.*,b.*,c.*,d.*,e.*,f.*,g.*,h.*,i.*,j.*,k.*,l.*,m.* from" +
						"(select count(auid) from APS_AUTHORITY) a,"+
						"(select count(capid) from APS_CAPACITY) b,"+
						"(select count(cid) from APS_CAR) c,"+
						"(select count(ctid) from APS_CUSTOMER) d,"+
						"(select count(deaid) from APS_DEA) e,"+
						"(select count(dpid) from APS_DPOINT) f,"+
						"(select count(drid) from APS_DRANGE) g,"+
						"(select count(eirid) from APS_EIR) h,"+
						"(select count(eid) from APS_EMP) i,"+
						"(select count(olid) from APS_OLIST) j,"+
						"(select count(rtid) from APS_ROUTE) k,"+
						"(select count(rwid) from APS_RW) l,"+
						"(select count(spid) from APS_SPARAMETER) m";
		try {
			sb = new StringBuffer();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				sb.append("<tr><td>Ȩ�ޱ���������</td><td align='center'>"+rs.getString(1)+"</td></tr>");
				sb.append("<tr><td>��������������</td><td align='center'>"+rs.getString(2)+"</td><br/>");
				sb.append("<tr><td>���������������</td><td align='center' align='center'>"+rs.getString(3)+"</td><br/>");
				sb.append("<tr><td>�ͻ������������</td><td align='center'>"+rs.getString(4)+"</td><br/>");
				sb.append("<tr><td>ָ��Ȩ�������͵��Ա����</td><td align='center'>"+rs.getString(5)+"</td><br/>");
				sb.append("<tr><td>���͵�����������</td><td align='center'>"+rs.getString(6)+"</td><br/>");
				sb.append("<tr><td>���ͷ�Χ����������</td><td align='center'>"+rs.getString(7)+"</td><br/>");
				sb.append("<tr><td>���ӵ�����������</td><td align='center'>"+rs.getString(8)+"</td><br/>");
				sb.append("<tr><td>Ա�������������</td><td align='center'>"+rs.getString(9)+"</td><br/>");
				sb.append("<tr><td>��������������</td><td align='center'>"+rs.getString(10)+"</td><br/>");
				sb.append("<tr><td>·�߱���������</td><td align='center'>"+rs.getString(11)+"</td><br/>");
				sb.append("<tr><td>·��;�������������</td><td align='center'>"+rs.getString(12)+"</td><br/>");
				sb.append("<tr><td>������������������</td><td align='center'>"+rs.getString(13)+"</td><br/>");
				sb.trimToSize();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void destroy() {
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		int rom = (int)(Math.random()*11),ro=rom;
		
		num += rom;
		
		if(rom%2==0){
			rom += 1;
		}else{
			rom += 2;
		}
		nu += rom;
		out.print("<table border=1 style='margin-top: -220px;width: 100%;'>" +
		
				  "<tr><td align='center' colspan=2 style='font-size: 60px;color:silver;margin-top: 10px;'>ajax�첽����ͳ��" +
				  "<div style='background-color: green;float: left;width: 150px;height: 70px;' id='always'>" +
				  "		<table style='font-size: 12px;color:yellow;'>" +
				  "			<tr align='right'><td>�����Ӷ�������</td><td style='color:white;background-color:black;'>" +
				  ro);
		out.print("��<td></tr>" +
				  "			<tr align='right'><td>�³ɽ��ӵ�����</td><td style='color:white;background-color:black;'>"+	
				  rom);
		out.print("��<td></tr>" +
				  "			<tr align='right'><td>��ʷ�ж�������</td><td style='color:white;background-color:black;'>" +
				  num);
		out.print("��<td></tr>" +
				  "			<tr align='right'><td>��ʷ���ӵ�����</td><td style='color:white;background-color:black;'>" +
				  nu);
		out.print("��<td></tr>" +
				  "		</table>" +
				  "</div>"+
				  "</td>" +
				  "</tr>" +
				  "<tr align='center'><td>����</td><td>������</td></tr>"+sb.toString());
		out.print("</table>");
		
		out.flush();
		out.close();
				 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}


	
}
