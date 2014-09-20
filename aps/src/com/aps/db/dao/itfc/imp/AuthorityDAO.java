package com.aps.db.dao.itfc.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aps.db.dao.itfc.Authority;
import com.aps.db.model.FenPage;
import com.aps.db.model.V_EmpDetail;
import com.aps.db.model.V_PdLogin;
import com.aps.db.model._Authority;
import com.aps.db.model._Dpoint;
import com.aps.db.model._Emp;
import com.aps.db.tem.CopyLimit;
import com.aps.db.tem.GetSelectQurey;

/**
 * Ȩ�ޱ�
 * @author Administrator
 *
 */
public class AuthorityDAO extends GetSelectQurey implements Authority{

	private PreparedStatement ps;
	private ResultSet rs;
	
	public boolean doDelete(String id) {
		return false;
	}

	/**
	 * ����Ȩ��
	 */
	@Override
	public boolean doInster(_Authority alobj) {
		boolean bool = false;
		String sql = "insert into aps_authority values(sdii.nextval,?,?)";
		try {
			ps = super.getPs(sql);
			ps.setString(1, alobj.getAuno());
			ps.setString(2, alobj.getAudesc());
			bool = ps.executeUpdate() > 0;
			super.commit();
		} catch (SQLException e) {
			super.rollback();
			e.printStackTrace();
		}
		return bool;
	}

	/**
	 * ��ѯ��ͼpdlogin������͵㡢���͵�Ա�������͵�Ȩ��
	 */
	@SuppressWarnings("static-access")
	public ArrayList<V_PdLogin> doSelect(FenPage page) {
		
		ArrayList<V_PdLogin> almodel = new ArrayList<V_PdLogin>();
		CopyLimit limit = new CopyLimit();
		boolean pdFp = false;
		try {
			rs = limit.doVLimit("pdlogin", "dpid", page.getPageNow(), CopyLimit.pageSize);
			while(rs.next()){
				V_PdLogin model = new V_PdLogin();
				model.setDpid(rs.getString("DPID"));
				model.setDpname(rs.getString("DPNAME"));
				model.setEid(rs.getString("EID"));
				model.setEname(rs.getString("ENAME"));
				model.setAuno(rs.getString("AUNO"));
				model.setAudesc(rs.getString("AUDESC"));

				if(!pdFp){
					limit.doCount();
					model.setPageCount(limit.doCount());	//��ʾһ���ж���������
					model.setPageNow(String.valueOf(Integer.valueOf(page.getPageNow()) + 1));				//��ǰҳΪ��0ҳ
					model.setPageNum(limit.pageNum);		//ÿҳ��ʾ�� ����� ��������1 2 3 4 5
					model.setPageSize(limit.pageSize);	//ÿҳ��С��������ʾ����������
					model.setPageS(limit.doPageS());		//��ʾһ���ֳܷ�������ҳ
					pdFp = true;
				}
				
				almodel.add(model);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return almodel;
	}

	@Override
	public ArrayList<_Authority> doSelect(_Authority alobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doUpdate(_Authority obj) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * ��ѯ����Ȩ�ޡ�����Ա�����������͵�
	 * @return
	 */
	public ArrayList<V_EmpDetail> doSelectGrant(){
		
		ArrayList<V_EmpDetail> almodel = new ArrayList<V_EmpDetail>();

		try {
			ps = super.getPs("select dpid,dppro from aps_dpoint");
			rs = ps.executeQuery();
			while(rs.next()){
				
				_Dpoint dpoint = new _Dpoint();
				V_EmpDetail empDetail = new V_EmpDetail();
				
				dpoint.setDpid(rs.getString("dpid"));
				dpoint.setDppro(rs.getString("dppro"));
				
				empDetail.setDpoint(dpoint);
				
				almodel.add(empDetail);
				
			}
			ps = super.getPs("select eid,ename from aps_emp where ename not in(select ename from pdlogin)");
			rs = ps.executeQuery();
			while(rs.next()){
				_Emp emp = new _Emp();
				V_EmpDetail empDetail = new V_EmpDetail();
				emp.setEid(rs.getString("eid"));
				emp.setEname(rs.getString("ename"));
				empDetail.setEmp(emp);
				almodel.add(empDetail);
			}
			
			ps = super.getPs("select auno,audesc from aps_authority");
			rs = ps.executeQuery();
			while(rs.next()){
				_Authority authority = new _Authority();
				V_EmpDetail empDetail = new V_EmpDetail();
				authority.setAuno(rs.getString("auno"));
				authority.setAudesc(rs.getString("audesc"));
				empDetail.setAuthority(authority);
				almodel.add(empDetail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return almodel;
	}
	
	

}
