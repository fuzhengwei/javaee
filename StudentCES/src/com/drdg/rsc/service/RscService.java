package com.drdg.rsc.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drdg.rsc.bean.RscBean;
import com.drdg.rsc.dao.RscDao;

public class RscService {

	static private RscDao rscDao = new RscDao();

	static public void doSelectRSC(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ArrayList<RscBean> modelList = rscDao.doSelectRSC("");

		Map<String, Double> modelMap = new HashMap<String, Double>();

		for (RscBean rb : modelList) {

			// 判断当前id的map是否存在key
			if (modelMap.containsKey(rb.getRsc_id())) {
				modelMap.put(rb.getRsc_id(), modelMap.get(rb.getRsc_id())
						+ Double.parseDouble(rb.getRsc_fraction()));
			} else {
				modelMap.put(rb.getRsc_id(), Double.parseDouble(rb
						.getRsc_fraction()));
			}

		}

		request.setAttribute("modelList", modelList);
		request.setAttribute("modelMap", modelMap);

		request.getRequestDispatcher("view/rsc/rsclist.jsp").forward(request,
				response);

	}

	public static void doSerachRSC(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ArrayList<RscBean> modelList = rscDao.doSelectRSC(request.getParameter("stu_name"));

		Map<String, Double> modelMap = new HashMap<String, Double>();

		for (RscBean rb : modelList) {

			// 判断当前id的map是否存在key
			if (modelMap.containsKey(rb.getRsc_id())) {
				modelMap.put(rb.getRsc_id(), modelMap.get(rb.getRsc_id())
						+ Double.parseDouble(rb.getRsc_fraction()));
			} else {
				modelMap.put(rb.getRsc_id(), Double.parseDouble(rb
						.getRsc_fraction()));
			}

		}

		request.setAttribute("modelList", modelList);
		request.setAttribute("modelMap", modelMap);

		request.getRequestDispatcher("view/rsc/rsclist.jsp").forward(request,
				response);

	}

}
