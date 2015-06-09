package it.objectway.corsi.spikes.springmvc.models;

import it.objectway.corsi.spikes.springmvc.enums.Category;

import java.math.BigDecimal;

/**
 * Created by stageusr2015 on 09/06/2015.
 */
public class Product {
    private String name;
    private String description;
    private Category category;
    private BigDecimal price;

    public Product() { }

    public Product(String name, String description, Category category, String price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = new BigDecimal(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
