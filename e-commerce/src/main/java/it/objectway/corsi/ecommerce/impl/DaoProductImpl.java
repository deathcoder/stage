package it.objectway.corsi.ecommerce.impl;

import it.objectway.corsi.ecommerce.interfaces.DaoProduct;
import it.objectway.corsi.ecommerce.interfaces.DatabaseManager;
import it.objectway.corsi.ecommerce.interfaces.LogManager;
import it.objectway.corsi.ecommerce.models.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stageusr2015 on 29/05/2015.
 */
public class DaoProductImpl implements DaoProduct {
    private static final String SELECTPRODS ="SELECT id, name" +
                    " FROM product";
    private static final DatabaseManager databaseManager = new DatabaseManagerImpl();
    private static final LogManager logger = new LogManagerImpl(DaoProductImpl.class);

    public List<Product> getProductList() {
        logger.trace("getProductList: start");
        ResultSet result = executeQuery(SELECTPRODS);
        List<Product> products = new ArrayList<>();
        try {
            while(result.next()) {
                Product temp = new Product();
                temp.setId(result.getInt("id"));
                temp.setName(result.getString("name"));
                products.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    private ResultSet executeQuery(String query) {
        logger.trace("executeQuery: start");
        try {
            return databaseManager.executeQuery(query);
        } catch (SQLException e) {
            logger.error("executeQuery: failed " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


}
