package com.drdg.category.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drdg.category.bean.CategoryBean;
import com.drdg.category.dao.CategoryDao;

public class CategoryService {

	static private CategoryDao categoryDao = new CategoryDao();
	
	static public void doSelectCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("modelList", categoryDao.doSelectCategory());
		request.getRequestDispatcher("view/category/categorylist.jsp").forward(request, response);
	}
	
	static public void doInsertCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		CategoryBean model = new CategoryBean();
		model.setCat_name(request.getParameter("cat_name"));
		model.setCat_weight(request.getParameter("cat_weight"));
		model.setCat_remark(request.getParameter("cat_remark"));
		
		if(categoryDao.doInsertCategory(model)){
			request.getRequestDispatcher("CategoryServlet?type=categorylist").forward(request, response);
		}else{
			System.out.println("error");
		}
	}
	
	static public void doDeleteCategory(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	static public void doUpdateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if("update_one".equals(request.getParameter("update_"))){
			request.setAttribute("model", categoryDao.doSelectCategoryById(request.getParameter("cat_id")));
			request.getRequestDispatcher("view/category/categoryupdate.jsp").forward(request, response);
			
		}else if("update_two".equals(request.getParameter("update_"))){
			CategoryBean model = new CategoryBean();
			model.setCat_id(request.getParameter("cat_id"));
			model.setCat_name(request.getParameter("cat_name"));
			model.setCat_weight(request.getParameter("cat_weight"));
			model.setCat_remark(request.getParameter("cat_remark"));
			if(categoryDao.doUpdateCategory(model)){
				request.getRequestDispatcher("CategoryServlet?type=categorylist").forward(request, response);
			}else{
				System.out.println("ÐÞ¸ÄÊ§°Ü");
			}
		}
	}
	
}
