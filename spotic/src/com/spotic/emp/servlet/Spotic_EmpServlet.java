package com.spotic.emp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spotic.emp.service.Spotic_EmpService;
import com.stack.util.pc.PC;

public class Spotic_EmpServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		if(!PC.doVerificationMac()){
//			request.setAttribute("error", "请获得正版软件使用权限！");
//			request.getRequestDispatcher("error/error.jsp").forward(request, response);
//			return;
//		}
		
		String type = request.getParameter("type");
		
		if("emplogin".equals(type)){
			Spotic_EmpService.doLogin(request, response);
		}else if("logout".equals(type)){
			Spotic_EmpService.doLoginOut(request,response);
		}else if("emplist".equals(type)){
			Spotic_EmpService.doSelectModelList(request,response);
		}else if("empadd".equals(type)){
			Spotic_EmpService.doInsertModel(request,response);
		}else if("empdelete".equals(type)){
			Spotic_EmpService.doDeleteModelById(request,response);
		}else if("empforupdate".equals(type)){
			Spotic_EmpService.doForUpdateModel(request,response);
		}else if("empupdate".equals(type)){
			Spotic_EmpService.doUpdateModel(request,response);
		}else if("empselectserach".equals(type)){
			Spotic_EmpService.doSelectModelListBySerachForLike(request,response);
		}
		
	}

}
