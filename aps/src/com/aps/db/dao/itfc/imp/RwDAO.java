package com.aps.db.dao.itfc.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aps.db.dao.itfc.Rw;
import com.aps.db.model.FenPage;
import com.aps.db.model._Route;
import com.aps.db.model._Rw;
import com.aps.db.tem.GetSelectQurey;

/**
 * ·��;���� �����
 * @author Administrator
 *
 */
public class RwDAO extends GetSelectQurey implements Rw{

	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public boolean doDelete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * ����·��;����
	 */
	public boolean doInster(_Rw alobj) {
		boolean bool = false;
		try {
			ps = super.getPs("insert into aps_rw values(sdii.nextval,?,?)");
			ps.setString(1, alobj.getFk_rtid());
			ps.setString(2, alobj.getRwroutend());
			bool = ps.executeUpdate() > 0;
			super.commit();
		} catch (SQLException e) {
			super.rollback();
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public ArrayList<_Rw> doSelect(FenPage page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<_Rw> doSelect(_Rw alobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doUpdate(_Rw obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 2012��9��9�� 10:02:22
	 * ��ѯ��·����㣬������·��;����ҳ��ʹ��
	 * @return almodel
	 */
	public ArrayList<_Route> doSelectPointToRw() {
		
		ArrayList<_Route> almodel = new ArrayList<_Route>();
		try {
			ps = super.getPs("select RTID,RTNAME,RTSPOINT from aps_route");
			rs = ps.executeQuery();
			while(rs.next()){
				_Route model = new _Route();
				model.setRtid(rs.getString("RTID"));
				model.setRtname(rs.getString("RTNAME"));
				model.setRtspoint(rs.getString("RTSPOINT"));
				almodel.add(model);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return almodel;
	}

}
