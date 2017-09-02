package com.cy.test.service;

import com.cy.test.dao.AccountDao;
import com.cy.test.utils.DataSourceUtils;

public class AccountService {
    public void account(String fromUser, String toUser, String money) throws Exception {
        try {
            DataSourceUtils.startTranstion();
            AccountDao dao = new AccountDao();
            dao.accountOut(fromUser, money);
            int i=3/0;
            dao.accountIn(toUser, money);
            DataSourceUtils.commitTranstionAndClose();
        } catch (Exception e) {
            e.printStackTrace();
            DataSourceUtils.rollbackAndClose();
            throw e;
        }
    }
}
