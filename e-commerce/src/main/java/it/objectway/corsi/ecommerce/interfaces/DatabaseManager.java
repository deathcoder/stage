package it.objectway.corsi.ecommerce.interfaces;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by stageusr2015 on 29/05/2015.
 */
public interface DatabaseManager {
    Connection getConnection();

    ResultSet executeQuery(String sql, Object... parameters) throws SQLException;
}
