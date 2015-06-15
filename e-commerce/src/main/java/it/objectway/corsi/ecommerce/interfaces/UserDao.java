package it.objectway.corsi.ecommerce.interfaces;

import it.objectway.corsi.ecommerce.models.User;

/**
 * Created by stageusr2015 on 15/06/2015.
 */
public interface UserDao {

    User findByUserName(String username);
}
