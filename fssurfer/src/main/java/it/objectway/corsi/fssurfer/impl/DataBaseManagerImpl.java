package it.objectway.corsi.fssurfer.impl;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import it.objectway.corsi.fssurfer.interfaces.DataBaseManager;
import it.objectway.corsi.fssurfer.interfaces.LogManager;
import it.objectway.corsi.fssurfer.models.FileModel;

import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by stageusr2015 on 18/05/2015.
 */
public class DataBaseManagerImpl implements DataBaseManager {
    private static LogManager logger = new LogManagerImpl(DataBaseManagerImpl.class);
    private static Connection connection = getConnection();
    private static final String PREPAREDFILEINSERT =
            " INSERT INTO files(abspath, name, type, extension, permissions, size)" +
                    " VALUES(?, ?, ?, ?, ?, ?)";

    private static final String CLEAN =
            "DROP TABLE IF EXISTS `surfer`.`files`";
    private static ExecutorService executor = Executors.newCachedThreadPool();

    public void execute(Runnable command) {
        executor.execute(command);
    }

    public void clean() {
        logger.warn("clean: this method cleaned the db, if you want to use again\n",
                "please load setup.sql first");
        Statement dropTable = getStatement();
        try {
            dropTable.executeUpdate(CLEAN);
        } catch (SQLException e) {
            logger.error("clean: failed to clean db");
            e.printStackTrace();
        }
    }

    public int getCount() {
        return 1;
    }

    public boolean updateFile(FileModel file) {
        return true;
    }

    public FileModel deleteFile(String absPath) {
        return null;
    }

    private Statement getStatement() {
        logger.trace("getStatement: start");
        try {
            return getConnection().createStatement();
        } catch (SQLException e) {
            logger.error("getStatement: failed to get statement");
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertFile(FileModel fileModel) {
        logger.trace("insertFile: start");
        PreparedStatement insert = getPreparedStatement(PREPAREDFILEINSERT);
        try {
            insert.setString(1, fileModel.getAbsolutePath());
            insert.setString(2, fileModel.getName());
            insert.setString(3, fileModel.getType());
            insert.setString(4, fileModel.getExtension());
            insert.setString(5, fileModel.getPermissions());
            insert.setLong(6, fileModel.getSize());
        } catch (SQLException e) {
            logger.error("insertFile: Failed to set parameters", e);
            e.printStackTrace();
        }
        int result;
        try {
            result = insert.executeUpdate();
        } catch(MySQLIntegrityConstraintViolationException e) {
            logger.debug("insertFile: catched IntegrityException, assuming it's a duplicate entry for primary key");
            logger.trace("insertFile: integrityException reason: ", e.getMessage());
            return false;
        } catch (SQLException e) {
            logger.error("insertFile: Failed to create file: ", insert);
            e.printStackTrace();
            return false;
        }
        if(result == 1) {
            logger.trace("insertFile: Created file(row count: ", result, "): ", insert);
            return true;
        }
        logger.trace("insertFile: file already exists: ", fileModel.getAbsolutePath());
        return false;
    }

    private static PreparedStatement getPreparedStatement(String preparedStatement) {
        logger.trace("getPreparedStatement: start");
        try {
            return getConnection().prepareStatement(preparedStatement);
        } catch (SQLException e) {
            logger.error("getPreparedStatement: Failed to prepare query: ", preparedStatement);
            e.printStackTrace();
        }
        return null;
    }
    private synchronized static Connection getConnection() {
        logger.trace("getConnection: start");
        if(connection == null) {
            driverCheck();
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/surfer", "surfer", "surfer");
                logger.debug("getConnection: Connection established");
            } catch (SQLException e) {
                logger.error("getConnection: Connection Failed! Check output console");
                e.printStackTrace();
            }
        }
        return connection;
    }

    private static void driverCheck() {
        logger.trace("driverCheck: start");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("driverCheck: Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        logger.trace("finalize: Closing db connection and shutting down executor");
        connection.close();
        super.finalize();
    }
}
