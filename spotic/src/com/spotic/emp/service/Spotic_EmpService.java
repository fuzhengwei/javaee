package com.spotic.emp.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spotic.emp.bean.Spotic_EmpBean;
import com.spotic.emp.dao.Spotic_EmpDao;
import com.stack.bean.PageBean;
import com.stack.util.date.DateUtil;

public class Spotic_EmpService {

	static private Spotic_EmpDao empDao = new Spotic_EmpDao();
	
	static public void doLogin(HttpServletRequest request, HttpServletResponse response){
		
		
		Spotic_EmpBean empBean = new Spotic_EmpBean();
		empBean.setEmp_name(request.getParameter("emp_name"));
		empBean.setEmp_pwd(request.getParameter("emp_pwd"));
		
		ArrayList<Spotic_EmpBean> empList = (ArrayList<Spotic_EmpBean>) empDao.doSelectModelListBySerach(new PageBean(), empBean);
		if(0 != empList.size()){
			request.getSession().setAttribute("spotic_emp", empList.get(0));
			try {
				response.sendRedirect("index.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				request.setAttribute("error", "emp inventory login error");
				request.getRequestDispatcher("error/error.jsp").forward(request, response);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void doSelectModelList(HttpServletRequest request,
			HttpServletResponse response) {
		
		PageBean pageBean = new PageBean();
		pageBean.setFirstResult(null == request.getParameter("page")?1:Integer.parseInt(request.getParameter("page")));
		request.setAttribute("page", null == request.getParameter("page")?"1":request.getParameter("page"));
		
		ArrayList<Spotic_EmpBean> empList = (ArrayList<Spotic_EmpBean>) empDao.doSelectModelList(pageBean);
		request.setAttribute("modelList", empList);
		
		try {
			request.getRequestDispatcher("view/emp/emplist.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void doInsertModel(HttpServletRequest request,
			HttpServletResponse response) {

		Spotic_EmpBean empBean = new Spotic_EmpBean();
		
		empBean.setEmp_name(request.getParameter("emp_name"));
		empBean.setEmp_pwd(request.getParameter("emp_pwd"));
		empBean.setEmp_phone(request.getParameter("emp_phone"));
		empBean.setEmp_createdate(DateUtil.getNow());
		empBean.setEmp_power(request.getParameter("emp_power"));
		empBean.setEmp_state(request.getParameter("emp_state"));
		empBean.setEmp_i18n(request.getParameter("emp_i18n"));
		empBean.setEmp_remarks(request.getParameter("emp_remarks"));
		
		if(empDao.doInsertModel(empBean)){
			try {
				request.getRequestDispatcher("Spotic_EmpServlet?type=emplist").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				request.setAttribute("error", "emp insert error");
				request.getRequestDispatcher("error/error.jsp").forward(request, response);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void doDeleteModelById(HttpServletRequest request,
			HttpServletResponse response) {
		
		if(empDao.doDeleteModelById(request.getParameter("emp_id"))){
			try {
				request.getRequestDispatcher("Spotic_EmpServlet?type=emplist").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				request.setAttribute("error", "emp delete error");
				request.getRequestDispatcher("error/error.jsp").forward(request, response);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void doForUpdateModel(HttpServletRequest request,
			HttpServletResponse response) {

		request.setAttribute("model", empDao.doSelectModelById(request.getParameter("emp_id")));
		
		try {
			request.getRequestDispatcher("view/emp/empupdate.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void doUpdateModel(HttpServletRequest request,
			HttpServletResponse response) {

		Spotic_EmpBean empBean = new Spotic_EmpBean();
		
		empBean.setEmp_id(request.getParameter("emp_id"));
		empBean.setEmp_name(request.getParameter("emp_name"));
		empBean.setEmp_pwd(request.getParameter("emp_pwd"));
		empBean.setEmp_phone(request.getParameter("emp_phone"));
		empBean.setEmp_createdate(DateUtil.getNow());
		empBean.setEmp_power(request.getParameter("emp_power"));
		empBean.setEmp_state(request.getParameter("emp_state"));
		empBean.setEmp_i18n(request.getParameter("emp_i18n"));
		empBean.setEmp_remarks(request.getParameter("emp_remarks"));
		
		if(empDao.doUpdateModel(empBean)){
			try {
				HttpSession session = request.getSession();
				Spotic_EmpBean empSessionBean = (Spotic_EmpBean) session.getAttribute("spotic_emp");
				
				if(null != empSessionBean){
					
					if("1".equals(empSessionBean.getEmp_power())){
						request.getRequestDispatcher("Spotic_EmpServlet?type=emplist").forward(request, response);
					}else {
						//销毁session，退出登录
						session.removeAttribute("spotic_emp");
						//退出到登录页面
						response.sendRedirect("login/login.jsp");
					}
				}
			
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				request.setAttribute("error", "emp update error");
				request.getRequestDispatcher("error/error.jsp").forward(request, response);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void doLoginOut(HttpServletRequest request,
			HttpServletResponse response) {
		
		request.getSession().removeAttribute("spotic_emp");
		
		try {
			response.sendRedirect("login/login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void doSelectModelListBySerachForLike(
			HttpServletRequest request, HttpServletResponse response) {

		PageBean pageBean = new PageBean(1);
		Spotic_EmpBean empBean = new Spotic_EmpBean();
		empBean.setEmp_name(request.getParameter("emp_name"));
		empBean.setEmp_power(request.getParameter("emp_power"));
		
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("modelList", empDao.doSelectModelListBySerachForLike(pageBean, empBean));
		request.setAttribute("emp_name", request.getParameter("emp_name"));
		try {
			request.getRequestDispatcher("view/emp/emplist.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
