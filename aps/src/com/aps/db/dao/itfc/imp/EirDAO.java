package com.aps.db.dao.itfc.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aps.db.dao.itfc.Eir;
import com.aps.db.model.FenPage;
import com.aps.db.model.V_Eirs;
import com.aps.db.model._Eir;
import com.aps.db.tem.CopyLimit;

/**
 * ���ӵ�
 * @author Administrator
 *
 */
public class EirDAO implements Eir{

	private PreparedStatement ps;
	private ResultSet rs;
	
	/**
	 * ͨ��idɾ������
	 */
	public boolean doDelete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * ��������
	 */
	public boolean doInster(_Eir alobj) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * �Է�ҳ�ķ�ʽ��ʾ������Ϣ
	 */
	@SuppressWarnings("static-access")
	public ArrayList<V_Eirs> doSelect(FenPage page) {
		
		ArrayList<V_Eirs> almodel = new ArrayList<V_Eirs>();
		/*�ж����Ե�һ��ȡ���ݿ���Ϣʱ��ѷ�ҳ��Ϣ���ؽ�ȥ*/
		boolean pdFp = false;
		CopyLimit limit = new CopyLimit();
		
		try {
			rs = limit.doVLimit("v_eirs", "DPID", page.getPageNow(), CopyLimit.pageSize);
			while(rs.next()){
				V_Eirs model = new V_Eirs();
				
				//װ�����͵���Ϣ
				model.setDpid(rs.getString("dpid"));
				model.setDpname(rs.getString("dpname"));
				model.setDptel(rs.getString("dptel"));
				
				//װ��·����Ϣ
				model.setRtid(rs.getString("rtid"));
				model.setRtname(rs.getString("rtname"));
				model.setRtspoint(rs.getString("rtspoint"));
				
				//װ�س�����Ϣ
				model.setCid(rs.getString("cid"));
				model.setCbrand(rs.getString("cbrand"));
				
				//װ��Ա����Ϣ
				model.setEid(rs.getString("eid"));
				model.setEname(rs.getString("ename"));
				model.setEphone(rs.getString("ephone"));
				
				//������id
				model.setCapid(rs.getString("capid"));
				
				//װ�ض�����Ϣ
				model.setOlid(rs.getString("olid"));
				model.setOlno(rs.getString("olno"));
				model.setOlname(rs.getString("olname"));
				model.setOlsendtel(rs.getString("olsendtel"));
				model.setOlsendaddress(rs.getString("olsendaddress"));
				model.setOlsendcode(rs.getString("olsendcode"));
				model.setOlsendemail(rs.getString("olsendemail"));
				model.setOlinname(rs.getString("olinname"));
				model.setOlintel(rs.getString("olintel"));
				model.setOlinaddress(rs.getString("olinaddress"));
				model.setOlincode(rs.getString("olincode"));
				model.setOlgoodsname(rs.getString("olgoodsname"));
				model.setOlgoodstype(rs.getString("olgoodstype"));
				model.setOlgoodsum(rs.getString("olgoodsnum"));
				model.setOlgoodsweight(rs.getString("olgoodsweight"));
				model.setOlgoodsaddress(rs.getString("olgoodsaddress"));
				model.setOldate(rs.getString("oldate"));
				model.setOlingoodsadd(rs.getString("olingoodsadd"));
				model.setOlins(rs.getString("olins"));
				model.setOlsnotice(rs.getString("olsnotice"));
				model.setOlpays(rs.getString("olpays"));
				model.setOlnote(rs.getString("olnote"));
				
				//���ӵ�id
				model.setEirid(rs.getString("eirid"));
				
				//��ҳ��Ϣ
				if(!pdFp){
					limit.doCount();
					model.setPageCount(limit.doCount());										//��ʾһ���ж���������
					model.setPageNow(String.valueOf(Integer.valueOf(page.getPageNow()) + 1));	//��ǰҳΪ�ڼ�ҳ
					model.setPageNum(limit.pageNum);											//ÿҳ��ʾ�� ����� ��������1 2 3 4 5
					model.setPageSize(limit.pageSize);											//ÿҳ��С��������ʾ����������
					model.setPageS(limit.doPageS());											//��ʾһ���ֳܷ�������ҳ
					pdFp = true;
				}
				//װ�뼯��
				almodel.add(model);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return almodel;
	}

	/**
	 * ������ʽ�鿴���Ҹ����ҳ
	 */
	public ArrayList<_Eir> doSelect(_Eir page) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ��������
	 */
	public boolean doUpdate(_Eir obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
