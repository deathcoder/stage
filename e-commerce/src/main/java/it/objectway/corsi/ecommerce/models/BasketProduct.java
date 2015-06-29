package it.objectway.corsi.ecommerce.models;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by stageusr2015 on 05/06/2015.
 */
public class BasketProduct implements Serializable {
    private int amount;
    private Product product;

    public BasketProduct() { }

    public BasketProduct(Product product, int amount) {
        setAmount(amount);
        setProduct(product);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getId() {
        return product.getId();
    }

    public String getName() {
        return product.getName();
    }

    public String getDescription() {
        return product.getDescription();
    }

    public BigDecimal getPrice() {
        return product.getPrice();
    }

    public long getStorage() {
        return product.getStorage();
    }

    public boolean getVisible() {
        return product.getVisible();
    }

    @Override
    public String toString() {
        return "BasketProduct{" +
                "amount=" + amount +
                ", product=" + product +
                '}';
    }
}
