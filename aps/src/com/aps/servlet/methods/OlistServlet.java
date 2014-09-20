package com.aps.servlet.methods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aps.db.dao.itfc.imp.OlistDAO;
import com.aps.db.model.FenPage;

/**
 * �������ݷ�װ�����á���ת
 * @author Administrator
 *
 */
public class OlistServlet {

	
	@SuppressWarnings("unused")
	private static OlistDAO olistDAO = new OlistDAO();
	
	/**
	 * ��ҳ�ķ�ʽ�鿴����
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doSelectOnPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		FenPage page = new FenPage();
		page.setPageNow(request.getParameter("pageNow"));
		request.setAttribute("almodel", olistDAO.doSelect(page));
		request.getRequestDispatcher("ZzCorporation/orderlist/orderlist.jsp").forward(request, response);
	}

}
