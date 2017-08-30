package com.cy.test.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JdbcUtils {

	static String driverClass;
	static String url;
	static String name;
	static String pwd;
	static {
		ResourceBundle rb = ResourceBundle.getBundle("jdbc");
		driverClass = rb.getString("driverClass");
		url = rb.getString("url");
		name = rb.getString("name");
		pwd = rb.getString("pwd");
	}

	static {
		// 注册驱动
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 获取连接
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// 获取了连接
		Connection conn = DriverManager.getConnection(url, name, pwd);
		return conn;
	}

	// 释放资源
	public static void closeResource(Connection conn, Statement st, ResultSet rs) {
		closeResult(rs);
		closeState(st);
		closeConn(conn);
	}

	/**
	 * 释放语句执行者
	 * 
	 * @param conn
	 */
	public static void closeState(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			st = null;
		}
	}

	/**
	 * 释放连接
	 * 
	 * @param conn
	 */
	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}

	/**
	 * 释放结果集
	 * 
	 * @param conn
	 */
	public static void closeResult(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
	}

}
