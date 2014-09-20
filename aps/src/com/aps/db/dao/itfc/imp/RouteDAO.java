package com.aps.db.dao.itfc.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aps.db.dao.itfc.Route;
import com.aps.db.model.FenPage;
import com.aps.db.model._Car;
import com.aps.db.model._Route;
import com.aps.db.tem.CopyLimit;
import com.aps.db.tem.GetSelectQurey;

/**
 * ·�߹���� 
 * @author Administrator
 *
 */
public class RouteDAO extends GetSelectQurey implements Route{

	private PreparedStatement ps;
	private ResultSet rs;
	
	public boolean doDelete(String id) {
		return false;
	}

	public boolean doInster(_Route route) {
		boolean pd = false;
		String sql = "insert into aps_route values(" +
				"sdii.nextval,?,?,?,?,?,?)";
		try {
			ps = super.getPs(sql);
			ps.setString(1, route.getRtname());
			ps.setString(2, route.getRtspoint());
			ps.setString(3, route.getRtpefpkg());
			ps.setString(4, route.getRtpeopkg());
			ps.setString(5, route.getRtpefpvo());
			ps.setString(6, route.getRtpeopvo());
			pd = ps.executeUpdate() > 0;
			super.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pd;
	}

	@SuppressWarnings("static-access")
	public ArrayList<_Route> doSelect() {
		
		ArrayList<_Route> alroute = new ArrayList<_Route>();
		CopyLimit limit = new CopyLimit();
		boolean pdFp = false;
		try {
			rs = limit.doVLimit("v_route_rw", "rtid", "1", limit.pageNum);
			while(rs.next()){
				_Route route = new _Route();
				route.setRtid(rs.getString(1));
				route.setRtname(rs.getString(2));
				route.setRtspoint(rs.getString(3));
				route.setRtpefpkg(rs.getString(4));
				route.setRtpeopkg(rs.getString(5));
				route.setRtpefpvo(rs.getString(6));
				route.setRtpeopvo(rs.getString(7));
				route.setRtEnd(rs.getString(10));
				
				if(!pdFp){
					limit.doCount();
					route.setPageCount(limit.doCount());	//��ʾһ���ж���������
					route.setPageNow("1");				//��ǰҳΪ��0ҳ
					route.setPageNum(limit.pageNum);		//ÿҳ��ʾ�� ����� ��������1 2 3 4 5
					route.setPageSize(limit.pageSize);	//ÿҳ��С��������ʾ����������
					route.setPageS(limit.doPageS());		//��ʾһ���ֳܷ�������ҳ
					pdFp = true;
				}
				alroute.add(route);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alroute;
	}

	public ArrayList<_Route> doSelect(_Route alobj) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean doUpdate(ArrayList<_Route> obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("static-access")
	public ArrayList<_Route> doSelectPage(FenPage fpage) {
		
		ArrayList<_Route> alroute = new ArrayList<_Route>();
		/*�ж����Ե�һ��ȡ���ݿ���Ϣʱ��ѷ�ҳ��Ϣ���ؽ�ȥ*/
		boolean pdFp = false;
		
		try {
			CopyLimit limit = new CopyLimit();
			rs = limit.doVLimit("v_route_rw", "rtid", fpage.getPageNow(), CopyLimit.pageSize);
			while(rs.next()){
				_Route route = new _Route();
				route.setRtid(rs.getString("RTID"));
				route.setRtname(rs.getString("RTNAME"));
				route.setRtspoint(rs.getString("RTSPOINT"));
				route.setRtpefpkg(rs.getString("RTPEFPKG"));
				route.setRtpeopkg(rs.getString("RTPEOPKG"));
				route.setRtpefpvo(rs.getString("RTPEFPVO"));
				route.setRtpeopvo(rs.getString("RTPEOPVO"));
				route.setRtEnd(rs.getString("RWROUTEND"));
				
				if(!pdFp){
					limit.doCount();
					route.setPageCount(limit.doCount());										//��ʾһ���ж���������
					route.setPageNow(String.valueOf(Integer.valueOf(fpage.getPageNow()) + 1));//��ǰҳΪ�ڼ�ҳ
					route.setPageNum(limit.pageNum);											//ÿҳ��ʾ�� ����� ��������1 2 3 4 5
					route.setPageSize(limit.pageSize);										//ÿҳ��С��������ʾ����������
					route.setPageS(limit.doPageS());											//��ʾһ���ֳܷ�������ҳ
					pdFp = true;
				}
				
				alroute.add(route);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alroute;
	}

}
