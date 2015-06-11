package it.objectway.corsi.hibtest.impl;

import it.objectway.corsi.hibtest.interfaces.AccountDao;
import it.objectway.corsi.hibtest.models.Account;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by stageusr2015 on 10/06/2015.
 */
public class AccountSpringDao extends HibernateDaoSupport implements AccountDao {
    public Account findById(long id) {
        return getHibernateTemplate().get(Account.class, id);
    }

    public List<Account> findAll() {
        return null;
    }

    public Account makePersistent(Account account) {
        return null;
    }

    public Account delete(Account account) {
        return null;
    }

    public void openSession() {

    }

    public void closeSession() {

    }
}
