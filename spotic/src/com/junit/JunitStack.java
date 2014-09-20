package com.junit;

import static org.junit.Assert.*;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.junit.Test;

import com.spotic.emp.bean.Spotic_EmpBean;
import com.stack.bean.PageBean;
import com.stack.bean.UserBean;
import com.stack.util.rsq.IReflctQueryDao;
import com.stack.util.rsq.ReflectQueryDao;

public class JunitStack {

	IReflctQueryDao rqd = new ReflectQueryDao("com.stack.bean.UserBean");

	@Test
	public void insert() {
		UserBean user = new UserBean();
		user.setUser_name(URLEncoder.encode("付政委"));
		rqd.doInsertModel(user);

	}

	@Test
	public void delete() {
		rqd.doDeleteModelById("23");
	}

	@Test
	public void update() {
		UserBean user = new UserBean();
		user.setUser_id("1");
		user.setUser_name(URLEncoder.encode("奥巴马"));
		rqd.doUpdateModel(user);
	}

	@Test
	public void select() {

		// 设置分页 默认为每页10条数据
		PageBean pageBean = new PageBean();
		pageBean.setFirstResult(1);

		ArrayList<UserBean> modelList = (ArrayList<UserBean>) rqd
				.doSelectModelList(pageBean);

		for (UserBean user : modelList) {
			System.out.print(user.getUser_id() + " ");
			System.out.print(URLDecoder.decode(user.getUser_name()) + " ");
		}

	}

	@Test
	public void selectSerach() {

		IReflctQueryDao rqd = new ReflectQueryDao("com.spotic.emp.bean.Spotic_EmpBean");
		
		PageBean pageBean = new PageBean();
		pageBean.setMaxResult(5);
		pageBean.setFirstResult(2);

		Spotic_EmpBean empBean = new Spotic_EmpBean();
//		empBean.setEmp_phone("152");
//		empBean.setEmp_remarks("1");

		ArrayList<Spotic_EmpBean> modelList = (ArrayList<Spotic_EmpBean>) rqd
				.doSelectModelListBySerach(pageBean, empBean);
		for (Spotic_EmpBean bean : modelList) {
			System.out.println(bean.getEmp_id()+ " " + bean.getEmp_name()
					+ " " + bean.getEmp_power());
		}
	}
	
	@Test
	public void selectSerachLike(){
		
		IReflctQueryDao rqd = new ReflectQueryDao("com.spotic.emp.bean.Spotic_EmpBean");
		
		PageBean pageBean = new PageBean();
		pageBean.setMaxResult(5);
		pageBean.setFirstResult(3);

		Spotic_EmpBean empBean = new Spotic_EmpBean();
//		empBean.setEmp_phone("152");
//		empBean.setEmp_remarks("1");
		ArrayList<Spotic_EmpBean> modelList = (ArrayList<Spotic_EmpBean>) rqd
		.doSelectModelListBySerachForLike(pageBean,empBean);
		
		for (Spotic_EmpBean bean : modelList) {
			System.out.println(bean.getEmp_id()+ " " + bean.getEmp_name()
					+ " " + bean.getEmp_power());
		}
	}

	@Test
	public void selectById() {
		UserBean user = (UserBean) rqd.doSelectModelById("1");
		System.out.println(URLDecoder.decode(user.getUser_name()));
	}

	@Test
	public void selectEmp(){
		// 设置分页 默认为每页10条数据
		PageBean pageBean = new PageBean();
		pageBean.setFirstResult(1);

		IReflctQueryDao rqd = new ReflectQueryDao("com.spotic.emp.bean.Spotic_EmpBean");
		ArrayList<Spotic_EmpBean> modelList = (ArrayList<Spotic_EmpBean>) rqd
		.doSelectModelList(pageBean);
		
		for(Spotic_EmpBean se : modelList){
			System.out.println(se.getEmp_name());
		}
		
		
	}
	
}
