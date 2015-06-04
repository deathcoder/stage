package it.objectway.corsi.hibtest.impl;

import it.objectway.corsi.hibtest.interfaces.AccountDao;
import it.objectway.corsi.hibtest.interfaces.LogManager;
import it.objectway.corsi.hibtest.managers.LogManagerImpl;
import it.objectway.corsi.hibtest.models.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by stageusr2015 on 04/06/2015.
 */
public class AccountDaoImplTest {
    private static AccountDao dao = new AccountDaoImpl();
    private static final LogManager logger = new LogManagerImpl(AccountDaoImplTest.class);

    @Before
    public void setUp() throws Exception {
        dao.openSession();
    }

    @After
    public void tearDown() throws Exception {
        dao.closeSession();
    }

    @Test
    public void testFindById() throws Exception {

    }

    @Test
    public void testFindAll() throws Exception {

    }

    @Test
    public void testMakePersistent() throws Exception {
        Account account = new Account();
        String expected = "test";
        account.setUsername(expected);
        account.setPassword(expected);
        dao.makePersistent(account);
        logger.trace(account.getId());
        dao.delete(account);
    }
}