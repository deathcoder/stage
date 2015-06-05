package it.objectway.corsi.ecommerce.interfaces;

import it.objectway.corsi.ecommerce.models.Product;

import java.util.List;

/**
 * Created by stageusr2015 on 29/05/2015.
 */
public interface ProductDao {
    List<Product> getProductList();

    Product getProduct(int id);
}
