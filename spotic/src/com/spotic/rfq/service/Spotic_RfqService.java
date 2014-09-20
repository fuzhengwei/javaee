package com.spotic.rfq.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spotic.customer.bean.Spotic_CustomerBean;
import com.spotic.customer.dao.Spotic_CustomerDao;
import com.spotic.emp.bean.Spotic_EmpBean;
import com.spotic.rfq.bean.Spotic_RfqBean;
import com.spotic.rfq.dao.Spotic_RfqDao;
import com.stack.bean.PageBean;
import com.stack.util.base.HandleBase;
import com.stack.util.date.DateUtil;
import com.stack.util.rsq.IReflctQueryDao;
import com.stack.util.rsq.ReflectQueryDao;

public class Spotic_RfqService extends HandleBase{

	private static IReflctQueryDao rqd = new ReflectQueryDao("com.spotic.rfq.bean.Spotic_RfqBean");
	private static Spotic_RfqDao dao = new Spotic_RfqDao();
	static private Spotic_CustomerDao customerDao = new Spotic_CustomerDao();
	@SuppressWarnings("unchecked")
	public static void doForInsertModel(HttpServletRequest request,
			HttpServletResponse response) {
		
		Spotic_RfqDao rfqDao = new Spotic_RfqDao();
		request.setAttribute("empList", rfqDao.doGetPurchaseEmpList());
//		request.setAttribute("customerList", rfqDao.doGetTwoTypeCustomer());
		try {
			request.getRequestDispatcher("view/rfq/rfqadd.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void doInsertModel(HttpServletRequest request,
			HttpServletResponse response) {

		//插入客户信息
		Spotic_CustomerBean customerBean = new Spotic_CustomerBean();
		customerBean.setCustomer_company(request.getParameter("customer_company"));
		customerBean.setCustomer_name(request.getParameter("customer_name"));
		customerBean.setCustomer_phone(request.getParameter("customer_phone"));
		customerBean.setCustomer_fax(request.getParameter("customer_fax"));
		customerBean.setCustomer_email(request.getParameter("customer_email"));
		customerBean.setCustomer_type(request.getParameter("customer_type"));
		customerBean.setCustomer_remarks(request.getParameter("customer_remarks"));
		if(customerDao.doInsertModel(customerBean)){
			ArrayList<Spotic_CustomerBean> cu = (ArrayList<Spotic_CustomerBean>) customerDao.doSelectModelListBySerach(new PageBean(1, 1), customerBean);
			Spotic_RfqBean rfqBean = new Spotic_RfqBean();
			rfqBean.setFk_apa_emp_id(request.getParameter("fk_apa_emp_id"));
			rfqBean.setFk_customer_id(cu.get(0).getCustomer_id());
			rfqBean.setFk_ppa_emp_id(request.getParameter("fk_ppa_emp_id"));
			rfqBean.setFk_sp_emp_id(request.getParameter("fk_sp_emp_id"));
			rfqBean.setRfq_alternative(request.getParameter("rfq_alternative"));
			rfqBean.setRfq_cost(request.getParameter("rfq_cost"));
			rfqBean.setRfq_cust_part_no(request.getParameter("rfq_cust_part_no"));
			rfqBean.setRfq_dc(request.getParameter("rfq_dc"));
			rfqBean.setRfq_internal(request.getParameter("rfq_internal"));
			rfqBean.setRfq_mfg(request.getParameter("rfq_mfg"));
			rfqBean.setRfq_packaging(request.getParameter("rfq_packaging"));
			rfqBean.setRfq_part_no(request.getParameter("rfq_part_no"));
			rfqBean.setRfq_quantity(request.getParameter("rfq_quantity"));
			rfqBean.setRfq_resale(request.getParameter("rfq_resale"));
			rfqBean.setRfq_routing_history(request.getParameter("rfq_routing_history"));
			rfqBean.setRfq_state("1");//[1预备采购、2开始采购、3采购完成、4异常关闭]
			rfqBean.setRfq_target_price(request.getParameter("rfq_target_price"));
			rfqBean.setRfq_loc(request.getParameter("rfq_loc"));
			rfqBean.setRfq_date(DateUtil.getNow());
			rfqBean.setRfq_dock_date(request.getParameter("rfq_dock_date"));
			
			if(rqd.doInsertModel(rfqBean)){
				try {
					request.getRequestDispatcher("Spotic_RfqServlet?type=rfqlist").forward(request, response);
					
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				try {
					request.setAttribute("error", "rfq insert error");
					request.getRequestDispatcher("error/error.jsp").forward(request, response);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ServletException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void doSelectModelListByMoreTable(HttpServletRequest request,
			HttpServletResponse response){
		
		PageBean pageBean = new PageBean();
		pageBean.setFirstResult(request.getParameter("page"));
		pageBean.setPageNow(null == request.getParameter("page")?"1":request.getParameter("page"));
		pageBean.setPageNum(dao.doSelectCount());
		
		request.setAttribute("page", null == request.getParameter("page")?"1":request.getParameter("page"));
		request.setAttribute("pageBean", pageBean);
		
		request.setAttribute("modelList", dao.doSelectModelListByMoreTable(pageBean));
		try {
			request.getRequestDispatcher("view/rfq/rfqlist.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void doSelectModelList(HttpServletRequest request,
			HttpServletResponse response) {

		PageBean pageBean = new PageBean();
		pageBean.setFirstResult(request.getParameter("page"));
		request.setAttribute("page", null == request.getParameter("page")?"1":request.getParameter("page"));
		
		ArrayList<Spotic_RfqBean> rfqList = (ArrayList<Spotic_RfqBean>) rqd.doSelectModelList(pageBean);
		
		try {
			request.setAttribute("modelList", rfqList);
			request.getRequestDispatcher("view/rfq/rfqlist.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void doForUpdateModel(HttpServletRequest request,
			HttpServletResponse response) {
		
		Spotic_RfqBean rfqBean = (Spotic_RfqBean) rqd.doSelectModelById(request.getParameter("rfq_id"));
		request.setAttribute("rfqBean", rfqBean);
		
		Spotic_RfqDao rfqDao = new Spotic_RfqDao();
		request.setAttribute("empList", rfqDao.doGetPurchaseEmpList());
		request.setAttribute("customerList", rfqDao.doGetTwoTypeCustomer());
		
		try {
			request.getRequestDispatcher("view/rfq/rfqupdate.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void doUpdateModel(HttpServletRequest request,
			HttpServletResponse response) {
		
		Spotic_RfqBean rfqBean = new Spotic_RfqBean();
		rfqBean.setRfq_id(request.getParameter("rfq_id"));
		rfqBean.setFk_apa_emp_id(request.getParameter("fk_apa_emp_id"));
		rfqBean.setFk_customer_id(request.getParameter("fk_customer_id"));
		rfqBean.setFk_ppa_emp_id(request.getParameter("fk_ppa_emp_id"));
		rfqBean.setFk_sp_emp_id(request.getParameter("fk_sp_emp_id"));
		rfqBean.setRfq_alternative(request.getParameter("rfq_alternative"));
		rfqBean.setRfq_cost(request.getParameter("rfq_cost"));
		rfqBean.setRfq_cust_part_no(request.getParameter("rfq_cust_part_no"));
		rfqBean.setRfq_dc(request.getParameter("rfq_dc"));
		rfqBean.setRfq_internal(request.getParameter("rfq_internal"));
		rfqBean.setRfq_mfg(request.getParameter("rfq_mfg"));
		rfqBean.setRfq_packaging(request.getParameter("rfq_packaging"));
		rfqBean.setRfq_part_no(request.getParameter("rfq_part_no"));
		rfqBean.setRfq_quantity(request.getParameter("rfq_quantity"));
		rfqBean.setRfq_resale(request.getParameter("rfq_resale"));
		rfqBean.setRfq_routing_history(request.getParameter("rfq_routing_history"));
		rfqBean.setRfq_state(request.getParameter("rfq_state"));//[1预备采购、2开始采购、3采购完成、4异常关闭]
		rfqBean.setRfq_target_price(request.getParameter("rfq_target_price"));
		rfqBean.setRfq_loc(request.getParameter("rfq_loc"));
		rfqBean.setRfq_date(DateUtil.getNow());
		rfqBean.setRfq_dock_date(request.getParameter("rfq_dock_date"));
		
		if(rqd.doUpdateModel(rfqBean)){
			try {
				request.getRequestDispatcher("Spotic_RfqServlet?type=rfqlist").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				request.setAttribute("error", "rfq update error");
				request.getRequestDispatcher("error/error.jsp").forward(request, response);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
	}

	public static void doSelectModelListBySerachForLike(
			HttpServletRequest request, HttpServletResponse response) {
	}

	public static void doDeleteModelById(HttpServletRequest request,
			HttpServletResponse response) {

		if(rqd.doDeleteModelById(request.getParameter("rfq_id"))){
			try {
				request.getRequestDispatcher("Spotic_RfqServlet?type=rfqlist").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				request.setAttribute("error", "rfq delete error");
				request.getRequestDispatcher("error/error.jsp").forward(request, response);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void doSelectModelListByMoreTableBySerachForLike(
			HttpServletRequest request, HttpServletResponse response) {

		PageBean pageBean = new PageBean();
		pageBean.setFirstResult(request.getParameter("page"));
		request.setAttribute("page", null == request.getParameter("page")?"1":request.getParameter("page"));
		
		try {
			request.setAttribute("modelList", dao.doSelectModelListByMoreTableBySerachForLike(pageBean,request.getParameter("rfq_part_no")));
			request.setAttribute("rfq_part_no", request.getParameter("rfq_part_no"));
			request.getRequestDispatcher("view/rfq/rfqlist.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
