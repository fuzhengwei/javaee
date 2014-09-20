package com.spotic.ei.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spotic.ei.bean.Spotic_Emp_InventoryBean;
import com.spotic.ei.bean.V_EIBean;
import com.spotic.ei.dao.Spotic_Emp_InventoryDao;
import com.stack.bean.PageBean;
import com.stack.util.date.DateUtil;

public class Spotic_Emp_InventoryService {

	private static Spotic_Emp_InventoryDao dao = new Spotic_Emp_InventoryDao();
	
	public static void doEiForAdd(HttpServletRequest request,
			HttpServletResponse response) {
		
		request.setAttribute("inventory_part_no", request.getParameter("inventory_part_no"));
		request.setAttribute("inventory_id", request.getParameter("inventory_id"));
		request.setAttribute("empList", dao.doGetPurchaseEmpList());
		request.setAttribute("inventory_type", request.getParameter("inventory_type"));
		
		try {
			request.getRequestDispatcher("view/ei/eiadd.jsp").forward(request, response);
			
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void doInsertModel(HttpServletRequest request,
			HttpServletResponse response) {

		Spotic_Emp_InventoryBean eiBean = new Spotic_Emp_InventoryBean();
		eiBean.setFk_emp_id(request.getParameter("fk_emp_id"));
		eiBean.setFk_inventory_id(request.getParameter("fk_inventory_id"));
		String ei_state = request.getParameter("ei_state");
		if("1".equals(ei_state)){
			eiBean.setEi_date_1(DateUtil.getNow());
		}else if("2".equals(ei_state)){
			eiBean.setEi_date_2(DateUtil.getNow());
		}else if("3".equals(ei_state)){
			eiBean.setEi_date_3(DateUtil.getNow());
		}else if("4".equals(ei_state)){
			eiBean.setEi_date_4(DateUtil.getNow());
		}
		eiBean.setEi_state(ei_state);
		eiBean.setEi_remarks(request.getParameter("ei_remarks"));
		
		if(dao.doInsertModel(eiBean)){
			
			//更新spotic_inventory表内字段
			dao.doUpdateInventory("1", request.getParameter("fk_inventory_id"));
			
			try {
				request.getRequestDispatcher("Spotic_InventoryServlet?type=inventoryselectmodellist_t1&inventory_type="+request.getParameter("inventory_type")).forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else{
			try {
				response.sendRedirect("error/error.jsp?error=emp inventory insert error");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void doSelectEI(HttpServletRequest request,
			HttpServletResponse response) {

		PageBean pageBean = new PageBean();
		pageBean.setFirstResult(request.getParameter("page"));
		request.setAttribute("page", null == request.getParameter("page")?"1":request.getParameter("page"));
		
		ArrayList<V_EIBean> modelList = (ArrayList<V_EIBean>) dao.doSelectEIList(pageBean);
		request.setAttribute("modelList", modelList);
		
		try {
			request.getRequestDispatcher("view/ei/eilist.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void doForUpdate(HttpServletRequest request,
			HttpServletResponse response) {

		request.setAttribute("ei_id", request.getParameter("ei_id"));
		request.setAttribute("emp_name", request.getParameter("emp_name"));
		request.setAttribute("inventory_part_no", request.getParameter("inventory_part_no"));
		request.setAttribute("ei_state", request.getParameter("ei_state"));
		request.setAttribute("ei_remarks", request.getParameter("ei_remarks"));
		
		try {
			request.getRequestDispatcher("view/ei/eiupdate.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void doUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		boolean bool = false;
		Spotic_Emp_InventoryBean eiBean = new Spotic_Emp_InventoryBean();
		eiBean.setEi_id(request.getParameter("ei_id"));
		String ei_state = request.getParameter("ei_state");
		eiBean.setEi_state(ei_state);
		eiBean.setEi_remarks(request.getParameter("ei_remarks"));
		if("1".equals(ei_state)){
			eiBean.setEi_date_1(DateUtil.getNow());
			bool = dao.doUpdate_1(eiBean);
		}else if("2".equals(ei_state)){
			eiBean.setEi_date_2(DateUtil.getNow());
			bool = dao.doUpdate_2(eiBean);
		}else if("3".equals(ei_state)){
			eiBean.setEi_date_3(DateUtil.getNow());
			bool = dao.doUpdate_3(eiBean);
		}else if("4".equals(ei_state)){
			eiBean.setEi_date_4(DateUtil.getNow());
			bool = dao.doUpdate_4(eiBean);
		}
	
		if(bool){
			try {
				request.getRequestDispatcher("Spotic_Emp_InventoryServlet?type=eiselect").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				request.setAttribute("error", "emp inventory update error");
				request.getRequestDispatcher("error/error.jsp").forward(request, response);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void doDeleteById(HttpServletRequest request,
			HttpServletResponse response) {

		if(dao.doDeleteModelById(request.getParameter("ei_id"))){
			try {
				
				dao.doUpdateInventory("0", request.getParameter("fk_inventory_id"));
				
				request.getRequestDispatcher("Spotic_Emp_InventoryServlet?type=eiselect").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				request.setAttribute("error", "emp inventory delete error");
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

		PageBean pageBean = new PageBean();
		pageBean.setFirstResult(request.getParameter("page"));
		request.setAttribute("page", null == request.getParameter("page")?"1":request.getParameter("page"));
		
		V_EIBean eiBean = new V_EIBean();
		eiBean.setInventory_part_no(request.getParameter("inventory_part_no"));
		eiBean.setInventory_type(request.getParameter("inventory_type"));
		eiBean.setEi_date_1(request.getParameter("ei_date"));
		eiBean.setEi_date_2(request.getParameter("ei_date"));
		eiBean.setEi_date_3(request.getParameter("ei_date"));
		eiBean.setEi_date_4(request.getParameter("ei_date"));
		eiBean.setEi_state(request.getParameter("ei_state"));
		
		request.setAttribute("modelList", dao.doSelectModelListBySerachForLike(pageBean, eiBean));
		
		try {
			request.getRequestDispatcher("view/ei/eilist.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
