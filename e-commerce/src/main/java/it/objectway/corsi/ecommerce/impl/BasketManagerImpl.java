package it.objectway.corsi.ecommerce.impl;

import it.objectway.corsi.ecommerce.interfaces.BasketManager;
import it.objectway.corsi.ecommerce.interfaces.ProductDao;
import it.objectway.corsi.ecommerce.models.Basket;
import it.objectway.corsi.ecommerce.models.BasketProduct;
import it.objectway.corsi.ecommerce.models.Product;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by stageusr2015 on 15/06/2015.
 */
/*@Service("basketService")*/
public class BasketManagerImpl implements BasketManager {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private Basket basket;

    @Override
    public Basket getBasket() {
        return basket;
    }

    @Override
    public void add(int productId, int amount) {
        BasketProduct product = basket.getBasketProduct(productId);
        if(amount == 0) {
            basket.remove(productId);
            return;
        }
        if (product == null) {
            product = new BasketProduct(productDao.getProduct(productId), amount);
            basket.add(product);
        }
        else {
            product.setAmount(amount);
        }
    }

    @Override
    public void add(Product product) {
        add(product.getId(), 1);
    }
}
