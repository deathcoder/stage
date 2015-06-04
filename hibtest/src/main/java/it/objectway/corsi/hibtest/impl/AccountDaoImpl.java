package it.objectway.corsi.hibtest.impl;

import it.objectway.corsi.hibtest.interfaces.AccountDao;
import it.objectway.corsi.hibtest.interfaces.LogManager;
import it.objectway.corsi.hibtest.managers.LogManagerImpl;
import it.objectway.corsi.hibtest.models.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by stageusr2015 on 04/06/2015.
 */
public class AccountDaoImpl implements AccountDao {
    /* https://developer.jboss.org/wiki/GenericDataAccessObjects */
    private Session session;
    private static final LogManager logger = new LogManagerImpl(AccountDaoImpl.class);

    public Account findById(long id) {
        logger.trace("findById(", id, "): start");
        return (Account) getSession().get(Account.class, id);
    }

    public List<Account> findAll() {
        logger.trace("findAll: start");
        return getSession().createCriteria(Account.class).list();
    }

    public Account makePersistent(Account account) {
        logger.trace("makePersistent(:", account.getId(), "): start");
        getSession().saveOrUpdate(account);
        getSession().delete(account);
        flush();
        return account;
    }

    public Account delete(Account account) {
        logger.trace("makeTransient(:", account.getId(), "): start");
        getSession().delete(account);
        return account;
    }

    private void flush() {
        getSession().flush();
    }

    public void openSession() {
        logger.trace("openSession: start");
        Configuration cfg = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties());
        SessionFactory factory = cfg.buildSessionFactory(builder.build());

        setSession(factory.openSession());
    }

    public void closeSession() {
        logger.trace("closeSession: start");
        getSession().close();
    }

    private void setSession(Session session) {
        logger.trace("setSession: start");
        this.session = session;
    }

    protected Session getSession() {
        logger.trace("getSession: start");
        if (session == null) {
            logger.error("getSession: session has not been opened");
            throw new IllegalStateException("Session has not been set on DAO before usage");
        }
        return session;
    }
}