package it.objectway.corsi.ecommerce.controllers;

import it.objectway.corsi.ecommerce.impl.LogManagerImpl;
import it.objectway.corsi.ecommerce.interfaces.BasketManager;
import it.objectway.corsi.ecommerce.interfaces.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by stageusr2015 on 12/06/2015.
 */
@Controller
public class BasketController {
    /* explains this class: */
    /* http://docs.spring.io/spring/docs/3.1.x/spring-framework-reference/html/mvc.html#mvc-ann-modelattrib-methods */
    /* http://stackoverflow.com/questions/3423262/what-is-modelattribute-in-spring-mvc/3423501#3423501 */
    @Autowired
    private BasketManager basketManager;

    private static final LogManager logger = new LogManagerImpl(BasketController.class);

    @RequestMapping(value = "/spring/basket", method = RequestMethod.GET)
    public ModelAndView getBasketProducts() {
        ModelAndView model = new ModelAndView();
        model.setViewName("springbasket");
        model.addObject("basket", basketManager.getBasket());
        return model;
    }

    @RequestMapping(value = "/spring/basket", method = RequestMethod.POST)
    public ModelAndView addProduct(@RequestParam(value = "action", required = false) String action,
                                   @RequestParam(value = "id", required = true) Integer id,
                                   @RequestParam(value = "amount", required = true) Integer amount) {
        ModelAndView model = new ModelAndView();
        model.setViewName("springbasket");
        basketManager.add(id, amount);
        model.addObject("basket", basketManager.getBasket());
        logger.debug("addProduct: basket(", basketManager.getBasket(), ")");
        return model;
    }

    public BasketManager getBasketManager() {
        return basketManager;
    }

    public void setBasketManager(BasketManager basketManager) {
        logger.trace("setBasketManager: start");
        this.basketManager = basketManager;
    }
}
