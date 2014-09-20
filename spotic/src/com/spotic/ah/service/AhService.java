package com.spotic.ah.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spotic.ah.bean.V_AhBean;
import com.spotic.ah.dao.AhDao;
import com.spotic.emp.bean.Spotic_EmpBean;
import com.stack.bean.PageBean;
import com.stack.util.base.HandleBase;

public class AhService extends HandleBase{

	private static AhDao dao = new AhDao();
	

	public static void doSelectModelListBySerach(HttpServletRequest request,
			HttpServletResponse response) {

		PageBean pageBean = new PageBean();
		pageBean.setFirstResult(request.getParameter("page"));
		request.setAttribute("page", null == request.getParameter("page")?"1":request.getParameter("page"));
		
		V_AhBean ahBean = new V_AhBean();
		ahBean.setInventory_type(request.getParameter("inventory_type"));
		
		
		ArrayList<V_AhBean> modelList = (ArrayList<V_AhBean>) dao.doSelectModelListBySerach(pageBean, ahBean);
		request.setAttribute("modelList", modelList);
		request.setAttribute("inventory_type", request.getParameter("inventory_type"));
		try {
			if("1".equals(request.getParameter("inventory_type"))){
				request.getRequestDispatcher("view/ah/salesrecord.jsp").forward(request, response);
			}else if("3".equals(request.getParameter("inventory_type"))){
				request.getRequestDispatcher("view/ah/purchaserecord.jsp").forward(request, response);
			}else if("4".equals(request.getParameter("inventory_type"))){
				request.getRequestDispatcher("view/ah/deliveryrecord.jsp").forward(request, response);
			}
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void doSelectModelListBySerachEmp(HttpServletRequest request,
			HttpServletResponse response) {
		
		PageBean pageBean = new PageBean();
		pageBean.setFirstResult(request.getParameter("page"));
		request.setAttribute("page", null == request.getParameter("page")?"1":request.getParameter("page"));

		V_AhBean ahBean = new V_AhBean();
		ahBean.setEmp_id(request.getParameter("emp_id"));
		
		ArrayList<V_AhBean> modelList = (ArrayList<V_AhBean>) dao.doSelectModelListBySerach(pageBean, ahBean);
		request.setAttribute("modelList", modelList);
		try {
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}


	public static void doUpdateModelById(HttpServletRequest request,
			HttpServletResponse response) {

		if(dao.doUpdateModelById(request.getParameter("ei_id"), request.getParameter("ei_state"))){
			try {
				
				HttpSession session = request.getSession();
				Spotic_EmpBean empBean = (Spotic_EmpBean) session.getAttribute("spotic_emp");
				
				request.getRequestDispatcher("AhServlet?type=welcome&emp_id="+empBean.getEmp_id()).forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				request.setAttribute("error", "ah update error");
				request.getRequestDispatcher("error/error.jsp").forward(request, response);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		
	}

	
	public static void doSelectModelLists(HttpServletRequest request,
			HttpServletResponse response) {

		request.setAttribute("empCount", dao.doGetEmpCount());
		request.setAttribute("customerCount", dao.doGetCustomerCount());
		request.setAttribute("rfqCount", dao.doGetRfqCount());
		request.setAttribute("iUsCount", dao.doGetInventoryUsCount());
		request.setAttribute("iExcessCount", dao.doGetInventoryExcessCount());
		request.setAttribute("iOutsideCount", dao.doGetInventoryOutsideCount());
		
		request.setAttribute("ieNow_1", dao.doGetEiNow_1());
		request.setAttribute("ieNow_2", dao.doGetEiNow_2());
		request.setAttribute("ieNow_3", dao.doGetEiNow_3());
		request.setAttribute("ieNow_4", dao.doGetEiNow_4());
		
		request.setAttribute("ie_1", dao.doGetEi_1());
		request.setAttribute("ie_2", dao.doGetEi_2());
		request.setAttribute("ie_3", dao.doGetEi_3());
		request.setAttribute("ie_4", dao.doGetEi_4());
		
		try {
			request.getRequestDispatcher("welcomeadmin.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void doSelectModelListBySerachForLike(
			HttpServletRequest request, HttpServletResponse response) {
		
		PageBean pageBean = new PageBean();
		pageBean.setFirstResult(request.getParameter("page"));
		request.setAttribute("page", null == request.getParameter("page")?"1":request.getParameter("page"));

		V_AhBean ahBean = new V_AhBean();
		ahBean.setInventory_part_no(request.getParameter("inventory_part_no"));
		ahBean.setEmp_name(request.getParameter("emp_name"));
		ahBean.setEi_state(request.getParameter("ei_state"));
		ahBean.setInventory_type(request.getParameter("inventory_type"));
		
		ArrayList<V_AhBean> modelList = (ArrayList<V_AhBean>) dao.doSelectModelListBySerachForLike(pageBean, ahBean);
		request.setAttribute("modelList", modelList);
		request.setAttribute("inventory_part_no", request.getParameter("inventory_part_no"));
		request.setAttribute("emp_name", request.getParameter("emp_name"));
		request.setAttribute("inventory_type", request.getParameter("inventory_type"));
		
		try {
			if("1".equals(request.getParameter("inventory_type"))){
				request.getRequestDispatcher("view/ah/salesrecord.jsp").forward(request, response);
			}else if("3".equals(request.getParameter("inventory_type"))){
				request.getRequestDispatcher("view/ah/purchaserecord.jsp").forward(request, response);
			}else if("4".equals(request.getParameter("inventory_type"))){
				request.getRequestDispatcher("view/ah/deliveryrecord.jsp").forward(request, response);
			}
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
