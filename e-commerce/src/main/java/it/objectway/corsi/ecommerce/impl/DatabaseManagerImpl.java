package it.objectway.corsi.ecommerce.impl;

import it.objectway.corsi.ecommerce.exceptions.InvalidParametersException;
import it.objectway.corsi.ecommerce.exceptions.PreparedStatementException;
import it.objectway.corsi.ecommerce.interfaces.DatabaseManager;
import it.objectway.corsi.ecommerce.interfaces.LogManager;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;

import static it.objectway.corsi.ecommerce.utils.Strings.buildString;

/**
 * Created by stageusr2015 on 29/05/2015.
 */
public class DatabaseManagerImpl implements DatabaseManager {
    private static LogManager logger = new LogManagerImpl(DatabaseManagerImpl.class);
    private static Connection connection;

    public ResultSet executeQuery(String query, Object... parameters) throws SQLException {
        logger.trace("executeQuery: start");
        String findParameters = "?";
        int queryParams = StringUtils.countMatches(query, findParameters);
        if(parameters.length == queryParams) {
            try {
                PreparedStatement prepQuery = getPreparedStatement(query);
                setParameters(prepQuery, parameters);
                return prepQuery.executeQuery();
            } catch (SQLException e) {
                logger.error("executeQuery: Failed to execute query: ", e.getMessage());
                throw new SQLException(e);
            }
        }
        else {
            throw new InvalidParametersException(buildString("Query requires ",
                    queryParams, " parameters, but only ", parameters.length, " were given.").toString());
        }
    }

    private void setParameters(PreparedStatement prepQuery, Object[] parameters) throws SQLException {
        for (int i = 0; i < parameters.length; i++) {
            /* automatically maps to the default jdbc type for that obj */
            prepQuery.setObject(i+1, parameters[i]);
        }
    }

    protected PreparedStatement getPreparedStatement(String preparedStatement) throws SQLException {
        logger.trace("getPreparedStatement: start");
        try {
            return getConnection().prepareStatement(preparedStatement);
        } catch (SQLException e) {
            logger.error("getPreparedStatement: Failed to prepare query: ", preparedStatement);
            throw new PreparedStatementException(e);
        }
    }

    public synchronized Connection getConnection() {
        logger.trace("getConnection: start");
        if(connection == null) {
            driverCheck();
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "ecommerce", "ecommerce");
                logger.debug("getConnection: Connection established");
            } catch (SQLException e) {
                logger.error("getConnection: Connection Failed! Check output console");
                e.printStackTrace();
            }
        }
        return connection;
    }

    protected void driverCheck() {
        logger.trace("driverCheck: start");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("driverCheck: Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }
    }
}
