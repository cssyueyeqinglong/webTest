package com.cy.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClearHistoryServ
 */
public class ClearHistoryServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//清空内容,Cookie.setMaxAge(0)时就代表清空cookie
		Cookie cookie = new Cookie("ids","");
		cookie.setMaxAge(0);
		cookie.setPath(request.getContextPath());//清空cookie时必须要将路径设为一致
		response.addCookie(cookie);
		response.sendRedirect(request.getContextPath()+"/product_list.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
