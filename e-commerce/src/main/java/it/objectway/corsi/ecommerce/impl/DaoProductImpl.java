package it.objectway.corsi.ecommerce.impl;

import it.objectway.corsi.ecommerce.interfaces.DaoProduct;
import it.objectway.corsi.ecommerce.interfaces.DatabaseManager;
import it.objectway.corsi.ecommerce.interfaces.LogManager;
import it.objectway.corsi.ecommerce.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stageusr2015 on 29/05/2015.
 */
public class DaoProductImpl implements DaoProduct {
    private static final String SELECTPRODS = "SELECT id, name, price" +
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
                temp.setPrice(result.getBigDecimal("price"));
                products.add(temp);
            }
        } catch (SQLException e) {
            logger.error("don't know why would happen");
            e.printStackTrace();
        }
        return products;
    }

    /*@Override
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
    }*/
    @Override
    public Product getProduct(int id) {
        logger.trace("getProduct(", id, "): start");
        Configuration cfg = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties());
        SessionFactory factory = cfg.buildSessionFactory(builder.build());
        Session session = factory.openSession();
        /*Product product = (Product) session.load(Product.class, id);*/
        Product product = (Product) session.get(Product.class, id);
        /*logger.trace("getProduct: exit", product);*/
        session.close();
        return product;
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
