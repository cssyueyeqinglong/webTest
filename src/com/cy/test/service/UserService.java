package com.cy.test.service;

import java.sql.SQLException;

import com.cy.test.bean.UserBean;
import com.cy.test.dao.UserDao;

public class UserService {

	public UserBean login(String userName, String pwd) throws SQLException {
		return new UserDao().getUserByNameAndPwd(userName, pwd);
	}
}
