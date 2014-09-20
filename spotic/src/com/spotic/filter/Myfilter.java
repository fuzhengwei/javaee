package com.spotic.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Myfilter implements Filter {

	private String encoding = null;
	private FilterConfig filterConfig = null;

	public void destroy() {
		this.encoding = null;
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest servletReq, ServletResponse servletRes,
			FilterChain chain) throws IOException, ServletException {

		if (filterConfig != null) {
			servletReq.setCharacterEncoding(encoding);
			servletRes.setContentType("text/html;charset=" + encoding);
		}

		HttpServletRequest req = (HttpServletRequest) servletReq;
		HttpServletResponse res = (HttpServletResponse) servletRes;
		HttpSession session = req.getSession();
		//验证登录
		if(null == session.getAttribute("spotic_emp") && req.getRequestURI().indexOf("Spotic_EmpServlet") == -1
				&& req.getRequestURI().indexOf("login.jsp") == -1
				&& req.getRequestURI().indexOf(".js") == -1
				&& req.getRequestURI().indexOf(".css") == -1
				&& req.getRequestURI().indexOf(".png") == -1
				&& req.getRequestURI().indexOf(".jpg") == -1){
			res.sendRedirect("login/login.jsp");
			return;
		}
		
		//获得客户端访问者IP
		//System.out.println(req.getRemoteAddr());
		
		chain.doFilter(servletReq, servletRes);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");
	}

}
