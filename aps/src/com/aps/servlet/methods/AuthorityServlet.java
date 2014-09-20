package com.aps.servlet.methods;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aps.db.dao.itfc.imp.AuthorityDAO;
import com.aps.db.dao.itfc.imp.DeaDAO;
import com.aps.db.model.FenPage;
import com.aps.db.model.V_EmpDetail;
import com.aps.db.model._Authority;
import com.aps.db.model._Dea;

/**
 * Ȩ��������װ
 * @author Administrator
 *
 */
public class AuthorityServlet {

	/**
	 * ����Ȩ��
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doAddAuthority(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		_Authority authority = new _Authority();
		authority.setAuno(request.getParameter("auno"));
		authority.setAudesc(request.getParameter("audesc"));
		
		AuthorityDAO authorityDAO = new AuthorityDAO();
		authorityDAO.doInster(authority);
		
		/*������Ȩ�ޣ���ת����Ȩҳ��*/
		doSelectAll(request,response);
	}

	/**
	 * ��Ȩ
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doGrantTo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		_Dea dea = new _Dea();
		dea.setFk_dpid(request.getParameter("fk_dpid"));
		dea.setFk_eid(request.getParameter("fk_eid"));
		dea.setFk_auid(request.getParameter("fk_auid"));
		
		/*����deaDAO*/
		
		DeaDAO deaDAO = new DeaDAO();
		if(deaDAO.doInster(dea)){
			doSelect(request,response);
		}else{
			System.out.println("��Ȩerror");
		}
		
	}
	/**
	 * ��ѯ���е�Ȩ�޲��Ҹ���Ȩҳ��
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doSelectAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		AuthorityDAO authorityDAO = new AuthorityDAO();
		request.setAttribute("almodel", authorityDAO.doSelectGrant());
		request.getRequestDispatcher("ZzCorporation/authority/au_grant.jsp").forward(request, response);
		
	}

	/**
	 * ��ѯ��ͼ��pdlogin�õ������ֶ����͵㡢Ա����Ȩ��
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doSelect(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		FenPage page = new FenPage();
		if(null !=request.getParameter("pageNow")){
			page.setPageNow(request.getParameter("pageNow"));
		}else{
			page.setPageNow("1");
		}
		AuthorityDAO authorityDAO = new AuthorityDAO();
		request.setAttribute("almodel", authorityDAO.doSelect(page));
		request.getRequestDispatcher("ZzCorporation/authority/au_list.jsp").forward(request, response);
	}

	
}
