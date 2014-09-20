package com.spotic.rfq.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spotic.rfq.service.Spotic_RfqService;

public class Spotic_RfqServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		if("rfqforadd".equals(type)){
			Spotic_RfqService.doForInsertModel(request,response);
		}else if("rfqadd".equals(type)){
			Spotic_RfqService.doInsertModel(request,response);
		}else if("rfqdelete".equals(type)){
			Spotic_RfqService.doDeleteModelById(request,response);
		}else if("rfqforupdate".equals(type)){
			Spotic_RfqService.doForUpdateModel(request,response);
		}else if("rfqupdate".equals(type)){
			Spotic_RfqService.doUpdateModel(request,response);
		}else if("rfqlist".equals(type)){
			Spotic_RfqService.doSelectModelListByMoreTable(request,response);
		}else if("empselectserach".equals(type)){
			Spotic_RfqService.doSelectModelListByMoreTableBySerachForLike(request,response);
		}
		
	}

}
