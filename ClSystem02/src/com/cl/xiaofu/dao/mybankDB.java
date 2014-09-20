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
	 * 像数据库增加礼单信息（礼人，礼钱）
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
	 * 删除随礼用户
	 * @付政委
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
	 * 通过传递过来的信息，获取list列表。
	 * @付政委
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
	 * 把拿过来的数据，直接更新到数据库
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
	 * 获取所有信息，用于更新数据
	 * @付政委
	 * @便利方法<s:iteator value="list" var="c"><s:property value="c.**"/></iteator>
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
	 * 每页显示六条数据
	 * 每次依据传递过来的当前页以用于增加一页或者减少一页对应显示出数据
	 * @付政委
	 * @遍历方法
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
	 * 通过传递过来的是姓名、事件、时间。
	 * 1：查询出此用户此次招待有多少人随礼
	 * 2：查询出此用户此次招待共收多少礼钱
	 * 3：查询出总共有多少页（每页6条数据）
	 * @付政委
	 */
	public List<Object[]> doGetUserMessNumber(String clHome, String clWhat,String clTime) {
		List<Object[]> list = new ArrayList<Object[]>();
			
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			//查询共多少人随礼
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
//		System.out.println("共收礼钱"+list.get(0)[0]);
//		System.out.println("共随礼人数"+list.get(0)[1]);
		return list;
	}
	
	/*
	 * 获取当前用户所办的招待有多少次以及对应的时间
	 * @付政委
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
	 * 获取当前用户彩礼的信息，装到ClUser_login.jsp页面
	 * @付政委
	 * */
	public String doUserClMessage(String userName) {
		String userClMessage = "┏━━━━━━━━━━┅┅┅┓\r\n";
		userClMessage += "┃--"+userName+"家彩礼信息简略表--┃\r\n";
		Session session = null;
		List<Object> list = new ArrayList<Object>();
		try {
			session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			//查询当前用户办过几次喜事
			String hql = "select ct.ClWhat from _cltable ct where ct.ClHome = '"+userName+"' group by ct.ClWhat ";
			Query query = session.createQuery(hql);
			list = query.list();
			userClMessage += "┣━━━━━━━┳━━┅┅┅┛\r\n";
			userClMessage += "┃总共招待客人：┃"+list.size()+"次"+"\r\n";
			userClMessage += "┣━━━━━━━╋━━┅┅┅\r\n";
			//查询当前用户总共收入礼钱多少
			hql = "select sum(ct.ClMoney) from _cltable ct where ct.ClHome = '"+userName+"'";
			list = session.createQuery(hql).list();
			userClMessage += "┃总共收入礼钱：┃"+list.get(0)+"元"+"\r\n";
			userClMessage += "┣━━━━━━━╋━━┅┅┅\r\n";
			//查询当前用户总共随出礼钱数
			hql = "select sum(ct.ClMoney) from _cltable ct where ct.ClWho = '"+userName+"'";
			list = session.createQuery(hql).list();
			userClMessage += "┃总共随出礼钱：┃"+list.get(0)+"元"+"\r\n";
			userClMessage += "┣━━━━━━━╋━━┅┅┅\r\n";
			//最高随处多少钱
			hql = "select max(ct.ClMoney) from _cltable ct where ct.ClWho = '"+userName+"'";
			list = session.createQuery(hql).list();
			userClMessage += "┃最高随出礼钱：┃"+list.get(0)+"元"+"\r\n";
			userClMessage += "┣━━━━━━━╋━━┅┅┅\r\n";
			//最低随处多少钱
			hql = "select min(ct.ClMoney) from _cltable ct where ct.ClWho = '"+userName+"'";
			list = session.createQuery(hql).list();
			userClMessage += "┃最低随出礼钱：┃"+list.get(0)+"元"+"\r\n";
			userClMessage += "┣━━━━━━━╋━━┅┅┅\r\n";
			//最高收礼多少钱
			hql = "select max(ct.ClMoney) from _cltable ct where ct.ClHome = '"+userName+"'";
			list = session.createQuery(hql).list();
			userClMessage += "┃最高收入礼钱：┃"+list.get(0)+"元"+"\r\n";
			userClMessage += "┣━━━━━━━╋━━┅┅┅\r\n";
			list = null;hql = null;
			//最低收礼多少钱
			hql = "select min(ct.ClMoney) from _cltable ct where ct.ClHome = '"+userName+"'";
			list = session.createQuery(hql).list();
			userClMessage += "┃最低收入礼钱：┃"+list.get(0)+"元"+"\r\n";
			userClMessage += "┗━━━━━━━┻━━┅┅┅\r\n";
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
