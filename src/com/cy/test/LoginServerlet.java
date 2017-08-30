package com.cy.test;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cy.test.bean.UserBean;
import com.cy.test.service.UserService;

/**
 * Servlet implementation class LoginServerlet
 */
public class LoginServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String password = req.getParameter("password");

		resp.setContentType("text/html;charset=utf-8");
		UserBean user = null;
		try {
			user = new UserService().login(userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (user == null) {
			resp.setHeader("refresh", "3,url=http://localhost:8080\\webTest1\\login.htm");
			resp.getWriter().print("登录失败");
		} else {
			resp.getWriter().print("登录成功");
		}
		String name = getServletContext().getInitParameter("name");
		System.out.println("init:" + name);
	}

}
