package it.objectway.corsi.ecommerce.exceptions;

import java.sql.SQLException;

/**
 * Created by stageusr2015 on 29/05/2015.
 */
public class PreparedStatementException extends SQLException {
    public PreparedStatementException(Throwable cause) {
        super(cause);
    }
}
