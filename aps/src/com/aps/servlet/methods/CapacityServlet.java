package com.aps.servlet.methods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aps.db.dao.itfc.imp.CapacityDAO;
import com.aps.db.model.FenPage;
import com.aps.db.model._Capacity;

/**
 * �������ݷ�װ������ת
 * @author ����ί
 * 2012��9��9�� 11:29:53
 */
public class CapacityServlet {

	@SuppressWarnings("unused")
	private static CapacityDAO capacityDAO = new CapacityDAO();
	
	/**
	 * װ�����͵㡢���ͷ�Χ��·����㡢·��;���㡢˾����Ϣ����������ҳ��
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doGetMessageToCorPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("almodel", capacityDAO.doGetAllToCap());
		request.getRequestDispatcher("ZzCorporation/capacity/capacity_add.jsp").forward(request, response);
		
	}

	/**
	 * ����µ�������������
	 * @param request
	 * @param response
	 */
	public static void doAddCapacity(HttpServletRequest request,
			HttpServletResponse response) {
		_Capacity capacity = new _Capacity();
		capacity.setFk_dpid(request.getParameter("fk_dpid"));
		capacity.setFk_rtid(request.getParameter("fk_rtid"));
		capacity.setFk_cid(request.getParameter("fk_cid"));
		capacity.setFk_eid(request.getParameter("fk_eid"));
		capacity.setCapstate(request.getParameter("capstate"));
		
		if(capacityDAO.doInster(capacity)){
			System.out.println("�������ok");	
		}else{
			System.out.println("�������error");
		}
		
	}

	/**
	 * ��ѯ���еģ����Է�ҳ��ʽ�鿴
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doSelectAllPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		FenPage page = new FenPage();
		page.setPageNow(request.getParameter("pageNow"));
		request.setAttribute("almodel", capacityDAO.doSelect(page));
		request.getRequestDispatcher("ZzCorporation/capacity/capacity_list.jsp").forward(request, response);
		
	}

	
	
}
