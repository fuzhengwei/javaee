package com.drdg.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drdg.student.service.StudentService;

public class StudentServlet extends HttpServlet {

	private String type = "";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		type = request.getParameter("type");
		
		if("studentlist".equals(type)){
			StudentService.doSelectStudent(request, response);
		}else if("studentadd".equals(type)){
			StudentService.doInsertStudent(request, response);
		}else if("deletestudent".equals(type)){
			StudentService.doDeleteStudent(request, response);
		}else if("studentupdate".equals(type)){
			StudentService.doUpdateStudent(request, response);
		}else if("userupdate_1".equals(type)){
			StudentService.doSelectStudentById(request, response);
		}
	}

}
