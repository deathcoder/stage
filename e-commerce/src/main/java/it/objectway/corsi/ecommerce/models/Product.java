package it.objectway.corsi.ecommerce.models;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by stageusr2015 on 29/05/2015.
 */
public class Product implements Serializable {
    private int id;
    private StringBuilder name;
    private StringBuilder description;
    private BigDecimal price;
    private long storage;
    private Boolean visible;

    public Product() { }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name.toString();
    }

    public void setName(String name) {
        this.name = new StringBuilder(name);
    }

    public String getDescription() {
        return description.toString();
    }

    public void setDescription(String description) {
        this.description = new StringBuilder(description);
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(String price) {
        /* the recommended constructor is BigDecimal(String), not BigDecimal(double) - see javadoc */
        this.price = new BigDecimal(price);
    }

    public long getStorage() {
        return storage;
    }

    public void setStorage(long storage) {
        this.storage = storage;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name=" + name +
                ", description=" + description +
                ", price=" + price +
                ", storage=" + storage +
                ", visible=" + visible +
                '}';
    }
}
