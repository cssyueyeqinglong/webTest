package com.cy.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Add2CartServ
 */
public class Add2CartServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");// 设置编码格式
		String name = request.getParameter("name");
		name = new String(name.getBytes("iso8859-1"), "utf-8");
		HttpSession session = request.getSession();
		Map<String, Integer> map = (Map<String, Integer>) session.getAttribute("cart");
		Integer count = null;
		if (map == null) {// 没有购物车
			map = new HashMap<>();
			map.put(name, 1);
			session.setAttribute("cart", map);
		} else {
			count = map.get(name);
			if (count == null) {
				count = 1;
			} else {
				count++;
			}
			map.put(name, count);
		}
		PrintWriter writer = response.getWriter();
		writer.print(name + "添加到购物车成功&nbsp&nbsp&nbsp&nbsp");
		writer.print("<a href='" + request.getContextPath() + "/product_list.jsp'>继续购物</a>&nbsp&nbsp&nbsp&nbsp");
		writer.print("<a href='" + request.getContextPath() + "/cart.jsp'>查看购物车</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
