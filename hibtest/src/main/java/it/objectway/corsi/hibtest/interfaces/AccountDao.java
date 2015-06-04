package it.objectway.corsi.hibtest.interfaces;

import it.objectway.corsi.hibtest.models.Account;

import java.util.List;

/**
 * Created by stageusr2015 on 04/06/2015.
 */
public interface AccountDao {
    Account findById(long id);

    List<Account> findAll();

    Account makePersistent(Account account);

    Account delete(Account account);

    void openSession();

    void closeSession();
}
