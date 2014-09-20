package com.aps.db.tem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aps.db.conn.OracleConn;

public class GetSelectQurey {
	
	private Connection conn;
	
	/**
	 * ����preparedstatement ps
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public PreparedStatement getPs(String sql) throws SQLException{
		conn = OracleConn.getConn();
		return conn.prepareStatement(sql);
	}
	/**
	 * �ύ
	 */
	public void commit(){
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	/**
	 * �ع�
	 */
	public void rollback(){
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
