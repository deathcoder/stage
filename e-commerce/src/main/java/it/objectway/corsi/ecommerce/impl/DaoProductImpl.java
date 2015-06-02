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
    private static final String SELECTPRODS = "SELECT id, name" +
            " FROM product";
    private static final String SELECTPROD = "SELECT *" +
            " FROM product" +
            " WHERE id=?";

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
                temp.setDescription("TODO change me");
                products.add(temp);
            }
        } catch (SQLException e) {
            logger.error("don't know why would happen");
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getProduct(int id) {
        logger.trace("getProduct(", id, "): start");
        ResultSet result = executeQuery(SELECTPROD, id);
        try {
            while(result.next()) {
                Product product = new Product();
                product.setId(result.getInt("id"));
                product.setName(result.getString("name"));
                product.setDescription(result.getString("description"));
                product.setPrice(result.getBigDecimal("price"));
                product.setStorage(result.getInt("storage"));
                return product;
            }
        } catch (SQLException e) {
            logger.error("don't know why would happen");
            e.printStackTrace();
        }
        return null;
    }

    private ResultSet executeQuery(String query, Object... parameters) {
        logger.trace("executeQuery: start");
        try {
            return databaseManager.executeQuery(query, parameters);
        } catch (SQLException e) {
            logger.error("executeQuery: failed " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


}
