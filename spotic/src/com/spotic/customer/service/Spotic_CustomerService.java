package com.spotic.customer.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spotic.customer.bean.Spotic_CustomerBean;
import com.spotic.customer.dao.Spotic_CustomerDao;
import com.stack.bean.PageBean;

public class Spotic_CustomerService {

	static private Spotic_CustomerDao customerDao = new Spotic_CustomerDao();
	
	public static void doInsertModel(HttpServletRequest request,
			HttpServletResponse response) {
		
		Spotic_CustomerBean customerBean = new Spotic_CustomerBean();
		
		customerBean.setCustomer_company(request.getParameter("customer_company"));
		customerBean.setCustomer_name(request.getParameter("customer_name"));
		customerBean.setCustomer_phone(request.getParameter("customer_phone"));
		customerBean.setCustomer_fax(request.getParameter("customer_fax"));
		customerBean.setCustomer_email(request.getParameter("customer_email"));
		customerBean.setCustomer_type(request.getParameter("customer_type"));
		customerBean.setCustomer_remarks(request.getParameter("customer_remarks"));
		
		if(customerDao.doInsertModel(customerBean)){
			try {
				request.getRequestDispatcher("Spotic_CustomerServlet?type=customerlist").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				request.setAttribute("error", "customer insert error");
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
		if(customerDao.doDeleteModelById(request.getParameter("customer_id"))){
			try {
				request.getRequestDispatcher("Spotic_CustomerServlet?type=customerlist").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				request.setAttribute("error", "customer delete error");
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
		Spotic_CustomerBean model = (Spotic_CustomerBean) customerDao.doSelectModelById(request.getParameter("customer_id"));
		request.setAttribute("model", model);
		try {
			request.getRequestDispatcher("view/customer/customerupdate.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void doUpdateModel(HttpServletRequest request,
			HttpServletResponse response) {
		
		Spotic_CustomerBean customerBean = new Spotic_CustomerBean();
		
		customerBean.setCustomer_id(request.getParameter("customer_id"));
		customerBean.setCustomer_company(request.getParameter("customer_company"));
		customerBean.setCustomer_name(request.getParameter("customer_name"));
		customerBean.setCustomer_phone(request.getParameter("customer_phone"));
		customerBean.setCustomer_fax(request.getParameter("customer_fax"));
		customerBean.setCustomer_email(request.getParameter("customer_email"));
		customerBean.setCustomer_type(request.getParameter("customer_type"));
		customerBean.setCustomer_remarks(request.getParameter("customer_remarks"));
		
		if(customerDao.doUpdateModel(customerBean)){
			try {
				request.getRequestDispatcher("Spotic_CustomerServlet?type=customerlist").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				request.setAttribute("error", "customer update error");
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
		pageBean.setFirstResult(request.getParameter("page"));
		request.setAttribute("page", null == request.getParameter("page")?"1":request.getParameter("page"));
		
		ArrayList<Spotic_CustomerBean> modelList = (ArrayList<Spotic_CustomerBean>) customerDao.doSelectModelList(pageBean);
		
		request.setAttribute("spotic_customer", modelList);
		try {
			request.getRequestDispatcher("view/customer/customerlist.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void doSelectModelListBySerachForLike(
			HttpServletRequest request, HttpServletResponse response) {

		PageBean pageBean = new PageBean(1);
		Spotic_CustomerBean customerBean = new Spotic_CustomerBean();
		customerBean.setCustomer_name(request.getParameter("customer_name"));
		
		ArrayList<Spotic_CustomerBean> modelList = (ArrayList<Spotic_CustomerBean>) customerDao.doSelectModelListBySerachForLike(pageBean, customerBean);
		
		request.setAttribute("spotic_customer", modelList);
		request.setAttribute("customer_name", request.getParameter("customer_name"));
		request.setAttribute("pageBean", pageBean);
		try {
			request.getRequestDispatcher("view/customer/customerlist.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
