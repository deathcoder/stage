package it.objectway.corsi.hibtest.impl;

import it.objectway.corsi.hibtest.interfaces.AccountDao;
import it.objectway.corsi.hibtest.interfaces.LogManager;
import it.objectway.corsi.hibtest.managers.LogManagerImpl;
import it.objectway.corsi.hibtest.models.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by stageusr2015 on 04/06/2015.
 */
public class AccountDaoImplTest {
    private static AccountDao accountDao = new AccountSpringDao();
    private static final LogManager logger = new LogManagerImpl(AccountDaoImplTest.class);

    public static void setAccountDao(AccountDao accountDao) {
        AccountDaoImplTest.accountDao = accountDao;
    }

    @Before
    public void setUp() throws Exception {
        accountDao.openSession();
    }

    @After
    public void tearDown() throws Exception {
        accountDao.closeSession();
    }

    @Test
    public void testFindById() throws Exception {
        Account account = accountDao.findById(4);
        assertEquals("test", account.getUsername());
        assertEquals("test", account.getPassword());
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
        accountDao.makePersistent(account);
        logger.trace(account.getId());
        accountDao.delete(account);
    }
}