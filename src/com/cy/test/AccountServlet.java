package com.cy.test;

import com.cy.test.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AccountServlet")
public class AccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String fromUser = request.getParameter("fromUser");
        String toUser = request.getParameter("toUser");
        String money = request.getParameter("money");
        try {
            new AccountService().account(fromUser,toUser,money);
            response.getWriter().print("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print("转账失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
