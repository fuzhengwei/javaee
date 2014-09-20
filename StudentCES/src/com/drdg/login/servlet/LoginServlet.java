package com.drdg.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drdg.login.service.LoginService;

public class LoginServlet extends HttpServlet {

	private String type = "";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginService.doLoginOut(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		type = request.getParameter("us");

		if ("user".equals(type)) {
			LoginService.doUserLogin(request, response);
		} else if ("student".equals(type)) {
			LoginService.doStudentLogin(request, response);
		}
		
	}

}
