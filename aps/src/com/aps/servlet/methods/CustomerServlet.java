package com.aps.servlet.methods;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aps.db.dao.itfc.imp.CustomerDAO;
import com.aps.db.model.FenPage;
import com.aps.db.model._Customer;

public class CustomerServlet {
	
	@SuppressWarnings("unused")
	private static CustomerDAO customerDAO = new CustomerDAO();
	
	/**
	 * �����µĿͻ������ݿ⣬��װ���ݣ�����DAO����ת
	 * 2012��9��10�� 12:58:22
	 * @param request
	 * @param request2
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doAddCustomer(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		_Customer customer = new _Customer();
		customer.setCnickname(request.getParameter("cnickname"));
		customer.setCname(request.getParameter("cname"));
		customer.setCsex(request.getParameter("csex"));
		customer.setCpwd(request.getParameter("cpwd"));
		customer.setCtel(request.getParameter("ctel"));
		customer.setCemail(request.getParameter("cemail"));
		customer.setCbirthday(request.getParameter("cbirthday"));
		customer.setCaddress(request.getParameter("tid1")+request.getParameter("tid2")+request.getParameter("tid3"));
		
		if(customerDAO.doInster(customer)){
			System.out.println("�û����ok");
			doSelectOnPage(request,response);
		}else{
			System.out.println("�û����error");
		}
	}

	/**
	 * ��ҳ��ʽ��ѯ�ͻ����ͻ��鿴ҳ��
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public static void doSelectOnPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		FenPage page = new FenPage();
		page.setPageNow(request.getParameter("pageNow"));
		request.setAttribute("almodel", customerDAO.doSelect(page));
		request.getRequestDispatcher("ZzCorporation/customer/customer_list.jsp").forward(request, response);
	}

	/**
	 * �첽�޸�����
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public static void doUpdateCustomer(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		_Customer customer = new _Customer();
		customer.setCtid(request.getParameter("ctid"));
		customer.setCnickname(utf(request.getParameter("cnickname")));
		customer.setCname(utf(request.getParameter("cname")));
		customer.setCsex(utf(request.getParameter("csex")));
		customer.setCtel(utf(request.getParameter("ctel")));
		customer.setCemail(utf(request.getParameter("cemail")));
		customer.setCbirthday(utf(request.getParameter("cbirthday")));
		customer.setCaddress(utf(request.getParameter("caddress")));
		if(customerDAO.doUpdate(customer)){
			System.out.println("�첽���³ɹ�");
			response.getWriter().print("update ok!");
		}else{
			System.out.println("�첽����ʧ��");
			response.getWriter().print("update error!");
		}
	}
	
	public static String utf(String str) throws UnsupportedEncodingException{
		return new String(str.getBytes("iso-8859-1"),"utf-8");
	}

	/**
	 * �첽ɾ���û�
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public static void doDeleteCustomerById(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		if(customerDAO.doDelete(request.getParameter("deleteId"))){
			response.getWriter().print("delete ok!");
		}else{
			response.getWriter().print("delete error!");
		}
	}

}
