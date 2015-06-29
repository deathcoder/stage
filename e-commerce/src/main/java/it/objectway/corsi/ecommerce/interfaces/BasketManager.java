package it.objectway.corsi.ecommerce.interfaces;

import it.objectway.corsi.ecommerce.models.Basket;
import it.objectway.corsi.ecommerce.models.Product;

/**
 * Created by stageusr2015 on 15/06/2015.
 */
public interface BasketManager {
    Basket getBasket();
    void add(int productId, int amount);

    void add(Product product);
}
