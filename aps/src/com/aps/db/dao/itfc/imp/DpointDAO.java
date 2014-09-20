package com.aps.db.dao.itfc.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aps.db.dao.itfc.Dpoint;
import com.aps.db.model.FenPage;
import com.aps.db.model.V_EmpDetail;
import com.aps.db.model._Authority;
import com.aps.db.model._Car;
import com.aps.db.model._Dpoint;
import com.aps.db.model._Drange;
import com.aps.db.model._Emp;
import com.aps.db.model._Route;
import com.aps.db.tem.CopyLimit;
import com.aps.db.tem.GetSelectQurey;

/**
 * ���͵��
 * @author Administrator
 *
 */
public class DpointDAO extends GetSelectQurey implements Dpoint{

	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public boolean doDelete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * ����
	 */
	@Override
	public boolean doInster(_Dpoint alobj) {
		boolean bool = false;
		String sql = "insert into aps_dpoint values(sdii.nextval,?,?,?,?,?,?)";
		try {
			ps = super.getPs(sql);
			ps.setString(1, alobj.getDppro());
			ps.setString(2, alobj.getDpaddress());
			ps.setString(3, alobj.getDptel());
			ps.setString(4, alobj.getDpemail());
			ps.setString(5, alobj.getDpnote());
			ps.setString(6, alobj.getDpname());
			bool = ps.executeUpdate() > 0;
			super.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}
	/**
	 * ��ѯ
	 */
	@SuppressWarnings("static-access")
	@Override
	public ArrayList<_Dpoint> doSelect() {
		
		ArrayList<_Dpoint> almodel = new ArrayList<_Dpoint>();
		CopyLimit limit = new CopyLimit();
		boolean pdFp = false;
		try {
			rs = limit.doLimit("aps_dpoint", "dpid", "1", limit.pageNum);
			while(rs.next()){
				_Dpoint model = new _Dpoint();
				model.setDpid(rs.getString(1));
				model.setDppro(rs.getString(2));
				model.setDpaddress(rs.getString(3));
				model.setDptel(rs.getString(4));
				model.setDpemail(rs.getString(5));
				model.setDpnote(rs.getString(6));
				model.setDpname(rs.getString(7));
				
				if(!pdFp){
					limit.doCount();
					model.setPageCount(limit.doCount());	//��ʾһ���ж���������
					model.setPageNow("1");				//��ǰҳΪ��0ҳ
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
	public ArrayList<_Dpoint> doSelect(ArrayList<_Dpoint> alobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doUpdate(ArrayList<_Dpoint> obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * ��ҳ
	 */
	@SuppressWarnings("static-access")
	@Override
	public ArrayList<_Dpoint> doSelectPage(FenPage fpage) {
		// TODO Auto-generated method stub
		ArrayList<_Dpoint> almodel= new ArrayList<_Dpoint>();
		/*�ж����Ե�һ��ȡ���ݿ���Ϣʱ��ѷ�ҳ��Ϣ���ؽ�ȥ*/
		boolean pdFp = false;
		
		try {
			CopyLimit limit = new CopyLimit();
			rs = limit.doLimit("aps_dpoint", "dpid", fpage.getPageNow(), CopyLimit.pageSize);
			while(rs.next()){
				_Dpoint model = new _Dpoint();
				model.setDpid(rs.getString(1));
				model.setDppro(rs.getString(2));
				model.setDpaddress(rs.getString(3));
				model.setDptel(rs.getString(4));
				model.setDpemail(rs.getString(5));
				model.setDpnote(rs.getString(6));
				model.setDpname(rs.getString(7));
				
				if(!pdFp){
					limit.doCount();
					model.setPageCount(limit.doCount());	//��ʾһ���ж���������
					model.setPageNow(String.valueOf(Integer.valueOf(fpage.getPageNow()) + 1));	//��ǰҳΪ��0ҳ
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

	/**
	 * �鿴����
	 */
	@SuppressWarnings("static-access")
	@Override
	public ArrayList<V_EmpDetail> doSelectDetail(FenPage fpage) {
		
		ArrayList<V_EmpDetail> almodel = new ArrayList<V_EmpDetail>();
		/*�ж����Ե�һ��ȡ���ݿ���Ϣʱ��ѷ�ҳ��Ϣ���ؽ�ȥ*/
		boolean pdFp = false;
		
		try {
			CopyLimit limit = new CopyLimit();
			rs = limit.doVLimit("v_empdetail", "eid", fpage.getPageNow(), CopyLimit.pageSize);
			
			while(rs.next()){
				
				V_EmpDetail model = new V_EmpDetail();
				
				_Emp emp = new _Emp();
				_Authority authority = new _Authority();
				_Dpoint dpoint = new _Dpoint();
				_Drange drange = new _Drange();
				//Ա��
				emp.setEid(rs.getString("eid"));
				emp.setEname(rs.getString("ename"));
				emp.setEsex(rs.getString("esex"));
				emp.setEage(rs.getString("eage"));
				emp.setEbirthday(rs.getString("ebirthday"));
				emp.setEpa(rs.getString("epa"));
				emp.setEaddress(rs.getString("eaddress"));
				emp.setEphone(rs.getString("ephone"));
				emp.setEemail(rs.getString("eemail"));
				emp.setEpost(rs.getString("epost"));
				emp.setEdept(rs.getString("edept"));
				emp.setEindate(rs.getString("edindate"));
				emp.setEsal(rs.getString("esal"));
				emp.setEstate(rs.getString("estate"));
				emp.setEnote(rs.getString("enote"));
				//Ȩ��
				authority.setAuid(rs.getString("auid"));
				authority.setAuno(rs.getString("auno"));
				authority.setAudesc(rs.getString("audesc"));
				//���͵�
				dpoint.setDpid(rs.getString("dpid"));
				dpoint.setDppro(rs.getString("dppro"));
				dpoint.setDpaddress(rs.getString("dpaddress"));
				dpoint.setDptel(rs.getString("dptel"));
				dpoint.setDpemail(rs.getString("dpemail"));
				dpoint.setDpname(rs.getString("dpname"));
				//���ͷ�Χ
				drange.setDrid(rs.getString("drid"));
				drange.setFk_dpid(rs.getString("fk_dpid"));
				drange.setDrend(rs.getString("drend"));
				drange.setDrfkg(rs.getString("drfkg"));
				drange.setDrokg(rs.getString("drokg"));
				
				//�������
				model.setEmp(emp);
				model.setAuthority(authority);
				model.setDpoint(dpoint);
				model.setDrange(drange);
				
				//��ҳ��Ϣ
				if(!pdFp){
					limit.doCount();
					model.setPageCount(limit.doCount());										//��ʾһ���ж���������
					model.setPageNow(String.valueOf(Integer.valueOf(fpage.getPageNow()) + 1));//��ǰҳΪ�ڼ�ҳ
					model.setPageNum(limit.pageNum);											//ÿҳ��ʾ�� ����� ��������1 2 3 4 5
					model.setPageSize(limit.pageSize);										//ÿҳ��С��������ʾ����������
					model.setPageS(limit.doPageS());											//��ʾһ���ֳܷ�������ҳ
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

}
