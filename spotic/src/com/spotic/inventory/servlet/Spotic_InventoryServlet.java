package com.spotic.inventory.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spotic.inventory.service.Spotic_InventoryService;

public class Spotic_InventoryServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String type = request.getParameter("type");
	
		if("inventoryforadd".equals(type)){
			Spotic_InventoryService.doInventoryForAdd(request,response);
		}else if("inventoryadd".equals(type)){
			Spotic_InventoryService.doInventoryAdd(request, response);
		}else if("inventorydelete".equals(type)){
			Spotic_InventoryService.doDeleteModelById(request,response);
		}else if("inventoryforupdate".equals(type)){
			Spotic_InventoryService.doForUpdateModel(request,response);
		}else if("inventoryupdate".equals(type)){
			Spotic_InventoryService.doUpdateModel(request,response);
		}else if("inventoryselectmodellist_t1".equals(type)){
			Spotic_InventoryService.doSelectModelList_T1(request,response);
		}else if("empselectserach".equals(type)){
			Spotic_InventoryService.doSelectModelListBySerachForLike(request,response);
		}
	}

}
