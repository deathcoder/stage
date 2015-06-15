package it.objectway.corsi.ecommerce.impl;

import it.objectway.corsi.ecommerce.interfaces.UserDao;
import it.objectway.corsi.ecommerce.models.User;
import org.hibernate.SessionFactory;

/**
 * Created by stageusr2015 on 15/06/2015.
 */
public class UserHibernateDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    @Override
    public User findByUserName(String username) {
        return (User) getSessionFactory().getCurrentSession().get(User.class, username);

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
