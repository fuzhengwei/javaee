package com.aps.db.dao.itfc.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aps.db.dao.itfc.Emp;
import com.aps.db.model.FenPage;
import com.aps.db.model._Authority;
import com.aps.db.model._Dpoint;
import com.aps.db.model._Drange;
import com.aps.db.model._Emp;
import com.aps.db.model._Route;
import com.aps.db.tem.CopyLimit;
import com.aps.db.tem.GetSelectQurey;
import com.aps.email.SendEmail;
import com.aps.log.imp.UserLog;

/**
 * Ա����
 * @author Administrator
 *
 */
public class EmpDAO extends GetSelectQurey implements Emp{

	private PreparedStatement ps;
	private ResultSet rs;
	private UserLog userLog = UserLog.getUserLogSingleton();
	private SendEmail sendEmail = new SendEmail();
	
	public boolean doDelete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * ����Ա��
	 */
	public boolean doInster(_Emp alobj) {
		boolean bool = false;
		String sql = "insert into aps_emp values(sdii.nextval,?,?,?,to_date(?,'yyyy-mm-dd'),?,?,?,?,?,?,to_date(?,'yyyy-mm-dd'),?,?,?)";
		try {
			ps = super.getPs(sql);
			ps.setString(1, alobj.getEname());
			ps.setString(2, alobj.getEsex());
			ps.setString(3, alobj.getEage());
			ps.setString(4, alobj.getEbirthday());
			ps.setString(5, alobj.getEpa());
			ps.setString(6, alobj.getEaddress());
			ps.setString(7, alobj.getEphone());
			ps.setString(8, alobj.getEemail());
			ps.setString(9, alobj.getEpost());
			ps.setString(10, alobj.getEdept());
			ps.setString(11, alobj.getEindate());
			ps.setString(12, alobj.getEsal());
			ps.setString(13, alobj.getEstate());
			ps.setString(14, alobj.getEnote());
			bool = ps.executeUpdate() > 0;
			super.commit();
			
			//д����־
			userLog.doSaveLog("������һ����Ա����"+alobj.getEname());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// error ���ø��෽���ع�
			super.rollback();
		}
		return bool;
	}

	/**
	 * ��ѯ���ҷ�ҳ��ʽ���ػ�ȥ
	 */
	@SuppressWarnings("static-access")
	@Override
	public ArrayList<_Emp> doSelect(FenPage page) {
		ArrayList<_Emp> almodel = new ArrayList<_Emp>();
		/*�ж����Ե�һ��ȡ���ݿ���Ϣʱ��ѷ�ҳ��Ϣ���ؽ�ȥ*/
		boolean pdFp = false;
		
		try {
			CopyLimit limit = new CopyLimit();
			rs = limit.doLimit("aps_emp", "eid", page.getPageNow(), CopyLimit.pageSize);
			while(rs.next()){
				_Emp model = new _Emp();
				//Ա��
				model.setEid(rs.getString("eid"));
				model.setEname(rs.getString("ename"));
				model.setEsex(rs.getString("esex"));
				model.setEage(rs.getString("eage"));
				model.setEbirthday(rs.getString("ebirthday"));
				model.setEpa(rs.getString("epa"));
				model.setEaddress(rs.getString("eaddress"));
				model.setEphone(rs.getString("ephone"));
				model.setEemail(rs.getString("eemail"));
				model.setEpost(rs.getString("epost"));
				model.setEdept(rs.getString("edept"));
				model.setEindate(rs.getString("edindate"));
				model.setEsal(rs.getString("esal"));
				model.setEstate(rs.getString("estate"));
				model.setEnote(rs.getString("enote"));
				
				//��ҳ��Ϣ
				if(!pdFp){
					limit.doCount();
					model.setPageCount(limit.doCount());										//��ʾһ���ж���������
					model.setPageNow(String.valueOf(Integer.valueOf(page.getPageNow()) + 1));//��ǰҳΪ�ڼ�ҳ
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

	@Override
	public ArrayList<_Emp> doSelect(_Emp alobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doUpdate(_Emp obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * �һ��û�����
	 * @return
	 */
	public String doFindUserPwd(String cname){
		StringBuffer sbUser = new StringBuffer();
		String email = "",callback = "";
		try {
			ps = super.getPs("select eemail from aps_emp where ename = ?");
			ps.setString(1, cname);
			rs = ps.executeQuery();
			
			if(rs.next()){
				sbUser.append("�𾴵��û����ã��뱣�ܺ���������--������<br/>");
				sbUser.append("�û�����"+cname+"<br/>");
				email = rs.getString("eemail");
				ps = super.getPs("select dpid from pdlogin where ename = ?");
				ps.setString(1, cname);
				rs = ps.executeQuery();
				
				if(rs.next()){
					sbUser.append("Ȩ���룺"+rs.getString("dpid")+"<br/>");
					
					//�����ʼ�
					sendEmail.doSendHtmlEmail("������ϵͳ�ʼ�", sbUser, email);
					
					callback = "�������룬�Ѿ����͵���ע��ʱ������䣬��ע����գ�";
				}else{
					callback = "����û��Ȩ�޵�¼���û������ҹ���Ա��Ȩ��";
				}
				
			}else{
				callback = "����������һ�������ڵ��û���";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return callback;
		
	}
}
