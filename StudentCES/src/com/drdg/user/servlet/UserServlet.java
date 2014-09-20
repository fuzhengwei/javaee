package com.drdg.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drdg.user.service.UserService;

public class UserServlet extends HttpServlet {

	//接收到操作类型
	private String type = "";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		type = request.getParameter("type");
		
		if("userlist".equals(type)){
			UserService.doSelectUser(request, response);
		}else if("useradd".equals(type)){
			UserService.doInsertUser(request, response);
		}else if("userdelete".equals(type)){
			UserService.doDelteUser(request, response);
		}else if("userupdate".equals(type)){
			UserService.doUpdateUser(request, response);
		}else if("userupdate_1".equals(type)){
			UserService.doSelectUserById(request, response);
		}
	}

}
