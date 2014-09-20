package com.aps.db.dao.itfc.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aps.db.dao.itfc.Capacity;
import com.aps.db.model.CapacityS;
import com.aps.db.model.FenPage;
import com.aps.db.model.V_Capacitys;
import com.aps.db.model.V_EmpDetail;
import com.aps.db.model._Capacity;
import com.aps.db.model._Car;
import com.aps.db.model._Dpoint;
import com.aps.db.model._Drange;
import com.aps.db.model._Emp;
import com.aps.db.model._Route;
import com.aps.db.model._Rw;
import com.aps.db.tem.CopyLimit;
import com.aps.db.tem.GetSelectQurey;

/**
 * ������
 * @author Administrator
 */
public class CapacityDAO extends GetSelectQurey implements Capacity{

	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public boolean doDelete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * �������
	 */
	public boolean doInster(_Capacity alobj) {
		
		boolean bool = false;
		try {
			ps = super.getPs("insert into aps_capacity values(sdii.nextval,?,?,?,?,?)");
			ps.setString(1, alobj.getFk_dpid());
			ps.setString(2, alobj.getFk_rtid());
			ps.setString(3, alobj.getFk_cid());
			ps.setString(4, alobj.getFk_eid());
			ps.setString(5, alobj.getCapstate());
			bool = ps.executeUpdate() > 0;
			super.commit();
			
		} catch (SQLException e) {
			super.rollback();
			e.printStackTrace();
		}
		return bool;
	}

	
	@Override
	public ArrayList<V_Capacitys> doSelect(FenPage page) {
		
		ArrayList<V_Capacitys> almodel = new ArrayList<V_Capacitys>();
		/*�ж����Ե�һ��ȡ���ݿ���Ϣʱ��ѷ�ҳ��Ϣ���ؽ�ȥ*/
		boolean pdFp = false;
		
		try {
			CopyLimit limit = new CopyLimit();
			rs = limit.doVLimit("v_capacitys", "DPTEL", page.getPageNow(), CopyLimit.pageSize);
			while(rs.next()){
				V_Capacitys model = new V_Capacitys();
				model.setDpname(rs.getString("DPNAME"));
				model.setDpaddress(rs.getString("DPADDRESS"));
				model.setDptel(rs.getString("DPTEL"));
				model.setRtname(rs.getString("RTNAME"));
				model.setRtspoint(rs.getString("RTSPOINT"));
				model.setCbrand(rs.getString("CBRAND"));
				model.setCmodel(rs.getString("CMODEL"));
				model.setEname(rs.getString("ENAME"));
				model.setEphone(rs.getString("EPHONE"));
				model.setCapastate(rs.getString("CAPSTATE"));
				
				if(!pdFp){
					limit.doCount();
					model.setPageCount(limit.doCount());	//��ʾһ���ж���������
					model.setPageNow(String.valueOf(Integer.valueOf(page.getPageNow()) + 1));	//��ǰҳΪ��0ҳ
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
	public ArrayList<_Capacity> doSelect(_Capacity alobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doUpdate(_Capacity obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * װ����Ϣ 
	 */
	public ArrayList<CapacityS> doGetAllToCap() {
		
		ArrayList<CapacityS> almodel = new ArrayList<CapacityS>();
		
		try {
			//���͵������ͷ�Χ
			ps = super.getPs("select DPID,DPADDRESS,DPNAME,DRID,DREND from v_dpoint_drange");
			rs = ps.executeQuery();
			while(rs.next()){
				CapacityS capacitys = new CapacityS();
				_Dpoint dpoint = new _Dpoint();
				_Drange drange = new _Drange();
				
				dpoint.setDpid(rs.getString("DPID"));
				dpoint.setDpname(rs.getString("DPNAME"));
				dpoint.setDpaddress(rs.getString("DPADDRESS"));
				
				drange.setDrid(rs.getString("DRID"));
				drange.setDrend(rs.getString("DREND"));
				
				capacitys.setDpoint(dpoint);
				capacitys.setDrange(drange);
				
				almodel.add(capacitys);
			}
			//·����·��;����
			ps = super.getPs("select RTID,RTNAME,RWID,RWROUTEND from v_route_rw");
			rs = ps.executeQuery();
			while(rs.next()){
				CapacityS capacitys = new CapacityS();
				_Route route = new _Route();
				_Rw rw = new _Rw();
				
				route.setRtid(rs.getString("RTID"));
				route.setRtname(rs.getString("RTNAME"));
				
				rw.setRwid(rs.getString("RWID"));
				rw.setRwroutend(rs.getString("RWROUTEND"));
				
				capacitys.setRoute(route);
				capacitys.setRw(rw);
				almodel.add(capacitys);
			}
			//������Ϣ
			ps = super.getPs("select CID,CBRAND,CMODEL from aps_car b where b.cid in (select max(a.cid) from aps_car a group by a.cbrand)");
			rs = ps.executeQuery();
			while(rs.next()){
				CapacityS capacitys = new CapacityS();
				_Car car = new _Car();
				car.setCid(rs.getString("CID"));
				car.setCbrand(rs.getString("CBRAND"));
				car.setCmodel(rs.getString("CMODEL"));
				capacitys.setCar(car);
				almodel.add(capacitys);
			}
			
			
			//Ա����Ϣ(ѡ����ְλ��˾��)
			ps = super.getPs("select a.eid,max(ENAME) ename,max(EPHONE) ephone,max(DPNAME) dpname from v_empdetail a group by a.eid");
			//select a.eid,max(ENAME),max(EPHONE),max(DPNAME) from v_empdetail a group by a.eid;
			rs = ps.executeQuery();
			while(rs.next()){
				CapacityS capacitys = new CapacityS();
				_Emp emp = new _Emp();
				_Dpoint dpoint = new _Dpoint();
				V_EmpDetail empdetail = new V_EmpDetail();
				
				emp.setEid(rs.getString("eid"));
				emp.setEname(rs.getString("ename"));
				emp.setEphone(rs.getString("ephone"));
				dpoint.setDpname(rs.getString("dpname"));
				
				empdetail.setEmp(emp);
				empdetail.setDpoint(dpoint);
				
				capacitys.setEmpDetail(empdetail);
				
				almodel.add(capacitys);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return almodel;
	}

}
