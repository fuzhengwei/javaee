package com.drdg.user.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drdg.user.bean.UserBean;
import com.drdg.user.dao.UserDao;

public class UserService {

	static private UserDao userDao = new UserDao();

	/**
	 * 获取用户列表
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	static public void doSelectUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		UserDao userDao = new UserDao();
		request.setAttribute("modelList", userDao.doSelectUser());
		request.getRequestDispatcher("view/user/userlist.jsp").forward(request,
				response);

	}

	static public void doDelteUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (userDao.doDeleteUser(request.getParameter("user_id"))) {
			request.getRequestDispatcher("UserServlet?type=userlist").forward(
					request, response);
		} else {
			System.out.println("delete error");
		}
	}

	static public void doInsertUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserBean model = new UserBean();
		model.setUser_name(request.getParameter("user_name"));
		model.setUser_password(request.getParameter("user_password"));
		model.setUser_jur(request.getParameter("user_jur"));
		model.setUser_contact(request.getParameter("user_contact"));
		if (userDao.doInsertUser(model)) {
			request.getRequestDispatcher("UserServlet?type=userlist").forward(
					request, response);
		} else {
			System.out.println("user insert error!");
		}
	}

	static public void doUpdateUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserBean model = new UserBean();
		model.setUser_id(request.getParameter("user_id"));
		model.setUser_name(request.getParameter("user_name"));
		model.setUser_password(request.getParameter("user_password"));
		model.setUser_jur(request.getParameter("user_jur"));
		model.setUser_contact(request.getParameter("user_contact"));
		
		if(userDao.doUpdateUser(model)){
			request.getRequestDispatcher("UserServlet?type=userlist").forward(
					request, response);
		}else{
			System.out.println("user update error!");
		}
	}

	static public void doSelectUserById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("model", userDao.doSelectUserById(request.getParameter("user_id")));
		request.getRequestDispatcher("view/user/userupdate.jsp").forward(
				request, response);
	}
}
