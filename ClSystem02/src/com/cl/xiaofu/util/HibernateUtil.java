package com.cl.xiaofu.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	//SeddionFaction对象
	private static SessionFactory factory = null;
	//静态块
	static{
		try {
			//加载Hibernate配置文件
			Configuration cfg = new Configuration().configure();
			//实例化SessionFaction
			factory = cfg.buildSessionFactory(); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/*
	 * 获取Session对象
	 * */
	public static Session getSession(){
		Session session = (factory!=null)?factory.openSession():null;
		return session;
	}
	/*
	 * 获取SessionFaction对象
	 * */
	public static SessionFactory getSessionFactory(){
		return factory;
	}
	/*
	 * 关闭Session
	 * */
	public static void closeSession(Session session){
		if(session!=null){
			if(session.isOpen()){
				session.close();
			}
		}
	}
}
