package com.aps.servlet.methods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aps.db.dao.itfc.imp.RouteDAO;
import com.aps.db.dao.itfc.imp.RwDAO;
import com.aps.db.model.FenPage;
import com.aps.db.model._Route;
import com.aps.db.model._Rw;
/**
 * ��ת����·�ߵķ���
 * @author Administrator
 */
public class RouteServlet {
	
	/**
	 * ����·�ߵķ���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void doAddRoute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		_Route route = new _Route();
		
		route.setRtname(request.getParameter("rtname"));
		route.setRtspoint(request.getParameter("rtspoint"));
		route.setRtpefpkg(request.getParameter("rtpefpkg"));
		route.setRtpeopkg(request.getParameter("rtpeopkg"));
		route.setRtpefpvo(request.getParameter("rtpefpvo"));
		route.setRtpeopvo(request.getParameter("rtpeopvo"));
		
		RouteDAO routeDAO = new RouteDAO();
		if(routeDAO.doInster(route)){
			doListRoute(request,response);
		}else{
			response.getWriter().print("����ʧ��");
		}
		
	}

	/**
	 * �鿴���г���
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doListRoute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		doPageRoute(request,response);
	}
	/**
	 * ִ�з�ҳ
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doPageRoute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		RouteDAO routeDAO = new RouteDAO();
		FenPage fpage = new FenPage();
		fpage.setPageNow(request.getParameter("pageNow"));
		request.setAttribute("alroute", routeDAO.doSelectPage(fpage));
		request.getRequestDispatcher("ZzCorporation/route/route_list.jsp").forward(request, response);
	}
	
	/**
	 * ȡ��·�������Ϣ��װ�ص�·��;����ҳ��
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doGetPointToRw(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RwDAO rwDAO = new RwDAO();
		request.setAttribute("almodel", rwDAO.doSelectPointToRw());
		request.getRequestDispatcher("ZzCorporation/route/route_end.jsp").forward(request, response);
	}

	/**
	 * ����·�߷�Χ
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doInsertRw(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RwDAO rwDAO = new RwDAO();
		_Rw rw = new _Rw();
		rw.setFk_rtid(request.getParameter("fk_rti"));
		rw.setRwroutend(request.getParameter("tid1")+request.getParameter("tid2")+request.getParameter("tid3"));
		if(rwDAO.doInster(rw)){
			System.out.println("·��;�������ӳɹ�");
			/*����ɹ�����ת��·�߲鿴ҳ��*/
			doPageRoute(request,response);
		}else{
			System.out.println("·��;��������ʧ��");
		}
	}
	
}
