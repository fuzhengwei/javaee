package com.drdg.results.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drdg.results.service.ResultsService;

public class ResultsServlet extends HttpServlet {

	private String type = "";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		type = request.getParameter("type");

		if ("resultslist".equals(type)) {
			ResultsService.doSelectResults(request, response);
		} else if ("resultsadd".equals(type)) {
			ResultsService.doInsertResults(request, response);
		} else if ("resultsdelete".equals(type)) {
			ResultsService.doDeleteResults(request, response);
		} else if ("resultsupdate".equals(type)) {
			ResultsService.doUpdateResults(request, response);
		} else if ("resultsaddmessage".equals(type)) {
			ResultsService.forAddGetMessage(request, response);
		} else if ("resultsbean".equals(type)){
			ResultsService.doSelectResultsById(request, response);
		}
	}

}
