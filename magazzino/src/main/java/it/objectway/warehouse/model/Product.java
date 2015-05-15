package it.objectway.warehouse.model;

import it.objectway.warehouse.util.DateUtils;

import java.util.Date;

import static it.objectway.warehouse.util.StringUtils.buildString;

/**
 * Created by stageusr2015 on 15/05/2015.
 */
public class Product {
    private int id, quantity;
    private String name, brand, category;
    private Date last_update;

    public Product(int id, String category, String name, String brand, int quantity) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.last_update = null;
    }

    public Product(int id, String name, String brand, String category, int quantity, Date last_update) {
        this(id, name, brand, category, quantity);
        this.last_update = last_update;
    }

    public Product(int id, String name, String brand, String category, int quantity, String last_update) {
        this(id, name, brand, category, quantity, DateUtils.parseDate(last_update));
    }

    @Override
    public String toString() {
        return buildString("Product{",
                "id=", id,
                ", quantity=", quantity,
                ", name='", name, '\'',
                ", brand='", brand, '\'',
                ", category='", category, '\'',
                ", last_update=", last_update,
                '}');
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
}
