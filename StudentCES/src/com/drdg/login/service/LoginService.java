package com.drdg.login.service;

import java.io.IOException;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.drdg.login.bean.LoginBean;
import com.drdg.student.dao.StudentDao;
import com.drdg.user.dao.UserDao;

public class LoginService {

	static private UserDao userDao = new UserDao();
	static private StudentDao stuDao = new StudentDao();
	
	static public void doUserLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		LoginBean model = new LoginBean();
		model.setName(request.getParameter("name"));
		model.setPassword(request.getParameter("password"));
		
		LoginBean login = userDao.doLoginUser(model);
		
		if(!"".equals(login.getName()) && null != login.getName()){
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			System.out.println("user login error");
		}
		
	}

	static public void doStudentLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		LoginBean model = new LoginBean();
		model.setName(request.getParameter("name"));
		model.setPassword(request.getParameter("password"));
		LoginBean login = stuDao.doLoginStudent(model);
		
		if(!"".equals(login.getName()) && null != login.getName()){
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			System.out.println("user login error");
		}
		
	}
	
	static public void doLoginOut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("login", new LoginBean());
		request.getRequestDispatcher("view/login/login.jsp").forward(request, response);
	}

}
