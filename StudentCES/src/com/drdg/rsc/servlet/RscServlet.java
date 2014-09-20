package com.drdg.rsc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drdg.rsc.service.RscService;

public class RscServlet extends HttpServlet {

	private String type = "";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		type = request.getParameter("type");
		
		if("rsclist".equals(type)){
			RscService.doSelectRSC(request, response);
		}else if("serach".equals(type)){
			RscService.doSerachRSC(request, response);
		}
		
	}

}
