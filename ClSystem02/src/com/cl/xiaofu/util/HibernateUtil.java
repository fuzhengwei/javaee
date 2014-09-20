package com.cl.xiaofu.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	//SeddionFaction����
	private static SessionFactory factory = null;
	//��̬��
	static{
		try {
			//����Hibernate�����ļ�
			Configuration cfg = new Configuration().configure();
			//ʵ����SessionFaction
			factory = cfg.buildSessionFactory(); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/*
	 * ��ȡSession����
	 * */
	public static Session getSession(){
		Session session = (factory!=null)?factory.openSession():null;
		return session;
	}
	/*
	 * ��ȡSessionFaction����
	 * */
	public static SessionFactory getSessionFactory(){
		return factory;
	}
	/*
	 * �ر�Session
	 * */
	public static void closeSession(Session session){
		if(session!=null){
			if(session.isOpen()){
				session.close();
			}
		}
	}
}
