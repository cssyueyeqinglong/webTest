package com.cy.test;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServerTest1
 */
public class CookieServerTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Cookie cook = getCookie(request.getCookies(), "lastTime");
		if (cook == null) {
			response.getWriter().print("您是第一次访问");
		} else {
			String value = cook.getValue();
			response.getWriter().print("上次访问时间：" + new Date(Long.valueOf(value)).toLocaleString());
		}
		cook = new Cookie("lastTime", new Date().getTime() + "");
		cook.setMaxAge(1800);
		response.addCookie(cook);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private Cookie getCookie(Cookie[] cookies, String cook) {
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cook.equals(cookies[i].getName())) {
					return cookies[i];
				}
			}
		}
		return null;
	}

}
