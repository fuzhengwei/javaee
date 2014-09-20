package com.drdg.student.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drdg.student.bean.StudentBean;
import com.drdg.student.dao.StudentDao;

public class StudentService {

	static public void doUpdateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		StudentBean stuBean = new StudentBean();
		stuBean.setStu_pwd(request.getParameter("stu_pwd"));
		stuBean.setStu_name(request.getParameter("stu_name"));
		stuBean.setStu_sex(request.getParameter("stu_sex"));
		stuBean.setStu_birthday(request.getParameter("stu_birthday"));
		stuBean.setStu_nation(request.getParameter("stu_nation"));
		stuBean.setStu_pa(request.getParameter("stu_pa"));
		stuBean.setStu_pro_number(request.getParameter("stu_pro_number"));
		stuBean.setStu_class_number(request.getParameter("stu_class_number"));
		stuBean.setStu_bedroom_number(request.getParameter("stu_bedroom_number"));
		stuBean.setStu_contact(request.getParameter("stu_contact"));
		stuBean.setStu_id(request.getParameter("stu_id"));
		
		StudentDao stuDao = new StudentDao();
		
		if(stuDao.doUpdateStudent(stuBean)){
			request.getRequestDispatcher("StudentServlet?type=studentlist&w=1").forward(request, response);
		}else{
			System.out.println("student update error");
		}
	}
	
	static public void doDeleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		StudentDao stuDao = new StudentDao();
		
		if(stuDao.doDeleteStudent(request.getParameter("stu_id"))){
			request.getRequestDispatcher("StudentServlet?type=studentlist&w=1").forward(request, response);
		}else{
			System.out.println("delete error");
		}
	}
	
	static public void doSelectStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		StudentDao stuDao = new StudentDao();
		request.setAttribute("modelList", stuDao.doSelectStudent());
		if("0".equals(request.getParameter("w"))){
			request.getRequestDispatcher("view/student/studentlist2.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("view/student/studentlist.jsp").forward(request, response);
		}
		
		
	}
	
	static public void doInsertStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		StudentBean stuBean = new StudentBean();
		
		stuBean.setStu_name(request.getParameter("stu_name"));
		stuBean.setStu_sex(request.getParameter("stu_sex"));
		stuBean.setStu_birthday(request.getParameter("stu_birthday"));
		stuBean.setStu_nation(request.getParameter("stu_nation"));
		stuBean.setStu_pa(request.getParameter("stu_pa"));
		stuBean.setStu_pro_number(request.getParameter("stu_pro_number"));
		stuBean.setStu_class_number(request.getParameter("stu_class_number"));
		stuBean.setStu_bedroom_number(request.getParameter("stu_bedroom_number"));
		stuBean.setStu_contact(request.getParameter("stu_contact"));
		stuBean.setStu_pwd(request.getParameter("stu_pwd"));
		
		StudentDao stuDao = new StudentDao();
		
		if(stuDao.doInsertStudent(stuBean)){
			request.getRequestDispatcher("StudentServlet?type=studentlist&w=1").forward(request, response);
		}else{
			System.out.println("insert error");
		}
		
	}

	public static void doSelectStudentById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		StudentDao stuDao = new StudentDao();
		request.setAttribute("model", stuDao.doSelectStudentById(request.getParameter("stu_id")));
		request.getRequestDispatcher("view/student/studentupdate.jsp").forward(request, response);
	}
	
	
	
}
