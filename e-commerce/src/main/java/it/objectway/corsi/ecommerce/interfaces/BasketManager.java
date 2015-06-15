package it.objectway.corsi.ecommerce.interfaces;

import it.objectway.corsi.ecommerce.models.Basket;

/**
 * Created by stageusr2015 on 15/06/2015.
 */
public interface BasketManager {
    Basket getBasket();
    void add(int productId, int amount);
}
