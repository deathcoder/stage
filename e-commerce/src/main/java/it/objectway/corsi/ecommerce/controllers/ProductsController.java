package it.objectway.corsi.ecommerce.controllers;

import it.objectway.corsi.ecommerce.interfaces.ProductDao;
import it.objectway.corsi.ecommerce.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by stageusr2015 on 11/06/2015.
 */
@Controller
@RequestMapping(value = "/spring/")
public class ProductsController {
    /* annotation-driven dependency injection tutorial: */
    /* http://simplespringtutorial.com/annotations.html */
    @Autowired
    private ProductDao productDao;

    @RequestMapping(value = "api/products", method = RequestMethod.GET)
    public @ResponseBody
    List<Product> getJsonProducts() {
        return getProductDao().getProductList();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getAllProducts() {
        ModelAndView model = new ModelAndView();
        model.setViewName("products");
        model.addObject("prodList", getProductDao().getProductList());
        model.addObject("hrefPrefix", "product/");
        return model;
    }

    @RequestMapping(value = "api/product/{id:[0-9]+}", method = RequestMethod.GET)
    public @ResponseBody
    Product getProductById(@PathVariable("id") Integer id) {
        return productDao.getProduct(id);
    }

    @RequestMapping(value = "product/{id:[0-9]+}", method = RequestMethod.GET)
    public ModelAndView getJsonProductById(@PathVariable("id") Integer id) {
        ModelAndView model = new ModelAndView();
        model.setViewName("product");
        model.addObject("product", productDao.getProduct(id));
        return model;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public ProductDao getProductDao() {
        return productDao;
    }
}
