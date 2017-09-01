package com.cy.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
        req.setCharacterEncoding("utf-8");
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");// 设置编码格式
        String cacheCode = (String) req.getSession().getAttribute("sessionCode");
        req.getSession().removeAttribute("sessionCode");
        if (userName.isEmpty() || "".equals(userName)) {//验证码为空,请求重定向
            req.setAttribute("errorMsg", "用户名不能为空");
            String path=req.getContextPath();
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
        if (password.isEmpty() || "".equals(password)) {//验证码为空,请求抓饭
            req.setAttribute("username", userName);
            req.setAttribute("errorMsg", "用户密码不能为空");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
        if (checkCode.isEmpty() || "".equals(checkCode)) {//验证码为空,请求重定向
            req.setAttribute("username", userName);
            req.setAttribute("errorMsg", "验证码为空");
            req.getRequestDispatcher( "/login.jsp").forward(req, resp);
            return;
        }
        if (!cacheCode.equalsIgnoreCase(checkCode)) {
            req.setAttribute("username", userName);
            req.setAttribute("errorMsg", "验证码不正确");
            req.getRequestDispatcher( "/login.jsp").forward(req, resp);
            return;
        }
        UserBean user = null;
        try {
            user = new UserService().login(userName, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user == null) {//登录失败
            req.setAttribute("username", userName);
            req.setAttribute("errorMsg", "用户名和验证码不匹配");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        } else {
            //重定向到index
            resp.sendRedirect(req.getContextPath() + "/index.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
