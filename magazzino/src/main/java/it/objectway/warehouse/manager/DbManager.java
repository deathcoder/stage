package it.objectway.warehouse.manager;

import it.objectway.warehouse.model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static it.objectway.warehouse.util.StringUtils.buildString;

/**
 * Created by stageusr2015 on 15/05/2015.
 */
public class DbManager {
    private static Connection connection = getConnection();

    private static String preparedProductUpdate = "UPDATE warehouse" +
            " SET last_update = CURDATE(), quantity=quantity + ?" +
            " WHERE id=? AND brand=? AND category=?";

    private static String preparedProductInsert = "INSERT INTO warehouse(id, name, brand, category, quantity)" +
            " VALUES(?, ?, ?, ?, ?)";

    public static int updateProduct(Product product) {
        PreparedStatement update = getPreparedStatement(preparedProductUpdate);
        try {
            update.setInt(1, product.getQuantity());
            update.setInt(2, product.getId());
            update.setString(3, product.getBrand());
            update.setString(4, product.getCategory());
        } catch (SQLException e) {
            LogManager.error(DbManager.class, "Failed to set parameters (update)");
            e.printStackTrace();
        }

        try {
            int rowsUpdated = update.executeUpdate();
            LogManager.debug(DbManager.class, buildString("Updated rows: ", rowsUpdated));
            return rowsUpdated;
        } catch (SQLException e) {
            LogManager.debug(DbManager.class, buildString("Updated rows: ", 0));
            LogManager.error(DbManager.class, buildString("Failed to update: ", update));
            e.printStackTrace();
        }
        return 0;
    }


    public static void insertProduct(Product product) {
        PreparedStatement insert = getPreparedStatement(preparedProductInsert);
        try {
            insert.setInt(1, product.getId());
            insert.setString(2, product.getName());
            insert.setString(3, product.getBrand());
            insert.setString(4, product.getCategory());
            insert.setInt(5, product.getQuantity());
        } catch (SQLException e) {
            LogManager.error(DbManager.class, "Failed to set parameters (insert)");
            e.printStackTrace();
        }

        try {
            insert.executeUpdate();
        } catch (SQLException e) {
            LogManager.error(DbManager.class, buildString("Failed to creare product: ", insert));
            e.printStackTrace();
        }
        LogManager.debug(DbManager.class, buildString("Created product: ", insert));
    }

    private static PreparedStatement getPreparedStatement(String preparedStatement) {
        try {
            return getConnection().prepareStatement(preparedStatement);
        } catch (SQLException e) {
            LogManager.error(DbManager.class, "Failed to prepare query");
            e.printStackTrace();
        }
        return null;
    }

    private synchronized static Connection getConnection() {
        if(connection == null) {
            driverCheck();
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/warehouse", "warehouse", "warehouse");
                LogManager.debug(DbManager.class, "Connection established");
            } catch (SQLException e) {
                LogManager.error(DbManager.class, "Connection Failed! Check output console");
                e.printStackTrace();
            }
        }
        return connection;
    }

    private static void driverCheck() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            LogManager.error(DbManager.class, "Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        connection.close();
        super.finalize();
    }
}
