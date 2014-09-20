package com.aps.db.dao.itfc.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aps.db.dao.itfc.Customer;
import com.aps.db.model.FenPage;
import com.aps.db.model._Customer;
import com.aps.db.tem.CopyLimit;
import com.aps.db.tem.GetSelectQurey;
import com.aps.email.SendEmail;
import com.aps.log.imp.UserLog;

/**
 * �û�����
 * @author Administrator
 *
 */
public class CustomerDAO extends GetSelectQurey implements Customer{

	private PreparedStatement ps;
	private ResultSet rs;
	private UserLog userLog = UserLog.getUserLogSingleton();
	private SendEmail sendEmail = new SendEmail();
	
	public boolean doDelete(String id) {
		boolean bool = false;
		try {
			ps = super.getPs("delete from aps_customer where CTID = ?");
			ps.setString(1, id);
			bool = ps.executeUpdate() > 0;
			super.commit();
			
			/*
			 * ������־ɾ���ͻ�
			 * */
			userLog.doSaveLog("ɾ���ͻ���"+id);
			
		} catch (SQLException e) {
			super.rollback();
			e.printStackTrace();
		}
		
		return bool;
	}

	/**
	 * �����û�
	 */
	public boolean doInster(_Customer alobj) {
		boolean bool = false;
		try {
			ps = super.getPs("insert into aps_customer values(sdii.nextval,?,?,?,?,?,?,to_date(?,'yyyy-mm-dd'),?)");
			ps.setString(1, alobj.getCnickname());
			ps.setString(2, alobj.getCname());
			ps.setString(3, alobj.getCsex());
			ps.setString(4, alobj.getCpwd());
			ps.setString(5, alobj.getCtel());
			ps.setString(6, alobj.getCemail());
			ps.setString(7, alobj.getCbirthday());
			ps.setString(8, alobj.getCaddress());
			bool =  ps.executeUpdate() > 0;
			super.commit();
			
			/*
			 *���뵽��־�� 
			 *�����ͻ�
			 */
			userLog.doSaveLog("�����ͻ���"+alobj.getCname());
			
			/*
			 *�����û�ע����Ϣ���û����ʼ����� 
			 */
			StringBuffer userMessage = new StringBuffer(); 
			userMessage.append("��ӭע������ǵ��û�<br>")
					   .append("�뱣���������û���������<br>")
					   .append("�û�����"+alobj.getCname()+"<br>")
					   .append("���룺"+alobj.getCpwd()+"<br>");
			sendEmail.doSendHtmlEmail("������", userMessage, alobj.getCemail());
			
		} catch (SQLException e) {
			super.rollback();
			e.printStackTrace();
		}
		
		return bool;
	}

	/**
	 * �Է�ҳ��ʽ�鿴�ͻ���Ϣ
	 */
	@SuppressWarnings("static-access")
	public ArrayList<_Customer> doSelect(FenPage page) {
		ArrayList<_Customer> almodel = new ArrayList<_Customer>();
		/*�ж����Ե�һ��ȡ���ݿ���Ϣʱ��ѷ�ҳ��Ϣ���ؽ�ȥ*/
		boolean pdFp = false;
		
		try {
			CopyLimit limit = new CopyLimit();
			rs = limit.doLimit("aps_customer", "CTID", page.getPageNow(), CopyLimit.pageSize);
			while(rs.next()){
				_Customer model = new _Customer();
				//�ͻ�
				model.setCtid(rs.getString("ctid"));
				model.setCnickname(rs.getString("cnickname"));
				model.setCname(rs.getString("cname"));
				model.setCsex(rs.getString("csex"));
				model.setCpwd(rs.getString("cpwd"));
				model.setCtel(rs.getString("ctel"));
				model.setCemail(rs.getString("cemail"));
				model.setCbirthday(rs.getString("cbirthday"));
				model.setCaddress(rs.getString("caddress"));
				
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

	public ArrayList<_Customer> doSelect(_Customer alobj) {
		return null;
	}

	/**
	 * �첽��������
	 */
	public boolean doUpdate(_Customer obj) {
		boolean bool = false;
		try {
			ps = super.getPs("update aps_customer set cnickname=?,cname = ?,csex = ?,ctel = ?,cemail = ?,caddress = ? where ctid = ?");
			ps.setString(1, obj.getCnickname());
			ps.setString(2, obj.getCname());
			ps.setString(3, obj.getCsex());
			ps.setString(4, obj.getCtel());
			ps.setString(5, obj.getCemail());
			ps.setString(6, obj.getCaddress());
			ps.setString(7, obj.getCtid());
			bool = ps.executeUpdate() > 0;
			super.commit();
			
			/*
			 *��������Ҳд����־ 
			 */
			userLog.doSaveLog("�����û���"+obj.getCname());
			
		} catch (SQLException e) {
			super.rollback();
			e.printStackTrace();
		}
		return bool;
	}

}
