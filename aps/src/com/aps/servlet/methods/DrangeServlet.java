package com.aps.servlet.methods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aps.db.dao.itfc.imp.DrangeDAO;
import com.aps.db.model.FenPage;
import com.aps.db.model._Dpoint;
import com.aps.db.model._Drange;

/**
 * ���ͷ�Χ
 * @author ����ί
 * @see 2012��9��7�� 09:25:08
 */
public class DrangeServlet {

	@SuppressWarnings("unused")
	private static DrangeDAO drangeDAO = new DrangeDAO();
	
	/**
	 * �������͵���Ϣ�������͵㷶Χҳ��
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void addDpointToPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("almodel", drangeDAO.doGetPointToDrange());
		request.getRequestDispatcher("ZzCorporation/drange/dranger_add.jsp").forward(request, response);
		
	}
	
	/**
	 * �鿴���͵㵽���ͷ�Χ����Ϣ
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doPageDrange(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		FenPage page = new FenPage();
		if(null != request.getParameter("pageNow")){
			page.setPageNow(request.getParameter("pageNow"));
		}else{
			page.setPageNow("1");
		}
		
		request.setAttribute("almodel", drangeDAO.doSelect(page));
		request.getRequestDispatcher("ZzCorporation/drange/dranger_list.jsp").forward(request, response);
	}
	
	/**
	 * �������ͷ�Χ�����ͷ�Χ��
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doAddDranger(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		_Drange drange = new _Drange();
		drange.setFk_dpid(request.getParameter("fk_dpid"));
		drange.setDrend(request.getParameter("tid1")+request.getParameter("tid2")+request.getParameter("tid3"));
		drange.setDrfkg(request.getParameter("drfkg"));
		drange.setDrokg(request.getParameter("drokg"));
		if(drangeDAO.doInster(drange)){
			System.out.println("����ok");
			doPageDrange(request,response);
		}else{
			System.out.println("����error");
		}
	}

	
	
}
