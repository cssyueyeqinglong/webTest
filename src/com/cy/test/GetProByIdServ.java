package com.cy.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cy.test.utils.CookieUtils;

/**
 * Servlet implementation class GetProByIdServ
 */
public class GetProByIdServ extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		Cookie cook = CookieUtils.getCookieByKey(request.getCookies(), "ids");
		String ids = "";
		if (cook == null) {
			ids = id + "-";
		} else {
			// ids不为空，判断是否包含
			ids = cook.getValue();
			String[] split = ids.split("-");
			LinkedList<String> list = new LinkedList<>(Arrays.asList(split));
			if (list.contains(id)) {
				list.remove(id);
			} else {
				if (list.size() > 2) {
					list.removeLast();
				}
			}
			list.addFirst(id);
			ids = "";
			for (String string : list) {
				ids += string + "-";
			}
		}

		ids = ids.substring(0, ids.length() - 1);
		cook = new Cookie("ids", ids);
		cook.setMaxAge(3600);
		cook.setPath(request.getContextPath());
		response.addCookie(cook);
		response.sendRedirect(request.getContextPath()+"/product_info"+id+".htm");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
