package com.cl.xiaofu.dao;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cl.xiaofu.model._usertable;
import com.cl.xiaofu.util.HibernateSessionFactory;
public class userDB {
	
	//添加用户- - ->注册
	public void addUser(_usertable strUser){
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			session.save(strUser);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	//查询用户- - ->登录
	public String selectUser(_usertable strUser) {
		String strLoginMessage = null;
		Session session = null;
		List<_usertable> list = new ArrayList<_usertable>();
		try {
			session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			String hql = "from _usertable ut where ut.userName = '"+doGbk(strUser.getUserName())+"'";
			Query query = session.createQuery(hql);
			list = query.list();
			if(list.size()>0){
				_usertable ut = list.get(0);
				if(strUser.getUserPw().equals(ut.getUserPw())){
					strLoginMessage = doGbk(strUser.getUserName());
				}else{
					strLoginMessage = "errorPw";
				}
			}else{
				strLoginMessage = "errorUser";
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return strLoginMessage;
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
