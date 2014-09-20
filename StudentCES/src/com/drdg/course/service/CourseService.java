package com.drdg.course.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drdg.course.bean.CourseBean;
import com.drdg.course.dao.CourseDao;

public class CourseService {

	static private CourseDao courseDao = new CourseDao();
	
	
	static public void doInsertCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		CourseBean model = new CourseBean();
		model.setFk_cat_id(request.getParameter("fk_cat_id"));
		model.setCou_name(request.getParameter("cou_name"));
		model.setCou_remark(request.getParameter("cou_remark"));
		
		if(courseDao.doInsertCourse(model)){
			request.getRequestDispatcher("CourseServlet?type=courselist").forward(request, response);
		}else{
			System.out.println("error");
		}
	}
	
	static public void doDeleteCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if(courseDao.doDeleteCourse(request.getParameter("cou_id"))){
			request.getRequestDispatcher("CourseServlet?type=courselist").forward(request, response);
		}else{
			System.out.println("course delete error");
		}
	}
	
	static public void doUpdateCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		CourseBean model = new CourseBean();
		model.setCou_id(request.getParameter("cou_id"));
		model.setFk_cat_id(request.getParameter("fk_cat_id"));
		model.setCou_name(request.getParameter("cou_name"));
		model.setCou_remark(request.getParameter("cou_remark"));
		
		if(courseDao.doUpdateCourse(model)){
			request.getRequestDispatcher("CourseServlet?type=courselist").forward(request, response);
		}else{
			System.out.println("error");
		}
	}
	
	static public void doSelectCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("modelList", courseDao.doSelectCourse());
		request.getRequestDispatcher("view/course/courselist.jsp").forward(request, response);
	}

	public static void doSelectCourseById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("model", courseDao.doSelectCourseById(request.getParameter("cou_id")));
		request.getRequestDispatcher("view/course/courseupdate.jsp").forward(request, response);
	}
	
}
