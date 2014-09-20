package com.drdg.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drdg.course.service.CourseService;

public class CourseServlet extends HttpServlet {

	private String type = "";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		type = request.getParameter("type");
		
		if ("courselist".equals(type)) {
			CourseService.doSelectCourse(request, response);
		} else if ("courseadd".equals(type)) {
			CourseService.doInsertCourse(request, response);
		} else if ("coursedelete".equals(type)) {
			CourseService.doDeleteCourse(request, response);
		} else if ("courseupdate".equals(type)) {
			CourseService.doUpdateCourse(request, response);
		} else if("coursebean".equals(type)){
			CourseService.doSelectCourseById(request, response);
		}
	}

}
