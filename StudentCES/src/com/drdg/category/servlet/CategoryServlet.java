package com.drdg.category.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drdg.category.service.CategoryService;

public class CategoryServlet extends HttpServlet {

	private String type = "";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		type = request.getParameter("type");
		
		if("categorylist".equals(type)){
			CategoryService.doSelectCategory(request, response);
		}else if("categoryadd".equals(type)){
			CategoryService.doInsertCategory(request, response);
		}else if("categorydelete".equals(type)){
			CategoryService.doDeleteCategory(request, response);
		}else if("categoryupdate".equals(type)){
			CategoryService.doUpdateCategory(request, response);
		}
	}

}
