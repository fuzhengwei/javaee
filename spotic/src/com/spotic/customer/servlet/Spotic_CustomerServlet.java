package com.spotic.customer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spotic.customer.service.Spotic_CustomerService;

public class Spotic_CustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		
		if("customeradd".equals(type)){
			Spotic_CustomerService.doInsertModel(request,response);
		}else if("customerdelete".equals(type)){
			Spotic_CustomerService.doDeleteModelById(request,response);
		}else if("customerforupdate".equals(type)){
			Spotic_CustomerService.doForUpdateModel(request,response);
		}else if("customerupdate".equals(type)){
			Spotic_CustomerService.doUpdateModel(request,response);
		}else if("customerlist".equals(type)){
			Spotic_CustomerService.doSelectModelList(request,response);
		}else if("empselectserach".equals(type)){
			Spotic_CustomerService.doSelectModelListBySerachForLike(request,response);
		}
	}

}
