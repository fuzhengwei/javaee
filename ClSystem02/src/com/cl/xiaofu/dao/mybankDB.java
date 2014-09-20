package com.cl.xiaofu.dao;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cl.xiaofu.model._cltable;
import com.cl.xiaofu.util.HibernateSessionFactory;

public class mybankDB {
	
	
	/*
	 * �����ݿ���������Ϣ�����ˣ���Ǯ��
	 */
	public void doAddList(_cltable ct) {
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			session.saveOrUpdate(ct);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	/*
	 * ɾ�������û�
	 * @����ί
	 */
	public void doDeleteList(String[] whoId) {
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			for(int i = 0; i < whoId.length; i++){
				_cltable ct = (_cltable)session.load(_cltable.class, Integer.parseInt(whoId[i]));
				session.delete(ct);
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
	}
	
	/*
	 * ͨ�����ݹ�������Ϣ����ȡlist�б�
	 * @����ί
	 */
	public List<_cltable> doList(String clHome, String clWhat,String clTime) {
		List<_cltable> list = new ArrayList<_cltable>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			String hql = "from _cltable ct where ct.ClHome = '"+clHome+"' and ct.ClTime = '"+clTime+"' and ct.ClWhat = '"+clWhat+"'";
			Query query = session.createQuery(hql);
			list = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return list;
	}
	
	/*
	 * ���ù��������ݣ�ֱ�Ӹ��µ����ݿ�
	 */
	public void doUpdate(_cltable ct) {
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			String hql = "select ct.ClId from _cltable ct where ct.ClWho = '"+ct.getClWho()+"'";
			Query query = session.createQuery(hql);
		    if(query.list() != null){
		    	ct.setClId(Integer.parseInt(query.list().get(0).toString()));
		    	session.update(ct);
		    }
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	/*
	 * ��ȡ������Ϣ�����ڸ�������
	 * @����ί
	 * @��������<s:iteator value="list" var="c"><s:property value="c.**"/></iteator>
	 */
	public List<_cltable> doAllSum(String clHome, String clWhat,String clTime) {
		List<_cltable> list = new ArrayList<_cltable>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			String hql = "from _cltable ct where ct.ClHome = '"+clHome+"' and ct.ClTime = '"+clTime+"' and ct.ClWhat = '"+clWhat+"'";
			Query query = session.createQuery(hql);
			list = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return list;
	}
	/*
	 * ÿҳ��ʾ��������
	 * ÿ�����ݴ��ݹ����ĵ�ǰҳ����������һҳ���߼���һҳ��Ӧ��ʾ������
	 * @����ί
	 * @��������
	 * for(_cltable ct:list){
	 *		System.out.println(ct.getClWho());
	 *		System.out.println(ct.getClMoney());
	 *	}
	 */
	public List<_cltable> doPage(int fr,String clHome, String clWhat,String clTime) {
		List<_cltable> list = new ArrayList<_cltable>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			String hql = "from _cltable ct where ct.ClHome = '"+clHome+"' and ct.ClTime = '"+clTime+"' and ct.ClWhat = '"+clWhat+"'";
			Query query = session.createQuery(hql);
			query.setFirstResult(fr*6);
			query.setMaxResults(6);
			list = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
//		for(_cltable ct:list){
//			System.out.println(ct.getClWho());
//			System.out.println(ct.getClMoney());
//		}
		return list;
	}
	
	
	/*
	 * ͨ�����ݹ��������������¼���ʱ�䡣
	 * 1����ѯ�����û��˴��д��ж���������
	 * 2����ѯ�����û��˴��д����ն�����Ǯ
	 * 3����ѯ���ܹ��ж���ҳ��ÿҳ6�����ݣ�
	 * @����ί
	 */
	public List<Object[]> doGetUserMessNumber(String clHome, String clWhat,String clTime) {
		List<Object[]> list = new ArrayList<Object[]>();
			
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			//��ѯ������������
			String hql = "select sum(ct.ClMoney),count(*) from _cltable ct where ct.ClHome = '"+clHome+"' and ct.ClWhat = '"+clWhat+"' and ct.ClTime = '"+clTime+"'";
			Query query = session.createQuery(hql);
			list = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
//		System.out.println("������Ǯ"+list.get(0)[0]);
//		System.out.println("����������"+list.get(0)[1]);
		return list;
	}
	
	/*
	 * ��ȡ��ǰ�û�������д��ж��ٴ��Լ���Ӧ��ʱ��
	 * @����ί
	 */
	public List<_cltable> doWhatTime(String userName) {
		List<_cltable> list = new ArrayList<_cltable>();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			String hql = "from _cltable ct where ct.ClHome = '"+userName+"' group by ct.ClWhat";
			Query query = session.createQuery(hql);
			list = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return list;
	}
	
	/*
	 * ��ȡ��ǰ�û��������Ϣ��װ��ClUser_login.jspҳ��
	 * @����ί
	 * */
	public String doUserClMessage(String userName) {
		String userClMessage = "������������������������������\r\n";
		userClMessage += "��--"+userName+"�Ҳ�����Ϣ���Ա�--��\r\n";
		Session session = null;
		List<Object> list = new ArrayList<Object>();
		try {
			session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			//��ѯ��ǰ�û��������ϲ��
			String hql = "select ct.ClWhat from _cltable ct where ct.ClHome = '"+userName+"' group by ct.ClWhat ";
			Query query = session.createQuery(hql);
			list = query.list();
			userClMessage += "�ǩ��������������ש�����������\r\n";
			userClMessage += "���ܹ��д����ˣ���"+list.size()+"��"+"\r\n";
			userClMessage += "�ǩ��������������贈��������\r\n";
			//��ѯ��ǰ�û��ܹ�������Ǯ����
			hql = "select sum(ct.ClMoney) from _cltable ct where ct.ClHome = '"+userName+"'";
			list = session.createQuery(hql).list();
			userClMessage += "���ܹ�������Ǯ����"+list.get(0)+"Ԫ"+"\r\n";
			userClMessage += "�ǩ��������������贈��������\r\n";
			//��ѯ��ǰ�û��ܹ������Ǯ��
			hql = "select sum(ct.ClMoney) from _cltable ct where ct.ClWho = '"+userName+"'";
			list = session.createQuery(hql).list();
			userClMessage += "���ܹ������Ǯ����"+list.get(0)+"Ԫ"+"\r\n";
			userClMessage += "�ǩ��������������贈��������\r\n";
			//����洦����Ǯ
			hql = "select max(ct.ClMoney) from _cltable ct where ct.ClWho = '"+userName+"'";
			list = session.createQuery(hql).list();
			userClMessage += "����������Ǯ����"+list.get(0)+"Ԫ"+"\r\n";
			userClMessage += "�ǩ��������������贈��������\r\n";
			//����洦����Ǯ
			hql = "select min(ct.ClMoney) from _cltable ct where ct.ClWho = '"+userName+"'";
			list = session.createQuery(hql).list();
			userClMessage += "����������Ǯ����"+list.get(0)+"Ԫ"+"\r\n";
			userClMessage += "�ǩ��������������贈��������\r\n";
			//����������Ǯ
			hql = "select max(ct.ClMoney) from _cltable ct where ct.ClHome = '"+userName+"'";
			list = session.createQuery(hql).list();
			userClMessage += "�����������Ǯ����"+list.get(0)+"Ԫ"+"\r\n";
			userClMessage += "�ǩ��������������贈��������\r\n";
			list = null;hql = null;
			//����������Ǯ
			hql = "select min(ct.ClMoney) from _cltable ct where ct.ClHome = '"+userName+"'";
			list = session.createQuery(hql).list();
			userClMessage += "�����������Ǯ����"+list.get(0)+"Ԫ"+"\r\n";
			userClMessage += "�����������������ߩ���������\r\n";
			list = null;hql = null;
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return userClMessage;
	}
	
	public static String doGbk(String strText) {
		String strGbk = null;
		try {
			strGbk = new String(strText.getBytes("iso-8859-1"),"gbk");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strGbk;
	}
}
