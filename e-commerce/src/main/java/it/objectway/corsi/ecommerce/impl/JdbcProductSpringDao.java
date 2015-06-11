package it.objectway.corsi.ecommerce.impl;

import it.objectway.corsi.ecommerce.interfaces.LogManager;
import it.objectway.corsi.ecommerce.interfaces.ProductDao;
import it.objectway.corsi.ecommerce.models.Product;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static it.objectway.corsi.ecommerce.utils.Strings.buildString;

/**
 * Created by stageusr2015 on 10/06/2015.
 */
public class JdbcProductSpringDao extends JdbcDaoSupport implements ProductDao {
    private static LogManager logger = new LogManagerImpl(JdbcProductSpringDao.class);
    private static final StringBuilder SELECTPRODS = buildString("SELECT id, name, price",
            " FROM product");
    private static final StringBuilder SELECTPROD = buildString("SELECT *",
            " FROM product",
            " WHERE id=?");
    @Override
    public List<Product> getProductList() {
        return getJdbcTemplate().queryForList(SELECTPRODS.toString(), Product.class);
    }

    @Override
    public Product getProduct(int id) {
        logger.trace("getProduct(", id, "): start");
        logger.debug(getJdbcTemplate());
        return getJdbcTemplate().queryForObject(SELECTPROD.toString(), new Object[]{id},
                new RowMapper<Product>() {
                    @Override
                    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                        Product product = new Product();
                        product.setId(resultSet.getInt("id"));
                        product.setName(resultSet.getString("name"));
                        product.setDescription(resultSet.getString("description"));
                        product.setPrice(resultSet.getBigDecimal("price"));
                        product.setStorage(resultSet.getLong("storage"));
                        product.setVisible(resultSet.getBoolean("visible"));
                        return product;
                    }
                });
    }
}
