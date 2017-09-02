package com.cy.test.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSourceUtils {
    private static ComboPooledDataSource ps = new ComboPooledDataSource();
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();//变量副本，将connection和当前线程绑定

    public static DataSource getDataSource() {
        return ps;
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = tl.get();
        if (conn == null) {
            conn = ps.getConnection();
            tl.set(conn);
        }
        return conn;
    }

    /**
     * 开启事物
     */
    public static void startTranstion() throws SQLException {
        getConnection().setAutoCommit(false);
    }

    /**
     * 提交事物
     */
    public static void commitTranstionAndClose() throws SQLException {
        Connection conn = getConnection();
        conn.commit();
        conn.close();
        tl.remove();
    }


    /**
     * 回滚
     */
    public static void rollbackAndClose() throws SQLException {
        Connection conn = getConnection();
        conn.rollback();
        conn.close();
        tl.remove();
    }

    // 释放资源
    public static void closeResource(Connection conn, Statement st, ResultSet rs) {
        closeResult(rs);
        closeState(st);
        closeConn(conn);
    }

    // 释放资源
    public static void closeResource(Statement st, ResultSet rs) {
        closeResult(rs);
        closeState(st);
    }

    /**
     * 释放语句执行者
     *
     * @param st
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
     * @param rs
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
