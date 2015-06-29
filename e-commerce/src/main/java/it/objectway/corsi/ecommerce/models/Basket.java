package it.objectway.corsi.ecommerce.models;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by stageusr2015 on 15/06/2015.
 */
public class Basket implements Serializable {

    @Resource(name = "map")
    private Map<Integer, BasketProduct> basket;

    public Basket() {
        this.basket = new HashMap<>();
    }

    public void add(BasketProduct product) {
        basket.put(product.getId(), product);
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

    public Map<Integer, BasketProduct> getBasket() {
        return basket;
    }

    public void setBasket(Map<Integer, BasketProduct> basket) {
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "basket=" + basket +
                '}';
    }
}
