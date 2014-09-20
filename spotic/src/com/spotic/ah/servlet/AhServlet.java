package com.spotic.ah.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spotic.ah.service.AhService;

public class AhServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String type = request.getParameter("type");
		
		if("1".equals(type)){
			AhService.doSelectModelListBySerach(request,response);
		}else if("3".equals(type)){
			AhService.doSelectModelListBySerach(request,response);
		}else if("4".equals(type)){
			AhService.doSelectModelListBySerach(request,response);
		}else if("welcome".equals(type)&&!"1".equals(request.getParameter("emp_power"))){
			AhService.doSelectModelListBySerachEmp(request,response);
		}else if("welcome".equals(type)&&"1".equals(request.getParameter("emp_power"))){
			AhService.doSelectModelLists(request,response);
		}else if("eiupdate".equals(type)){
			AhService.doUpdateModelById(request,response);
		}else if("eiselectserach".equals(type)){
			AhService.doSelectModelListBySerachForLike(request,response);
		}
	}

}
