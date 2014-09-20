package com.aps.db.tem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aps.db.conn.OracleConn;

public class CopyLimit {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String table;
	
	
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	
	/**
	 * �����ҳ��Ϣ
	 * pageSize ÿҳ5����¼
	 * pageNum ÿҳ5��С��ҳ��
	 * */
	public final static String pageSize = "5";
	public final static String pageNum = "5";
	
	/********************************
	 * ģ��limit
	 * @param table ����
	 * @param odby  ��˭���򡢽���id
	 * @param start �����ּ���ʼ 1�����һ������
	 * @param sum   ȡ����������
	 * @throws SQLException 
	 ********************************/
	public ResultSet doLimit(String table,String odby,String start,String sum) throws SQLException{
		/*������֤table�ܱ�������*/
		this.table = table;
		setTable(table);
		String sql = 	"select a.* from "+table+" a where rowid in (" +
						"select rd from (" +
						"select rownum rm,rd from (" +
						"select rowid rd from "+table+" order by "+odby+") where rownum <= ?+?) where rm > ?)";
		/*�������*/
		conn = OracleConn.getConn();
		ps = conn.prepareStatement(sql);
		
		//��ʼλ��
		start = String.valueOf((Integer.parseInt(start) - 1) * Integer.valueOf(pageSize));
		//��ֵ
		ps.setString(1, start);
		ps.setString(2, sum);
		ps.setString(3, start);
		return ps.executeQuery();
	}
	/**
	 * ��ͼ���治����rowid���Ե�д����һ��rownum��ҳ
	 * @param table
	 * @param start
	 * @param sum
	 * @return
	 * @throws SQLException
	 */
	public ResultSet doVLimit(String table,String odby,String start,String sum) throws SQLException{
		/*������֤table�ܱ�������*/
		this.table = table;
		setTable(table);
		String sql = 	"select v.* from (" +
						"select rownum rm,v.* from "+table+" v " +
						"where rownum <= ?+? order by "+odby+") v where rm > ?";
		/*�������*/
		conn = OracleConn.getConn();
		ps = conn.prepareStatement(sql);
		
		//��ʼλ��
		start = String.valueOf((Integer.parseInt(start) - 1) * Integer.valueOf(pageSize));
		//��ֵ
		ps.setString(1, start);
		ps.setString(2, sum);
		ps.setString(3, start);
		return ps.executeQuery();
	}
	/**
	 * �������������
	 * @return
	 * @throws SQLException
	 */
	public String doCount() throws SQLException{
		String count = "";
		conn = OracleConn.getConn();
		ps = conn.prepareStatement("select count(*) from "+getTable());
		rs = ps.executeQuery();
		if(rs.next()){
			count = rs.getString(1);
		}
		
		return count;
	}
	/**********************
	 * ��ȡ���ֳܷ�������ҳ
	 * @throws SQLException 
	 **********************
	 */
	public String doPageS() throws SQLException{
		String pages = doCount();
		double pc = Double.parseDouble(pages)/5.0;
		if(pc*10%10 > 0){
			pc = (int)pc+1;
		}
		pages = String.valueOf((int)pc);
		return pages;
	}
}
