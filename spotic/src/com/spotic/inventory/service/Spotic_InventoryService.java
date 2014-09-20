package com.spotic.inventory.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spotic.customer.dao.Spotic_CustomerDao;
import com.spotic.inventory.bean.Spotic_InventoryBean;
import com.spotic.inventory.bean.V_Spotic_Customer_InventoryBean;
import com.spotic.inventory.dao.Spotic_InventoryDao;
import com.stack.bean.PageBean;
import com.stack.util.date.DateUtil;

public class Spotic_InventoryService{

	private static Spotic_InventoryDao dao = new Spotic_InventoryDao();
	
	public static void doInventoryForAdd(HttpServletRequest request,
			HttpServletResponse response) {
		
		request.setAttribute("customerList", dao.doSelectModelByType(request.getParameter("customer_type")));
		request.setAttribute("customer_type", request.getParameter("customer_type"));
		
		try {
			request.getRequestDispatcher("view/inventory/inventoryadd.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void doInventoryAdd(HttpServletRequest request,
			HttpServletResponse response) {
		Spotic_InventoryBean inventoryBean = new Spotic_InventoryBean();
		inventoryBean.setFk_customer_id(request.getParameter("fk_customer_id"));
		inventoryBean.setInventory_cost(request.getParameter("inventory_cost"));
		inventoryBean.setInventory_date(DateUtil.getNow());
		inventoryBean.setInventory_dc(request.getParameter("inventory_dc"));
		inventoryBean.setInventory_loc(request.getParameter("inventory_loc"));
		inventoryBean.setInventory_lt(request.getParameter("inventory_lt"));
		inventoryBean.setInventory_mfg(request.getParameter("inventory_mfg"));
		inventoryBean.setInventory_part_no(request.getParameter("inventory_part_no"));
		inventoryBean.setInventory_remarks(request.getParameter("inventory_remarks"));
		inventoryBean.setInventory_state(request.getParameter("inventory_state"));
		inventoryBean.setInventory_allto_state(request.getParameter("inventory_allto_state"));
		inventoryBean.setInventory_type(request.getParameter("inventory_type"));
		
		if(dao.doInsertModel(inventoryBean)){
			try {
				request.getRequestDispatcher("Spotic_InventoryServlet?type=inventoryselectmodellist_t1&&inventory_type="+request.getParameter("inventory_type")).forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				request.setAttribute("error", "inventory insert error");
				request.getRequestDispatcher("error/error.jsp").forward(request, response);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void doSelectModelList_T1(HttpServletRequest request,
			HttpServletResponse response) {
		
		PageBean pageBean = new PageBean();
		pageBean.setFirstResult(request.getParameter("page"));
		request.setAttribute("page", null == request.getParameter("page")?"1":request.getParameter("page"));
		
		V_Spotic_Customer_InventoryBean sci = new V_Spotic_Customer_InventoryBean();
		sci.setInventory_type(request.getParameter("inventory_type"));
		
		ArrayList<V_Spotic_Customer_InventoryBean> vsci =  (ArrayList<V_Spotic_Customer_InventoryBean>) dao.doSelectModelListT1ByType(sci,pageBean);
		request.setAttribute("modelList", vsci);
		request.setAttribute("inventory_type", request.getParameter("inventory_type"));
		try {
			request.getRequestDispatcher("view/inventory/inventorylist_t1.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void doDeleteModelById(HttpServletRequest request,
			HttpServletResponse response) {

		if(dao.doDeleteModelById(request.getParameter("inventory_id"))){
			try {
				request.getRequestDispatcher("Spotic_InventoryServlet?type=inventoryselectmodellist_t1&&inventory_type="+request.getParameter("inventory_type")).forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				request.setAttribute("error", "inventory delete error");
				request.getRequestDispatcher("error/error.jsp").forward(request, response);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void doUpdateModel(HttpServletRequest request,
			HttpServletResponse response) {
		
		Spotic_InventoryBean inventoryBean = new Spotic_InventoryBean();
		inventoryBean.setFk_customer_id(request.getParameter("fk_customer_id"));
		inventoryBean.setInventory_cost(request.getParameter("inventory_cost"));
		inventoryBean.setInventory_date(DateUtil.getNow());
		inventoryBean.setInventory_dc(request.getParameter("inventory_dc"));
		inventoryBean.setInventory_loc(request.getParameter("inventory_loc"));
		inventoryBean.setInventory_lt(request.getParameter("inventory_lt"));
		inventoryBean.setInventory_mfg(request.getParameter("inventory_mfg"));
		inventoryBean.setInventory_part_no(request.getParameter("inventory_part_no"));
		inventoryBean.setInventory_remarks(request.getParameter("inventory_remarks"));
		inventoryBean.setInventory_state(request.getParameter("inventory_state"));
		inventoryBean.setInventory_type(request.getParameter("inventory_type"));
		inventoryBean.setInventory_allto_state(request.getParameter("inventory_allto_state"));
		inventoryBean.setInventory_id(request.getParameter("inventory_id"));
		
		if(dao.doUpdateModel(inventoryBean)){
			try {
				request.getRequestDispatcher("Spotic_InventoryServlet?type=inventoryselectmodellist_t1&&inventory_type="+request.getParameter("inventory_type")).forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				request.setAttribute("error", "inventory update error");
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

		Spotic_CustomerDao customerDao = new Spotic_CustomerDao();
		
		Spotic_InventoryBean model = (Spotic_InventoryBean) dao.doSelectModelById(request.getParameter("inventory_id"));
		request.setAttribute("model", model);
		request.setAttribute("customerList", dao.doSelectModelByType(request.getParameter("inventory_type")));
//		request.setAttribute("customer", customerDao.doSelectModelById(model.getFk_customer_id()));
		try {
			request.getRequestDispatcher("view/inventory/inventoryupdate.jsp?inventory_type="+request.getParameter("inventory_type")).forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void doSelectModelListBySerachForLike(
			HttpServletRequest request, HttpServletResponse response) {
		
		V_Spotic_Customer_InventoryBean sci = new V_Spotic_Customer_InventoryBean();
		sci.setInventory_type(request.getParameter("inventory_type"));
		sci.setInventory_part_no(request.getParameter("inventory_part_no"));
		
		PageBean pageBean = new PageBean();
		pageBean.setFirstResult(request.getParameter("page"));
		request.setAttribute("page", null == request.getParameter("page")?"1":request.getParameter("page"));

		ArrayList<V_Spotic_Customer_InventoryBean> modelList = (ArrayList<V_Spotic_Customer_InventoryBean>) dao.doSelectModelListBySerachForLike(pageBean, sci);
		request.setAttribute("modelList", modelList);
		request.setAttribute("inventory_part_no", request.getParameter("inventory_part_no"));
		try {
			request.getRequestDispatcher("view/inventory/inventorylist_t1.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
