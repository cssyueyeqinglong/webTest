package com.cy.test.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * c3p0连接池
 * 
 * @author Administrator
 *
 */
public class DataSourcePoolV2 {

	public static DataSource getDataSource() {
		return new ComboPooledDataSource();
	}

	public static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
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
