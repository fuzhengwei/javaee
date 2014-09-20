package com.drdg.results.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drdg.course.dao.CourseDao;
import com.drdg.results.bean.ResultsBean;
import com.drdg.results.dao.ResultsDao;
import com.drdg.student.dao.StudentDao;
import com.drdg.util.date.DateUtil;

public class ResultsService {
	
	static private ResultsDao resultsDao = new ResultsDao();
	static private CourseDao courseDao = new CourseDao();
	static private StudentDao studentDao = new StudentDao();
	
	static public void doInsertResults(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		ResultsBean model = new ResultsBean();
		model.setFk_cou_id(request.getParameter("fk_cou_id"));
		model.setFk_stu_id(request.getParameter("fk_stu_id"));
		model.setRes_entrydate(DateUtil.getNow());
		model.setRes_fraction(request.getParameter("res_fraction"));
		model.setRes_remark(request.getParameter("res_remark"));
		model.setRes_state("0");
		
		if(resultsDao.doInsertResults(model)){
			request.getRequestDispatcher("ResultsServlet?type=resultslist").forward(request, response);
		}else{
			System.out.println("error");
		}
		
	}
	
	static public void doDeleteResults(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if(resultsDao.doDeleteResults(request.getParameter("res_id"))){
			request.getRequestDispatcher("ResultsServlet?type=resultslist").forward(request, response);
		}else{
			System.out.println("results delete error!");
		}
	}
	
	static public void doUpdateResults(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ResultsBean model = new ResultsBean();
		model.setRes_id(request.getParameter("res_id"));
		model.setFk_cou_id(request.getParameter("fk_cou_id"));
		model.setFk_stu_id(request.getParameter("fk_stu_id"));
		model.setRes_entrydate(DateUtil.getNow());
		model.setRes_fraction(request.getParameter("res_fraction"));
		model.setRes_remark(request.getParameter("res_remark"));
		model.setRes_state(request.getParameter("res_state"));
		
		if(resultsDao.doUpdateResults(model)){
			request.getRequestDispatcher("ResultsServlet?type=resultslist").forward(request, response);
		}else{
			System.out.println("error");
		}
	}
	
	static public void doSelectResults(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("modelList", resultsDao.doSelectResults());
		if("0".equals(request.getParameter("w"))){
			//学生
			request.getRequestDispatcher("view/results/resultslist2.jsp").forward(request, response);
		}else{
			//管理员、导员、班长
			request.getRequestDispatcher("view/results/resultslist.jsp").forward(request, response);
		}
		
		
	}
	
	static public void forAddGetMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("modelListCou", courseDao.doSelectCourse());
		request.setAttribute("modelListStu", studentDao.doSelectStudent());
		
		request.getRequestDispatcher("view/results/resultsadd.jsp").forward(request, response);
	}

	public static void doSelectResultsById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("modelListCou", courseDao.doSelectCourse());
		request.setAttribute("modelListStu", studentDao.doSelectStudent());
		request.setAttribute("model", resultsDao.doSelectResultsById(request.getParameter("res_id")));
		
		request.getRequestDispatcher("view/results/resultsupdate.jsp").forward(request, response);
	}
	
}
