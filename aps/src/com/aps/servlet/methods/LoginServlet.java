package com.aps.servlet.methods;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aps.db.dao.itfc.imp.EmpDAO;

public class LoginServlet {

	private static EmpDAO empDAO = new EmpDAO();
	
	/**
	 * ͨ���û�����������䣬���ҷ��ʼ�
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public static void doGetPwdToEmail(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.getWriter().print(
		empDAO.doFindUserPwd(new String(request.getParameter("cname").getBytes("iso-8859-1"),"gbk")));
	}

}
