package com.cy.test;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cy.test.bean.UserBean;
import com.cy.test.dao.UserDao;

/**
 * Servlet implementation class RegisterResultServ
 */
public class RegisterResultServ extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object msg = request.getAttribute("msg");
		System.out.println("执行结果：" + msg);
		UserBean bean = new UserBean();
		bean.username = "曹勇";
		bean.password = "1234";
		bean.name = "曹勇";
		bean.email = "596282182qq.com";
		bean.birthday = "19921220";
		bean.inlineRadioOptions = "男";
		try {
			new UserDao().registUser(bean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
