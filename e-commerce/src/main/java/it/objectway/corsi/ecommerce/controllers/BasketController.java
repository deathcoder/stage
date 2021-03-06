package it.objectway.corsi.ecommerce.controllers;

import it.objectway.corsi.ecommerce.impl.LogManagerImpl;
import it.objectway.corsi.ecommerce.interfaces.BasketManager;
import it.objectway.corsi.ecommerce.interfaces.LogManager;
import it.objectway.corsi.ecommerce.models.BasketProduct;
import it.objectway.corsi.ecommerce.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
@RequestMapping(value = "/spring")
public class BasketController {
    /* explains this class: */
    /* http://docs.spring.io/spring/docs/3.1.x/spring-framework-reference/html/mvc.html#mvc-ann-modelattrib-methods */
    /* http://stackoverflow.com/questions/3423262/what-is-modelattribute-in-spring-mvc/3423501#3423501 */
    @Autowired
    private BasketManager basketManager;

    private static final LogManager logger = new LogManagerImpl(BasketController.class);


    @RequestMapping(value = "basket", method = RequestMethod.GET)
    public ModelAndView getBasketProducts() {
        ModelAndView model = new ModelAndView();
        model.setViewName("springbasket");
        model.addObject("basket", basketManager.getBasket());
        return model;
    }

    @RequestMapping(value = "api/basket", method = RequestMethod.GET)
    public @ResponseBody
    Collection<BasketProduct> getJsonBasket() {
        logger.debug("basket ", basketManager.getBasket().values());
        return basketManager.getBasket().values();
    }

    @RequestMapping(value = "basket", method = RequestMethod.POST)
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

    @RequestMapping(value = "api/basket", method = RequestMethod.POST)
    public @ResponseBody
    Collection<BasketProduct> addJsonProduct(@RequestBody Product product) {
        basketManager.add(product);
        logger.debug("addProduct: basket(", basketManager.getBasket(), ")");
        return basketManager.getBasket().values();
    }

    @RequestMapping(value = "api/test", method = RequestMethod.POST)
    public @ResponseBody
    Collection<BasketProduct> addTest(@RequestBody String product) {
        logger.debug("addProduct: basket(", basketManager.getBasket(), ")");
        return basketManager.getBasket().values();
    }

    public BasketManager getBasketManager() {
        return basketManager;
    }

    public void setBasketManager(BasketManager basketManager) {
        logger.trace("setBasketManager: start");
        this.basketManager = basketManager;
    }

    /*@Configuration
    *//*@Order(2147483640)*//*
    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .httpBasic().and()
                    .authorizeRequests()
                    .antMatchers("/spring/app/index.html").permitAll().anyRequest()
                    .authenticated().and()
                    .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
                    .csrf().csrfTokenRepository(csrfTokenRepository());
        }

        private CsrfTokenRepository csrfTokenRepository() {
            HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
            repository.setHeaderName("X-XSRF-TOKEN");
            return repository;
        }
    }*/
}
