package com.spotic.ei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spotic.ei.service.Spotic_Emp_InventoryService;

public class Spotic_Emp_InventoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String type = request.getParameter("type");
		
		if("eiforadd".equals(type)){
			Spotic_Emp_InventoryService.doEiForAdd(request,response);
		}else if("eiadd".equals(type)){
			Spotic_Emp_InventoryService.doInsertModel(request,response);
		}else if("eidelete".equals(type)){
			Spotic_Emp_InventoryService.doDeleteById(request,response);
		}else if("eiforupdate".equals(type)){
			Spotic_Emp_InventoryService.doForUpdate(request,response);
		}else if("eiupdate".equals(type)){
			Spotic_Emp_InventoryService.doUpdate(request,response);
		}else if("eiselect".equals(type)){
			Spotic_Emp_InventoryService.doSelectEI(request,response);
		}else if("empselectserach".equals(type)){
			Spotic_Emp_InventoryService.doSelectModelListBySerachForLike(request,response);
		}
		
	}

}
