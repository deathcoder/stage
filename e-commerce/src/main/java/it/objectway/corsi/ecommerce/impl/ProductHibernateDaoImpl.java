package it.objectway.corsi.ecommerce.impl;

import it.objectway.corsi.ecommerce.interfaces.ProductDao;
import it.objectway.corsi.ecommerce.models.Product;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by stageusr2015 on 12/06/2015.
 */
public class ProductHibernateDaoImpl implements ProductDao {
    private SessionFactory sessionFactory;

    @Override
    public List<Product> getProductList() {
        return getSessionFactory().getCurrentSession()
                .createCriteria(Product.class).list();
    }

    @Override
    public Product getProduct(int id) {
        return (Product) getSessionFactory().getCurrentSession().get(Product.class, id);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
