package com.aps.db.dao.itfc.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aps.db.conn.OracleConn;
import com.aps.db.model.V_PdLogin;
import com.aps.db.tem.GetSelectQurey;

/*ǰ���v�ı�ʾ�� ���ݿ��������ͼ*/
public class V_PdLoginDAO extends GetSelectQurey{
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	/**
	 * ���ݴ�����֤��¼
	 * @throws SQLException 
	 * */
	public V_PdLogin doLogin(V_PdLogin vl) throws SQLException{
		
		V_PdLogin vlx = new V_PdLogin();
		/*��ʼ��һ��ֵ*/
		vlx.setDpid("0");
		
		/*Ҫִ�е�sql���*/
		String sql = "select DPID,DPNAME,EID,ENAME,AUNO,AUDESC from pdlogin where ename = ? and eid = ?";
		
		/*���ø���ģ��*/
		ps = super.getPs(sql);
		/*���ø���ֵ*/
		ps.setString(1, vl.getEname());
		ps.setString(2, vl.getEid());
		/*ִ��*/
		rs = ps.executeQuery();
		
		while(rs.next()){
			vlx.setDpid(rs.getString("dpid"));			//���͵�id
			vlx.setDpname(rs.getString("dpname"));		//���͵�����
			vlx.setEid(rs.getString("eid"));			//Ա����� 
			vlx.setEname(rs.getString("ename"));		//Ա������
			vlx.setAuno(rs.getString("auno"));			//Ȩ�ޱ��
			vlx.setAudesc(rs.getString("audesc"));		//Ȩ������
		}
		
		return vlx;
	}
	
}
