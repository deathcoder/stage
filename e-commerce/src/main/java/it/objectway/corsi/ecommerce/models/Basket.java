package it.objectway.corsi.ecommerce.models;

import it.objectway.corsi.ecommerce.impl.LogManagerImpl;
import it.objectway.corsi.ecommerce.interfaces.LogManager;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by stageusr2015 on 15/06/2015.
 */
public class Basket implements Serializable {
    private Map<Integer, BasketProduct> basket;
    private static final LogManager logger = new LogManagerImpl(Basket.class);;

    public Basket() {
        logger.trace("basket constructor: start");
        this.basket = new HashMap<>();
    }

    public void add(BasketProduct product) {
        logger.trace("add: start");
        basket.put(product.getId(), product);
        logger.debug("add: basket(", basket, ")");
    }

    public Collection<BasketProduct> getBasketProducts() {
        return basket.values();
    }

    public Collection<BasketProduct> values() {
        return getBasketProducts();
    }

    public void remove(int id) {
        basket.remove(id);
    }

    public BasketProduct getBasketProduct(int id) {
        return basket.get(id);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "basket=" + basket +
                '}';
    }
}
