package com.cy.test.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.cy.test.bean.UserBean;
import com.cy.test.utils.DataSourcePoolV2;

/**
 * 实行查询数据库的操作类
 * 
 * @author Administrator
 *
 */
public class UserDao {
	public UserBean getUserByNameAndPwd(String name, String pwd) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourcePoolV2.getDataSource());
		String sql = "select * from user where username=? and password=?";
		UserBean bean = qr.query(sql, new BeanHandler<>(UserBean.class), name, pwd);
		return bean;
	}

	public int registUser(UserBean bean) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourcePoolV2.getDataSource());
		String sql = "insert into user(username,password,name,email,sex,birthday) values(? ,?,?,?,?,?)";
		return qr.update(sql, bean.username, bean.password, bean.name, bean.email, bean.inlineRadioOptions,
				bean.birthday);
	}
}
