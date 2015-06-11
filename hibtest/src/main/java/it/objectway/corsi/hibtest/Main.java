package it.objectway.corsi.hibtest;

import it.objectway.corsi.hibtest.interfaces.AccountDao;
import it.objectway.corsi.hibtest.models.Account;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by stageusr2015 on 10/06/2015.
 */
public class Main {
    private static AccountDao accountDao;

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        new String[]{"applicationContext.xml"}
                );
        BeanFactory factory = context;
        accountDao = (AccountDao) context.getBean("accountDao");
        Account account = accountDao.findById(4);
        System.out.println(account.getUsername());
        System.out.println(account.getPassword());
    }


    public void setAccountDao(AccountDao accountDao) {
        Main.accountDao = accountDao;
    }
}
