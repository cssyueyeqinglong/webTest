package com.cy.test.dao;

import com.cy.test.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDao {
    public void accountOut(String fromUser, String money) throws SQLException {
        PreparedStatement ps = null;
        try {
            Connection conn = DataSourceUtils.getConnection();
            String sql = "update account set money=money-? where name=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, money);
            ps.setString(2, fromUser);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            DataSourceUtils.closeState(ps);
        }
    }

    public void accountIn(String toUser, String money) throws SQLException {
        PreparedStatement ps = null;
        try {
            Connection conn = DataSourceUtils.getConnection();
            String sql = "update account set money=money+? where name=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, money);
            ps.setString(2, toUser);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            DataSourceUtils.closeState(ps);
        }
    }
}
