package com.cy.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.cy.test.bean.UserBean;
import com.cy.test.service.UserService;

/**
 * Servlet implementation class RegistServerlet
 */
public class RegistServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Map<String, String[]> map = request.getParameterMap();
		UserBean bean = new UserBean();
		for (String key : map.keySet()) {
			System.out.println("key:" + key + ",===" + Arrays.toString(map.get(key)));
		}

		int res = 0;
		try {
			bean.username = request.getParameter("username");
			bean.password = request.getParameter("password");
			bean.email = request.getParameter("email");
			bean.name = request.getParameter("name");
			bean.inlineRadioOptions = request.getParameter("inlineRadioOptions");
			bean.birthday = request.getParameter("birthday");
			// BeanUtils.populate(bean, request.getParameterMap());
			System.out.println("bean::" + bean.toString());
			res = new UserService().regist(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (res == 1) {
			System.out.println("注册成功");
		} else {
			System.out.println("注册失败");
		}
	}

}
